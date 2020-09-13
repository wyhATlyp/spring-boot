package com.wyh.spring.source.circle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {
	
	public A() {
		System.out.println("A类构造方法");
	}
	
	@Autowired
	private B b;
	
	public B getB() {
		return b;
	}

}
