package com.batch.example.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class JobController {
    @Autowired
    JobLauncher jobLauncher;
    @Autowired
    Job job;

   @GetMapping("/addData")
   public void excelDataToDB() {
       try{
         JobParameters parameters=new JobParametersBuilder()
         .addLong("startAt", System.currentTimeMillis()).toJobParameters();

         jobLauncher.run(job, parameters);
       }
       catch(JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException | JobParametersInvalidException e){
        e.printStackTrace();
       }
   }
   
}
