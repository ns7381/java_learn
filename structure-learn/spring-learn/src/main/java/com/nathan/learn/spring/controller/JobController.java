package com.nathan.learn.spring.controller;

import com.nathan.learn.spring.entity.JobEntity;
import com.nathan.learn.spring.service.JobService;
import com.nathan.learn.spring.utils.Result;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("jobs")
public class JobController {
    private final Logger logger = LoggerFactory.getLogger(JobController.class);
    @Autowired
    private JobService jobService;

    @PostMapping("/submit")
    @ResponseBody
    public Result submit(@RequestBody @Valid JobParamVO jobParamVO) {
        JobEntity jobEntity = jobService.create(jobParamVO.getSrcPath(), jobParamVO.getSrcCluster(),
                jobParamVO.getDestPath(), jobParamVO.getDestCluster());
        return Result.Builder.ok().withData(jobEntity).build();
    }

    @GetMapping("/{jobId}")
    @ResponseBody
    public Result getStatus(@PathVariable String jobId) {
        JobEntity jobEntity = jobService.getJob(jobId);
        return Result.Builder.ok().withData(jobEntity).build();
    }

    @Data
    @NoArgsConstructor
    static class JobParamVO {
        @NotBlank(message = "源路径不能为空")
        String srcPath;
        @NotBlank(message = "源路径对应的集群不能为空")
        String srcCluster;
        @NotBlank(message = "目的路径不能为空")
        String destPath;
        @NotBlank(message = "目的路径对应的集群不能为空")
        String destCluster;
    }
}
