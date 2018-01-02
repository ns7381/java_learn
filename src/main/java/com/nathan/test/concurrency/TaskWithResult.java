package com.nathan.test.concurrency;

import java.util.concurrent.Callable;

/**
 * Created by nathan on 17/2/4.
 */
public class TaskWithResult implements Callable<String> {
    private final int id;

    public TaskWithResult(int i) {
        this.id = i;
    }

    @Override
    public String call() throws Exception {
        return "result of task "+id;
    }
}
