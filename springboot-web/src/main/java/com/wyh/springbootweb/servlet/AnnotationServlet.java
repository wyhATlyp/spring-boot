package com.wyh.springbootweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Spring Boot 用注解方式整个servlet
 * @author Administrator
 *
 */
@WebServlet(urlPatterns = "/servlet")
public class AnnotationServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("Spring Boot 用注解方式整合servlet");
		}

}
