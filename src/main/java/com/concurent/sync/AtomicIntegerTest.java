package com.concurent.sync;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ning on 2015/10/13.
 */
public class AtomicIntegerTest {
    public AtomicInteger inc = new AtomicInteger();

    public  void increase() {
        inc.getAndIncrement();
    }

    public static void main(String[] args) {
        final AtomicIntegerTest test = new AtomicIntegerTest();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++) {
                        test.increase();
                    }
                }
            }.start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(test.inc);
    }
}
