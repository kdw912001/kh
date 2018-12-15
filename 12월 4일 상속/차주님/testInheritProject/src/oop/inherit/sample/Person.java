package oop.inherit.sample;

public class Person {
	//Field
	//protected String name;
	private String name;
	private int age;
	private char gender;
	
	//Constructor
	public Person() {
		System.out.println("Person() run...");
	}
	
	public Person(String name, int age, 
			char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	//Method
	public String information() {
		return name + ", " + age + ", "
				+ gender;
	}
	
	//Getters and Setters
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public char getGender() {
		return this.gender;
	}
}
