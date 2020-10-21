package com.io.net.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class NonBlockingIOServerLearn {
    public static void main(String[] args) {
        LinkedList<SocketChannel> clients = new LinkedList<>();

        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();//服务端绑定端口，开启监听
            ssc.bind(new InetSocketAddress(9090));
            ssc.configureBlocking(false);//OS的 nonblocking 只有服务端监听非阻塞

            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                SocketChannel client = ssc.accept();//接收客户端连接，不会阻塞，没有客户端连接 返回值 null 在linux中 -1。
                //如果来客户端的连接， accept返回的是这个客户端的fd
                // NONBLOCKING就是代码能往下走了，只不过有不同的情况

                if (client == null) {
                    System.out.println("client is null");
                } else {
                    client.configureBlocking(false);//nonblocking 读取客户端发送的数据非阻塞
                    int port = client.socket().getPort();
                    System.out.println("client port:" + port);
                    clients.add(client);
                }

                ByteBuffer buffer = ByteBuffer.allocateDirect(4096);

                //遍历已经连接进来的客户端能不能读写数据
                for (SocketChannel cli : clients) {
                    int read = cli.read(buffer);//不会阻塞，>0（有数据）-1 0
                    if (read > 0) {
                        buffer.flip();
                        byte[] aaa = new byte[buffer.limit()];
                        buffer.get(aaa);
                        String b = new String(aaa);
                        System.out.println(cli.socket().getPort() + ":" + b);
                        buffer.clear();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
