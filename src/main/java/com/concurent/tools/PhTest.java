package com.concurent.tools;

import java.util.concurrent.Phaser;

/**
 * Created by ning on 2015/10/12.
 */
public class PhTest {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);
        System.out.println("starting...");

        new Worker(phaser,"chushi").start();
        new Worker(phaser,"fuwuyuan").start();
        new Worker(phaser,"chuancaiyuan").start();

        for (int i = 0; i < 3; i++) {
            phaser.arriveAndAwaitAdvance();
            System.out.println("order: "+i+" finished");
        }
        phaser.arriveAndDeregister();
    }
}
class Worker extends Thread{
    private Phaser phaser;
    public Worker(Phaser phaser,String name){
        setName(name);
        this.phaser=phaser;
        phaser.register();
    }
    @Override
    public void run(){
        for (int i = 0; i < 3; i++) {
            System.out.println("current order is :"+i+" : "+getName());
            if(i==2){
                phaser.arriveAndDeregister();
            }else{
                phaser.arriveAndAwaitAdvance();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
