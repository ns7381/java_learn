package com.design;

import java.lang.reflect.Proxy;

/**
 * @author ningsheng
 * @version 1.0
 * @date 2018/4/24
 */
public class Solution {
    public static void main(String[] args) {

        Subject subject = new RealSubject();
        DynamicProxy proxy = new DynamicProxy(subject);
        //获取该代理对象
        Subject realSubject = (Subject) Proxy.newProxyInstance(proxy.getClass().getClassLoader(),
                subject.getClass().getInterfaces(), proxy);

        realSubject.run();
        realSubject.hello("Jack");
    }
}
