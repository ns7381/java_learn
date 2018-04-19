package com.base.inner;

/**
 * Created by nathan on 16/8/8.
 */
public class Outer {
    private class Inner{

    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        Inner inner = outer.new Inner();
    }
}
