package com.nathan.learn.concurrent.thread;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {
    public static void main(String[] args) {
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            // method call or code to be asynch.
            System.out.println("-----");
        });
    }
}
