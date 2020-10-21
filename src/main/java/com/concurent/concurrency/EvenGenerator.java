package com.concurent.concurrency;

/**
 * Created by nathan on 17/2/9.
 */
public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 10;
    @Override
    public int next() {
        ++currentEvenValue;
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
