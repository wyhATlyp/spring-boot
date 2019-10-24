package com.wyh.springbootschedule.schedule;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.wyh.springbootschedule.service.TestService;

@Component
public class ScheduleTask {
	
	@Autowired
	private TestService testService;

	@Scheduled(cron = "0/2 * * * * ?")
	public void execute() {
		System.out.println("Scheduler Exec...." + LocalDateTime.now());
		testService.test();
	}
	
}
