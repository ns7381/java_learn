package com.design.delegate;

public class WorkTwo implements ITask{
    @Override
    public void work() {
        System.out.println("第二个人需要完成的事情");
    }
}
