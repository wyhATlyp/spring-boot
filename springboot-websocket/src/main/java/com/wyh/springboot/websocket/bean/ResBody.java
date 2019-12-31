package com.wyh.springboot.websocket.bean;

public class ResBody {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ResBody [message=" + message + "]";
	}
	
}
