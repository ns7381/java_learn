package com.nathan.learn.concurrent.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试ReentrantLock可中断锁的效果
 */
public class ThreadInteruptExample {
    ReentrantLock lock1 = new ReentrantLock();
    ReentrantLock lock2 = new ReentrantLock();

    /**
     * ReentrantLock响应中断
     *
     * @throws Exception
     */
    public void reentrantLockInterupt() throws Exception {
        Thread t1 = new Thread(new ReentrantLockTask(lock1, lock2));
        Thread t2 = new Thread(new ReentrantLockTask(lock2, lock1));
        t1.start();
        t2.start();
        System.out.println(t1.getName() + "中断");
        //主线程睡眠1秒，避免线程t1直接响应run方法中的睡眠中断
        Thread.sleep(1000);
        t1.interrupt();
        //阻塞主线程，避免所有线程直接结束，影响死锁效果
        Thread.sleep(10000);
    }


    /**
     * Synchronized响应中断
     *
     * @throws Exception
     */
    public void synchronizedInterupt() throws Exception {
        Object syn1 = new Object();
        Object syn2 = new Object();
        Thread t1 = new Thread(new SynchronizedTask(syn1, syn2));
        Thread t2 = new Thread(new SynchronizedTask(syn2, syn1));
        t1.start();
        t2.start();
        System.out.println(t1.getName() + "中断");
        //主线程睡眠1秒，避免线程t1直接响应run方法中的睡眠中断
        Thread.sleep(1000);
        t1.interrupt();
        //阻塞主线程，避免所有线程直接结束，影响死锁效果
        Thread.sleep(1000);
    }

    /**
     * ReentrantLock实现死锁
     */
    static class ReentrantLockTask implements Runnable {

        ReentrantLock lock1;
        ReentrantLock lock2;

        public ReentrantLockTask(ReentrantLock lock1, ReentrantLock lock2) {
            this.lock1 = lock1;
            this.lock2 = lock2;
        }

        @Override
        public void run() {
            try {
                //可中断的获取锁
                lock1.lockInterruptibly();
                //lock1.lock();
                //睡眠200毫秒，保证两个线程分别已经获取到两个锁，实现相互的锁等待
                TimeUnit.MILLISECONDS.sleep(200);
                //lock2.lock();
                //可中断的获取锁
                lock2.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock1.unlock();
                lock2.unlock();
                System.out.println("线程" + Thread.currentThread().getName() + "正常结束");
            }

        }
    }

    /**
     * Synchronized实现死锁
     */
    static class SynchronizedTask implements Runnable {

        Object lock1;
        Object lock2;

        public SynchronizedTask(Object lock1, Object lock2) {
            this.lock1 = lock1;
            this.lock2 = lock2;
        }

        @Override
        public void run() {
            try {
                synchronized (lock1) {
                    //睡眠200毫秒，再获取另一个锁，
                    //保证两个线程分别已经获取到两个锁，实现相互的锁等待
                    Thread.sleep(200);
                    synchronized (lock2) {
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("线程" + Thread.currentThread().getName() + "正常结束");
            }

        }
    }

    public static void main(String[] args) throws Exception {
        ThreadInteruptExample demo = new ThreadInteruptExample();
        ThreadInteruptExample demo1 = new ThreadInteruptExample();
        demo.reentrantLockInterupt();
        demo1.synchronizedInterupt();
    }

}