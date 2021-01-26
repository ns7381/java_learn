package com.nathan.learn.base.classloader;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class URLClassLoaderDemo {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        URL urls[] = new URL[1];
        urls[0] = new URL("file:D:/Test_fat.jar");


        URLClassLoader ClassLoader = new URLClassLoader(urls);
        Class xClass = ClassLoader.loadClass("classLoad.Test");
        System.out.println("--------加载器1：" + xClass.getClassLoader());

        System.out.println("=======反射调用方法1");
        Object xObject = xClass.newInstance();
        xClass.getMethod("getStr").invoke(xObject);

        System.out.println("=======使用接口接收加载的对象1");
//        ITest test = (ITest)xClass.newInstance();
//        test.getStr();
    }
}
