package com.wyh.spring.source.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wyh.spring.source.circle.A;
import com.wyh.spring.source.config.SpringSourceConfig;

/**
 * Spring 循环引用
 *
 */
public class CircleDI {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringSourceConfig.class);
		A a = ctx.getBean(A.class);
//		a.getB().getA().getB();
		a.getB().getA();
		ctx.close();
	}

}
