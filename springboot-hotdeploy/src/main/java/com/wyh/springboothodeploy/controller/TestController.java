 package com.wyh.springboothodeploy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
public class TestController {
	
	@RequestMapping("index")
	public String index(Model model) {
		model.addAttribute("resCode", "GR000000");
		return "index";
	}

}
