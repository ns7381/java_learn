package com.io.net.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketLearn {
    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(9090);
             Socket s = ss.accept();
             InputStream is = s.getInputStream();
             OutputStream os = s.getOutputStream();) {
            byte[] b = new byte[20];
            int len;
            while ((len = is.read(b)) != -1) {
                String str = new String(b, 0, len);
                System.out.println(str);
            }
            System.out.println("收到来自" + s.getInetAddress().getHostName());

            os.write("我已经收到了，谢谢你客户端".getBytes());
            s.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
