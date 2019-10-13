package com.wyh.springbootview.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("thymeleaf")
public class ThymeleafController {
	
	@RequestMapping("index")
	public String index(HttpServletRequest request, Model model) {
		model.addAttribute("msg", "首页");
		model.addAttribute("date", new Date());
		model.addAttribute("id", 1);
		model.addAttribute("list", new ArrayList<Integer>() {
			private static final long serialVersionUID = 1L;
			{
				add(1);
				add(2);
				add(3);
			}
		});
		model.addAttribute("map", new HashMap<String, Object>() {
			private static final long serialVersionUID = 1L;
			{
				put("wyh", "28");
				put("lyp", "30");
			}
		});
		request.setAttribute("req", "HttpServletRequest");
		request.getSession().setAttribute("sess", "HttpSession");
		request.getSession().getServletContext().setAttribute("app", "Application");
		return "index";
	}

	@RequestMapping("/url/{path}")
	public String url(@PathVariable String path, String id) {
		System.out.println(id);
		return "/url/" + path;
	}
	
}
