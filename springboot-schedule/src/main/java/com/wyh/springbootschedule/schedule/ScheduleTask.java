package com.wyh.springbootschedule.schedule;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTask {

	@Scheduled(cron = "0/2 * * * * ?")
	public void execute() {
		System.out.println(LocalDateTime.now());
	}
	
}
