package com.wyh.springboot.websocket.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.wyh.springboot.websocket.bean.Group;
import com.wyh.springboot.websocket.bean.ReqBody;
import com.wyh.springboot.websocket.bean.User;

@Controller
public class ChatController {
	
	private static List<Group> mock = new ArrayList<Group>(){
		private static final long serialVersionUID = 1L;
		{
			Group g1 = new Group();
			g1.setId(1);
			g1.setUsers(new ArrayList<User>(){
				private static final long serialVersionUID = 1L;
				{
					for(int i = 1; i < 4; i ++) {
						User u = new User();
						u.setId(i);
						add(u);
					}
				}
			});
			add(g1);
			
			Group g2 = new Group();
			g2.setId(2);
			g2.setUsers(new ArrayList<User>(){
				private static final long serialVersionUID = 1L;
				{
					for(int i = 4; i < 6; i ++) {
						User u = new User();
						u.setId(i);
						add(u);
					}
				}
			});
			add(g2);
		}
	};
	
	{
		System.out.println(mock);
	}
	
	@Autowired
	private SimpMessagingTemplate smt;
	
	@MessageMapping("/chat")
//	@SendToUser("/topic/user1")
	public void hello(ReqBody body) {
		System.out.println("收到消息:" + body);
		Integer gId = body.getgId();
		smt.convertAndSendToUser("" + gId, "/topic", "{'code':'" + body.getMessage() + "'}");
		smt.convertAndSendToUser("" + gId, "/topic2", body.getMessage());
	}

}
