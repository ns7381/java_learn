package com.nathan.java.netty.bio;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author nathan
 * @version 1.0
 * @date 2019/3/10
 */
@Slf4j
public class SocketHandler implements Runnable {
    private final Socket socket;

    public SocketHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter pw = new PrintWriter(socket.getOutputStream(), true)
        ) {
            String message;
            String result;
            while ((message = br.readLine()) != null) {
                log.info("Server receive: " + message);
                result = Calculator.cal(message);
                pw.println(result);
            }
        } catch (IOException e) {
            log.error(e.getLocalizedMessage());
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
