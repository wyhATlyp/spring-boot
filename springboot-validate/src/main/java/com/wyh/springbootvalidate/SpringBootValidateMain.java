package com.wyh.springbootvalidate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wyh.springbootvalidate.mapper")
public class SpringBootValidateMain {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootValidateMain.class, args);
	}

}
