package com.wyh.springbootschedule.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.wyh.springbootschedule.factory.MyAdaptableJobFactory;
import com.wyh.springbootschedule.quartz.QuartzJob;

@Configuration
public class QuartzConfig {
	
	//1.创建JOB
	@Bean
	public JobDetailFactoryBean jobDetailFactoryBean() {
		JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
		jobDetailFactoryBean.setJobClass(QuartzJob.class);
		return jobDetailFactoryBean;
	}
	
	//2.创建触发器
	@Bean
	public CronTriggerFactoryBean cronTriggerFactoryBean() {
		CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
		cronTriggerFactoryBean.setCronExpression("0/3 * * * * ?");
		cronTriggerFactoryBean.setJobDetail(jobDetailFactoryBean().getObject());
		return cronTriggerFactoryBean;
	}
	
	//创建Scheduler
	@Bean
	public SchedulerFactoryBean schedulerFactoryBean(MyAdaptableJobFactory myAdaptableJobFactory) {
		SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
		schedulerFactoryBean.setTriggers(cronTriggerFactoryBean().getObject());
		schedulerFactoryBean.setJobFactory(myAdaptableJobFactory);
		return schedulerFactoryBean;
	}

}
