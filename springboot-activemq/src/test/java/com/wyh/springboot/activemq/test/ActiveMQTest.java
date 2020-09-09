package com.wyh.springboot.activemq.test;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wyh.springboot.activemq.JmsProducer;
import com.wyh.springboot.activemq.SpringBootActiveMQMain;

/**
 * P2P模式下：一个消息可以确保被一个消费者消费一次。
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringBootActiveMQMain.class})
public class ActiveMQTest {
	
	@Autowired
	private JmsProducer jmsProducer;
	
//	@JmsListener(destination = "queue.bar", containerFactory = "queueFactory") 
//	public void listenQueue1(final TextMessage text, Session session) {
//		try {
//			System.out.println("监听器1收到消息（queue.bar）：" + text.getText());
//			session.rollback();
//		} catch (JMSException e) {
//			e.printStackTrace();
//		}
//	}
	
//	@JmsListener(destination = "topic.msg", containerFactory = "topicFactory") 
//	public void listen(String msg) {
//		System.out.println("订阅者收到消息（queue.bar）：" + msg);
//	}
	
	@JmsListener(destination = "topic.msg", containerFactory = "presistentTopicFactory2") 
	public void listen(String msg) {
		System.out.println("订阅者收到消息（queue.bar）：" + msg);
	}
	
	@Test
	public void send2Queue() {
//		jmsProducer.sendMessage("queue.bar", "点对点消息");
//		jmsProducer.publish("topic.maslkdj", "持久化主题消息");
//		jmsProducer.publish("topic.msg", "持久化主题消息7");
//		jmsProducer.publish("topic.msg", "持久化主题消息9");
//		jmsProducer.publish("topic.msg", "持久化主题消息10");
		while(true){}
	}

}
