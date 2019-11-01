package com.wyh.springboot.rabbitmq.autoconfig;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQAutoConfiguration {

	public static final String EXCHANGE_NAME = "exchange.test";
	public static final String QUEQUE_NAME = "queue.test";
	public static final String ROUTE_NAME = "route.test";
	
	@Bean
	public DirectExchange directExchange() {
		DirectExchange directExchange = new DirectExchange(EXCHANGE_NAME);
		directExchange.setDelayed(true);
		return directExchange;
	}
	
	@Bean
	public Queue queque() {
		return QueueBuilder.durable(QUEQUE_NAME).build();
	}
	
	@Bean
	public Binding binding(DirectExchange directExchange, Queue queue) {
		return BindingBuilder.bind(queue).to(directExchange).with(ROUTE_NAME);
	}
	
	@Bean
	public MessageConverter messageContext() {
		return new Jackson2JsonMessageConverter();
	}
	
}
