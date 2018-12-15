package oop.run;

import java.util.Scanner;

import oop2.model.vo.Customer;

public class TestCustomer {

	public static void main(String[] args) {
		// oop encapsulation test
		//Ŭ���� ���
		//Ŭ������ ���۷�������;
		//���۷���(reference) : ����
		//���۷��� = ��ü�� �ּ� �����.
		Customer cm;
		
		//���۷������� = new ������([�ʱⰪ]);
		//�����ڿ� ���� ���޸𸮿� 
		//�ش� Ŭ������ ���� ��ü(�ν��Ͻ�)��
		//�Ҵ��ϰ�, �� �ּҸ� ���۷����� ���
		cm = new Customer();
		
		//System.out.println("cm : " + cm.hashCode());
		
		//Ŭ������ ���� �޼ҵ� ���
		//[�ڷ��� ����=]���۷���.�޼ҵ��([���ް�]);
		cm.printCustomer();
		
		Customer cm2 = new Customer(123, "ȫ���");
		//System.out.println("cm2 : " + cm2.hashCode());
		cm2.printCustomer();
		
		//cm �� �����ϴ� ��ü�� �ʵ尪 ����
		cm.setId(33);
		cm.setName("�ڹ���");
		cm.setAge(35);
		cm.setGender('��');
		cm.setPhone("010-1234-5678");
		cm.setAddress("�泲 �뿵��");
		
		cm.printCustomer();
		
		//cm2�� �����ϴ� ��ü�� �⺻�� ����
		cm2.setAge(28);
		cm2.setGender('��');
		cm2.setPhone("010-7777-8888");
		cm2.setAddress("����� ������ ���ﵿ");
		cm2.setPoint(1257.5);
		
		cm2.printCustomer();
		
		//Ű����� �Է¹��� ������ ��� ó��
		/*Customer cm3 = new Customer();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���̵� : ");
		int id = sc.nextInt();
		cm3.setId(id);
		cm3.setId(sc.nextInt());
		System.out.print("�̸� : ");
		String name = sc.next();
		cm3.setName(name);
		cm3.setName(sc.next());
		System.out.print("���� : ");
		cm3.setAge(sc.nextInt());
		System.out.print("����[��/��] : ");
		cm3.setGender(sc.next().charAt(0));
		System.out.print("��ȭ��ȣ : ");
		cm3.setPhone(sc.next());
		System.out.print("�ּ� : ");
		sc.nextLine();
		cm3.setAddress(sc.nextLine());
		System.out.print("��������Ʈ : ");
		cm3.setPoint(sc.nextDouble());
		
		cm3.printCustomer();*/
		
		//cm �� �����ϴ� ��ü�� 
		//�̸�, ����, ����Ʈ ��ȸ
		String name = cm.getName();
		int age = cm.getAge();
		double point = cm.getPoint();
		
		System.out.println("�̸� : " + name);
		System.out.println("���� : " + age);
		System.out.println("����Ʈ : " + point);
		
		//�� ��ü�� ���� ��� ��� ���
		int avg = (cm.getAge() + cm2.getAge()) / 2;
		System.out.println("���� ��� : " + avg);
	}

}








