package com.concurent.tools;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ning on 2015/10/13.
 */
public class ProducerConsumer {
    // 初始化生产者线程池
    ExecutorService producerPool = Executors.newFixedThreadPool(3);
    // 初始化消费者线程池
    ExecutorService consumerPool = Executors.newFixedThreadPool(2);
    // 初始化管理者。
    ScheduledExecutorService supervisor = Executors.newSingleThreadScheduledExecutor();
    // 产品计件器
    AtomicInteger counter = new AtomicInteger(0);
    // 产品存放仓库。容量为5个。
    BlockingQueue<Integer> products = new LinkedBlockingQueue<Integer>(5);
    // 生产出的产品内容。从0递增。
    int product = 0;
    // 对生产过程上锁。
    Lock lock = new ReentrantLock();

    public void start() {
        // 提交管理任务，30秒以后执行。
        supervisor.schedule(new CloseTask(), 30, TimeUnit.SECONDS);
        // 开始生产
        new Producer().start();
        // 开始消费
        new Consumer().start();
    }

    // 生产者
    private class Producer extends Thread {
        // 初始化可重复的生产任务。
        Runnable task = new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                    int i;
                    try {
                        lock.lock(); // 对生产过程上锁。
                        i = ++product; // 生产内容
                    } finally {
                        lock.unlock();
                    }
                    System.out.println("Producing " + i);
                    products.put(i); // 放入仓库。
                    counter.getAndIncrement(); // 计件
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        public void run() {
            // 每隔300毫秒，向线程池提交一个生产任务。间隔如果太短，会导致队列过大outofmemory.
            while (!producerPool.isShutdown()) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                producerPool.execute(task);
            }
        }
    }

    // 消费者
    private class Consumer extends Thread {
        // 初始化可重复的消费任务。
        Runnable task = new Runnable() {
            public void run() {
                try {
                    Thread.sleep(800);
                    int i = products.take();
                    System.out.println("Consuming " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        public void run() {
            // 每隔400毫秒，向线程池提交一个消费任务。间隔如果太短，会导致队列过大outofmemory.
            while (!consumerPool.isShutdown()) {
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                consumerPool.execute(task);
            }
        }
    }

    // 管理者任务
    private class CloseTask implements Runnable {
        @Override
        public void run() {
            System.out.println("Try to close all tasks.");
            // 立刻关闭生产线程池。
            producerPool.shutdownNow();
            try {
                while (!producerPool.awaitTermination(1000, TimeUnit.MILLISECONDS)) ;
                // 循环等待线程池是否关闭
                System.out.println("Producer thread pool stops.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 等待生产仓库被清空。
            while (products.size() > 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // 立刻关闭生产线程池
            consumerPool.shutdownNow();
            try {
                while (!consumerPool.awaitTermination(1000, TimeUnit.MILLISECONDS)) ;
                // 循环等待是否关闭完成。
                System.out.println("Consumer thread pool stops.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(counter.get() + " products.");
            // 关闭管理者
            supervisor.shutdownNow();
        }

    }

    public static void main(String[] args) {
        new ProducerConsumer().start();
    }

}
