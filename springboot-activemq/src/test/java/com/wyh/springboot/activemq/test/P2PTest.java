package com.wyh.springboot.activemq.test;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wyh.springboot.activemq.SpringBootActiveMQMain;
import com.wyh.springboot.activemq.ptp.P2PProducer;

/**
 * P2P模式下：一个消息可以确保被一个消费者消费一次。
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringBootActiveMQMain.class})
public class P2PTest {
	
	@Autowired
	private P2PProducer p2PProducer;
	
	/**
	 * 默认为点对点：一个消息只能被一个生产者消费，消费者可以收到队列中存在的消息。
	 *
	 * 修改为主题模式：spring.jms.pub-sub-domain=true
	 * 	一个消息可以被多个消费者消费，消费者只能接收到连接后发送过来的消息。
	 */
	@Test
	public void ptpConsumer() throws InterruptedException {
		p2PProducer.sendMessage("foo.bar", "hello");
		
		TimeUnit.SECONDS.sleep(10);//等待所有消息都消费完
	}

}
