package com.nathan.learn.netty.rpc;

public interface RpcEndpoint {

    /**
     * The [[RpcEnv]] that this [[RpcEndpoint]] is registered to.
     */
    RpcEnv rpcEnv = null;

    /**
     * The [[RpcEndpointRef]] of this [[RpcEndpoint]]. `self` will become valid when `onStart` is
     * called. And `self` will become `null` when `onStop` is called.
     *
     * Note: Because before `onStart`, [[RpcEndpoint]] has not yet been registered and there is not
     * valid [[RpcEndpointRef]] for it. So don't call `self` before `onStart` is called.
     */
    RpcEndpointRef getSelfRef() {
        rpcEnv.endpointRef(this)
    }

    /**
     * Process messages from `RpcEndpointRef.send` or `RpcCallContext.reply`. If receiving a
     * unmatched message, `SparkException` will be thrown and sent to `onError`.
     */
    def receive: PartialFunction[Any, Unit] = {
        case _ => throw new SparkException(self + " does not implement 'receive'")
    }

    /**
     * Process messages from `RpcEndpointRef.ask`. If receiving a unmatched message,
     * `SparkException` will be thrown and sent to `onError`.
     */
    def receiveAndReply(context: RpcCallContext): PartialFunction[Any, Unit] = {
        case _ => context.sendFailure(new SparkException(self + " won't reply anything"))
    }

    /**
     * Invoked when any exception is thrown during handling messages.
     */
    def onError(cause: Throwable): Unit = {
        // By default, throw e and let RpcEnv handle it
        throw cause
    }

    /**
     * Invoked when `remoteAddress` is connected to the current node.
     */
    def onConnected(remoteAddress: RpcAddress): Unit = {
        // By default, do nothing.
    }

    /**
     * Invoked when `remoteAddress` is lost.
     */
    def onDisconnected(remoteAddress: RpcAddress): Unit = {
        // By default, do nothing.
    }

    /**
     * Invoked when some network error happens in the connection between the current node and
     * `remoteAddress`.
     */
    def onNetworkError(cause: Throwable, remoteAddress: RpcAddress): Unit = {
        // By default, do nothing.
    }

    /**
     * Invoked before [[RpcEndpoint]] starts to handle any message.
     */
    def onStart(): Unit = {
        // By default, do nothing.
    }

    /**
     * Invoked when [[RpcEndpoint]] is stopping. `self` will be `null` in this method and you cannot
     * use it to send or ask messages.
     */
    def onStop(): Unit = {
        // By default, do nothing.
    }

    /**
     * A convenient method to stop [[RpcEndpoint]].
     */
    final def stop(): Unit = {
        val _self = self
        if (_self != null) {
            rpcEnv.stop(_self)
        }
    }
}
