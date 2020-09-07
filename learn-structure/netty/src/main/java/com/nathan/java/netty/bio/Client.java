package com.nathan.java.netty.bio;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author ningsheng
 * @version 1.0
 * @date 2019/3/10
 */
@Slf4j
public class Client {
    private static Socket socket;

    public Client() {
        try {
            socket = new Socket("127.0.0.1", 7777);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(String message) {
        try (
                PrintWriter pw = new PrintWriter(socket.getOutputStream(), true)
        ) {
            pw.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void accept() {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            String result;
            while ((result = br.readLine()) != null) {
                log.info("Client receive result: " + result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.send("haha");
        client.send("sdfsd");
        client.send("1qa");
        client.send("2wsx");
        client.send("3edc");
        client.send("4rfv");
        client.send("5tgb");
        client.accept();
    }
}
