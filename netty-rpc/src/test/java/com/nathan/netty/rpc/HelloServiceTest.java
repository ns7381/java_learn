package com.nathan.netty.rpc;

import com.nathan.netty.rpc.client.proxy.RpcProxy;
import com.nathan.netty.rpc.service.HelloService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by feizi on 2018/5/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class HelloServiceTest {
    @Resource
    private RpcProxy rpcProxy;

    @Test
    public void helloTest() {
        HelloService helloService = rpcProxy.create(HelloService.class);
        String result = helloService.hello("feizi");
        System.out.println("============>result: " + result);
        Assert.assertEquals("Hello! feizi", result);
    }
}
