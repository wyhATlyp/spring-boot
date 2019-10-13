package com.wyh.springbootweb.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Spring boot 用注解方式整合listener
 * @author Administrator
 *
 */
@WebListener
public class AnnotationListener implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("l-Spring boot 用注解方式整合listener-服务启动了(程序启动时在控制台打印)");
	}

}
