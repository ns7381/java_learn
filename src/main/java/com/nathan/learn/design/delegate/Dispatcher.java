package com.nathan.learn.design.delegate;

public class Dispatcher implements ITask {

    private Class<? extends  ITask> clazz;

    public Dispatcher(Class<? extends  ITask> clazz){
        this.clazz = clazz;
    }
    @Override
    public void work() {
        try {
            clazz.getDeclaredMethod("work").invoke(clazz.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
