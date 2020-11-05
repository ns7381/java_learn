package com.nathan.thrift.nio;

import com.nathan.thrift.HelloWordService;
import com.nathan.thrift.HelloWordServiceImpl;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;

/**
 * HsHaServer是半同步半异步(Half-Sync/Half-Async)的处理模式，Half-Aysnc用于IO事件处理(Accept/Read/Write)，Half-Sync用于业务handler对rpc的同步处理上。
 * THsHaServer和TNonblockingServer一样，要求底层的传输通道必须使用TFramedTransport。
 */
public class HelloWordHsHaServer {
    public static void main(String[] args) throws Exception {
        THsHaServer.Args serverArgs = new THsHaServer.Args(new TNonblockingServerSocket(7912))
                .processor(new HelloWordService.Processor<HelloWordService.Iface>(new HelloWordServiceImpl()))
                // 默认为TFramedTransport, 客户端需要指定TFramedTransport数据传输的方式
                .transportFactory(new TFramedTransport.Factory())
                //默认为TBinaryProtocol.Factory
                .protocolFactory(new TBinaryProtocol.Factory());
        TServer server = new THsHaServer(serverArgs);
        System.out.println("开启Thrift服务器，监听端口:7912");
        server.serve();
    }
}
