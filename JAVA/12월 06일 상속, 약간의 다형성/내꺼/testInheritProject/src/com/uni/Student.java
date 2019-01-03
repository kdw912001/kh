package com.uni;

public class Student extends Human{
	private String number;
	private String major;
	
	public Student() {}

	public Student(String name, int age, int height, int weight, String number, String major) {
	/*	super.name=name;
		super.age=age;
		super.height=height;
		super.weight=weight;*/
		super(name,age,height,weight);
		this.number = number;
		this.major = major;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	public String printInformation() {
		return super.name+" "+super.age+" "+super.height+" "+super.weight+" "+this.number+" "+this.major;
	}
	
	
}
