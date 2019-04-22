package com.nathan.java.netty.nio;

import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author ningsheng
 * @version 1.0
 * @date 2019/3/10
 */
@Slf4j
public class SelectorExample {
    public static void main(String[] args) throws Exception {
        Selector selector = Selector.open();
        SocketChannel channel = SocketChannel.open();
        channel.connect(new InetSocketAddress("127.0.0.1", 7777));
        channel.configureBlocking(false);
        channel.register(selector, SelectionKey.OP_READ);
        while (true) {
            int readyChannels = selector.select();
            if (readyChannels == 0) {
                continue;
            }
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    channel = server.accept();
                    channel.configureBlocking(false);
                    log.info("客户端已经连接！");
                    channel.register(selector, SelectionKey.OP_READ);
                } else if (key.isReadable()) {
                    channel = (SocketChannel) key.channel();
                    // 创建读取缓冲
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    //读取到Buffer中
                    int read = channel.read(buffer);
                    if (read > 0) {
                        byte[] data = buffer.array();
                        String msg = new String(data).trim();
                        log.info("receive msg: {}", msg);

                        //回写数据
                        ByteBuffer outBuffer = ByteBuffer.wrap("OK".getBytes());
                        channel.write(outBuffer);
                    } else {
                        log.info("client closed!!!");
                        key.cancel();
                    }
                }
                keyIterator.remove();
            }
        }
    }
}
