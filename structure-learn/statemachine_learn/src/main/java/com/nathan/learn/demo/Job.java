package com.nathan.learn.demo;

import com.nathan.learn.event.EventHandler;
import com.nathan.learn.state.InvalidStateTransitionException;
import com.nathan.learn.state.SingleArcTransition;
import com.nathan.learn.state.StateMachine;
import com.nathan.learn.state.StateMachineFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Job implements EventHandler<JobEvent> {
    private static final Logger LOG = LoggerFactory.getLogger(Job.class);

    private String jobId;
    private final Lock readLock;
    private final Lock writeLock;
    private final EventHandler eventHandler;

    private static final InternalErrorTransition
            INTERNAL_ERROR_TRANSITION = new InternalErrorTransition();
    protected static final
    StateMachineFactory<Job, JobStateInternal, JobEventType, JobEvent>
            stateMachineFactory
            = new StateMachineFactory<Job, JobStateInternal, JobEventType, JobEvent>
            (JobStateInternal.NEW)

            // Transitions from NEW state
            .addTransition(JobStateInternal.NEW, JobStateInternal.FAIL_ABORT,
                    JobEventType.JOB_INIT_FAILED,
                    new InitFailedTransition())
            .addTransition(JobStateInternal.NEW, JobStateInternal.ERROR,
                    JobEventType.INTERNAL_ERROR,
                    INTERNAL_ERROR_TRANSITION)
            // Ignore-able events
            .addTransition(JobStateInternal.NEW, JobStateInternal.NEW,
                    JobEventType.JOB_UPDATED_NODES)
            .installTopology();
    private final StateMachine<JobStateInternal, JobEventType, JobEvent> stateMachine;

    public Job(String jobId, EventHandler eventHandler) {
        this.jobId = jobId;
        this.eventHandler = eventHandler;
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        this.readLock = readWriteLock.readLock();
        this.writeLock = readWriteLock.writeLock();
        // This "this leak" is okay because the retained pointer is in an
        //  instance variable.
        stateMachine = stateMachineFactory.make(this);
    }

    /**
     * The only entry point to change the Job.
     */
    @Override
    public void handle(JobEvent event) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Processing " + event.getJobId() + " of type "
                    + event.getType());
        }
        try {
            writeLock.lock();
            JobStateInternal oldState = getInternalState();
            try {
                getStateMachine().doTransition(event.getType(), event);
            } catch (InvalidStateTransitionException e) {
                LOG.error("Can't handle this event at current state", e);
                eventHandler.handle(new JobEvent(this.jobId,
                        JobEventType.INTERNAL_ERROR));
            }
            //notify the eventhandler of state change
            if (oldState != getInternalState()) {
                LOG.info(jobId + "Job Transitioned from " + oldState + " to "
                        + getInternalState());
            }
        } finally {
            writeLock.unlock();
        }
    }

    protected StateMachine<JobStateInternal, JobEventType, JobEvent> getStateMachine() {
        return stateMachine;
    }

    public JobStateInternal getInternalState() {
        readLock.lock();
        try {
            return getStateMachine().getCurrentState();
        } finally {
            readLock.unlock();
        }
    }

    private static class InitFailedTransition
            implements SingleArcTransition<Job, JobEvent> {
        @Override
        public void transition(Job job, JobEvent event) {
            job.eventHandler.handle(new JobEvent(job.jobId, JobEventType.JOB_COMPLETED));
        }
    }

    private static class InternalErrorTransition extends InternalTerminationTransition {
        public InternalErrorTransition(){
            super(JobStateInternal.ERROR, JobStateInternal.ERROR.toString());
        }
    }



    private static class InternalTerminationTransition implements
            SingleArcTransition<Job, JobEvent> {
        JobStateInternal terminationState = null;
        String jobHistoryString = null;
        public InternalTerminationTransition(JobStateInternal stateInternal,
                                             String jobHistoryString) {
            this.terminationState = stateInternal;
            //mostly a hack for jbhistoryserver
            this.jobHistoryString = jobHistoryString;
        }

        @Override
        public void transition(Job job, JobEvent event) {
            //TODO Is this JH event required.
            System.exit(0);
        }
    }

    public String getJobId() {
        return jobId;
    }
}
