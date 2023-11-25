/*
 * Ant Group
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.nathan.learn.netty.rpc.netty;

import com.nathan.learn.netty.rpc.RpcCallContext;
import com.nathan.learn.netty.rpc.RpcEndpoint;
import com.nathan.learn.netty.rpc.RpcEnv;

/**
 * @author ningsheng
 * @version RpcEndpointVerifier.java, v 0.1 2021年10月29日 8:47 下午 ningsheng
 */
public class RpcEndpointVerifier implements RpcEndpoint {
    RpcEnv rpcEnv;
    Dispatcher dispatcher;

    public RpcEndpointVerifier(RpcEnv rpcEnv, Dispatcher dispatcher) {
        this.rpcEnv = rpcEnv;
        this.dispatcher = dispatcher;
    }

    @Override
    public void receive() {

    }

    @Override
    public void receiveAndReply(RpcCallContext context) {

    }
}