package com.wyh.springbootschedule.factory;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

@Component("myAdaptableJobFactory")
public class MyAdaptableJobFactory extends AdaptableJobFactory  {
	
	@Autowired
	private AutowireCapableBeanFactory autowireCapableBeanFactory;
	
	@Override
	protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
		Object obj = super.createJobInstance(bundle);
		//将obj对象添加Spring IOC容器中，并完成注入
		this.autowireCapableBeanFactory.autowireBean(obj);
		return obj;
	}

}
