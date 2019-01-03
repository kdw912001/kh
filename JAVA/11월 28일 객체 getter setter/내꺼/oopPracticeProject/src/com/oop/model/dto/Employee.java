package com.oop.model.dto;

import java.util.Scanner;

public class Employee {
	private int empNo;
	private String empName;
	private String dept;
	private String job;
	private int age;
	private char gender;
	private int salary;
	private double bonusPoint;
	private String phone;
	private String address;
	
	public Employee() {}
	public Employee(int empNo,String empName,String dept,
					String job, int age, char gender, int salary, 
					double bonusPoint, String phone, String address) {
		this.empNo=empNo;
		this.empName=empName;
		this.dept=dept;
		this.job=job;
		this.age=age;
		this.gender=gender;
		this.salary=salary;
		this.bonusPoint=bonusPoint;
		this.phone=phone;
		this.address=address;
	}
	public void setEmpNo(int empNO) {
		this.empNo=empNo;
	}
	public void setEmpName(String empName) {
		this.empName=empName;
	}
	public void setDept(String dept) {
		this.dept=dept;
	}
	public void setJob(String job) {
		this.job=job;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public void setGender(char gender) {
		this.gender=gender;
	}
	public void setSalary(int salary) {
		this.salary=salary;
	}
	public void setBonusPoint(double bonusPoint) {
		this.bonusPoint=bonusPoint;
	}
	public void setAddress(String address) {
		this.address=address;
	}
	public int getEmpNo() {
		return this.empNo;
	}
	public String getEmpName() {
		return this.empName;
	}
	public String getDept() {
		return this.dept;
	}
	public String getJob() {
		return this.job;
	}
	public int getAge() {
		return this.age;
	}
	public char getGender() {
		return this.gender;
	}
	public int getSalary() {
		return this.salary;
	}
	public double getBonusPoint() {
		return this.bonusPoint;
	}
	public String getAddress() {
		return this.address;
	}
	
	public void empIntput() {
		Scanner sc = new Scanner(System.in);
		System.out.print("��� : ");
		this.empNo=sc.nextInt();
		System.out.print("�̸� : ");
		this.empName=sc.next();
		System.out.print("�ҼӺμ� : ");
		this.dept=sc.next();
		System.out.print("���� : ");
		this.job=sc.next();
		System.out.print("���� : ");
		this.age=sc.nextInt();
		System.out.print("����[��][��] : ");
		this.gender = sc.next().charAt(0);
		System.out.print("�޿� : ");
		this.salary = sc.nextInt();
		System.out.print("���ʽ�����Ʈ : ");
		this.bonusPoint=sc.nextDouble();
		System.out.print("�ڵ��� : ");
		this.phone = sc.next();
		System.out.print("�ּ� : ");
		this.address = sc.next();
	}
	public void empOutput() {
		System.out.println(this.empNo+" "+this.empName+" "+this.dept+" "+this.job+" "+
					this.age+" "+this.gender+" "+this.salary+" "+this.bonusPoint+" "+this.phone+" "+
				this.address);
	}
	public void delete() {
		System.out.println("������ �����մϴ�.");
		this.empNo=0;
		this.empName=null;
		this.dept=null;
		this.job=null;
		this.age=0;
		this.gender=0;
		this.salary=0;
		this.bonusPoint=0.0;
		this.phone=null;
		this.address=null;
	}
}
