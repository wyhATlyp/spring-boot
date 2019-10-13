package com.wyh.springbootexception.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Configuration
public class HandlerExceptionImplements implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		ModelAndView mv = new ModelAndView();
		if(ex instanceof NullPointerException) {
			mv.addObject("msg", "空指针异常");
		} else if(ex instanceof ArithmeticException) {
			mv.addObject("msg", "算术异常");
		}
		mv.setViewName("handler_exception_resolver");
		return mv;
	}

}
