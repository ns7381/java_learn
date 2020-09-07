package com.nathan.thrift;


import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;

import java.net.ServerSocket;

/**
 * @author qifuguang
 * @date 15/9/11 16:07
 */
public class HelloWordServer {
    public static void main(String[] args) throws Exception {
        ServerSocket socket = new ServerSocket(7912);
        TServerSocket serverTransport = new TServerSocket(socket);
        com.nathan.thrift.HelloWordService.Processor processor = new com.nathan.thrift.HelloWordService.Processor(new HelloWordServiceImpl());
        TSimpleServer.Args tArgs = new TSimpleServer.Args(serverTransport);
        tArgs.processor(processor);
        TServer server = new TSimpleServer(tArgs);
        System.out.println("Running server...");
        server.serve();
    }
}
