package exception.silsub1;

import java.util.Scanner;

import exception.silsub2.NumberProcess;
import exception.silsub2.NumberRangeException;

public class TestSilsub {

	public static void main(String[] args) {
		// ����ó�� �ǽ����� �׽�Ʈ
		TestSilsub test = new TestSilsub();
		test.silsub1();
		//test.silsub2();
	}
	
	//�ǽ����� 1
	public void silsub1(){
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("���ڿ� �Է� : ");
			int count = new CharacterProcess().countAlpha(sc.nextLine());
			System.out.println("���Ե� ���ĺ� ���� ���� : " + count);
		} catch (CharCheckException e) {
			System.out.println(e.getMessage());
		}
	}

	//�ǽ����� 2
	public void silsub2(){
		Scanner sc = new Scanner(System.in);
		System.out.print("ù��° ���� : ");
		int first = sc.nextInt();
		System.out.print("�ι�° ���� : ");
		int second = sc.nextInt();
		
		try {
			if(new NumberProcess().checkDouble(first, second))
				System.out.println(first + "�� " + second + "�� ����̴�.");
			else
				System.out.println(first + "�� " + second + "�� ����� �ƴϴ�.");
		} catch (NumberRangeException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
