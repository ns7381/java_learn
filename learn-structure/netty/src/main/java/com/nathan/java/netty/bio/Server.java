package com.nathan.java.netty.bio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
public class Server {
    private static int DEFAULT_PORT = 7777;
    private static ServerSocket serverSocket;

    public static void start() throws IOException {
        start(DEFAULT_PORT);
    }

    private synchronized static void start(int defaultPort) throws IOException {
        if (serverSocket == null) {
            serverSocket = new ServerSocket(defaultPort);
        }
        while (true) {
            Socket socket = serverSocket.accept();
            new SocketHandler(socket).run();
        }
    }

    public static void main(String[] args) throws IOException {
        Server.start();
    }
}
