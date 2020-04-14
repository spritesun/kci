package com.kci.service;

import com.kci.entity.Build;
import com.kci.entity.Job;
import com.kci.entity.Pipeline;
import com.kci.entity.Stage;
import com.kci.job.JobExecutor;
import com.kci.repository.BuildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BuildService {

    @Autowired
    private GitService gitService;

    @Autowired
    private JobExecutor jobExecutor;
    @Autowired
    private BuildRepository buildRepository;

    public void trigger(Pipeline pipeline) {
        runJobs(pipeline);

        Build build = new Build(pipeline);
        buildRepository.save(build);
    }

    private void runJobs(Pipeline pipeline) {
        String localPath = pipeline.getRepository().getAbsolutePath();
        gitService.pull(localPath);
        for (Stage stage : pipeline.getConfiguration().getStages()) {
            for (Job job : stage.getJobs()) {
                jobExecutor.execute(job, localPath);
            }
        }
    }

    public List<Build> getBuilds() {
        return buildRepository.findAll();
    }
}
