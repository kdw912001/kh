package com.practice2.controller;
import com.practice2.model.entity.*;
public class Main3 {

	public static void main(String[] args) {
		// 실습문제3
		
		//부모 한 개로 여러 개의 자료형(클래스)을 다룰 수 있다->다형성
		Point[] par = new Point[5];
		par[0] = new Circle(0, 0, 100);
		par[1] = new Rectangle(100, 100, 150, 200);
		par[2] = new Rectangle(20, 20, 150, 100);
		par[3] = new Circle(50, 50, 150);
		par[4] = new Circle(10, 10, 200);
		
		for(int i=0; i<par.length;i++) {
			par[i].draw();
		}
	}
}
