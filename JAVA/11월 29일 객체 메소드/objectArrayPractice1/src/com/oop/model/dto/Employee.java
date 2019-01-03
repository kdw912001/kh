package com.oop.model.dto;

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
	public Employee(int empNo, int age, char gender, 
			String phone, String address) {
		this.empNo=empNo;
		this.age=age;
		this.gender=gender;
		this.phone=phone;
		this.address=address;
	}
	public Employee(int empNo, String empName, String dept, String job,
			int age, char gender, int salary, double bonusPoint,
			String phone, String address) {
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
	
	public void setEmpNo(int empNo) {
		this.empNo=empNo;
	}
	public int getEmpNo() {
		return this.empNo;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpName() {
		return this.empName;
	}
	public void setDept(String dept) {
		this.dept=dept;
	}
	public String getDept() {
		return this.dept;
	}
	public void setJob(String job) {
		this.job=job;
	}
	public String getJob() {
		return this.job;
	}
	public void setAge(int age) {
		this.age = age;
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
	public void setSalary(int salary) {
		this.salary=salary;
	}
	public int getSalary() {
		return this.salary;
	}
	public void setBonusPoint(double bonusPoint) {
		this.bonusPoint=bonusPoint;
	}
	public double getBonusPoint() {
		return this.bonusPoint;
	}
	public void setPhone(String phone) {
		this.phone=phone;
	}
	public String getPhone() {
		return this.phone;
	}
	public void setAddress(String address) {
		this.address=address;
	}
	public String getAddress() {
		return this.address;
	}
	
	public String empInformation() {
		return this.empNo+" "+this.empName+" "+this.dept+" "+this.job+" "+
				this.age+" "+this.gender+" "+this.salary+" "+
				this.bonusPoint+" "+this.phone+" "+this.address;
	}
	
}
