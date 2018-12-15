package com.array2.controller;

import java.util.Scanner;

import com.oop.array2.model.Student;

public class TestStudentArray {

	public static void main(String[] args) {
		// 객체배열실습 문제2
		Scanner sc = new Scanner(System.in);
		Student[] sar = new Student[10];
		int count = 0, sumScore = 0;
		
		while(true) {
			sar[count] = new Student();
			
			System.out.print("이름 : ");
			sar[count].setName(sc.next());
			System.out.print("점수 : ");
			sar[count].setScore(sc.nextDouble());
			System.out.print("레벨 : ");
			sar[count].setGrade(sc.next().toUpperCase().charAt(0));
			
			sumScore += sar[count].getScore();
			count++;
			
			System.out.print("계속 추가(y|n) : ");
			if(sc.next().toUpperCase().charAt(0) != 'Y') {
				System.out.println("학생 정보 입력을 종료합니다.");
				break;
			}
		}
		
		System.out.println("점수 평균 : "
				+ (sumScore / count));
		
		for(int i = 0; i < count; i++) {
			System.out.println(sar[i].information());
		}
	}

}
