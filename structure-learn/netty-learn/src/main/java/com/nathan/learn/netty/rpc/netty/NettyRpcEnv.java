package com.nathan.learn.netty.rpc.netty;

import com.nathan.learn.netty.rpc.RpcAddress;
import com.nathan.learn.netty.rpc.RpcEndpoint;
import com.nathan.learn.netty.rpc.RpcEndpointRef;
import com.nathan.learn.netty.rpc.RpcEnv;
import com.nathan.learn.netty.rpc.network.client.TransportClientFactory;
import com.nathan.learn.netty.rpc.network.util.TransportConf;
import com.nathan.learn.netty.rpc.network.TransportContext;
import com.nathan.learn.netty.rpc.network.server.TransportServer;
import com.nathan.learn.netty.rpc.serializer.Serializer;

public class NettyRpcEnv extends RpcEnv {
    private Serializer serializer;
    private String host;
    private TransportServer server;

    private Dispatcher dispatcher = new Dispatcher(this);
    private TransportConf transportConf = new TransportConf("rpc");

    private TransportContext transportContext = new TransportContext(transportConf,
            new NettyRpcHandler(dispatcher, this));
    private TransportClientFactory clientFactory = transportContext.createClientFactory();

    public NettyRpcEnv(Serializer serializer, String host) {
        this.serializer = serializer;
        this.host = host;
    }

    public void startServer(String bindAddress, int port) {
        server = transportContext.createServer(bindAddress, port);
        dispatcher.registerRpcEndpoint("endpoint-verifier", new RpcEndpointVerifier(this, dispatcher));
    }

    @Override
    protected RpcEndpointRef endpointRef(RpcEndpoint endpoint) {
        return dispatcher.getRpcEndpointRef(endpoint);
    }

    public RpcAddress address() {
        return server != null ? new RpcAddress(host, server.getPort()) : null;
    }

}
