package com.wsomad.jobscheduler.service;

import com.wsomad.jobscheduler.model.Job;
import com.wsomad.jobscheduler.scheduler.JobQueue;
import org.springframework.stereotype.Service;

@Service
public class JobService {
    public String submitJob(String jobName, int jobDuration) {
        Job job = new Job(jobName, jobDuration);
        JobQueue.addJob(job);
        return job.getJobId();
    }

    public int countPendingJobs() {
        return JobQueue.size();
    }
}
