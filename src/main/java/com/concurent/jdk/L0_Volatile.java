package com.concurent.jdk;

public class L0_Volatile {
    private static volatile boolean flag = true;

    // 线程可见性
    public static void main(String[] args) throws InterruptedException {
        new Thread(()-> {
            while (flag) {
                //do sth
            }
            System.out.println("end");
        }, "server").start();


        Thread.sleep(1000);

        flag = false;
    }
}
