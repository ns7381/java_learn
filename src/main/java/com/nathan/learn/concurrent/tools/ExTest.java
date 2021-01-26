package com.nathan.learn.concurrent.tools;

import java.util.concurrent.Exchanger;

/**
 * Created by ning on 2015/10/12.
 */
public class ExTest {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<String>();
        new A(exchanger).start();
        new B(exchanger).start();

    }
}

class A extends Thread {
    private Exchanger<String> exchanger;

    public A(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    public void run() {
        String str = null;
        try {
            str = exchanger.exchange("Hello?");
            System.out.println(str);
            str = exchanger.exchange("A");
            System.out.println(str);
            str = exchanger.exchange("B");
            System.out.println(str);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class B extends Thread {
    private Exchanger<String> exchanger;

    public B(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    public void run() {
        String str = null;
        try {
            str = exchanger.exchange("hi?");
            System.out.println(str);
            str = exchanger.exchange("1");
            System.out.println(str);
            str = exchanger.exchange("2");
            System.out.println(str);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}