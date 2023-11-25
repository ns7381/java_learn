package com.nathan.learn.netty.rpc.network.server;


import com.nathan.learn.netty.rpc.network.TransportContext;
import com.nathan.learn.netty.rpc.network.util.IOMode;
import com.nathan.learn.netty.rpc.network.util.NettyUtils;
import com.nathan.learn.netty.rpc.network.util.TransportConf;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import org.apache.commons.lang3.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;


/**
 * Server for the efficient, low-level streaming service.
 */
public class TransportServer implements Closeable {
    private static final Logger logger = LoggerFactory.getLogger(TransportServer.class);

    private final TransportContext context;
    private final TransportConf conf;
    private final RpcHandler appRpcHandler;

    private ServerBootstrap bootstrap;
    private ChannelFuture channelFuture;
    private int port = -1;
    private final PooledByteBufAllocator pooledAllocator;


    /**
     * Creates a TransportServer that binds to the given host and the given port, or to any available
     * if 0. If you don't want to bind to any special host, set "hostToBind" to null.
     */
    public TransportServer(
            TransportContext context,
            String hostToBind,
            int portToBind,
            RpcHandler appRpcHandler) {
        this.context = context;
        this.conf = context.getConf();
        this.appRpcHandler = appRpcHandler;
        this.pooledAllocator = NettyUtils.getSharedPooledByteBufAllocator(true, true /* allowCache */);
        boolean shouldClose = true;
        try {
            init(hostToBind, portToBind);
            shouldClose = false;
        } finally {
            if (shouldClose) {
                close();
            }
        }
    }

    public int getPort() {
        if (port == -1) {
            throw new IllegalStateException("Server not initialized");
        }
        return port;
    }

    private void init(String hostToBind, int portToBind) {

        IOMode ioMode = IOMode.valueOf(conf.ioMode());
        EventLoopGroup bossGroup = NettyUtils.createEventLoop(ioMode, 1,
                conf.getModuleName() + "-boss");
        EventLoopGroup workerGroup = NettyUtils.createEventLoop(ioMode, conf.serverThreads(),
                conf.getModuleName() + "-server");

        bootstrap = new ServerBootstrap()
                .group(bossGroup, workerGroup)
                .channel(NettyUtils.getServerChannelClass(ioMode))
                .option(ChannelOption.ALLOCATOR, pooledAllocator)
                .option(ChannelOption.SO_REUSEADDR, !SystemUtils.IS_OS_WINDOWS)
                .childOption(ChannelOption.ALLOCATOR, pooledAllocator);


        bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) {
                logger.debug("New connection accepted for remote address {}.", ch.remoteAddress());

                RpcHandler rpcHandler = appRpcHandler;
                context.initializePipeline(ch, rpcHandler);
            }
        });

        InetSocketAddress address = hostToBind == null ?
                new InetSocketAddress(portToBind) : new InetSocketAddress(hostToBind, portToBind);
        channelFuture = bootstrap.bind(address);
        channelFuture.syncUninterruptibly();

        port = ((InetSocketAddress) channelFuture.channel().localAddress()).getPort();
        logger.debug("Shuffle server started on port: {}", port);
    }

    @Override
    public void close() {
        if (channelFuture != null) {
            // close is a local operation and should finish within milliseconds; timeout just to be safe
            channelFuture.channel().close().awaitUninterruptibly(10, TimeUnit.SECONDS);
            channelFuture = null;
        }
        if (bootstrap != null && bootstrap.config().group() != null) {
            bootstrap.config().group().shutdownGracefully();
        }
        if (bootstrap != null && bootstrap.config().childGroup() != null) {
            bootstrap.config().childGroup().shutdownGracefully();
        }
        bootstrap = null;
    }

}
