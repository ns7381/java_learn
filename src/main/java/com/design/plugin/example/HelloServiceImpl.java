package com.design.plugin.example;

public class HelloServiceImpl implements IHelloService {
    @Override
    public String hello(String msg) {
        System.out.println("hello " + msg);
        return "hello " + msg;
    }
}
