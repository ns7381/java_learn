package com.nathan.learn.base.grammar.inheritance;

/**
 * @author nathan
 * @version 1.0
 * @date 2018/1/12
 */
public class Parent {
    private String test;
    private static String test2;

    public Parent() {
        System.out.println("Parent construct test: " + test);
        System.out.println("Parent construct test2: " + test2);
        this.test = "test";
    }

    static {
        System.out.println("Parent static test2: " + test2);
        test2 = "test2";
    }

    public void testA() {
        System.out.println("Parent testA.");
        testB();
    }

    private void testB() {
        System.out.println("Parent testB.");
    }
}
