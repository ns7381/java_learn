package com.nathan.learn.concurrent.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class SpinlockDemo {

    // int   0
    // Thread  null
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    // 加锁
    public void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "==> mylock");

        // 自旋锁
        while (!atomicReference.compareAndSet(null, thread)) {

        }
    }

    // 解锁
    // 加锁
    public void myUnLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "==> myUnlock");
        atomicReference.compareAndSet(thread, null);
    }

    public static void main(String[] args) throws InterruptedException {
//        ReentrantLock reentrantLock = new ReentrantLock();
//        reentrantLock.lock();
//        reentrantLock.unlock();

        // 底层使用的自旋锁CAS
        SpinlockDemo lock = new SpinlockDemo();


        new Thread(() -> {
            lock.myLock();

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.myUnLock();
            }

        }, "T1").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            lock.myLock();

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.myUnLock();
            }

        }, "T2").start();

    }
}

