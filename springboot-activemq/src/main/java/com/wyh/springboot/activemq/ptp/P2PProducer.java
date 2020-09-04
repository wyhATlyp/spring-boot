package com.wyh.springboot.activemq.ptp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

/**
 * JMS生产者
 */
@Component
public class P2PProducer {
	
	@Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
	
	public void sendMessage(String destination, String message) {
		jmsMessagingTemplate.convertAndSend(destination, message);
		System.out.println("生产者发送消息成功！" + "发送到队列" + destination + ",消息 = " + message);
	}

}
