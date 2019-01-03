package com.practice2.model.entity;

public class Rectangle extends Point{
	private int width;
	private int height;
	
	public Rectangle() {}
	public Rectangle(int x, int y, int width, int height) {
		/*super.x=x;
		super.y=y;*/		
		super(x,y);
		this.width=width;
		this.height=height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	@Override
	public void draw() {
		super.draw();
		System.out.println("�簢�� ���� : "+(this.width*this.height));
		System.out.println("�簢�� �ѷ� : "+(2*(this.width+this.height)));
	}
}
