package com.wyh.springbootview.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wyh.springbootview.pojo.User;

/**
 * -整合freemarker
 * @author Administrator
 *
 */
@Controller
@RequestMapping("freemarker")
public class FreeMarkerController {
	
	@RequestMapping("queryUsers")
	public String queryUsers(Model model) {
		List<User> users = new ArrayList<User>() {
			private static final long serialVersionUID = 1L;
			{
				add(new User(1, "wsj", 1));
				add(new User(2, "lyp", 28));
				add(new User(3, "wyh", 28));
			}
		};
		model.addAttribute("users", users);
		return "user";//src/main/resources/templates/user.ftl
	}
	
}