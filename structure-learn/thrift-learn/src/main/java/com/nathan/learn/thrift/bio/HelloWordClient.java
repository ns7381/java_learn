package com.nathan.learn.thrift.bio;

import com.nathan.learn.thrift.HelloWordService;
import com.nathan.learn.thrift.Request;
import com.nathan.learn.thrift.RequestType;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class HelloWordClient {
    public static void main(String[] args) throws Exception {
        TTransport transport = new TSocket("localhost", 7912);
        TProtocol protocol = new TBinaryProtocol(transport);
        HelloWordService.Client client = new HelloWordService.Client(protocol);
        transport.open();
        Request request = new Request().setType(RequestType.SAY_HELLO).setName("nathan2012").setAge(24);
        System.out.println(client.doAction(request));
        System.out.println(client.doTest(request, ""));
        transport.close();
    }
}
