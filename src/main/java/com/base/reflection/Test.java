package com.base.reflection;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        final Class<?> aClass = Class.forName("com.base.reflection.Person");
//        final Object o = aClass.newInstance();
//        System.out.println(o);
    }
}
