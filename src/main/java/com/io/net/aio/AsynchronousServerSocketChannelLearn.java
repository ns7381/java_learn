package com.io.net.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class AsynchronousServerSocketChannelLearn {

    public final static int PORT = 8001;
    public final static String IP = "127.0.0.1";


    public void start() throws IOException {
        // 同样是利用工厂方法产生一个通道，异步通道 AsynchronousServerSocketChannel
        AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(IP, PORT));
        System.out.println("Server listen on " + PORT);

        // 注册事件和事件完成后的处理器，这个CompletionHandler就是事件完成后的处理器
        server.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {

            final ByteBuffer buffer = ByteBuffer.allocate(1024);

            @Override
            public void completed(AsynchronousSocketChannel result, Object attachment) {

                System.out.println(Thread.currentThread().getName());
                Future<Integer> writeResult = null;

                try {
                    buffer.clear();
                    result.read(buffer).get(100, TimeUnit.SECONDS);

                    System.out.println("In server: " + new String(buffer.array()));

                    // 将数据写回客户端
                    buffer.flip();
                    writeResult = result.write(buffer);
                } catch (InterruptedException | ExecutionException | TimeoutException e) {
                    e.printStackTrace();
                } finally {
                    server.accept(null, this);
                    try {
                        writeResult.get();
                        result.close();
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.out.println("failed:" + exc);
            }

        });
    }

    public static void main(String[] args) throws IOException {
        new AsynchronousServerSocketChannelLearn().start();
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
