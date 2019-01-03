package com.practice.model.vo;

public class Ship extends Vehicle{
	private int propeller;
	
	public Ship() {}
	
	public Ship(String name, 
			double mileage, 
			String kind, int propeller) {
		super(name, mileage, kind);
		this.propeller = propeller;
	}	
	
	//Setter and Getter
	public int getPropeller() {
		return propeller;
	}

	public void setPropeller(int propeller) {
		this.propeller = propeller;
	}

	@Override
	public String howToMove() {
		return "�����緯�� ������ �̵��Ѵ�.";
	}

	@Override
	public String howToStop() {
		return "�����緯�� ��ȸ�����Ѽ� �����.";
	}
	
	@Override
	public String toString() {
		return super.toString() + ", "
				+ this.propeller;
	}

}
