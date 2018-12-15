package com.mvc.controller;

import java.util.Scanner;

import com.mvc.model.Calculate;
import com.mvc.model.PayTable;
import com.mvc.model.Salary;
import com.mvc.view.Output;

public class PayTableTest {

	public static void main(String[] args) {
		// 다형성 문제 테스트
		Salary[] pt = new Salary[3];
		Scanner sc = new Scanner(System.in);

		// Salary 레퍼런스 = 후손객체 주소;
		pt[0] = new PayTable("소서노", 750000, 2, 3);
		pt[1] = new PayTable("고주몽", 800000, 1, 4);
		pt[2] = new PayTable("모팔모", 650000, 6, 2);

		System.out.println("인센티브 입력 : ");
		Salary.setIncentive(sc.nextFloat());

		System.out.println("        **** 급여명세서 ****");
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println("이름      기본급    가족수   가족수당   시간외근무  시간외수당 세금  인센티브(%)  성과금   실수령액");
		System.out.println("---------------------------------------------------------------------------------------------------");
		
		for(int i = 0; i < pt.length; i++) {
			//계산 처리
			//((PayTable)pt[i]).calc();
			((Calculate)pt[i]).calc();  //동적바인딩 처리됨
			//실제 구동은 오버라이딩된 PayTable의 calc() 가 실행됨.
			//출력
			//((PayTable)pt[i]).out();
			((Output)pt[i]).out();  //자동 동적바인딩 처리됨
		}
		System.out.println("---------------------------------------------------------------------------------------------------");

		System.out.println("인원수 : " + Salary.getCount() + "명");

		//인센티브 0.7f 입력 처리
		System.out.println("인센티브 입력 : ");
		Salary.setIncentive(sc.nextFloat());

		System.out.println("        **** 급여명세서 ****");
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println("이름      기본급    가족수   가족수당   시간외근무  시간외수당 세금  인센티브(%)  성과금   실수령액");
		System.out.println("---------------------------------------------------------------------------------------------------");
		
		for(int i = 0; i < pt.length; i++) {
			//계산 처리
			((PayTable)pt[i]).calc();
			//출력
			((PayTable)pt[i]).out();
		}
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println("인원수 : " + Salary.getCount() + "명");

	}

}
