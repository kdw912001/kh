package com.week4;

import java.util.Scanner;

public class NumberOk {

	public static void main(String[] args) {
		// 실습문제 5
		char answer = 'N';
		NumberOk game = new NumberOk();
		
		do{
			int rnum = (int)(Math.random() * 100) + 1;
			System.out.println("임의의 정수 발생!");
			
			int count = 0;
			
			while(true){
				int value = game.getNumber();
				
				if(game.questionNumber(rnum, value) == 1)
					System.out.println("크다.");
				if(game.questionNumber(rnum, value) == -1)
					System.out.println("작다.");
				if(game.questionNumber(rnum, value) == 0)
					break;
				
				count++;
			}
			
			System.out.println("맞았습니다. (" + count + "번)");
			
			System.out.print("\n계속하시겠습니까?[y|n] : ");
			answer = new Scanner(System.in).next()
					.toUpperCase().charAt(0);
		}while(answer == 'Y');
		
		System.out.println("숫자 맞추기 게임을 종료합니다.");

	}
	
	public int getNumber(){
		System.out.print("정수 입력 : ");
		return new Scanner(System.in).nextInt();
	}
	
	public int questionNumber(int hidden, int compareNum){
		int result = 0;
		
		if(hidden > compareNum) result = -1;
		else if(hidden < compareNum) result = 1;
			
		return result;
	}

}
