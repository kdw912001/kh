package loop.sample;

import java.util.Scanner;

public class BreakSample {
	//1~10���� �������� �հ� ���
	public void testBreak1() {
		int sum = 0;
		
		int k = 1;
		for( ; ; ) {
			if(k == 11)
				break;
			
			System.out.print(k + "+");
			sum += k++;
			//k++;
		}
		
		System.out.println(" = " + sum);
	}
	
	//���ڿ� �Է¹ް�, ���� �ϳ� �Է¹޾Ƽ�
	//���ڿ� �ȿ� ���ڰ� � ���ԵǾ� �ִ���
	//ī��Ʈ�ؼ� ���
	//��, �����ڰ� �ƴϸ� "�����ڰ� �ƴմϴ�."
	//ī��Ʈ ������
	public void testBreak2() {
		Scanner sc = new Scanner(System.in);
		int count = 0, i;
		
		System.out.print("���ڿ� �Է� : ");
		String str = sc.nextLine();
		System.out.print("ã�� ���� : ");
		char ch = sc.next().charAt(0);
		
		for(i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			//���������� Ȯ��
			if(Character.isLowerCase(c) 
				|| Character.isUpperCase(c)) {
				//���ڰ� �Է¹��ڿ� ��ġ�ϴ��� Ȯ��
				if(c == ch)
					count++;
			}else {
				//�����ڰ� �ƴϸ�
				System.out.println("�����ڰ� �ƴմϴ�.");
				break;  //for ���� ������.
			}
		} //for
		
		//���ڿ����� ���� �˻簡 ����������
		//������ ��, ī��Ʈ�� ���
		if(i == str.length()) {
			System.out.println("���Ե� " + ch + "������ ���� : " + count);
		}
	}
	
	public void testBreak22() {
		Scanner sc = new Scanner(System.in);
		int count = 0, i = 0;
		
		System.out.print("���ڿ� �Է� : ");
		String str = sc.nextLine();
		System.out.print("ã�� ���� : ");
		char ch = sc.next().charAt(0);
		
		while(i < str.length()) {
			char c = str.charAt(i++);
			//���������� Ȯ��
			if(Character.isLowerCase(c) 
				|| Character.isUpperCase(c)) {
				//���ڰ� �Է¹��ڿ� ��ġ�ϴ��� Ȯ��
				if(c == ch)
					count++;
			}else {
				//�����ڰ� �ƴϸ�
				System.out.println("�����ڰ� �ƴմϴ�.");
				break;  //for ���� ������.
			} //else close
			//i++;
		} //while close
		
		//���ڿ����� ���� �˻簡 ����������
		//������ ��, ī��Ʈ�� ���
		if(i == str.length()) {
			System.out.println("���Ե� " 
					+ ch + "������ ���� : "
					+ count);
		}
	}
	
	public void testBreak23() {
		Scanner sc = new Scanner(System.in);
		int count = 0, i = 0;
		
		System.out.print("���ڿ� �Է� : ");
		String str = sc.nextLine();
		System.out.print("ã�� ���� : ");
		char ch = sc.next().charAt(0);
		
		do {
			if(i == str.length())
				break;
			
			char c = str.charAt(i++);
			//���������� Ȯ��
			if(Character.isLowerCase(c) 
				|| Character.isUpperCase(c)) {
				//���ڰ� �Է¹��ڿ� ��ġ�ϴ��� Ȯ��
				if(c == ch)
					count++;
			}else {
				//�����ڰ� �ƴϸ�
				System.out.println("�����ڰ� �ƴմϴ�.");
				break;  //for ���� ������.
			} //else close
			//i++;
		}while(true);
		
		//���ڿ����� ���� �˻簡 ����������
		//������ ��, ī��Ʈ�� ���
		if(i == str.length()) {
			System.out.println("���Ե� " 
					+ ch + "������ ���� : "
					+ count);
		}
	}
}









