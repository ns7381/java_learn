package com.concurent;

import java.util.concurrent.CountDownLatch;
/**
 * Created by ning on 2015/10/12.
 */
public class CDTest {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        Racer p1 = new Racer(countDownLatch,"A");
        p1.start();
        Racer p2 = new Racer(countDownLatch,"B");
        p2.start();
        Racer p3 = new Racer(countDownLatch,"C");
        p3.start();

        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
            countDownLatch.countDown();

        }
    }
}

class Racer extends Thread{
    private CountDownLatch countDownLatch;
    public Racer(CountDownLatch countDownLatch, String name){
        setName(name);
        this.countDownLatch = countDownLatch;
    }
    public void run(){
        System.out.println(getName()+" is waiting");
        try{
            countDownLatch.await();
            System.out.println(getName()+" is servicing");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName()+" is done");
    }
}