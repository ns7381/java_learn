/*
 * Ant Group
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.nathan.learn.netty.rpc.netty;

import com.nathan.learn.netty.rpc.RpcAddress;
import com.nathan.learn.netty.rpc.RpcEndpointAddress;
import com.nathan.learn.netty.rpc.RpcEndpointRef;

public class NettyRpcEndpointRef extends RpcEndpointRef {
    RpcEndpointAddress endpointAddress;
    NettyRpcEnv nettyEnv;

    public NettyRpcEndpointRef(RpcEndpointAddress endpointAddress, NettyRpcEnv nettyEnv) {
        this.endpointAddress = endpointAddress;
        this.nettyEnv = nettyEnv;
    }

    @Override
    public RpcAddress address() {
        return null;
    }
}