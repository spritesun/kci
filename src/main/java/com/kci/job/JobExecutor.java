package com.kci.job;

import com.kci.entity.Job;
import com.kci.service.NotificationCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobExecutor {
    @Autowired
    private NotificationCenter nc;

    public void execute(Job job) {
        JobInstance jobInstance = JobTypes.valueOf(job.getType()).createJobInstance();
        jobInstance.execute();
        nc.notifyf("Job %s executed", job.getType());
    }
}
