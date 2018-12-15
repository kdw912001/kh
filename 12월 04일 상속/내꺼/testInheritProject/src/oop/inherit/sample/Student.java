package oop.inherit.sample;

public class Student extends Person/*, SuperClass*/ implements ISub, java.io.Serializable{
	//Field
	private String schoolName;
	private int schoolYear;
	private double score;
	private String major;
	
	public Student() {
		super (); //부모의 기본 생성자호출구문
					//생성 안 하더라도 모든 생성자에 다 들어있음. 기본 생략.
					//생성자 안에서만 사용함
					//반드시 첫 줄에만 기입해야 함.
		System.out.println("Student() run...");
	}
	
	public Student(String schoolName, int schoolYear, double score, String major) {
		super();
		this.schoolName=schoolName;
		this.schoolYear=schoolYear;
		this.score=score;
		this.major=major;
	}
	
	public Student(String name, int age, char gender, String schoolName, 
			int schoolYear, double score, String major) {
		//부모의 매개변수 있는 생성자 호출 가능
		super(name, age, gender);
		//this.name = name; 
		//부모클래스에서 변수를 protected로 선언했을 시 후손 클래스에서 접근 가능
		//this.name = name;
		//부모의 private 멤버는 상속은 받지만 접근은 못 함.
		this.schoolName=schoolName;
		this.schoolYear=schoolYear;
		this.score=score;
		this.major=major;
	}
	
	//Method
	//부모의 메소드를 후손이 다시 작성하는 것
	//오버라이딩된 메소드라고 함.
	//어노테이션 표시해야 함.
	//annotation : 컴파일러 주석문
	@Override     //오버라이딩시 무조건 표시, Annotation 이라고 함.
	public String information() {
		return super.information()+", "+this.schoolName+", "+this.schoolYear+"학년, "
	+this.score+"점, "+this.major+"학과";
	}

	//Getters and Setters
	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public int getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(int schoolYear) {
		this.schoolYear = schoolYear;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	
	
	
	/*
	public void setSchoolName(String schoolName) {
		this.schoolName=schoolName;
	}
	public String getSchoolName() {
		return this.schoolName;
	}
	public void setSchoolYear(int schoolYear) {
		this.schoolYear=schoolYear;
	}
	public int getSchoolYear() {
		return this.schoolYear;
	}
	public void setScore(double score) {
		this.score=score;
	}
	public double getScore() {
		return this.score;
	}
	public void setMajor(String major) {
		this.major=major;
	}
	public String getMajor() {
		return this.major;
	}*/
}
