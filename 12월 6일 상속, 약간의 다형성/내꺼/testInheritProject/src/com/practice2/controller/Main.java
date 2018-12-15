package com.practice2.controller;

import com.practice2.model.entity.Circle;
import com.practice2.model.entity.Point;
import com.practice2.model.entity.Rectangle;

public class Main {

	public static void main(String[] args) {
		//이건 차주님 코드로 프린트 할 것!!!
		
		Circle[] c = new Circle[3];
		Rectangle[] r = new Rectangle[3];
		
		
		for(int i=0; i<c.length;i++) {
			c[i]=new Circle(3+i,3+i,5+i);
			r[i]=new Rectangle(2+i,2+i,2+i,2+i);
			
			c[i].draw();
			r[i].draw();
			System.out.println();
		}

	}
}
