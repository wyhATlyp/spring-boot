package com.wyh.springboot.websocket.bean;

import java.util.List;

public class Group {
	
	private Integer id;
	
	private List<User> users;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public List<User> getUsers() {
		return users;
	}
	
	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", users=" + users + "]";
	}
	
}
