package com.wyh.springboot.source.tomcat;

import java.io.File;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

public class TomcatMain {
	
	public static void main(String[] args) throws LifecycleException {
		//创建tomcat容器
		final String baseDir = new File(".").getAbsolutePath();
		System.out.println("baseDir:" + baseDir);
		
		Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir(baseDir);
        
        Connector connector = new Connector();
        connector.setPort(8080); // 端口号
        connector.setURIEncoding("UTF-8");
        tomcat.getService().addConnector(connector);

        Context context = tomcat.addWebapp("/springboot-source", baseDir);
        tomcat.addServlet("/springboot-source", "IndexServlet", new IndexServlet());
        context.addServletMappingDecoded("/index.do", "IndexServlet");
        
		tomcat.getServer().start();
		tomcat.getServer().await();
	}
	
}
