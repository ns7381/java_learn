package com.nathan.learn.demo;

/**
 * Event types handled by Job.
 */
public enum JobEventType {

    //Producer:Client
    JOB_KILL,

    //Producer:MRAppMaster
    JOB_INIT,
    JOB_INIT_FAILED,
    JOB_START,

    //Producer:Task
    JOB_TASK_COMPLETED,
    JOB_MAP_TASK_RESCHEDULED,
    JOB_TASK_ATTEMPT_COMPLETED,

    //Producer:CommitterEventHandler
    JOB_SETUP_COMPLETED,
    JOB_SETUP_FAILED,
    JOB_COMMIT_COMPLETED,
    JOB_COMMIT_FAILED,
    JOB_ABORT_COMPLETED,

    //Producer:Job
    JOB_COMPLETED,
    JOB_FAIL_WAIT_TIMEDOUT,

    //Producer:Any component
    JOB_DIAGNOSTIC_UPDATE,
    INTERNAL_ERROR,
    JOB_COUNTER_UPDATE,

    //Producer:TaskAttemptListener
    JOB_TASK_ATTEMPT_FETCH_FAILURE,

    //Producer:RMContainerAllocator
    JOB_UPDATED_NODES,
    JOB_AM_REBOOT
}
