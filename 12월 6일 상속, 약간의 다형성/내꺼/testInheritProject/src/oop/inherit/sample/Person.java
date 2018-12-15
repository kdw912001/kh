package oop.inherit.sample;

public class Person {
	//Field
	//protected String name; //��� ���� �ļ� Ŭ�������� ���ٰ��������� ĸ��ȭ ����
	private String name;
	private int age;
	private char gender;
	
	//Constructor
	public Person() {
		System.out.println("Person() run...");
		
	} //�θ��� �⺻�����ڴ� ������ �־����.
		//�ļ��� �θ��� �⺻�����ڸ� ���� ȣ���ϱ� ������
		//�θ��� �⺻�����ڰ� ���ٸ� ����� �� ��.
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
