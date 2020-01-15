package com.wyh.springboot.websocket.config;

import java.util.Map;

import javax.servlet.http.Cookie;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

@Configuration
public class HttpHandShakeIntecepter implements HandshakeInterceptor {

	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		
        if(request instanceof ServletServerHttpRequest) {
             ServletServerHttpRequest servletRequest = (ServletServerHttpRequest)request;
             Cookie[] cookies = servletRequest.getServletRequest().getCookies();
             String sessionId = "";
             for(Cookie cookie : cookies) {
            	 if("JSESSIONID".equals(cookie.getName()))
            		 sessionId = cookie.getValue();
             }
             attributes.put("session", sessionId);
           }
         
         return true;
	}

	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception exception) {
	}

}
