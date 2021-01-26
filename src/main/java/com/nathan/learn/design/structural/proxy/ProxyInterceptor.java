package com.nathan.learn.design.structural.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyInterceptor implements MethodInterceptor {
    private Object target;

    public ProxyInterceptor(Object proxy) {
        this.target = proxy;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("start transaction");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("end transaction");
        return result;
    }

    public Object getProxyInstance() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }
}
