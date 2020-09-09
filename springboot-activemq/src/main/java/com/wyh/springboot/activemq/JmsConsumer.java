package com.wyh.springboot.activemq;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.annotation.JmsListener;

/**
 * 消费者：点对点模式下只有一个消费者可以收到消息，主题模式下所有消费者均可收到消息
 *	1.从队列中获取一条消息
 *	2.从主题中获取消息
 *	3.持久化订阅某个主题
 */
//@Component
public class JmsConsumer {
	
	/**
	 * 监听队列-点对点
	 */
	@JmsListener(destination = "queue.bar", containerFactory = "queueFactory") 
	public void listenQueue1(final TextMessage text, Session session) {
		try {
			System.out.println("监听器1收到消息（queue.bar）：" + text.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 监听队列-点对点
	 */
	@JmsListener(destination = "queue.bar", containerFactory = "queueFactory")
	public void listenQueue2(String msg) {
		System.out.println("监听器2收到消息：(queue.bar)" + msg);
	}
	
	/**
	 * 订阅主题-非持久化
	 */
	@JmsListener(destination = "topic.no-presistent", containerFactory = "topicFactory")
	public void subscribe1(String msg) {
		System.out.println("订阅主题1收到消息(topic-nopresistent):" + msg);
	}
	
	/**
	 * 订阅主题-非持久化
	 */
	@JmsListener(destination = "topic.no-presistent", containerFactory = "topicFactory")
	public void subscribe2(String msg) {
		System.out.println("订阅主题2收到消息(topic-nopresistent):" + msg);
	}
	
	/**
	 * 订阅主题-持久化
	 */
	@JmsListener(destination = "topic.presistent", containerFactory = "presistentTopicFactory")
	public void presistentSubscribe1(String msg) {
		System.out.println("持久化订阅主题1收到消息(topic-nopresistent):" + msg);
	}
	
	/**
	 * 订阅主题-持久化
	 * 	同一主题消息，如果持久化订阅，那么订阅的clientId不可相同。
	 */
	@JmsListener(destination = "topic.presistent", containerFactory = "presistentTopicFactory2")
	public void presistentSubscribe2(String msg) {
		System.out.println("持久化订阅主题2收到消息(topic-nopresistent):" + msg);
	}

}
