package nonstatic.method.sample;

import java.util.Scanner;

public class MethodSample {
	//Field
	//���������� [�����] �ڷ��� ������;
	private Scanner sc = new Scanner(System.in);
	
	//Constructor
	//���������� Ŭ������([�ڷ��� ����]){ �ʵ� �ʱ�ȭ }
	//�⺻������
	public MethodSample() {}
	
	//Method
	//���������� [�����] ��ȯ�ڷ��� �޼ҵ��([�ڷ��� ����]){}
	
	//1. ��ȯ�� ���� �Ű����� ���� �޼ҵ�
	public void printLotto() {
		int[] lotto = new int[6];
		
		for(int i = 0; i < lotto.length; i++) {
			lotto[i] = (int)(Math.random() * 45) + 1;
			
			if(i > 0) {  //�ߺ��� üũ
				for(int j = 0; j < i; j++) {
					if(lotto[j] == lotto[i]) {
						i--;
						break;
					}
				}
			}
		}
		
		//�������������ϰ� ���
		for(int i = 0; i < lotto.length - 1; i++) {
			for(int j = i + 1; j < lotto.length; j++) {
				if(lotto[i] > lotto[j]) {
					//swap ���� ���
					int tmp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = tmp;
				}
			}
		}
		
		//���� �� ���
		System.out.print("lotto : ");
		for(int i = 0; i < lotto.length; i++)
			System.out.print(lotto[i] + "   ");
		System.out.println();
		
		return;
	}
	
	//2. ��ȯ�� ���� �Ű����� �ִ� �޼ҵ�
	public void printUnicode(char ch) {
		System.out.println(ch + " is unicode " + (int)ch);
		return;
	}
	
	//3. ��ȯ�� �ְ� �Ű����� ���� �޼ҵ�
	public int random1to100() {
		return (int)(Math.random() * 100) + 1;
	}
	
	//4. ��ȯ�� �ְ� �Ű����� �ִ� �޼ҵ�
	public int randomInt(int start, int end) {
		return (int)(Math.random() * (end - start + 1)) + start;
	}
}










