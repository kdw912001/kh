package com.oop.model.dto;

public class Employee {
	//Field
	private int empNo;			//	사번 : - empNo:int
	private String empName;	//	이름 : - empName:String
	private String dept;		//	소속부서 : - dept:String
	private String job;			//	직급 : - job:String
	private int age;			//	나이 : - age:int
	private char gender;		//	성별 : - gender:char
	private int salary;			//	급여 : - salary:int
	private double bonusPoint;	//	보너스포인트 : - bonusPoint:double
	private String phone;		//	핸드폰 : - phone:String
	private String address;		//	주소 : - address:String
	
	//Constructor
	public Employee(){}
	
	//사번, 이름, 나이, 성별, 핸드폰, 주소 초기화 생성자
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
	
	//모든 필드를 초기화하는 생성자
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
		
		System.out.print("사번 : ");
		empNo = sc.nextInt();
		System.out.print("사원명 : ");
		empName =sc.next();
		System.out.print("부서명 : ");
		dept = sc.next();
		System.out.print("직급 : ");
		job = sc.next();
		System.out.print("나이 : ");
		age = sc.nextInt();
		System.out.print("성별 : ");
		gender = sc.next().charAt(0);
		System.out.print("급여 : ");
		salary = sc.nextInt();		
		System.out.print("보너스포인트 : ");
		bonusPoint = sc.nextDouble();
		System.out.print("핸드폰 번호 : ");
		phone = sc.next();
		System.out.print("주소 : ");
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
