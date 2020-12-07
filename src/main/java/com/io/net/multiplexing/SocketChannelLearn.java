package com.io.net.multiplexing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class SocketChannelLearn {

    private Logger logger = LoggerFactory.getLogger(SocketChannelLearn.class);

    /* 缓冲区大小 */
    private static final int BLOCK_SIZE = 4096;
    /* 接收数据缓冲区大小 */
    private ByteBuffer recieveBuffer = ByteBuffer.allocate(BLOCK_SIZE);
    /* 发送数据缓冲区大小 */
    private ByteBuffer sendBuffer = ByteBuffer.allocate(BLOCK_SIZE);
    /* 服务器端地址 */
    private final static InetSocketAddress SERVER_ADDRESS = new InetSocketAddress("localhost", 9090);

    /**
     * 多路复用器
     */
    private Selector selector;


    private SocketChannel init() throws IOException {
        /* 创建一个SocketChannel */
        SocketChannel socketChannel = SocketChannel.open();
        /* 设为非阻塞模式 */
        socketChannel.configureBlocking(Boolean.FALSE);
        /* 注册连接服务端socket动作 */
        socketChannel.register(selector, SelectionKey.OP_CONNECT);
        /* 连接到服务器,判断是否连接成功 */
        boolean connect = socketChannel.connect(SERVER_ADDRESS);
        logger.info("connect is {}", connect);
        return socketChannel;
    }

    public void handle() throws IOException, ClassNotFoundException {
        /* 打开Selector(多路复用器) */
        selector = Selector.open();

        SocketChannel socketChannel = init();

        Set<SelectionKey> keys = null;
        Iterator<SelectionKey> it = null;
        SelectionKey key = null;

        while (true) {
            /* 监控注册在Selector上的SocketChannel，返回值代表有多少channel已经就绪，可以进行I/O操作了 */
            int ready = selector.select();
            /* 其中每个SelectionKey代表了一个可以进行IO操作的channel */
            keys = selector.selectedKeys();
            it = keys.iterator();
            while (it.hasNext()) {
                key = it.next();
                handleKey(key, socketChannel);

            }
            keys.clear();
        }
    }

    /**
     * 处理请求
     */
    public void handleKey(SelectionKey key, SocketChannel socketChannel) throws IOException {

        // 判断该通道是否可以进行连接操作
        if (key.isConnectable()) {
            logger.info("客户端开始连接......");
            /* 返回为之创建此键的通道 */
            socketChannel = (SocketChannel) key.channel();
            if (socketChannel.isConnectionPending()) {
                socketChannel.finishConnect();
                logger.info("完成连接!");
                sendBuffer.clear();
                sendBuffer.put("hello server".getBytes(Charset.defaultCharset()));
                sendBuffer.flip();
                socketChannel.write(sendBuffer);
            }
            /* 又注册到selector，等待读取 */
            socketChannel.register(selector, SelectionKey.OP_READ);
        } else if (key.isReadable()) { // 判断该通道是否可以读
            /* 返回为之创建此键的通道 */
            socketChannel = (SocketChannel) key.channel();
            // 将接收数据缓冲区清空以备下次读取
            recieveBuffer.clear();
            // 读取服务器发送来的数据到缓冲区中
            int count = socketChannel.read(recieveBuffer);
            if (count > 0) {
                String recvText = new String(recieveBuffer.array(), 0, count, Charset.defaultCharset());
                logger.info("客户端接受服务器端数据=> {}", recvText);
            }
            /* 又注册到selector，等待写入 */
            socketChannel.register(selector, SelectionKey.OP_WRITE);
        } else if (key.isWritable()) { // 判断该通道是否可以写
            /* 返回为之创建此键的通道 */
            socketChannel = (SocketChannel) key.channel();
            // 将发送数据缓冲区清空以备下次读取
            sendBuffer.clear();
            // String data = String.valueOf(Math.round(Math.random() *
            // 100 + 1));
            String data = "周强";
            sendBuffer.put(data.getBytes(Charset.defaultCharset()));
            // 将缓冲区各标志复位,因为向里面put了数据标志被改变要想从中读取数据发向服务器,就要复位
            sendBuffer.flip();
            socketChannel.write(sendBuffer);
            logger.info("客户端向服务器端发送数据=> " + data);
        }
        socketChannel.register(selector, SelectionKey.OP_READ);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SocketChannelLearn client = new SocketChannelLearn();
        client.handle();
    }
}
