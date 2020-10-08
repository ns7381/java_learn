package com.design.structural.proxy.custom;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public interface MyInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException;
}
