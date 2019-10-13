package com.wyh.springbootexception.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ControllerAdviceException {
	
	@ExceptionHandler(value= {ArithmeticException.class})
	public ModelAndView exceptionHandle(Exception e) {
		ModelAndView model = new ModelAndView();
		model.addObject("error", e.toString());
		model.setViewName("controller_advice");
		return model;
	}

}
