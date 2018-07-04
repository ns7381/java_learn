package com.design.delegate;

public class DelegateTestDemo {
    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher(WorkerOne.class);
        dispatcher.work();
    }
}
