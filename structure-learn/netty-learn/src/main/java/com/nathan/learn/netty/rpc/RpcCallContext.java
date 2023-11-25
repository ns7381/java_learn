/*
 * Ant Group
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.nathan.learn.netty.rpc;

/**
 * @author ningsheng
 * @version RpcCallContext.java, v 0.1 2021年10月29日 8:50 下午 ningsheng
 */
public interface RpcCallContext {
    /**
     * Reply a message to the sender. If the sender is [[RpcEndpoint]], its `RpcEndpoint.receive`
     * will be called.
     */
    void reply(Object response);

    /**
     * Report a failure to the sender.
     */
    void sendFailure(Throwable e);

    /**
     * The sender of this message.
     */
    RpcAddress senderAddress();
}