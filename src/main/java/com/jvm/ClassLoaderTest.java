package com.jvm;

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
    }
}
