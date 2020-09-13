package com.wyh.spring.source.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SpringSourceAop {
	
	@Before("within(com.wyh.spring.source.bean..*)")
    public void before(JoinPoint joinPoint) {
		System.out.println("before aop!");
		System.out.println("目标类：" + joinPoint.getTarget().getClass());
		System.out.println("目标方法：" + joinPoint.getSignature());
    }

}
