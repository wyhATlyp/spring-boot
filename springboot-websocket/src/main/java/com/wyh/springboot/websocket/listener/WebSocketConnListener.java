package com.wyh.springboot.websocket.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class WebSocketConnListener implements ApplicationListener<SessionConnectEvent> {

	@Override
	public void onApplicationEvent(SessionConnectEvent event) {
		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        System.out.println("【监听器事件 类型】" + headerAccessor.getCommand().getMessageType());
	}

}
