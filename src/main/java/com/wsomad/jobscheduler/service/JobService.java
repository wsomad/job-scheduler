package com.wsomad.jobscheduler.service;

import com.wsomad.jobscheduler.model.Job;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JobService {
    private final Queue<Job> jobQueue = new LinkedList<>();
    private final List<Job> completedJobs = new ArrayList<>();

    @Autowired
    private SchedulerService schedulerService;

    public Job submitJob(Job job) {
        job.setJobId(UUID.randomUUID().toString());
        job.setStatus("Waiting");
        jobQueue.offer(job);
        schedulerService.scheduleJobs(jobQueue, completedJobs);
        return job;
    }

    public List<Job> getWaitingJobs() {
        return new ArrayList<>(jobQueue);
    }

    public List<Job> getCompletedJobs() {
        return completedJobs;
    }
}
