package com.wyh.springboot.source.tomcat;

import java.io.File;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.scan.StandardJarScanFilter;

public class TomcatMain {
	
	public static void main(String[] args) throws LifecycleException {
		start();
	}
	
	public static void start() throws LifecycleException {
		//创建tomcat容器
		final String baseDir = new File(".").getAbsolutePath();
		
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(8088);
		tomcat.setHostname("localhost");
		tomcat.setBaseDir(baseDir);
		tomcat.setAddDefaultWebXmlToWebapp(false);
		System.out.println("bseDir:" + baseDir);
		
		//1.将一个web项目放入tomcat
		Context context = tomcat.addWebapp("/springboot-source", baseDir);
		
		StandardJarScanFilter filter = new StandardJarScanFilter();
		filter.setTldSkip("*.jar");
		context.getJarScanner().setJarScanFilter(filter);
		
		tomcat.addServlet("/springboot-source", "IndexServlet", new IndexServlet());
		context.addServletMappingDecoded("/index.do", "IndexServlet");
		
		tomcat.getServer().start();
		tomcat.getServer().await();
	}

}
