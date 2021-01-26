package com.nathan.learn.concurrent.jdk.thread;

public class ThreadLocalExample {

    public class MyRunnable implements Runnable {

        private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

        @Override
        public void run() {
            threadLocal.set((int) (Math.random() * 100D));

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }

            System.out.println(Thread.currentThread().getName()+threadLocal.get());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final ThreadLocalExample threadLocalExample = new ThreadLocalExample();
        final MyRunnable sharedRunnableInstance = threadLocalExample.new MyRunnable();

        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);
        thread1.setName("thread 1 ");
        thread2.setName("thread 2 ");
        thread1.start();
        thread2.start();

        thread1.join(); //wait for thread 1 to terminate
        thread2.join(); //wait for thread 2 to terminate
    }

}
