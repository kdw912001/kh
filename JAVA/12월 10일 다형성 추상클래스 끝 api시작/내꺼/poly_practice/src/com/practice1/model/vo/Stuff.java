package com.practice1.model.vo;

public class Stuff extends MyInfo{
	private String watch;
	private String phone;
	private int shoesNum;
	
	public Stuff() {}
	
	
	public Stuff(String name, int age, String watch, String phone, int shoesNum){
		super(name, age);
		this.watch=watch;
		this.phone=phone;
		this.shoesNum=shoesNum;
	}


	public String getWatch() {
		return watch;
	}


	public void setWatch(String watch) {
		this.watch = watch;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public int getShoesNum() {
		return shoesNum;
	}


	public void setShoesNum(int shoesNum) {
		this.shoesNum = shoesNum;
	}
	
	public String toString() {
		return super.toString()+" ������ �ð�� "+this.watch+", ���� "+this.phone+", �Ź��� ������ "+this.shoesNum+"�Դϴ�.";
	}
}
