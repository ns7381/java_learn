package com.design.proxy.custom;

import com.design.proxy.DbQuery;
import com.design.proxy.IDbQuery;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CustomProxyTest {
    public static void main(String[] args) throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        DbQuery dbQuery = new DbQuery();
        IDbQuery o = (IDbQuery) MyProxy.newProxyInstance(new MyClassLoader(), DbQuery.class.getInterfaces(), new MyInvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
                return method.invoke(dbQuery, args);
            }
        });
        o.select();
    }
}
