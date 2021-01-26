package com.nathan.learn.base.classloader;

/**
 * Created by nathan on 18/1/10.
 */
public class ClassLoaderTest {
    static {
        i = 0;
//        System.out.println(i);//Error：Cannot reference a field before it is defined（非法向前应用）
    }

    static int i = 1;

    public static void main(String[] args) {
        System.out.println(i);
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
    }
}
