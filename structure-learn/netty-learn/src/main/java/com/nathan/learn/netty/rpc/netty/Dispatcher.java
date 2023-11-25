package com.nathan.learn.netty.rpc.netty;

import com.nathan.learn.netty.rpc.RpcEndpoint;
import com.nathan.learn.netty.rpc.RpcEndpointAddress;
import com.nathan.learn.netty.rpc.RpcEndpointRef;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class Dispatcher {
    private NettyRpcEnv nettyEnv;
    private Map<String, MessageLoop> endpoints = new ConcurrentHashMap<>();
    private Map<RpcEndpoint, RpcEndpointRef> endpointRefs = new ConcurrentHashMap<>();

    private CountDownLatch shutdownLatch = new CountDownLatch(1);

    /**
     * True if the dispatcher has been stopped. Once stopped, all messages posted will be bounced
     * immediately.
     */
    private boolean stopped = false;

    public Dispatcher(NettyRpcEnv nettyEnv) {
        this.nettyEnv = nettyEnv;
    }

    public void registerRpcEndpoint(String name, RpcEndpointVerifier endpoint) {
        RpcEndpointAddress addr = new RpcEndpointAddress(nettyEnv.address(), name);
        NettyRpcEndpointRef endpointRef = new NettyRpcEndpointRef(addr, nettyEnv);
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
}
