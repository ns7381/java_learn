package com.nathan.learn.spring.service;

import com.nathan.learn.spring.entity.JobEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleJobStatusUpdater {
    @Autowired
    private JobService jobService;

    @Scheduled(initialDelay = 10000, fixedRate = 5000)
    public void fixedDelayWithInitialDelayTask() {
        for (JobEntity job : jobService.getNotFinishJobs()) {
            jobService.updateJobEntityState(job);
        }
    }
}
