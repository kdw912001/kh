package oop.inherit.sample;

public class Student extends Person/*, SuperClass*/ 
implements ISub, java.io.Serializable {
	//Field
	private String schoolName;
	private int schoolYear;
	private double score;
	private String major;
	
	//Constructor
	public Student() {
		super();  //부모의 기본생성자 호출구문
		System.out.println("Student() run...");
	}
	
	public Student(String schoolName, 
			int schoolYear, double score,
			String major) {
		super();
		this.schoolName = schoolName;
		this.schoolYear = schoolYear;
		this.score = score;
		this.major = major;
	}
	
	public Student(String name, int age, 
			char gender, String schoolName,
			int schoolYear, double score, 
			String major) {
		//부모의 매개변수 있는 생성자 호출 가능
		super(name, age, gender);
		
		//this.name = name;
		//부모의 private 멤버는 상속은 받지만
		//접근은 못 함
		this.schoolName = schoolName;
		this.schoolYear = schoolYear;
		this.score = score;
		this.major = major;
	}
	
	//Method
	//부모의 메소드를 후손이 다시 작성하는 것ㄹ
	//오버라이딩된 메소드라고 함
	//어노테이션을 표시해야 함
	//annotation : 컴파일러 주석문
	@Override
	public String information() {
		return super.information() + ", " +
				this.schoolName + ", " + 
				this.schoolYear + "학년, "
				+ score + "점, "
				+ major + "학과";
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
	
}
