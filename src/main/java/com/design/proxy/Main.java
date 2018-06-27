package com.design.proxy;

public class Main {
    public static void main(String[] args) {
        /*DbQueryStaticProxy staticProxy = new DbQueryStaticProxy();
        staticProxy.select();*/
        /*IDbQuery proxyInstance = (IDbQuery) new ProxyHandler(new DbQuery()).getProxyInstance();
        proxyInstance.select();*/
        IDbQuery proxyInstance = (IDbQuery) new ProxyInterceptor(new DbQuery()).getProxyInstance();
        proxyInstance.select();
    }
}
