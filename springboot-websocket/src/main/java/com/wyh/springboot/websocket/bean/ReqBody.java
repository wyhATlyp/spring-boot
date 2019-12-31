package com.wyh.springboot.websocket.bean;

public class ReqBody {
	
	private Integer uId;
	
	private Integer gId;
	
	private Head head;
	
	private String message;

	public Head getHead() {
		return head;
	}

	public void setHead(Head head) {
		this.head = head;
	}
	
	public Integer getuId() {
		return uId;
	}
	
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	
	public Integer getgId() {
		return gId;
	}
	
	public void setgId(Integer gId) {
		this.gId = gId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ReqBody [head=" + head + ", message=" + message + "]";
	}
	
}
