package com.nathan.learn.netty.rpc;

public abstract class RpcEndpointRef {

    /**
     * return the address for the [[RpcEndpointRef]]
     */
    public abstract RpcAddress address();

    public abstract String name();

    /**
     * Sends a one-way asynchronous message. Fire-and-forget semantics.
     */
    public abstract void send(Object message);

}
