package com.design.structural.proxy;

public class DbQueryStaticProxy implements IDbQuery {
    private IDbQuery dbQuery;

    @Override
    public String select() {
        if (dbQuery == null) {
            dbQuery = new DbQuery();
        }
        return dbQuery.select();
    }
}
