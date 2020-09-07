package com.base.effective;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by nathan on 17/7/20.
 */
public class StopThread {
    private static volatile boolean stopRequested;
    private static final AtomicLong nextSerailNum = new AtomicLong();

    public static long generateSerailNumber() {
        return nextSerailNum.getAndIncrement();
    }
    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested) {
                i++;
            }
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}
