/*
 * Ant Group
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.nathan.learn.base.grammar.inheritance;

/**
 * @author ningsheng
 * @version InterfaceClass.java, v 0.1 2021年10月22日 6:01 下午 ningsheng
 */
public interface InterfaceClass {
    int test = 1;
    String test2 = null;

    void test();

    default void test2() {
        System.out.println();
    }

    static void test3(){
        System.out.println("");
    }
}