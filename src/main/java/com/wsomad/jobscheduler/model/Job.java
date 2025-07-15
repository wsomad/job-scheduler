package com.wsomad.jobscheduler.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    private String jobId;
    private String jobName;
    private int jobDuration;
    private int jobPriority;
    private String status;
}
