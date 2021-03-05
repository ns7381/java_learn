package com.nathan.learn.demo;


public enum JobStateInternal {
    NEW,
    SETUP,
    INITED,
    RUNNING,
    COMMITTING,
    SUCCEEDED,
    FAIL_WAIT,
    FAIL_ABORT,
    FAILED,
    KILL_WAIT,
    KILL_ABORT,
    KILLED,
    ERROR,
    REBOOT
}
