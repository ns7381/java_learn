package com.design.singleton;

import java.io.Serializable;

public class SerSingleton implements Serializable {
    String name;
    private SerSingleton(){
        System.out.println("Singleton is creating");
    }

    private static SerSingleton instance = new SerSingleton();

    public static SerSingleton getInstance(){
        return instance;
    }

    public static void createString(){
        System.out.println("create string in singleton");
    }
    private Object readResolve(){
        System.out.println("read resolve");
        return instance;
    }
}
