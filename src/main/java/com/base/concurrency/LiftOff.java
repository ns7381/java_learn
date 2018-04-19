package com.base.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Created by nathan on 17/2/3.
 */
public class LiftOff implements Runnable {
    private int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());
//            Thread.yield();
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private String status() {
        return "#" +id +"(" +
                (countDown>0?countDown:"lift off!")
                +"), ";
    }
}
