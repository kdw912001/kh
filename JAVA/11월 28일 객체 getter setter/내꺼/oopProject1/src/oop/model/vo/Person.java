package oop.model.vo;

import java.util.Scanner;

public class Person {
	//�ڷ����� �ٸ� ����(�ʵ�)���� ���� + �������ѱ�� =>Ŭ����
	//�������(Field)
	//���������� [�����] �ڷ��� �ʵ�� [ = �ʱⰪ];
	private String name; //�̸�   
					//private�� ������ ĸ��ȭ(class �ۿ��� ���� ����), class�������� ��밡��
					//private ������ (default) ������. class�ۿ��� ���� ����,���� ��Ű�� ������ ����(����ü�� ����)
					//public ��Ű�� ���� ��𼭳� ���� ����(���� ����)
	private int age; //����
	private char gender; //����
	private String phone; //��ȭ��ȣ
	private double point; //����Ʈ
	
	//������(Constructor)
	//
	
	//����Լ�(Method)
	//�ʵ�� private���� ��ȣ(ĸ��ȭ) �ϰ� ����Լ��� ȣ���Ͽ� ���
	public void inputName() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�̸� : ");
		name = sc.next();
	}
	public void printPerson() {
		System.out.println(name+", "+age+"��, "+gender+"��, "+phone);
	}
	
}
