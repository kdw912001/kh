package com.oop.array2.model;

public class Student {
	//Field
	private String name;
	private double score;
	private char grade;
	
	//Constructor
	public Student() {}

	public Student(String name, double score, char grade) {
		super();
		this.name = name;
		this.score = score;
		this.grade = grade;
	}

	//Method
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}
	
	public String information() {
		return name + ", " + score
				+ "Á¡, " + grade;
	}
}







