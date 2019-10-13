package com.wyh.springbootexception.controller;

import java.math.BigDecimal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("exception2")
public class ExceptionController2 {
	
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

}
