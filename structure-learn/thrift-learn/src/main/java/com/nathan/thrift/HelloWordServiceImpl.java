package com.nathan.thrift;

import org.apache.thrift.TException;

import java.util.Date;

public class HelloWordServiceImpl implements HelloWordService.Iface {
    @Override
    public String doAction(Request request) throws TException {
        System.out.println("Get request: " + request);
        if (request.getType() == null) {
            throw new com.nathan.thrift.RequestException();
        }
        String result = "Hello, " + request.getName();
        if (request.getType() == com.nathan.thrift.RequestType.SAY_HELLO) {
            result += ", Welcome!";
        } else {
            result += ", Now is " + new Date().toLocaleString();
        }
        return result;
    }
}