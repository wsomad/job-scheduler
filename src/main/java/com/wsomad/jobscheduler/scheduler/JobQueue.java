package com.wsomad.jobscheduler.scheduler;

import com.wsomad.jobscheduler.model.Job;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class JobQueue {
    // Over here, we define a static instance object
    // static final means this object can't be override and can't be change
    private static final BlockingQueue<Job> jobQueue = new LinkedBlockingQueue<>();

    public static void addJob(Job job) {
        // To put the job into the queue
        System.out.println("Job added: " + job.getJobName() + " | Queue size: " + jobQueue.size());
        jobQueue.offer(job);
    }

    public static Job getJob() throws InterruptedException {
        // Use take() to return elements when only it is available (wait)
        // Different to poll() where it returns null although element queue is empty
        return jobQueue.take();
    }

    public static List<Job> getAllPendingJobs() {
        return new ArrayList<>(jobQueue); // copies the queue
    }

    public static int size() {
        // Returns size of queue
        System.out.println("Checking queue size: " + jobQueue.size());
        return jobQueue.size();
    }
}
