package com.wyh.spring.source.circle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class B {

	public B() {
		System.out.println("B类构造方法");
	}
	
	@Autowired
	private A a;
	
	public A getA() {
		return a;
	}
	
}
