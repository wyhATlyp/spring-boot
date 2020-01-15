package com.wyh.springboot.websocket.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class WebSocketCloseListener implements ApplicationListener<SessionDisconnectEvent> {

	@Override
	public void onApplicationEvent(SessionDisconnectEvent event) {
		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        System.out.println("【监听器事件 类型】" + headerAccessor.getCommand().getMessageType());
        //必须在HandshakeInterceptor拦截之后放入了sessionid才可以取到
        System.out.println("【监听器事件 session】"+ headerAccessor.getSessionAttributes().get("session"));
	}

}
