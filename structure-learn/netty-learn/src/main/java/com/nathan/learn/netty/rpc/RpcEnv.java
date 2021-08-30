package com.nathan.learn.netty.rpc;

public abstract class RpcEnv {
    public static RpcEnv create(String name, String host, int port) {
        return create(name, host, port, false);
    }

    public static RpcEnv create(String name, String host, int port, Boolean clientMode) {
        RpcEnvConfig config = new RpcEnvConfig(name, host, port, clientMode);
        return new NettyRpcEnvFactory().create(config);
    }

    protected abstract RpcEndpointRef endpointRef(RpcEndpoint endpoint);

}



