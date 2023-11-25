/*
 * Ant Group
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.nathan.learn.design.util;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DAGSchedulerEventProcessLoop extends EventLoop<DAGSchedulerEvent> {
    private MetricRegistry metricRegistry = new MetricRegistry();

    /**
     * Timer that tracks the time to process messages in the DAGScheduler's event loop
     */
    private Timer timer =
            metricRegistry.timer(MetricRegistry.name("messageProcessingTime"));

    public DAGSchedulerEventProcessLoop() {
        super("dag-scheduler-event-loop");
    }

    @Override
    protected void onReceive(DAGSchedulerEvent event) {
        Timer.Context timerContext = timer.time();
        try {
            doOnReceive(event);
        } finally {
            timerContext.stop();
        }
    }

    private void doOnReceive(DAGSchedulerEvent event) {
        if (event instanceof JobSubmitted) {
            handleJobSubmitted(((JobSubmitted) event).getJobId());
        }
    }

    private void handleJobSubmitted(int jobId) {
        System.out.println("Job submitted: " + jobId);
    }

    @Override
    protected void onError(Throwable e) {
        log.error("DAGSchedulerEventProcessLoop failed; shutting down SparkContext", e);
        try {
//            doCancelAllJobs()
        } catch (Throwable t) {
            log.error("DAGScheduler failed to cancel all jobs.", t);
        }
    }
}