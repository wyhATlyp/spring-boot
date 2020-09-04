package com.wyh.springboot.activemq.ptp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class P2PConsumerTwo {
	
    private final static Logger logger = LoggerFactory.getLogger(P2PConsumerTwo.class);

    @JmsListener(destination = "foo.bar")
    public void receiveQueue(String msg) {
        logger.info("消费者2抢到了消息：{}",msg);
    }
}
