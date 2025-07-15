package com.wsomad.jobscheduler.controller;

import com.wsomad.jobscheduler.model.Job;
import com.wsomad.jobscheduler.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    @Autowired
    private JobService jobService;

    @PostMapping("/submit")
    public ResponseEntity<Job> submitJob(@RequestBody Job job) {
        return ResponseEntity.ok(jobService.submitJob(job));
    }

    @GetMapping("/waiting")
    public List<Job> getWaitingJobs() {
        return jobService.getWaitingJobs();
    }

    @GetMapping("/completed")
    public List<Job> getCompletedJobs() {
        return jobService.getCompletedJobs();
    }
}
