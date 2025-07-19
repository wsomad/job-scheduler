package com.wsomad.jobscheduler.scheduler;

import com.wsomad.jobscheduler.model.Job;

// Thread the process jobs
public class JobScheduler implements Runnable {

    @Override
    public void run() {
        System.out.println("Job Scheduler Started...");

        while (true) {
            try {
                Job job = JobQueue.getJob();
                System.out.println("Executing jobs: " + job.getJobName() + " for " + job.getJobDuration() + "s");

                // Pauses the thread in # milliseconds
                // So this means thread is blocked
                Thread.sleep(job.getJobDuration() * 10000L);

                System.out.println("Finished job - " + job.getJobName());
            } catch (InterruptedException e) {
                System.out.println("Scheduler was interrupted");
                break;
            }
        }
    }
}
