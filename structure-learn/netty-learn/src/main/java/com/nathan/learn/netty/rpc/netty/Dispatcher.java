package com.nathan.learn.netty.rpc.netty;

import com.nathan.learn.netty.rpc.RpcEndpoint;
import com.nathan.learn.netty.rpc.RpcEndpointRef;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class Dispatcher {
    NettyRpcEnv nettyEnv;
    private Map<String, MessageLoop> endpoints =
            new ConcurrentHashMap<>();
    private Map<RpcEndpoint, RpcEndpointRef> endpointRefs =
            new ConcurrentHashMap<>();

    private CountDownLatch shutdownLatch = new CountDownLatch(1);

    /**
     * True if the dispatcher has been stopped. Once stopped, all messages posted will be bounced
     * immediately.
     */
    private boolean stopped = false;

    def registerRpcEndpoint(name: String, endpoint: RpcEndpoint): NettyRpcEndpointRef = {
        val addr = RpcEndpointAddress(nettyEnv.address, name)
        val endpointRef = new NettyRpcEndpointRef(nettyEnv.conf, addr, nettyEnv)
        synchronized {
            if (stopped) {
                throw new IllegalStateException("RpcEnv has been stopped")
            }
            if (endpoints.containsKey(name)) {
                throw new IllegalArgumentException(s"There is already an RpcEndpoint called $name")
            }

            // This must be done before assigning RpcEndpoint to MessageLoop, as MessageLoop sets Inbox be
            // active when registering, and endpointRef must be put into endpointRefs before onStart is
            // called.
            endpointRefs.put(endpoint, endpointRef)

            var messageLoop: MessageLoop = null
            try {
                messageLoop = endpoint match {
                    case e: IsolatedRpcEndpoint =>
                        new DedicatedMessageLoop(name, e, this)
                    case _ =>
                        sharedLoop.register(name, endpoint)
                        sharedLoop
                }
                endpoints.put(name, messageLoop)
            } catch {
                case NonFatal(e) =>
                    endpointRefs.remove(endpoint)
                    throw e
            }
        }
        endpointRef
    }

    def getRpcEndpointRef(endpoint: RpcEndpoint): RpcEndpointRef = endpointRefs.get(endpoint)

    def removeRpcEndpointRef(endpoint: RpcEndpoint): Unit = endpointRefs.remove(endpoint)

    // Should be idempotent
    private def unregisterRpcEndpoint(name: String): Unit = {
        val loop = endpoints.remove(name)
        if (loop != null) {
            loop.unregister(name)
        }
        // Don't clean `endpointRefs` here because it's possible that some messages are being processed
        // now and they can use `getRpcEndpointRef`. So `endpointRefs` will be cleaned in Inbox via
        // `removeRpcEndpointRef`.
    }

    def stop(rpcEndpointRef: RpcEndpointRef): Unit = {
        synchronized {
            if (stopped) {
                // This endpoint will be stopped by Dispatcher.stop() method.
                return
            }
            unregisterRpcEndpoint(rpcEndpointRef.name)
        }
    }

    /**
     * Send a message to all registered [[RpcEndpoint]]s in this process.
     *
     * This can be used to make network events known to all end points (e.g. "a new node connected").
     */
    def postToAll(message: InboxMessage): Unit = {
        val iter = endpoints.keySet().iterator()
        while (iter.hasNext) {
            val name = iter.next
            postMessage(name, message, (e) => { e match {
            case e: RpcEnvStoppedException => logDebug (s"Message $message dropped. ${e.getMessage}")
            case e: Throwable => logWarning(s"Message $message dropped. ${e.getMessage}")
        }}
      )}
    }

    /** Posts a message sent by a remote endpoint. */
    def postRemoteMessage(message: RequestMessage, callback: RpcResponseCallback): Unit = {
        val rpcCallContext =
                new RemoteNettyRpcCallContext(nettyEnv, callback, message.senderAddress)
        val rpcMessage = RpcMessage(message.senderAddress, message.content, rpcCallContext)
        postMessage(message.receiver.name, rpcMessage, (e) => callback.onFailure(e))
    }

    /** Posts a message sent by a local endpoint. */
    def postLocalMessage(message: RequestMessage, p: Promise[Any]): Unit = {
        val rpcCallContext =
                new LocalNettyRpcCallContext(message.senderAddress, p)
        val rpcMessage = RpcMessage(message.senderAddress, message.content, rpcCallContext)
        postMessage(message.receiver.name, rpcMessage, (e) => p.tryFailure(e))
    }

    /** Posts a one-way message. */
    def postOneWayMessage(message: RequestMessage): Unit = {
        postMessage(message.receiver.name, OneWayMessage(message.senderAddress, message.content),
                (e) => throw e)
    }

    /**
     * Posts a message to a specific endpoint.
     *
     * @param endpointName name of the endpoint.
     * @param message the message to post
     * @param callbackIfStopped callback function if the endpoint is stopped.
     */
    private def postMessage(
            endpointName: String,
            message: InboxMessage,
            callbackIfStopped: (Exception) => Unit): Unit = {
        val error = synchronized {
            val loop = endpoints.get(endpointName)
            if (stopped) {
                Some(new RpcEnvStoppedException())
            } else if (loop == null) {
                Some(new SparkException(s"Could not find $endpointName."))
            } else {
                loop.post(endpointName, message)
                None
            }
        }
        // We don't need to call `onStop` in the `synchronized` block
        error.foreach(callbackIfStopped)
    }

    def stop(): Unit = {
        synchronized {
            if (stopped) {
                return
            }
            stopped = true
        }
        var stopSharedLoop = false
        endpoints.asScala.foreach { case (name, loop) =>
            unregisterRpcEndpoint(name)
            if (!loop.isInstanceOf[SharedMessageLoop]) {
                loop.stop()
            } else {
                stopSharedLoop = true
            }
        }
        if (stopSharedLoop) {
            sharedLoop.stop()
        }
        shutdownLatch.countDown()
    }

    def awaitTermination(): Unit = {
        shutdownLatch.await()
    }

    /**
     * Return if the endpoint exists
     */
    def verify(name: String): Boolean = {
        endpoints.containsKey(name)
    }

}
