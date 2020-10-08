package com.design.structural.proxy.custom;

import com.design.structural.proxy.DbQuery;
import com.design.structural.proxy.IDbQuery;

public class CustomProxyTest {
    public static void main(String[] args) throws Exception {
        DbQuery dbQuery = new DbQuery();
        IDbQuery o = (IDbQuery) MyProxy.newProxyInstance(new MyClassLoader(), DbQuery.class.getInterfaces(), (proxy, method, args1) -> method.invoke(dbQuery, args1));
        o.select();
    }
}
