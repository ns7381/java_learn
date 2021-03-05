package com.nathan.learn;

import com.nathan.learn.demo.Job;
import com.nathan.learn.demo.JobEvent;
import com.nathan.learn.demo.JobEventType;
import com.nathan.learn.event.AsyncDispatcher;
import com.nathan.learn.event.Dispatcher;
import com.nathan.learn.event.EventHandler;

public class App {
    private String jobId;
    private AsyncDispatcher dispatcher;
    private AppContext context;
    private JobEventDispatcher jobEventDispatcher;

    public static void main(String[] args) throws Exception {
        new App().initAndStart();
    }

    private void initAndStart() throws Exception {
        jobId = "mock_001";
        context = new AppContext();
        dispatcher = new AsyncDispatcher();

        this.jobEventDispatcher = new JobEventDispatcher();
        //register the event dispatchers
        dispatcher.register(JobEventType.class, jobEventDispatcher);

        Job job = createJob();
        context.addJob(job);

        JobEvent initJobEvent = new JobEvent(jobId, JobEventType.JOB_INIT);
        // Send init to the job (this does NOT trigger job execution)
        // This is a synchronous call, not an event through dispatcher. We want
        // job-init to be done completely here.
        jobEventDispatcher.handle(initJobEvent);

        dispatcher.start();

        JobEvent initFailedEvent = new JobEvent(jobId, JobEventType.JOB_INIT_FAILED);
        jobEventDispatcher.handle(initFailedEvent);
    }


    /**
     * Create and initialize (but don't start) a single job.
     */
    protected Job createJob() {
        // create single job
        Job newJob = new Job(jobId, dispatcher.getEventHandler());
        return newJob;
    } // end createJob()

    private class JobEventDispatcher implements EventHandler<JobEvent> {
        @SuppressWarnings("unchecked")
        @Override
        public void handle(JobEvent event) {
            ((EventHandler<JobEvent>) context.getJob(event.getJobId())).handle(event);
        }
    }
}
