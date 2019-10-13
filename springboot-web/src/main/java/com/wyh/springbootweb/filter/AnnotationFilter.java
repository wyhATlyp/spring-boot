package com.wyh.springbootweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * SpringBoot 用注解方式整合filter
 * 	拦截/servlet
 * @author Administrator
 *
 */
@WebFilter(urlPatterns = "/servlet")
public class AnnotationFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("f-SpringBoot 用注解方式整合filter");
		System.out.println("f-进入filter");
		chain.doFilter(request, response);
		System.out.println("f-离开filter");
	}

}
