package com.design;

/**
 * @author ningsheng
 * @version 1.0
 * @date 2018/4/24
 */
public class RealSubject implements Subject {

    @Override
    public void run() {
        System.out.println("I`m running");
    }

    @Override
    public void hello(String str) {
        System.out.println("say hello to " + str);
    }
}
