package com.concurent.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by nathan on 17/2/9.
 */
public class MutexEvenGenerator extends IntGenerator {
    private int val = 0;
    private Lock lock = new ReentrantLock();
    @Override
    public int next() {
        try{
            lock.lock();
            ++val;
            ++val;
            return val;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        EvenChecker.test(new MutexEvenGenerator());
    }
}
