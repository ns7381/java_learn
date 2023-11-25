/*
 * Ant Group
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.nathan.learn.design.util;

public class PostEvent {
    public static void main(String[] args) throws InterruptedException {
        EventLoop<DAGSchedulerEvent> eventProcessLoop = new DAGSchedulerEventProcessLoop();
        eventProcessLoop.start();
        eventProcessLoop.post(new JobSubmitted());

        Thread.sleep(1000000);
    }
}