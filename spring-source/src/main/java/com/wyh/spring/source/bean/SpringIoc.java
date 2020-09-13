package com.wyh.spring.source.bean;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpringIoc implements BeanNameAware, DisposableBean {
	
	public SpringIoc() {
		System.out.println("SpringIoc构造方法");
	}
	
	public SpringIocProperties springIocProperties;
	
	@Autowired
	public void setSpringIocProperties(SpringIocProperties springIocProperties) {
		this.springIocProperties = springIocProperties;
		System.out.println("SpringIoc通过set方法完成属性注入");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("SpringIoc生命周期回调方法");
	}
	
	public void common() {
		System.out.println("调用了SpringIoc普通方法");
	}

	//重写BeanNameAware
	public void setBeanName(String name) {
		System.out.println("SpringIoc实现了BeanNameAware");
	}

	//重写DisposableBean
	public void destroy() throws Exception {
		System.out.println("SpringIoc对象销毁");
	}

}

@Component
class SpringIocProperties {
	
}
