package com.wsomad.jobscheduler.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    private String jobId = UUID.randomUUID().toString();
    private String jobName;
    private int jobDuration;

    public Job(String jobName, int jobDuration) {
        this.jobId = UUID.randomUUID().toString();  // Auto-generated
        this.jobName = jobName;
        this.jobDuration = jobDuration;
    }
}
