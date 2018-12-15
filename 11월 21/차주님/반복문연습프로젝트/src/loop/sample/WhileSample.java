package loop.sample;

import java.util.Random;
import java.util.Scanner;

public class WhileSample {
	//���ڿ��� �Է¹޾� ���ڰ����� ���
	//�ݺ������.
	//"exit" �� �ԷµǸ� �ݺ������
	public void testWhile1() {
		Scanner sc = 
				new Scanner(System.in);
		String str;
		
		System.out.print("���ڿ� �Է� : ");
		str = sc.nextLine();
		while(!str.equals("exit")) {
			System.out.println("���ڰ��� : "
					+ str.length());
			
			System.out.print("���ڿ� �Է� : ");
			str = sc.nextLine();
		}
		
		System.out.println("�Է� ����.");
	}
	
	public void testWhile11() {
		Scanner sc = 
				new Scanner(System.in);
		String str;
		
		System.out.print("���ڿ� �Է� : ");
		/*str = sc.nextLine();
		while(!str.equals("exit")) {*/
		while(!(str = sc.nextLine()).equals("exit")) {
			  System.out.println("���ڰ��� : "
					+ str.length());
			
			System.out.print("���ڿ� �Է� : ");
			//str = sc.nextLine();
		}
		
		System.out.println("�Է� ����.");
	}
	
	//�ݺ��� ���� : 
	//������ �ϳ� �Է¹޾�, �����հ� ����
	//���� ���� : 0�� �ԷµǸ� ����
	public void testWhile2() {
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �Է� : ");
		int num = sc.nextInt();
		
		while(num != 0) {
			sum += num;
			System.out.print("���� �Է� : ");
			num = sc.nextInt();
		}
		
		System.out.println("�Էµ� ���� ���� : "
				+ sum);
	}
	
	public void testWhile22() {
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �Է� : ");
		
		/*int num = sc.nextInt();		
		while(num != 0) {*/
		int num;
		while((num = sc.nextInt()) != 0) {
			sum += num;
			System.out.print("���� �Է� : ");
			//num = sc.nextInt();
		}
		
		System.out.println("�Էµ� ���� ���� : "
				+ sum);
	}
	
	//1~100������ ������ ���� �߻�
	//java.util.Random ���
	//�ݺ��� ���� : 
	//������ �Է¹޾Ƽ� ������ ���� ������
	//�ٽ� ���� �Է¹޾Ƽ� ��
	//������ �Է°��� ��ġ�ϸ� �ݺ� ����
	public void testWhile3() {
		Scanner sc = new Scanner(System.in);
		/*Random r = new Random();
		int number = r.nextInt(100) + 1;*/
		int number = new Random().nextInt(100) + 1;
		
		System.out.println("���ڸ� �˾Ƹ��� ������.");
		System.out.print("���ڴ�? ");
		int findNumber = sc.nextInt();
		
		while(number != findNumber) {
			System.out.println("Ʋ�Ƚ��ϴ�. �ٽ�!");
			
			if(number > findNumber)
				System.out.println(findNumber + 
						"���� Ů�ϴ�.");
			else if(number < findNumber)
				System.out.println(findNumber + 
						"���� �۽��ϴ�.");
			
			System.out.print("���ڴ�? ");
			findNumber = sc.nextInt();
		}
		
		System.out.println("����! ������ϴ�.");
	}
}






