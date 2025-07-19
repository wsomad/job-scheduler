package com.wsomad.jobscheduler.controller;

import com.wsomad.jobscheduler.model.Job;
import com.wsomad.jobscheduler.scheduler.JobQueue;
import com.wsomad.jobscheduler.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jobs")
public class JobController {
    @Autowired
    private JobService jobService;

    @PostMapping("/add-job")
    public ResponseEntity<Map<String, Object>> addJob(@RequestParam String jobName, @RequestParam int jobDuration) {
        String jobId = jobService.submitJob(jobName, jobDuration);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Successfully submitted job");
        response.put("jobId", jobId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/pending")
    public ResponseEntity<List<String>> getPendingJobs() {
        List<String> names = JobQueue.getAllPendingJobs().stream()
                .map(Job::getJobName)
                .toList();
        return ResponseEntity.ok(names);
    }

    @GetMapping("/count")
    public ResponseEntity<Map<String, Object>> count() {
        int pending = jobService.countPendingJobs();

        Map<String, Object> response = new HashMap<>();
        response.put("pendingJobs", pending);

        return ResponseEntity.ok(response);
    }
}
