package com.nathan.learn.base.grammar.reflection;

public class Person {
    private final static String STATIC_STR = "sa";
    private String INSTANCE_STR = "sb";

    static {
        System.out.println("-------------------" + STATIC_STR);
    }

    public Person() {
        System.out.println("construct method: " + STATIC_STR);
        System.out.println("construct method: " + INSTANCE_STR);
    }

    {
        System.out.println("instance method: " + STATIC_STR);
        System.out.println("instance method: " + INSTANCE_STR);
    }
}
