package com.nathan.learn.spring.entity;

import org.apache.hadoop.mapreduce.JobStatus;
import org.apache.hadoop.yarn.api.records.FinalApplicationStatus;
import org.apache.hadoop.yarn.api.records.YarnApplicationState;

import java.util.ArrayList;
import java.util.List;


public enum JobEntityState {
    /**
     * 已创建
     */
    NEW,
    /**
     * 已提交
     */
    SUBMITTED,
    /**
     * 正在排队中
     */
    ACCEPTED,
    /**
     * 正在运行中
     */
    RUNNING,
    /**
     * 运行成功
     */
    SUCCEEDED,
    /**
     * 运行失败
     */
    FAILED,
    /**
     * 未知状态
     */
    UNDEFINED,
    /**
     * 任务被杀
     */
    KILLED,
    /**
     * 未找到yarn对应的application
     */
    NOT_FOUND;

    public static JobEntityState fromJobState(JobStatus.State state) {
        switch (state) {
            case PREP:
                return NEW;
            case RUNNING:
                return RUNNING;
            case KILLED:
                return KILLED;
            case FAILED:
                return FAILED;
            case SUCCEEDED:
                return SUCCEEDED;
            default:
                return UNDEFINED;
        }
    }

    public static JobEntityState fromApplicationState(YarnApplicationState applicationState, FinalApplicationStatus finalApplicationStatus) {
        switch (applicationState) {
            case NEW:
            case NEW_SAVING:
                return NEW;
            case SUBMITTED:
                return SUBMITTED;
            case ACCEPTED:
                return ACCEPTED;
            case RUNNING:
                return RUNNING;
            case KILLED:
                return KILLED;
            case FAILED:
                return FAILED;
            case FINISHED:
                switch (finalApplicationStatus) {
                    case SUCCEEDED:
                        return SUCCEEDED;
                    case FAILED:
                        return FAILED;
                    case KILLED:
                        return KILLED;
                    default:
                        return UNDEFINED;
                }
            default:
                return UNDEFINED;
        }
    }

    public static List<JobEntityState> getNotFinishStates() {
        List<JobEntityState> states = new ArrayList<>();
        states.add(NEW);
        states.add(SUBMITTED);
        states.add(ACCEPTED);
        states.add(RUNNING);
        return states;
    }
}
