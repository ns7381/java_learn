package com.nathan.learn.spring.entity;

import org.apache.hadoop.mapreduce.JobStatus.State;
import org.apache.hadoop.yarn.api.records.YarnApplicationState;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "job")
public class JobEntity extends BaseObject{
    String srcPath;
    String srcCluster;
    String destPath;
    String destCluster;
    String applicationId;
    JobEntityState state;
    String message;

    public String getSrcPath() {
        return srcPath;
    }

    public void setSrcPath(String srcPath) {
        this.srcPath = srcPath;
    }

    public String getSrcCluster() {
        return srcCluster;
    }

    public void setSrcCluster(String srcCluster) {
        this.srcCluster = srcCluster;
    }

    public String getDestPath() {
        return destPath;
    }

    public void setDestPath(String destPath) {
        this.destPath = destPath;
    }

    public String getDestCluster() {
        return destCluster;
    }

    public void setDestCluster(String destCluster) {
        this.destCluster = destCluster;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    @Enumerated(EnumType.STRING)
    public JobEntityState getState() {
        return state;
    }

    public void setState(JobEntityState state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
