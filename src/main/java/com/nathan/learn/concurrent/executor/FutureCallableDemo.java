package com.nathan.learn.concurrent.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by nathan on 17/2/4.
 */
public class FutureCallableDemo {
    public static void main(String[] args) {
        long currentTimeMillis = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        
        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futures.add(executorService.submit(new TaskWithResult(i)));
        }

//        executorService.shutdown();
        for (Future<String> future : futures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                executorService.shutdown();
            }
        }
        System.out.println(System.currentTimeMillis() - currentTimeMillis);
    }
}

class TaskWithResult implements Callable<String> {
    private final int id;

    public TaskWithResult(int i) {
        this.id = i;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "result of task " + id;
    }
}