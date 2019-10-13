package com.wyh.springbootexception.exception;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

@Configuration
public class SimpleMappingException {
	
	@Bean
	public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
		SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
		Properties mappings = new Properties();
		mappings.put("java.lang.NullPointerException", "simple_mapping_exception");
		mappings.put("java.lang.ArithmeticException", "simple_mapping_exception");
		resolver.setExceptionMappings(mappings);
		return resolver;
	}

}
