package com.nathan.learn.base.grammar;

/**
 * Created by nathan on 18/1/10.
 */
public class StaticTest {
    public static void main(String[] args) {
//        staticFunction();
        StaticTest st = new StaticTest();
        System.out.println(b);
        StaticTest st2 = new StaticTest();
        System.out.println(b);
    }

//    static StaticTest st = new StaticTest();

    static {   //静态代码块
        System.out.println("1");
    }


    StaticTest() {    // 实例构造器
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }

    {       // 实例代码块
        System.out.println("2");
    }

    public static void staticFunction() {   // 静态方法
        System.out.println("4");
    }

    int a = 110;    // 实例变量
    static int b = 112;     // 静态变量
}
