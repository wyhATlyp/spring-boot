package com.wyh.springboot.rabbitmq.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.wyh.springboot.rabbitmq.autoconfig.RabbitMQAutoConfiguration;
import com.wyh.springboot.rabbitmq.bean.User;

@Component
public class RabbitMQListener {
	
	private Log log = LogFactory.getLog(RabbitMQListener.class);
	
	@RabbitListener(queues = RabbitMQAutoConfiguration.QUEQUE_NAME)
	public void listen(User user) {
		log.info("收到消息：" + user);
	}

}
