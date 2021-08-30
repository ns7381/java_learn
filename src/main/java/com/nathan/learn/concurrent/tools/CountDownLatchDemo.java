package com.nathan.learn.concurrent.tools;

import java.util.concurrent.CountDownLatch;
/**
 * Created by ning on 2015/10/12.
 */
// 计数器
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        // 总数是6，必须要执行任务的时候，再使用！
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <=6 ; i++) {
            new Thread(()->{


                countDownLatch.countDown(); // 数量-1
                System.out.println(Thread.currentThread().getName()+" Go out");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                },String.valueOf(i)).start();
        }

        countDownLatch.await(); // 等待计数器归零，然后再向下执行

        System.out.println("Close Door");

    }
}
