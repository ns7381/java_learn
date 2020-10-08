package com.design.structural.proxy;

public class DbQuery implements IDbQuery {
    @Override
    public String select() {
        System.out.println("select");
        return "select";
    }
}
