package com.nathan.test.inner;

/**
 * Created by nathan on 16/8/11.
 */
public class ClosureOut extends MyIncrement {
    private int i = 0;
    @Override
    public void increment() {
        super.increment();
        System.out.println(i++);
    }

    private class Clousure implements Incrementable {

        @Override
        public void increment() {
            ClosureOut.this.increment();
        }

        Incrementable getIncrementable() {
            return new Clousure();
        }
    }

    public Incrementable getCallbackReference() {
        return new Clousure();
    }
}
