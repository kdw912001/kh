package loop.sample;

import java.util.Scanner;

public class MultiLoopSample {
	// A,B,C,D ... ����빮�ڸ� �ѱ��ھ� ���
	// �ݺ����� : 5��
	// ��, E�� �Ǹ� ����
	public void testDoubleFor1() {
		OUT: for (int k = 1; k <= 5; k++) {
			for (int c = 65; c < 91; c++) {
				if (c == 69)
					// break;
					break OUT;
				System.out.print((char) c + ", ");
			}
			System.out.println();
			System.out.println("���� for �� ��������...");
		} // �ٱ� for

		System.out.println("�ٱ� for�� ��������...");
	}

	public void testDoubleFor2() {
		for (int n = 1; n <= 5; n++) {
			for (int k = 1; k <= 10; k++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	public void testDoubleFor3() {
		for (int a = 1; a <= 5; a++) {
			for (int b = 1; b <= 5; b++) {
				System.out.println(a + ", " + b);
			}
			System.out.println("-------------------");
		}
	}

	// ������ 2~9�ܱ��� ��� ó��
	public void testDoubleFor4() {
		for (int dan = 2; dan <= 9; dan++) {
			System.out.println(dan + "��");
			for (int su = 1; su <= 9; su++) {
				System.out.println(dan + " * " + su + " = " + (dan * su));
			}
			System.out.println("-------------------");
		}
	}

	// ������ 2~9�ܱ��� ��� ó��
	//��, Ȧ������ ������
	public void testDoubleFor41() {
		for (int dan = 2; dan <= 9; dan++) {
			if(dan % 2 == 1)
				continue;
			
			System.out.println(dan + "��");
			for (int su = 1; su <= 9; su++) {
				System.out.println(dan + " * " + su + " = " + (dan * su));
			}
			System.out.println("-------------------");
		}
	}

	//�ݺ��� �ǽ����� 1
	public void printStar1(){
		System.out.print("�� �� : ");
		int line = new Scanner(System.in).nextInt();
		
		if(line > 0) {
			for(int row = 1; row <= line; row++) {
				for(int col = 1; col <= row; col++) {
					if(row == col)
						System.out.print(row);
					else
						System.out.print("*");
				}
				System.out.println();
			}
		}else {
			System.out.println("����� �ƴմϴ�.");
		}
	}
	
	public void printStar2(){
		System.out.print("�ټ� �Է� : ");
		int line = new Scanner(System.in).nextInt();
		
		if(line > 0) {  //����� ��
			for(int row = 1; row <= line; row++) {
				for(int col = 1; col <= row; col++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}else if(line < 0){  //������ ��
			for(int row = 1; row <= -line; row++){
				for(int col = 1; col <= -line; col++){
					if(row > col)
						System.out.print(" ");
					else
						System.out.print("*");
				}
				System.out.println();
			}
		}else{  //0�� ��
			System.out.println("��±���� �����ϴ�.");
		}
	}
	
	/*	12345
	 * 	12345
	 * 	12345
	 * 	12345
	 * 	12345
	 */
	public void printMultiNumber1(){
		for(int n = 1; n < 6; n++){
			for(int m = 1; m < 6; m++){
				System.out.print(m);
			}
			System.out.println();
		}
	}
	
	
	/*	12345
	 * 	23456
	 * 	34567
	 * 	45678
	 * 	56789
	 */
	public void printMultiNumber2(){
		for(int n = 1; n < 6; n++){
			for(int m = n; m < (n + 5); m++){
				System.out.print(m);
			}
			System.out.println();
		}
	}
}









