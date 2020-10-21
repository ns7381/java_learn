package com.io.net.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class SocketLearn {
    public static void main(String[] args) {
        try (Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
             OutputStream os = socket.getOutputStream();
             InputStream is = socket.getInputStream();) {

            String str = "你好，我是客户端，你是服务端吗？";
            os.write(str.getBytes());
            socket.shutdownOutput();

            byte[] buffer = new byte[20];
            int len;
            while ((len = is.read(buffer)) != -1) {
                String st = new String(buffer, 0, len);
                System.out.println(st);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
