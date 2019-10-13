package com.wyh.springbootmybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wyh.springbootmybatis.mapper")
public class SpringBootMybatisMain {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMybatisMain.class, args);
	}

}
