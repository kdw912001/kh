package com.oop.controller;

import com.oop.model.dto.Employee;

public class EmpArrayTest {

	public static void main(String[] args) {
		// Employee Ŭ������ ���� ��ü �迭 �׽�Ʈ
		Employee[] ear = new Employee[]{
				new Employee(),
				new Employee(201503, "�ڱ浿", 29, 'M', "010-1234-5678", "��⵵ �����ν�"),
				new Employee(201004, "��ö��", "���ߺ�", "����", 34, 'M', 4500000, 0.15, "010-2143-9876", "����� ����� ����� 123")
				};
		
		for(int i = 0; i < ear.length; i++)
			System.out.println(ear[i].empInformation());
		System.out.println();

		ear[0].setEmpNo(201305);
		ear[0].setEmpName("�̿���");
		ear[0].setDept("�ѹ���");
		ear[0].setJob("�븮");
		ear[0].setAge(28);
		ear[0].setGender('F');
		ear[0].setSalary(3750000);
		ear[0].setBonusPoint(0.1);
		ear[0].setEmpName("010-9512-7534");
		ear[0].setEmpName("��⵵ ����õ");
		
		ear[1].setDept("��ȹ��");
		ear[1].setJob("���");
		ear[1].setSalary(2900000);
		ear[1].setBonusPoint(0.05);
		
		System.out.println("ear[0] : " + ear[0].empInformation());
		System.out.println("ear[1] : " + ear[1].empInformation());
		System.out.println();
		
		//���� = (�޿� + (�޿� * ���ʽ�����Ʈ)) * 12 ;
		int payTotal = 0;	//������ ���հ� �����
		for(int i = 0; i < ear.length; i++){
			int payOfYear = 
					(int)(ear[i].getSalary() 
					+ (ear[i].getSalary() * ear[i].getBonusPoint())) * 12;
			System.out.println(ear[i].getEmpName() 
					+ "�� ���� : " + payOfYear);
			payTotal += payOfYear;
		}
		
		System.out.println("\n�������� ������ ��� : " 
				+ (payTotal / ear.length));
	}

}
