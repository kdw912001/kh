package com.week4;

import java.util.Scanner;

public class NumberOk {

	public static void main(String[] args) {
		// �ǽ����� 5
		char answer = 'N';
		NumberOk game = new NumberOk();
		
		do{
			int rnum = (int)(Math.random() * 100) + 1;
			System.out.println("������ ���� �߻�!");
			
			int count = 0;
			
			while(true){
				int value = game.getNumber();
				
				if(game.questionNumber(rnum, value) == 1)
					System.out.println("ũ��.");
				if(game.questionNumber(rnum, value) == -1)
					System.out.println("�۴�.");
				if(game.questionNumber(rnum, value) == 0)
					break;
				
				count++;
			}
			
			System.out.println("�¾ҽ��ϴ�. (" + count + "��)");
			
			System.out.print("\n����Ͻðڽ��ϱ�?[y|n] : ");
			answer = new Scanner(System.in).next()
					.toUpperCase().charAt(0);
		}while(answer == 'Y');
		
		System.out.println("���� ���߱� ������ �����մϴ�.");

	}
	
	public int getNumber(){
		System.out.print("���� �Է� : ");
		return new Scanner(System.in).nextInt();
	}
	
	public int questionNumber(int hidden, int compareNum){
		int result = 0;
		
		if(hidden > compareNum) result = -1;
		else if(hidden < compareNum) result = 1;
			
		return result;
	}

}
