package com.base.inheritance;

/**
 * @author ningsheng
 * @version 1.0
 * @date 2018/1/12
 */
public class Child extends Parent{


    @Override
    protected void testB() {
        System.out.println("child testB.");
    }

    public static void main(String[] args) {
        new Parent().testA();
    }
}
