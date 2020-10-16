package com.nathan.thrift.bio;


import com.nathan.thrift.HelloWordService;
import com.nathan.thrift.HelloWordServiceImpl;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportFactory;

public class HelloWordServer {
    public static void main(String[] args) throws Exception {
        TSimpleServer.Args tArgs = new TSimpleServer.Args(new TServerSocket(7912))
                // 默认为new TTransportFactory()
                .transportFactory(new TTransportFactory())
                .processor(new HelloWordService.Processor<HelloWordService.Iface>(new HelloWordServiceImpl()))
                // 默认为new TBinaryProtocol.Factory()
                .protocolFactory(new TBinaryProtocol.Factory());
        TServer server = new TSimpleServer(tArgs);
        System.out.println("Running server...");
        server.serve();
    }
}
