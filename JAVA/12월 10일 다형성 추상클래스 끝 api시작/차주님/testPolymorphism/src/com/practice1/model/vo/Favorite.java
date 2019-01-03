package com.practice1.model.vo;

public class Favorite extends MyInfo{
	private String hobby;
	private int fNum;
	private String fruit;
	
	public Favorite() {}
	
	public Favorite(String hobby, int fNum, String fruit) {
		this.hobby = hobby;
		this.fNum = fNum;
		this.fruit = fruit;
	}
	
	public Favorite(String name, 
			int age, String hobby, 
			int fNum, String fruit) {
		super(name, age);
		this.hobby = hobby;
		this.fNum = fNum;
		this.fruit = fruit;
	}
	
	@Override
	public String toString() {
		return "Favorite [hobby=" + hobby + ", fNum=" + fNum + ", fruit=" + fruit + "]";
	}
	
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public int getfNum() {
		return fNum;
	}
	public void setfNum(int fNum) {
		this.fNum = fNum;
	}
	public String getFruit() {
		return fruit;
	}
	public void setFruit(String fruit) {
		this.fruit = fruit;
	}
}
