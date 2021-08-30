package com.nathan.learn.netty.rpc;

public interface RpcEnvFactory {
    RpcEnv create(RpcEnvConfig config);

}
