package com.nathan.thrift;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * @author qifuguang
 * @date 15/9/11 16:13
 */
public class HelloWordClient {
    public static void main(String[] args) throws Exception {
        TTransport transport = new TSocket("localhost", 7912);
        TProtocol protocol = new TBinaryProtocol(transport);

        // 创建client
        com.nathan.thrift.HelloWordService.Client client = new com.nathan.thrift.HelloWordService.Client(protocol);

        transport.open();  // 建立连接

        // 第一种请求类型
        com.nathan.thrift.Request request = new com.nathan.thrift.Request()
                .setType(com.nathan.thrift.RequestType.SAY_HELLO).setName("nathan2012").setAge(24);
        System.out.println(client.doAction(request));

        // 第二种请求类型
        request.setType(com.nathan.thrift.RequestType.QUERY_TIME).setName("nathan2012");
        System.out.println(client.doAction(request));

        transport.close();  // 请求结束，断开连接
    }
}
