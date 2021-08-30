package com.nathan.learn.interview;

import java.util.concurrent.Semaphore;

public class ThreadInterview {
    /**
     * 多线编程实现在屏幕上循环打印10次ABCABC…（三个线程ID分别是A、B、C）
     */
    public void printABC() {
        Semaphore semaphoresA = new Semaphore(1);
        Semaphore semaphoresB = new Semaphore(0);
        Semaphore semaphoresC = new Semaphore(0);
        new Thread("A") {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        semaphoresA.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print("A");
                    semaphoresB.release();

                }
            }
        }.start();
        new Thread("B") {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        semaphoresB.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print("B");
                    semaphoresC.release();
                }
            }
        }.start();
        new Thread("C") {
            @Override
            public void run() {

                for (int i = 0; i < 10; i++) {
                    try {
                        semaphoresC.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print("C");
                    semaphoresA.release();
                }
            }
        }.start();
    }

    public static void main(String[] args) {
        ThreadInterview interview = new ThreadInterview();
        interview.printABC();
    }
}
