package com.oop.model.dto;

public class Employee {
	//Field
	private int empNo;			//	��� : - empNo:int
	private String empName;	//	�̸� : - empName:String
	private String dept;		//	�ҼӺμ� : - dept:String
	private String job;			//	���� : - job:String
	private int age;			//	���� : - age:int
	private char gender;		//	���� : - gender:char
	private int salary;			//	�޿� : - salary:int
	private double bonusPoint;	//	���ʽ�����Ʈ : - bonusPoint:double
	private String phone;		//	�ڵ��� : - phone:String
	private String address;		//	�ּ� : - address:String
	
	//Constructor
	public Employee(){}
	
	//���, �̸�, ����, ����, �ڵ���, �ּ� �ʱ�ȭ ������
	public Employee(int empNo, String empName, 
			int age, char gender, String phone, 
			String address){
		this.empNo = empNo;
		this.empName = empName;
		this.age = age;
		this.gender =gender;
		this.phone = phone;
		this.address = address;
	}
	
	//��� �ʵ带 �ʱ�ȭ�ϴ� ������
	public Employee(int empNo, String empName, String dept, String job, 
			int age, char gender, int salary, double bonusPoint, String phone, String address){
		this.empNo = empNo;
		this.empName = empName;
		this.dept = dept;
		this.job = job;
		this.age = age;
		this.gender =gender;
		this.salary = salary;
		this.bonusPoint = bonusPoint;
		this.phone = phone;
		this.address = address;
	}

	//Setter
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void setBonusPoint(double bonusPoint) {
		this.bonusPoint = bonusPoint;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getEmpNo() {
		return empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public String getDept() {
		return dept;
	}

	public String getJob() {
		return job;
	}

	public int getAge() {
		return age;
	}

	public char getGender() {
		return gender;
	}

	public int getSalary() {
		return salary;
	}

	public double getBonusPoint() {
		return bonusPoint;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	//Method
	public void empInput(){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		
		System.out.print("��� : ");
		empNo = sc.nextInt();
		System.out.print("����� : ");
		empName =sc.next();
		System.out.print("�μ��� : ");
		dept = sc.next();
		System.out.print("���� : ");
		job = sc.next();
		System.out.print("���� : ");
		age = sc.nextInt();
		System.out.print("���� : ");
		gender = sc.next().charAt(0);
		System.out.print("�޿� : ");
		salary = sc.nextInt();		
		System.out.print("���ʽ�����Ʈ : ");
		bonusPoint = sc.nextDouble();
		System.out.print("�ڵ��� ��ȣ : ");
		phone = sc.next();
		System.out.print("�ּ� : ");
		sc.nextLine();
		address = sc.nextLine();
	}
	
	public void empOutput(){
		System.out.println(empNo + ", " + empName + ", " + dept + ", " + job + ", " +
						age + ", " + gender + ", " + salary + ", " + bonusPoint + ", " + phone);
	}
	
	public String empInformation(){
		return empNo + ", " + empName + ", " + dept + ", " + job + ", " +
				age + ", " + gender + ", " + salary + ", " + bonusPoint + ", " + phone;
	}
	
}
