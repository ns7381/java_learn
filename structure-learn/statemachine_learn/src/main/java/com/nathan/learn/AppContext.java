package com.nathan.learn;

import com.nathan.learn.demo.Job;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AppContext {
    private final Map<String, Job> jobs = new ConcurrentHashMap<String, Job>();

    public AppContext() {
    }

    public void addJob(Job job) {
        jobs.put(job.getJobId(), job);
    }

    public Job getJob(String jobID) {
        return jobs.get(jobID);
    }

    public Map<String, Job> getAllJobs() {
        return jobs;
    }

}
