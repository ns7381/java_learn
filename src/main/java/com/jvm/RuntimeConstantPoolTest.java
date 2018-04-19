package com.jvm;

/**
 * Created by nathan on 18/1/3.
 */
public class RuntimeConstantPoolTest {
    public static void main(String[] args) {
        String s = new StringBuilder("极客").append("学院").toString();
        System.out.println(s.intern() == s);
    }
}
