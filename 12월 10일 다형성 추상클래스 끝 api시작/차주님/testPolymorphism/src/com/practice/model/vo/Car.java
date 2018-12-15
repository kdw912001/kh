package com.practice.model.vo;

public class Car extends Vehicle {
	private int tire;

	public Car() {
	}

	public Car(String name, 
			double mileage, String kind, int tire) {
		super(name, mileage, kind);
		this.tire = tire;
	}

	// Setters and Getters
	public int getTire() {
		return tire;
	}

	public void setTire(int tire) {
		this.tire = tire;
	}

	@Override
	public String howToMove() {
		return "������ �޷��� �̵�.";
	}

	@Override
	public String howToStop() {
		return "�극��ũ�� ��Ƽ� �����.";
	}
	
	@Override
	public String toString() {
		return super.toString() + ", "
				+ this.tire;
	}

}
