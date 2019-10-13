package com.wyh.springbootexception.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wyh.springbootexception.SpringBootExceptionMain;
import com.wyh.springbootexception.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringBootExceptionMain.class})
public class UserTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void testAddUser() {
		userService.addUser();
	}

}
