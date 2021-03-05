package com.nathan.learn.base.grammar.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        final Class<?> aClass = Class.forName("com.nathan.learn.base.grammar.reflection.Person");
        final Object o = aClass.newInstance();
        System.out.println(o);

        Method method = aClass.getMethod("setUpdateTime", long.class);
        method.invoke(o, System.currentTimeMillis());
        System.out.println(o);
    }
}
