package oop2.model.vo;

public class Customer {
	//멤버변수 : Field
	//자료형이 다른 변수들의 나열 묶음 : 구조체
	//구조체 + 보안기능 : 클래스 => 캡슐화
	//필드를 캡슐화 : private 접근제한자 사용
	//private : 클래스 안에서만 사용가능
	
	//접근제한자 [예약어] 자료형 변수명[ = 초기값];
	private int id;//고객 아이디
	private String name;//고객 이름
	private int age;//고객 나이
	private char gender;//고객 성별
	private String phone;//고객 전화번호
	private String address;//고객 주소
	private double point;//고객 누적포인트
	
	//생성자 : Constructor
	//new 할 때 실행되는 초기화 메소드임.
	//new 할 때 해당 클래승 대한 객체(인스턴스)
	//가 힙(heap : 자유메모리 영역)에 만들어질 때
	//객체 안에 할당되는 필드들의 초기값 처리 담당
	//api Deprecated->이제 사용 안함.
	//매개변수가 다르게 구성 됨->오버로딩 가능
	
	//접근제한자 클래스명(){ 필드 = 초기값; }
	//접근제한자 클래스명(자료형 변수명){}
	//생성자는 오버로딩(overloading) 가능함
	
	//오버로딩 :  한 클래스 안에 이름이 같은 
	//생성자나 메소드를 여러 개 중복 작성하는 것
	//1. 이름이 반드시 같아야 함
	//2. 매개변수는 달라야 함

	//생성자는 일반적으로 public 사용함
	//public(공개) : 클래스 안/밖, 패키지 안/밖
	//			어디서나 모두 접근가능함
	
	//기본(default) 생성자라고 함
	public Customer() {
		//생성자와 메소드 안에는
		//this 레퍼런스가 존재함
		//해당 생성자나 메소드가 사용될 때
		//this가 자동으로 주소를 전달받음
		//System.out.println("this : " + this.hashCode());
		//실행 클래스에서 새로운 객체 생성하면서 만든 주소값 = this가 받은 주소 비교
		//실행클래스에서 cm = new Customer();에서 만들어진 주소 cm.hashCode()= Customer클래스의 this.hashCode()
	}
	
	//매개변수 있는 생성자라고 함
	public Customer(int id, String name) {
		//System.out.println("this : " + this.hashCode());
		
		this.id = id; //앞 this.id는 heap메모리에 있는주소 위치,
						//뒤 id는 stack에 지역변수로 저장되어 있는 값
		this.name = name;
		
		
	}
	
	public Customer(int id, String name, int age, 
			char gender, String phone, String address, double point) {
		//System.out.println("this : " + this.hashCode());
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.address = address;
		this.point = point;
	}
	
	//멤버함수 : Method (기능)
	//접근제한자 반환자료형 메소드명([자료형 변수]){}
	
	public void printCustomer() {
		//System.out.println("printCustomer() run...");
		//System.out.println("this : "+this.hashCode());

		System.out.println(this.id + ", "+this.name+", "+this.age+", "+this.gender+", "+
							this.phone+", "+this.address+", "+this.point);
		//this를 안 붙이더라도 JVM에서 자동으로 this를 붙임.
	}
	
	//Setter : set 메소드
	//public void set필드명(자료형 변수){ 필드명 = 변수; }
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setPoint(double point) {
		this.point = point;
	}
	
	//Getter : get 메소드
	public int getId() {
		return this.id; //this 생략가능
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
	public String getPhone() {
		return this.phone;
	}
	public String getAddress() {
		return this.address;
	}
	public double getPoint() {
		return this.point;
	}
}