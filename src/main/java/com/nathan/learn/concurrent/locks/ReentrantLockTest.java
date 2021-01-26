package com.nathan.learn.concurrent.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ning on 2015/10/13.
 */
public class ReentrantLockTest {
    public  int inc = 0;
    Lock lock = new ReentrantLock();

    public  void increase() {
        lock.lock();
        try {
            inc++;
        } finally{
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final ReentrantLockTest test = new ReentrantLockTest();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++) {
                        test.increase();
                    }
                }
            }.start();
        }

       Thread.sleep(1000);
        System.out.println(test.inc);
    }
}
