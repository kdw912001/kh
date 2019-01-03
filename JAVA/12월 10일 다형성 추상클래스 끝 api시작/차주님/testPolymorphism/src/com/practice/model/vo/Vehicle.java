package com.practice.model.vo;

public abstract class Vehicle {
	//Field
	private String name;
	private double mileage;
	private String kind;
	
	//Constructor
	public Vehicle() {}
	
	public Vehicle(String name, 
			double mileage, 
			String kind) {
		this.name = name;
		this.mileage = mileage;
		this.kind = kind;
	}	
	
	//Setters and Getters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	@Override
	public String toString() {
		return this.name + ", " + 
				this.mileage + ", " + 
				this.kind;
	}
	
	public abstract String howToMove();
	public abstract String howToStop();
}








