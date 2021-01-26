package com.nathan.learn.design.creation.singleton;

/**
 * 饿汉式（静态常量
 * @author nathan
 */
public class EagerSingleton {
    private final static EagerSingleton INSTANCE = new EagerSingleton();

    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return INSTANCE;
    }
}
