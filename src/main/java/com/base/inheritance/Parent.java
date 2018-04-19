package com.base.inheritance;

/**
 * @author ningsheng
 * @version 1.0
 * @date 2018/1/12
 */
public class Parent {
    public void testA() {
        System.out.println("Parent testA.");
        testB();
    }

    protected void testB() {
        System.out.println("Parent testB.");
    }
}
