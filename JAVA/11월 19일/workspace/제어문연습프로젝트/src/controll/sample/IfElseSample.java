package controll.sample;

import java.util.Scanner;

public class IfElseSample {
	//Field
	private Scanner sc = new Scanner(System.in);
		
	//if~else �� ��� ����
	/*Ű����� ���� �� ���� ���� �Է¹޾Ƽ�
	 * ù��° ������ �ι�° ������ �������
	 * Ȯ���ϰ�, ������ '�����'���
	 * �ƴϸ� '����� �ƴϴ�' ��µǰ� �ۼ�
	 * */
	public void testIfElse1() {
		System.out.print("ù���� ���� �Է� : ");
		int first = sc.nextInt();
		System.out.print("�ι�° ���� �Է� : ");
		int second = sc.nextInt();
		if(first%second==0) 
			System.out.println("�����");
		else
			System.out.println("����� �ƴϴ�");
	}
	/* ù��° ������ �ݵ�� �ι�° �������� 
	 * ū������ Ȯ���ϰ� ������
	 * ù��° ������ �ι�° ������ ������� 
	 * Ȯ���ϰ� ������ '�����' ����ϰ�
	 * �ƴϸ� ' ����� �ƴϴ�'
	 * ��µǰ� �ۼ�
	 * �ι��� ������ ũ�� �ƹ��͵� ������� ����
	 * 
	 */
	public void testIfElse2() {
		System.out.print("ù��° ���� �Է� : ");
		int first = sc.nextInt();
		System.out.print("�ι�° ���� �Է� : ");
		int second = sc.nextInt();
		if(first>second) {
			if(first%second==0)
				System.out.println("�����");
			else
				System.out.println("����� �ƴϴ�");
		}
	
	}
	/* ù��° ������ �ݵ�� �ι�° �������� ū��
	 * �� �� ��� ���
	 * 
	 * 
	 */
	public void testIfElse3() {
		System.out.print("ù��° ���� �Է� : ");
		int first = sc.nextInt();
		System.out.print("�ι�° ���� �Է� : ");
		int second = sc.nextInt();
		/*if(first>0 && second>0) {
			if(first>second) {
				if(first%second==0)
					System.out.println("�����");
				else
					System.out.println("����� �ƴϴ�");
			}
		}*/
		if(first > 0 && second > 0 && first > second) {
			if(first % second == 0)
				System.out.println("�����");
			else 
				System.out.println("����� �ƴϴ�");
		}
	}
	
	
}
