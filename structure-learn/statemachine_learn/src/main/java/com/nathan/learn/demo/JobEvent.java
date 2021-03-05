package com.nathan.learn.demo;

import com.nathan.learn.event.AbstractEvent;

/**
 * This class encapsulates job related events.
 */
public class JobEvent extends AbstractEvent<JobEventType> {

    private String jobID;

    public JobEvent(String jobID, JobEventType type) {
        super(type);
        this.jobID = jobID;
    }

    public String getJobId() {
        return jobID;
    }

}
