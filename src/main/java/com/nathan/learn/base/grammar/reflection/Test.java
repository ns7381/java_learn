package com.nathan.learn.base.grammar.reflection;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        final Class<?> aClass = Class.forName("com.nathan.learn.base.grammar.reflection.Person");
        final Object o = aClass.newInstance();
        System.out.println(o);
    }
}
