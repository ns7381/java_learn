package com.test;


/**
 * Created by nathan on 16/7/26.
 */
class A {
    static {
        System.out.println("------");
    }

    static int i = 10;

    static {
        i = 20;
        System.out.println("static-i: " + i);
    }

    A() {
        i = 30;
        System.out.println("construct-i: " + i);
        System.out.println("construct-j: " + j);
    }

    int j = 10;

    public void print() {
        System.out.println("method: " + i);
    }
}

class B extends A {
    static int i;

    static {
        i = 20;
        System.out.println("B static: " + i);
    }

    B() {
        i = 30;
        j = 30;
        System.out.println("B construct: " + i);
    }

    public void print() {
        System.out.println("B");
    }
}

class Test {
    public static void main(String[] args) {
        A objectB = (A) new B();
        objectB.print();

    }
}
