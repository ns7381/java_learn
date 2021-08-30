package com.nathan.learn.netty.rpc;

public class RpcEnvConfig {
    String name;
    String bindAddress;
    int port;
    Boolean clientMode;

    public RpcEnvConfig(String name, String bindAddress, int port, Boolean clientMode) {
        this.name = name;
        this.bindAddress = bindAddress;
        this.port = port;
        this.clientMode = clientMode;
    }

}
