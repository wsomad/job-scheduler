package com.wsomad.jobscheduler.service;

import com.wsomad.jobscheduler.model.Job;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Queue;

@Service
public class SchedulerService {
    private boolean isRunning = false;

    public void scheduleJobs(Queue<Job> jobQueue, List<Job> completedJobs) {
        if (isRunning) return;

        isRunning = true;

        new Thread(() -> {
            while (!jobQueue.isEmpty()) {
                Job job = jobQueue.poll();
                if (job == null) continue;

                job.setStatus("Running");

                try {
                    Thread.sleep(job.getJobDuration() * 1000L);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }

                job.setStatus("Completed");
                completedJobs.add(job);
            }
            isRunning = false;
        }).start();
    }
}
