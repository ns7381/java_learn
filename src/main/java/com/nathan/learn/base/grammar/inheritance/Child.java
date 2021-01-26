package com.nathan.learn.base.grammar.inheritance;

/**
 * @author nathan
 * @version 1.0
 * @date 2018/1/12
 */
public class Child extends Parent{
    private String test;
    private static String test2;

    public Child() {

        System.out.println("Parent construct test: " + test);
        System.out.println("Parent construct test2: " + test2);
    }

    private void testB() {
        System.out.println("Child test: "+test);
    }

    public static void main(String[] args) {
//        new Parent().testA();
        Parent child = new Child();
        child.testA();
        ((Child) child).testB();
    }
}
