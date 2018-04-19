package com.base.generic;

/**
 * Created by nathan on 16/9/14.
 */
public class SimpleGeneric<T> {
    private T a;

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public SimpleGeneric(T a) {
        this.a = a;
    }

    public static void main(String[] args) {
        SimpleGeneric<Automile> test = new SimpleGeneric<>(new Automile());
        Automile a = test.getA();
    }
}
