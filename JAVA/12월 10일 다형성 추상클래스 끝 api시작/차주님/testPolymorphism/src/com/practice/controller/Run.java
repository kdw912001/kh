package com.practice.controller;

import com.practice.model.vo.*;

public class Run {
	public static void main(String[] args) {
		Vehicle[] arr = new Vehicle[3];
		
		arr[0] = new Car("BMW", 12.5, "sedan", 4);
		arr[1] = new Airplane("보잉747", 0.062, "점보 제트기", 16, 5);
		arr[2] = new Ship("낚시배", 3.0, "어선", 1);
		
		//향상된 for문
		/* for(클래스 레퍼런수변수 : 배열명){
		 * 	   레퍼런스.메소드():
		 * }
		 */
		
		for(Vehicle ref : arr) {
			System.out.println(ref.toString());
			System.out.println(ref.howToMove());
			System.out.println(ref.howToStop());
			System.out.println("-------------------");
		}
	}
}
