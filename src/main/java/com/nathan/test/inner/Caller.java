package com.nathan.test.inner;

/**
 * Created by nathan on 16/8/11.
 */
public class Caller {
    private Incrementable incrementable;

    public Caller(Incrementable incrementable) {
        this.incrementable = incrementable;
    }

    void go() {
        incrementable.increment();
    }

    public static void main(String[] args) {
        ClosureOut closureOut = new ClosureOut();
        Caller caller = new Caller(closureOut.getCallbackReference());
        caller.go();
        caller.go();
        caller.go();

    }
}
