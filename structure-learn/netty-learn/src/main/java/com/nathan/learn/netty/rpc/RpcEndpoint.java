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
    default RpcEndpointRef getSelfRef() {
        return rpcEnv.endpointRef(this);
    }

    /**
     * Process messages from `RpcEndpointRef.send` or `RpcCallContext.reply`. If receiving a
     * unmatched message, `SparkException` will be thrown and sent to `onError`.
     */
    void receive();

    /**
     * Process messages from `RpcEndpointRef.ask`. If receiving a unmatched message,
     * `SparkException` will be thrown and sent to `onError`.
     */
    void receiveAndReply(RpcCallContext context);

}
