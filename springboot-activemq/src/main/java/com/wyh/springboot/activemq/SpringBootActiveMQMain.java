package com.wyh.springboot.activemq;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class SpringBootActiveMQMain {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootActiveMQMain.class, args);
	}
	
	/**
	 * 消费者-队列工厂-消费者可以使用这个对象来监听某个队列
	 * @return
	 */
	@Bean("queueFactory")
    public DefaultJmsListenerContainerFactory queueFactory(ConnectionFactory connectionFactory){
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		
		factory.setSessionTransacted(true);//开启事务
		factory.setSessionAcknowledgeMode(2);//手动提交
		
		factory.setPubSubDomain(false);
		factory.setConnectionFactory(connectionFactory);
		return factory;
    }
	
	/**
	 * 消费者-主题工厂-消费者可以使用这个对象来监听某个主题
	 * @return
	 */
	@Bean("topicFactory")
	public DefaultJmsListenerContainerFactory topicFactory(ConnectionFactory connectionFactory){
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(true);
        return factory;
    }
	
	/**
	 * 消费者-持久化主题工厂-消费者持久订阅时使用
	 */
	@Bean("presistentTopicFactory")
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
		ActiveMQConnectionFactory presisentConnectionFactory = new ActiveMQConnectionFactory();//持久化订阅和非持久化订阅不能共用一个连接工厂
		presisentConnectionFactory.setBrokerURL("tcp://192.168.30.186:61616");
		
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(presisentConnectionFactory);
		
		factory.setPubSubDomain(true);//主题-订阅模式
		factory.setSubscriptionDurable(true);//持久化订阅
		factory.setClientId("springboot-activemq-3");//持久化订阅ID
		return factory;
	}
	
	/**
	 * 消费者2-持久化主题工厂-消费者持久订阅时使用
	 */
	@Bean("presistentTopicFactory2")
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory2() {
		ActiveMQConnectionFactory presisentConnectionFactory = new ActiveMQConnectionFactory();//持久化订阅和非持久化订阅不能共用一个连接工厂
		presisentConnectionFactory.setBrokerURL("tcp://192.168.30.186:61616");
		
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(presisentConnectionFactory);
		factory.setPubSubDomain(true);//主题-订阅模式
		factory.setSubscriptionDurable(true);//持久化订阅
		factory.setClientId("springboot-activemq-2");//持久化订阅ID
		return factory;
	}
	
	/**
	 * 生产者-点对点-默认方式
	 */
	@Bean("jmsTemplate")
	public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory) {
		JmsTemplate jmsTemplate = new JmsTemplate();
		jmsTemplate.setDeliveryPersistent(true);
		jmsTemplate.setConnectionFactory(connectionFactory);
		return jmsTemplate;
	}
	
	/**
	 * 生产者-主题模式-主题模式的持久化是通过持久化订阅来实现的
	 * @return
	 */
	@Bean("topicTemplate")
	public JmsTemplate topicTemplate(ConnectionFactory connectionFactory) {
		JmsTemplate jmsTemplate = new JmsTemplate();
		jmsTemplate.setConnectionFactory(connectionFactory);
		jmsTemplate.setPubSubDomain(true);//变为发布-订阅的方式
		jmsTemplate.setDeliveryPersistent(true);
		return jmsTemplate;
	}
	
}
