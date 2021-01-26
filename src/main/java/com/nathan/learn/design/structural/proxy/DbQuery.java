package com.nathan.learn.design.structural.proxy;

public class DbQuery implements IDbQuery {
    @Override
    public String select() {
        System.out.println("select");
        return "select";
    }
}
