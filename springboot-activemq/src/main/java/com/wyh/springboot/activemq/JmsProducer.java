package com.wyh.springboot.activemq;

import javax.annotation.Resource;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * 生产者：
 * 	1.发送一个消息到一个队列中。sendMessage(false, queueName, msg);
 * 	2.发送一个消息到一个队列中，并并久化。sendMessage(true, queueName, msg);
 * 	3.发布一个主题。publish(topic, msg);
 */
@Component
public class JmsProducer {
	
	@Resource(name = "jmsTemplate")
	private JmsTemplate jmsTemplate;
	
	@Resource(name = "topicTemplate")
	private JmsTemplate topicTemplate;
	
	/**
	 * 点对点：发送一个消息到一个指定到队列中
	 * @param presistent
	 * @param queueName
	 * @param msg
	 */
	public void sendMessage(String queueName, String msg) {
		System.out.printf("将消息[%s]放入到了队列[%s]中。\n", msg, queueName);
		jmsTemplate.convertAndSend(queueName, msg);
	}
	
	/**
	 * 主题模式：发布一个主题
	 */
	public void publish(String topic, String msg) {
		System.out.printf("发布主题[%s]消息[%s]。\n", topic, msg);
		topicTemplate.convertAndSend(topic, msg);
	}

}
