package com.nathan.learn.netty.rpc;

import com.nathan.learn.netty.rpc.netty.NettyRpcEnv;
import com.nathan.learn.netty.rpc.serializer.KryoSerializer;
import com.nathan.learn.netty.rpc.serializer.Serializer;

public class NettyRpcEnvFactory implements RpcEnvFactory {
    @Override
    public RpcEnv create(RpcEnvConfig config) {
        Serializer serializer = new KryoSerializer();
        NettyRpcEnv nettyEnv = new NettyRpcEnv(serializer, config.bindAddress);
        if (!config.clientMode) {
            nettyEnv.startServer(config.bindAddress, config.port);
        }
        return nettyEnv;
    }
}
