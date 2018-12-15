package com.practice2.model.entity;

public class Circle extends Point {
	private int radius;
	
	public Circle() {}
	
	public Circle(int x, int y, int radius) {
		super(x, y);
		/*this.x = x;
		this.y = y;*/
		this.radius = radius;
	}
	
	@Override
	public void draw() {
		double area = (int)(Math.PI * radius * radius * 10) / 10.0;
		double perimeter = (int)(2 * Math.PI * radius * 10) / 10.0;
		
		super.draw();
		/*System.out.printf("원면적 : %.1f \n", area);
		System.out.printf("원둘레 : %.1f \n", perimeter);*/
		System.out.println("원면적 : " + area);
		System.out.println("원둘레 : " + perimeter);
	}
}




