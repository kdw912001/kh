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
		return "ÇÏ´ÃÀ» ³¯¾Æ¼­ ÀÌµ¿ÇÑ´Ù.";
	}

	@Override
	public String howToStop() {
		return "¶¥¿¡ ÂøÁöÇØ¼­ ºê·¹ÀÌÅ©¸¦ ¹â¾Æ ¸ØÃá´Ù.";
	}
	
	@Override
	public String toString() {
		return super.toString() + ", "
				+ this.tire + ", "
				+ this.wing;
	}

}
