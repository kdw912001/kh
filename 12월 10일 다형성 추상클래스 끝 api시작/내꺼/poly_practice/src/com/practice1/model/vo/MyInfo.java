package com.practice1.model.vo;

public class MyInfo {
	private String name;
	private int age;
	
	public MyInfo() {}
	
	public MyInfo(String name, int age) {
		this.name=name;
		this.age=age;
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

	public String toString() {
		return this.age+"¼¼ "+this.name+"¾¾°¡";
	}
	
	
}
