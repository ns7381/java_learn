package com.nathan.learn.spring.service;

import com.nathan.learn.spring.dao.JobRepository;
import com.nathan.learn.spring.entity.JobEntity;
import com.nathan.learn.spring.entity.JobEntityState;
import com.nathan.learn.spring.exception.SyncJobRuntimeException;
import com.nathan.learn.spring.threadpool.ThreadPoolCreator;
import com.nathan.learn.spring.utils.HdfsUtils;
import com.nathan.learn.spring.utils.YarnUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.ExecutorService;

import static com.nathan.learn.spring.entity.JobEntityState.*;
import static com.nathan.learn.spring.exception.ErrorType.SOURCE_PATH_NOT_EXIST_ERROR;


@Service
public class JobService {
    private final Logger logger = LoggerFactory.getLogger(JobService.class);

    private final ExecutorService pool = ThreadPoolCreator.createBaseThreadPool("DistCp");
    @Autowired
    private JobRepository dao;

    public JobEntity create(String srcPath, String srcCluster, String destPath, String destCluster) {
        srcPath = HdfsUtils.parseHdfsPath(srcPath, srcCluster);
        destPath = HdfsUtils.parseHdfsPath(destPath, destCluster);
        if (!HdfsUtils.exist(srcPath)) {
            throw new SyncJobRuntimeException(SOURCE_PATH_NOT_EXIST_ERROR);
        }

        JobEntity job = new JobEntity();
        job.setState(NEW);
        job.setSrcPath(srcPath);
        job.setSrcCluster(srcCluster);
        job.setDestPath(destPath);
        job.setDestCluster(destCluster);
        JobEntity saveJob = dao.save(job);

        Path src = new Path(srcPath);
        Path dest = new Path(destPath);
        pool.execute(() -> {
            Job mrJob = null;
            try {
                mrJob = HdfsUtils.runDistCp(src, dest);
                saveJob.setApplicationId(mrJob.getJobID().appendTo(new StringBuilder("application")).toString());
                saveJob.setState(JobEntityState.fromJobState(mrJob.getJobState()));
                dao.save(saveJob);
            } catch (IOException | InterruptedException e) {
                if (mrJob != null && mrJob.getJobID() != null) {
                    saveJob.setState(UNDEFINED);
                    saveJob.setApplicationId(mrJob.getJobID().appendTo(new StringBuilder("application")).toString());
                } else {
                    saveJob.setState(FAILED);
                    saveJob.setMessage(e.getMessage());
                }
                dao.save(saveJob);
                logger.error("run distcp error.", e);
            }
        });
        return saveJob;
    }

    public JobEntity getJob(String jobId) {
        JobEntity jobEntity = dao.findById(jobId)
                .orElseThrow(() -> new SyncJobRuntimeException("JobId为" + jobId + "的Job不存在."));
        updateJobEntityState(jobEntity);
        return jobEntity;
    }

    public List<JobEntity> getNotFinishJobs() {
        return dao.findByApplicationIdNotNullAndStateIsIn(getNotFinishStates());
    }

    void updateJobEntityState(JobEntity jobEntity) {
        if (EnumSet.of(SUCCEEDED, FAILED, KILLED, NOT_FOUND).contains(jobEntity.getState())
                || StringUtils.isEmpty(jobEntity.getApplicationId())) {
            return;
        }

        JobEntityState newState = YarnUtils.getJobStateFromYarn(jobEntity.getApplicationId());
        if (!newState.equals(jobEntity.getState())) {
            jobEntity.setState(newState);
            dao.save(jobEntity);
        }
    }
}
