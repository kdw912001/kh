package oop.inherit.sample;

public class Student extends Person/*, SuperClass*/ implements ISub, java.io.Serializable{
	//Field
	private String schoolName;
	private int schoolYear;
	private double score;
	private String major;
	
	public Student() {
		super (); //�θ��� �⺻ ������ȣ�ⱸ��
					//���� �� �ϴ��� ��� �����ڿ� �� �������. �⺻ ����.
					//������ �ȿ����� �����
					//�ݵ�� ù �ٿ��� �����ؾ� ��.
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
		//�θ��� �Ű����� �ִ� ������ ȣ�� ����
		super(name, age, gender);
		//this.name = name; 
		//�θ�Ŭ�������� ������ protected�� �������� �� �ļ� Ŭ�������� ���� ����
		//this.name = name;
		//�θ��� private ����� ����� ������ ������ �� ��.
		this.schoolName=schoolName;
		this.schoolYear=schoolYear;
		this.score=score;
		this.major=major;
	}
	
	//Method
	//�θ��� �޼ҵ带 �ļ��� �ٽ� �ۼ��ϴ� ��
	//�������̵��� �޼ҵ��� ��.
	//������̼� ǥ���ؾ� ��.
	//annotation : �����Ϸ� �ּ���
	@Override     //�������̵��� ������ ǥ��, Annotation �̶�� ��.
	public String information() {
		return super.information()+", "+this.schoolName+", "+this.schoolYear+"�г�, "
	+this.score+"��, "+this.major+"�а�";
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
