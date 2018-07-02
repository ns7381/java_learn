package com.design.delegate;

public class WorkerOne implements ITask {
    @Override
    public void work() {
        System.out.println("第一个人需要完成的事情");
    }
}