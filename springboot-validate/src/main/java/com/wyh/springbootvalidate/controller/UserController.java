package com.wyh.springbootvalidate.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wyh.springbootvalidate.entity.UserEntity;
import com.wyh.springbootvalidate.mapper.UserMapper;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("addPage")
	public String addUserPage(UserEntity userEntity) {
		return "user";
	}
	
	@RequestMapping("save")
	public String save(@Valid UserEntity userEntity, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors())
			return "user";
		if(userMapper.insert(userEntity) == 1) {
			model.addAttribute("msg", "成功");
		} else {
			model.addAttribute("msg", "失败");
		}
		return "user";
	}

}
