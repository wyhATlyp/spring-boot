package com.wyh.springbootschedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootScheduleMain {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootScheduleMain.class, args);
	}

}
