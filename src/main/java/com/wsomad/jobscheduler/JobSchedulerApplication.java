package com.wsomad.jobscheduler;

import com.wsomad.jobscheduler.scheduler.JobScheduler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JobSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobSchedulerApplication.class, args);

		Thread schedulerThread = new Thread(new JobScheduler());
		schedulerThread.start();
	}
}
