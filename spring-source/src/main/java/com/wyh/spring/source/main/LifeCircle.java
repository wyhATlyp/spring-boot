package com.wyh.spring.source.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wyh.spring.source.bean.SpringIoc;
import com.wyh.spring.source.config.SpringSourceConfig;

/**
 * Spring生命周期：
 * 	1.实例化
 * 	2.属性注入
 * 	3.初始化
 * 	4.调用aware
 * 	5.aop
 * 	6.放入容器
 * 	7.销毁
 *
 */
public class LifeCircle {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringSourceConfig.class);
		System.out.println("容器初始化完成");
		System.out.println("=============================================");
		SpringIoc bean = ctx.getBean(SpringIoc.class);
		System.out.println("bean:" + bean.getClass());
		System.out.println("=============================================");
		bean.common();
		System.out.println("=============================================");
		ctx.close();
	}

}
