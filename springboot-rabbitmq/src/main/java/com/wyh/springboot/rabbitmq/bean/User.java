package com.wyh.springboot.rabbitmq.bean;

public class User {
	
	public int id;
	
	public String name;
	
	public int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User {id:" + id + ",name:" + name + ",age:" + age + "}";
	}
	
}
