package com.design;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ningsheng
 * @version 1.0
 * @date 2018/4/24
 */
public class DynamicProxy implements InvocationHandler {

    private Object subject;

    public DynamicProxy(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before-----------------");
        method.invoke(subject, args);
        System.out.println("after------------------");
        return null;
    }
}
