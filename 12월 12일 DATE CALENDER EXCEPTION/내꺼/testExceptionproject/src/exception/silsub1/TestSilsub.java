package exception.silsub1;

import java.util.Scanner;

import exception.silsub2.NumberProcess;
import exception.silsub2.NumberRangeException;

public class TestSilsub {

	public static void main(String[] args) {
		TestSilsub test = new TestSilsub();
		test.silsub1();
		//test.silsub2();
		
	}
	public void silsub1() {
		Scanner sc = new Scanner(System.in);
		//CharacterProcess cp = new CharacterProcess();
		
		try {
			System.out.print("���ڿ��� �Է� : ");
			int count = new CharacterProcess().countAlpha(sc.nextLine());
			System.out.println("���Ե� ���ĺ� ���� ���� : " +count);
			//System.out.println(cp.countAlpha(sc.nextLine()));
			//���鹮�� ���� üũ�Ϸ��� nextLine()
		} catch (CharCheckException e) {
			System.out.println(e.getMessage());
		}
		
	}
	public void silsub2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("ù��° ���� �Է� : ");
		int a = sc.nextInt();
		System.out.print("�ι��� ���� �Է� : "); 
		int b = sc.nextInt();
		//NumberProcess np = new NumberProcess();
		try {
			if(new NumberProcess().checkDouble(a, b))
				System.out.println(a+"�� "+b+"�� ����̴�.");
			else
				System.out.println(a+"�� "+b+"�� ����� �ƴϴ�");
		} catch (NumberRangeException e) {
			System.out.println(e.getMessage());
		}
		
	}
	

}
