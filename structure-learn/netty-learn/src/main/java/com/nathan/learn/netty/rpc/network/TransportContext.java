/*
 * Ant Group
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.nathan.learn.netty.rpc.network;

import com.nathan.learn.netty.rpc.netty.NettyRpcHandler;
import com.nathan.learn.netty.rpc.network.client.TransportClient;
import com.nathan.learn.netty.rpc.network.client.TransportClientFactory;
import com.nathan.learn.netty.rpc.network.client.TransportResponseHandler;
import com.nathan.learn.netty.rpc.network.protocol.MessageDecoder;
import com.nathan.learn.netty.rpc.network.protocol.MessageEncoder;
import com.nathan.learn.netty.rpc.network.server.RpcHandler;
import com.nathan.learn.netty.rpc.network.server.TransportChannelHandler;
import com.nathan.learn.netty.rpc.network.server.TransportRequestHandler;
import com.nathan.learn.netty.rpc.network.server.TransportServer;
import com.nathan.learn.netty.rpc.network.util.NettyUtils;
import com.nathan.learn.netty.rpc.network.util.TransportConf;
import com.nathan.learn.netty.rpc.network.util.TransportFrameDecoder;
import io.netty.channel.Channel;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

/**
 * @author ningsheng
 * @version TransportContext.java, v 0.1 2021年10月29日 8:01 下午 ningsheng
 */
public class TransportContext {
    TransportConf conf;
    NettyRpcHandler rpcHandler;
    private static final MessageEncoder ENCODER = MessageEncoder.INSTANCE;
    private static final MessageDecoder DECODER = MessageDecoder.INSTANCE;

    public TransportContext(TransportConf transportConf, NettyRpcHandler nettyRpcHandler) {
        this.conf = transportConf;
        this.rpcHandler = nettyRpcHandler;
    }

    public TransportClientFactory createClientFactory() {
        return new TransportClientFactory(this);
    }

    public TransportServer createServer(String host, int port) {
        return new TransportServer(this, host, port, rpcHandler);
    }

    public TransportConf getConf() {
        return conf;
    }

    /**
     * Initializes a client or server Netty Channel Pipeline which encodes/decodes messages and
     * has a TransportChannelHandler to handle request or
     * response messages.
     *
     * @param channel The channel to initialize.
     * @param channelRpcHandler The RPC handler to use for the channel.
     *
     * @return Returns the created TransportChannelHandler, which includes a TransportClient that can
     * be used to communicate on this channel. The TransportClient is directly associated with a
     * ChannelHandler to ensure all users of the same channel get the same TransportClient object.
     */
    public TransportChannelHandler initializePipeline(
            SocketChannel channel,
            RpcHandler channelRpcHandler) {
        try {
            TransportResponseHandler responseHandler = new TransportResponseHandler(channel);
            TransportClient client = new TransportClient(channel, responseHandler);
            TransportRequestHandler requestHandler = new TransportRequestHandler(channel, client,
                    rpcHandler);
            TransportChannelHandler channelHandler = new TransportChannelHandler(client, responseHandler, requestHandler,120000,this);
            ChannelPipeline pipeline = channel.pipeline()
                    .addLast("encoder", ENCODER)
                    .addLast(TransportFrameDecoder.HANDLER_NAME, NettyUtils.createFrameDecoder())
                    .addLast("decoder", DECODER)
                    .addLast("idleStateHandler",
                            new IdleStateHandler(0, 0, 120*1000 / 1000))
                    // NOTE: Chunks are currently guaranteed to be returned in the order of request, but this
                    // would require more logic to guarantee if this were not part of the same event loop.
                    .addLast("handler", channelHandler);
            return channelHandler;
        } catch (RuntimeException e) {
            throw e;
        }
    }

}