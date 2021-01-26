package com.nathan.learn.io.net.bio;

import io.netty.util.concurrent.DefaultThreadFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolServerSocketLearn {
    public static void main(String[] args) throws IOException {
        // 用一个线程池处理接收到的请求
        ExecutorService executor = new ThreadPoolExecutor(10,
                Integer.MAX_VALUE,
                5,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(10),
                new DefaultThreadFactory("ReadThreadPool"));
        // 服务端开启8081端口
        ServerSocket serverSocket = new ServerSocket(8080);
        while (!Thread.interrupted()) {
            // 阻塞式接收请求
            final Socket accept = serverSocket.accept();
            // 每当有新的请求到来，将其放到线程池中处理
            executor.submit(() -> {
                try (InputStream inputStream = accept.getInputStream();) {
                    // 从inputStream中读取输入内容
                    byte[] bytes = new byte[inputStream.available()];
                    inputStream.read(bytes);

                    // 封装输出内容，并将其写到outputStream
                    System.out.println(new String(bytes, StandardCharsets.UTF_8));

                    // 这里需要分别关闭输入和输出，否则浏览器请求的时候会发生异常
                    // 思考1：为什么不能直接close
                    accept.shutdownInput();
                    accept.shutdownOutput();
                    accept.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

    }
}
