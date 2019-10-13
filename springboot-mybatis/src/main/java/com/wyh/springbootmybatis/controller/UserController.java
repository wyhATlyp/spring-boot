package com.wyh.springbootmybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wyh.springbootmybatis.entity.UserEntity;
import com.wyh.springbootmybatis.mapper.UserMapper;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserMapper testMapper;
	
	@GetMapping("/detail/{id}")
	public UserEntity detail(@PathVariable long id) {
		return testMapper.selectById(id);
	}

}