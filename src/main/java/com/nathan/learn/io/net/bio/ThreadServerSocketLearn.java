package com.nathan.learn.io.net.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadServerSocketLearn {
    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(9090);) {
            while (!Thread.interrupted()) {
                // 阻塞式接收请求
                Socket s = ss.accept();
                new Thread(() -> {
                    try {
                        InputStream is = s.getInputStream();
                        OutputStream os = s.getOutputStream();
                        byte[] b = new byte[1024];
                        int len;
                        while ((len = is.read(b)) != -1) {
                            String str = new String(b, 0, len);
                            System.out.println(str);
                        }
                        System.out.println("收到来自" + s.getInetAddress().getHostName());

                        os.write("我已经收到了 谢谢你客户端".getBytes());
                        s.shutdownOutput();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
