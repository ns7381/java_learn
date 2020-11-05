package com.nathan.thrift.nio;

import com.nathan.thrift.HelloWordService;
import com.nathan.thrift.HelloWordServiceImpl;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;

/**
 * TThreadedSelectorServer是对THsHaServer的一种扩充，它将selector中的读写IO事件(read/write)从主线程中分离出来。
 * 同时引入worker工作线程池，它也是种Half-Sync/Half-Async的服务模型。
 */
public class HelloWordThreadedSelectorServer {
    public static void main(String[] args) throws Exception {
        TThreadedSelectorServer.Args serverArgs = new TThreadedSelectorServer.Args(new TNonblockingServerSocket(7912))
                .processor(new HelloWordService.Processor<HelloWordService.Iface>(new HelloWordServiceImpl()))
                // 默认为TFramedTransport, 客户端需要指定TFramedTransport数据传输的方式
                .transportFactory(new TFramedTransport.Factory())
                //默认为TBinaryProtocol.Factory
                .protocolFactory(new TBinaryProtocol.Factory());
        TServer server = new TThreadedSelectorServer(serverArgs);
        System.out.println("开启Thrift服务器，监听端口:7912");
        server.serve();
    }
}
