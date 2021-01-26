package com.nathan.learn.thrift.nio;

import com.nathan.learn.thrift.HelloWordService;
import com.nathan.learn.thrift.HelloWordServiceImpl;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;

public class HelloWordNonBlockingServer {
    public static void main(String[] args) throws Exception {
        TNonblockingServer.Args serverArgs = new TNonblockingServer.Args(new TNonblockingServerSocket(7912))
                .processor(new HelloWordService.Processor<HelloWordService.Iface>(new HelloWordServiceImpl()))
                // 默认为TFramedTransport, 客户端需要指定TFramedTransport数据传输的方式
                .transportFactory(new TFramedTransport.Factory())
                //默认为TBinaryProtocol.Factory
                .protocolFactory(new TBinaryProtocol.Factory());
        TServer server = new TNonblockingServer(serverArgs);
        System.out.println("开启Thrift服务器，监听端口:7912");
        server.serve();
    }
}
