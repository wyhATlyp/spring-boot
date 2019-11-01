package com.wyh.springboot.rabbitmq.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wyh.springboot.rabbitmq.autoconfig.RabbitMQAutoConfiguration;
import com.wyh.springboot.rabbitmq.bean.User;

@RestController
@RequestMapping("rabbitmq")
public class RabbitMQController {

	private Log log = LogFactory.getLog(RabbitMQController.class);
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@GetMapping("send/{id}")
	public User sendMessage(@PathVariable int id) {
		User user = new User();
		user.setId(id);
		user.setName("张三");
		user.setAge(18);
		rabbitTemplate.convertAndSend(RabbitMQAutoConfiguration.EXCHANGE_NAME, RabbitMQAutoConfiguration.ROUTE_NAME, user, (message) -> {
			message.getMessageProperties().setHeader("x-delay", 5000);
			return message;
		});
		log.info("消息发送成功:" + user);
		return user;
	}
	
}
