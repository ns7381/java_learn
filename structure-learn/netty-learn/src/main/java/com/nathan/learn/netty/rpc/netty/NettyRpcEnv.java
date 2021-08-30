package com.nathan.learn.netty.rpc.netty;

import com.nathan.learn.netty.rpc.RpcEndpoint;
import com.nathan.learn.netty.rpc.RpcEndpointRef;
import com.nathan.learn.netty.rpc.RpcEnv;
import com.nathan.learn.netty.rpc.network.TransportServer;
import com.nathan.learn.netty.rpc.serializer.Serializer;

public class NettyRpcEnv extends RpcEnv {
    Serializer serializer;
    String host;
    TransportServer server;
    private Dispatcher dispatcher = new Dispatcher(this);



    public NettyRpcEnv(Serializer serializer, String host) {
        this.serializer = serializer;
        this.host = host;
    }

    public void startServer(String bindAddress, int port) {
        server = new TransportServer(this, host, port, rpcHandler, bootstraps);
        dispatcher.registerRpcEndpoint(
                RpcEndpointVerifier.NAME, new RpcEndpointVerifier(this, dispatcher))
    }

    @Override
    protected RpcEndpointRef endpointRef(RpcEndpoint endpoint) {
        return dispatcher.getRpcEndpointRef(endpoint);
    }
}
