package com.wyh.springboot.activemq.ptp;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class P2PConsumerOne {
	
    private final static Logger logger = LoggerFactory.getLogger(P2PConsumerOne.class);

    @JmsListener(destination = "foo.bar")
    public void receiveQueue(String msg) throws InterruptedException {
    	TimeUnit.SECONDS.sleep(3);
        logger.info("消费者1抢到了消息：{}",msg);
    }
}
