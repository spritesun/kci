package com.kci.service;

import com.kci.entity.Job;
import com.kci.entity.Pipeline;
import com.kci.entity.Stage;
import com.kci.job.JobExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuildService {

    @Autowired
    private GitService gitService;

    @Autowired
    private JobExecutor jobExecutor;

    public void trigger(Pipeline pipeline) {
        gitService.pull(pipeline.getRepository().getAbsolutePath());
        for (Stage stage : pipeline.getConfiguration().getStages()) {
            for (Job job : stage.getJobs()) {
                jobExecutor.execute(job);
            }
        }
    }
}
