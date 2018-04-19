package com.concurent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by ning on 2015/10/12.
 */
public class CBTest {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("game start");
            }
        });
        new player(cyclicBarrier,"A").start();
        new player(cyclicBarrier,"B").start();
        new player(cyclicBarrier,"C").start();
    }
}
class player extends Thread{
    private CyclicBarrier cyclicBarrier;
    public player(CyclicBarrier cyclicBarrier,String name){
        setName(name);
        this.cyclicBarrier = cyclicBarrier;
    }
    public void run(){
        System.out.println(getName()+" is waiting other player");
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}