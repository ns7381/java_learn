package com.base.inner;

/**
 * Created by nathan on 16/8/8.
 */
public class Outer {
    private class Inner{

    }

    public static void main(String[] args) {
//        Outer outer = new Outer();
//        Inner inner = outer.new Inner();
        OutClassTest a = new OutClassTest();
        //创建静态内部类
        OutClassTest.InnerstaticClass b = new OutClassTest.InnerstaticClass();
        //创建非静态内部类
        OutClassTest.InnerClass c = a.new InnerClass();
    }
}
