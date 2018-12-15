package com.oop.array1.model;

public class Person {
	//Field
	private String name;  	//이름
	private int age;		//나이
	private double height;	//키
	private double weight;	//몸무게
	private int money;		//재산
	
	//Constructor
	public Person() {}
	
	public Person(String name, int age, 
			double height, double weight,
			int money) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.money = money;
	}
	
	//Method
	//getter and setter
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public double getHeight() {
		return height;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public int getMoney() {
		return money;
	}
	
	public String personInfo() {
		return this.name + ", " + this.age
			+ ", " + this.height + ", "
			+ this.weight + ", "
			+ this.money;
	}
}




