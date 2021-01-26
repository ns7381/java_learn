package com.nathan.learn.thrift.bio;

import com.nathan.learn.thrift.HelloWordService;
import com.nathan.learn.thrift.HelloWordServiceImpl;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.TTransportFactory;

import java.io.IOException;
import java.net.ServerSocket;

public class HelloWordThreadPoolServer {
    public static void main(String[] args) throws TTransportException, IOException {
        ServerSocket serverSocket = new ServerSocket(7912);
        TServerSocket serverTransport = new TServerSocket(serverSocket);
        HelloWordService.Processor<HelloWordService.Iface> processor =
                new HelloWordService.Processor<HelloWordService.Iface>(new HelloWordServiceImpl());

        TThreadPoolServer.Args poolServerArgs = new TThreadPoolServer.Args(serverTransport)
                .transportFactory(new TTransportFactory())
                .processor(processor)
                .protocolFactory(new TBinaryProtocol.Factory());

        TServer server = new TThreadPoolServer(poolServerArgs);
        System.out.println("Running ThreadPool Server");
        server.serve();

    }
}
