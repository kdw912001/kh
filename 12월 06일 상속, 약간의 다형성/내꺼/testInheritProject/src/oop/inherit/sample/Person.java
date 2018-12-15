package oop.inherit.sample;

public class Person {
	//Field
	//protected String name; //상속 받은 후손 클래스에서 접근가능하지만 캡슐화 깨짐
	private String name;
	private int age;
	private char gender;
	
	//Constructor
	public Person() {
		System.out.println("Person() run...");
		
	} //부모의 기본생성자는 무조건 있어야함.
		//후손이 부모의 기본생성자를 먼저 호출하기 때문에
		//부모의 기본생성자가 없다면 상속이 안 됨.
	public Person(String name, int age, char gender) {
		this.name=name;
		this.age=age;
		this.gender=gender;
	}
	
	//Method
	public String information() {
		return name+", "+age+", "+gender;
	}
		
	//Getters and Setters
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return this.name;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public int getAge() {
		return this.age;
	}
	public void setGender(char gender) {
		this.gender=gender;
	}
	public char getGender() {
		return this.gender;
	}
	
	
	
}
