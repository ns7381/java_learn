package com.nathan.learn.design.structural.proxy;

public class Main {
    public static void main(String[] args) {
        DbQueryStaticProxy staticProxy = new DbQueryStaticProxy();
        staticProxy.select();
        IDbQuery jdkProxy = (IDbQuery) new ProxyHandler(new DbQuery()).getProxyInstance();
        jdkProxy.select();
        IDbQuery cglibProxy = (IDbQuery) new ProxyInterceptor(new DbQuery()).getProxyInstance();
        cglibProxy.select();
    }
}
