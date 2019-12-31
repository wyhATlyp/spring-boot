package com.wyh.springboot.websocket.bean;

public class Head {
	
	private Integer uId;
	
	private Integer gId;

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

	@Override
	public String toString() {
		return "Head [uId=" + uId + ", gId=" + gId + "]";
	}
	
}
