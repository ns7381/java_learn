package com.design.proxy.custom;

import com.design.proxy.DbQuery;
import com.design.proxy.IDbQuery;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CustomProxyTest {
    public static void main(String[] args) throws Exception {
        DbQuery dbQuery = new DbQuery();
        IDbQuery o = (IDbQuery) MyProxy.newProxyInstance(new MyClassLoader(), DbQuery.class.getInterfaces(), (proxy, method, args1) -> method.invoke(dbQuery, args1));
        o.select();
    }
}
