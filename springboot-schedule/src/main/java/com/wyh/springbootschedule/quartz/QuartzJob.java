package com.wyh.springbootschedule.quartz;

import java.time.LocalDateTime;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import com.wyh.springbootschedule.service.TestService;

@Component
public class QuartzJob extends QuartzJobBean {
	
	@Autowired
	private TestService testService;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		System.out.println("Quartz Exec...." + LocalDateTime.now());
		testService.test();
	}
	
}
