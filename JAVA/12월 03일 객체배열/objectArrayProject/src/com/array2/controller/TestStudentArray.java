package com.array2.controller;

import java.util.Scanner;

import com.oop.array2.model.Student;

public class TestStudentArray {

	public static void main(String[] args) {
		// ��ü�迭�ǽ� ����2
		Scanner sc = new Scanner(System.in);
		Student[] sar = new Student[10];
		int count = 0, sumScore = 0;
		
		while(true) {
			sar[count] = new Student();
			
			System.out.print("�̸� : ");
			sar[count].setName(sc.next());
			System.out.print("���� : ");
			sar[count].setScore(sc.nextDouble());
			System.out.print("���� : ");
			sar[count].setGrade(sc.next().toUpperCase().charAt(0));
			
			sumScore += sar[count].getScore();
			count++;
			
			System.out.print("��� �߰�(y|n) : ");
			if(sc.next().toUpperCase().charAt(0) != 'Y') {
				System.out.println("�л� ���� �Է��� �����մϴ�.");
				break;
			}
		}
		
		System.out.println("���� ��� : "
				+ (sumScore / count));
		
		for(int i = 0; i < count; i++) {
			System.out.println(sar[i].information());
		}
	}

}
