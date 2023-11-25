/*
 * Ant Group
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.nathan.learn.netty.rpc.netty;

import com.nathan.learn.netty.rpc.network.server.RpcHandler;

/**
 * @author ningsheng
 * @version NettyRpcHandler.java, v 0.1 2021年10月29日 7:58 下午 ningsheng
 */
public class NettyRpcHandler extends RpcHandler {
    private Dispatcher dispatcher;
    private NettyRpcEnv nettyEnv;

    public NettyRpcHandler(Dispatcher dispatcher, NettyRpcEnv nettyEnv) {
        this.dispatcher = dispatcher;
        this.nettyEnv = nettyEnv;
    }
}