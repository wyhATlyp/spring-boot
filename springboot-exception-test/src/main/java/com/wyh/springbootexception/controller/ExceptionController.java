package com.wyh.springbootexception.controller;

import java.math.BigDecimal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("exception")
public class ExceptionController {
	
	@SuppressWarnings("unused")
	@RequestMapping("errorPage")
	public String errorPage() {
		if(true)
			throw new RuntimeException();
		return "index";
	}
	
	@SuppressWarnings("null")
	@RequestMapping("nullPoint")
	public String nullPoint() {
		String str = null;
		str.toString();
		return "index";
	}
	
	@RequestMapping("arithmetic")
	public String arithmetic() {
		BigDecimal a = BigDecimal.valueOf(10);
		BigDecimal b = BigDecimal.valueOf(3);
		System.out.println(a.divide(b));
		return "index";
	}
	
	@ExceptionHandler(value= {ArithmeticException.class})
	public ModelAndView exceptionHandler(Exception e) {
		ModelAndView model = new ModelAndView();
		model.addObject("error", e.toString());
		model.setViewName("exception_handler");
		return model;
	}

}
