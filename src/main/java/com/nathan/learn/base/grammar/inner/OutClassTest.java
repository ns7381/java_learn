package com.nathan.learn.base.grammar.inner;

public class OutClassTest {
    int out1 = 1;
    static int out2 = 1;

    void out() {
        System.out.println("非静态");
    }

    static void outstatic() {
        System.out.println("静态");
    }

    public class InnerClass {
        void InnerClass() {
            System.out.println("InnerClass!");
            System.out.println(OutClassTest.this.out1);
            System.out.println(out2);
            out();
            outstatic();
        }

        // static void inner(){}  static int i=1; 非静态内部类不能有静态成员（方法、属性）
    }

    public static class InnerstaticClass {
        void InnerstaticClass() {
            System.out.println("InnerstaticClass");
//            OutClassTest.this.out1;
//              System.out.println(out1);静态内部类只能够访问外部类的静态成员
            System.out.println(out2);
            outstatic();
        }

        static void innerstatic() {
        }

        static int i = 1;//静态内部类能有静态成员（方法、属性）
    }

    public static void main(String args[]) {
        OutClassTest a = new OutClassTest();
        //创建静态内部类
        OutClassTest.InnerstaticClass b = new OutClassTest.InnerstaticClass();
        //创建非静态内部类
        OutClassTest.InnerClass c = a.new InnerClass();
    }
}

