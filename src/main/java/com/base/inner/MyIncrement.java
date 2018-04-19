package com.base.inner;

/**
 * Created by nathan on 16/8/11.
 */
public class MyIncrement {
    public void increment() {
        System.out.println("other operation");
    }

    public static void f(MyIncrement myIncrement) {
        myIncrement.increment();
    }
}
