package com.practice.model.vo;

public class Airplane extends Vehicle{
	private int tire;
	private int wing;
	
	public Airplane() {}	
	
	public Airplane(String name, 
			double mileage, 
			String kind, int tire, int wing) {
		super(name, mileage, kind);
		this.tire = tire;
		this.wing = wing;
	}

	//Setters and Getters
	public int getTire() {
		return tire;
	}

	public void setTire(int tire) {
		this.tire = tire;
	}

	public int getWing() {
		return wing;
	}

	public void setWing(int wing) {
		this.wing = wing;
	}

	@Override
	public String howToMove() {
		return "�ϴ��� ���Ƽ� �̵��Ѵ�.";
	}

	@Override
	public String howToStop() {
		return "���� �����ؼ� �극��ũ�� ��� �����.";
	}
	
	@Override
	public String toString() {
		return super.toString() + ", "
				+ this.tire + ", "
				+ this.wing;
	}

}
