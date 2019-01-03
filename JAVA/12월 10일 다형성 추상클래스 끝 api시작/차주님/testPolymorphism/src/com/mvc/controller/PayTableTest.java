package com.mvc.controller;

import java.util.Scanner;

import com.mvc.model.Calculate;
import com.mvc.model.PayTable;
import com.mvc.model.Salary;
import com.mvc.view.Output;

public class PayTableTest {

	public static void main(String[] args) {
		// ������ ���� �׽�Ʈ
		Salary[] pt = new Salary[3];
		Scanner sc = new Scanner(System.in);

		// Salary ���۷��� = �ļհ�ü �ּ�;
		pt[0] = new PayTable("�Ҽ���", 750000, 2, 3);
		pt[1] = new PayTable("���ָ�", 800000, 1, 4);
		pt[2] = new PayTable("���ȸ�", 650000, 6, 2);

		System.out.println("�μ�Ƽ�� �Է� : ");
		Salary.setIncentive(sc.nextFloat());

		System.out.println("        **** �޿����� ****");
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println("�̸�      �⺻��    ������   ��������   �ð��ܱٹ�  �ð��ܼ��� ����  �μ�Ƽ��(%)  ������   �Ǽ��ɾ�");
		System.out.println("---------------------------------------------------------------------------------------------------");
		
		for(int i = 0; i < pt.length; i++) {
			//��� ó��
			//((PayTable)pt[i]).calc();
			((Calculate)pt[i]).calc();  //�������ε� ó����
			//���� ������ �������̵��� PayTable�� calc() �� �����.
			//���
			//((PayTable)pt[i]).out();
			((Output)pt[i]).out();  //�ڵ� �������ε� ó����
		}
		System.out.println("---------------------------------------------------------------------------------------------------");

		System.out.println("�ο��� : " + Salary.getCount() + "��");

		//�μ�Ƽ�� 0.7f �Է� ó��
		System.out.println("�μ�Ƽ�� �Է� : ");
		Salary.setIncentive(sc.nextFloat());

		System.out.println("        **** �޿����� ****");
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println("�̸�      �⺻��    ������   ��������   �ð��ܱٹ�  �ð��ܼ��� ����  �μ�Ƽ��(%)  ������   �Ǽ��ɾ�");
		System.out.println("---------------------------------------------------------------------------------------------------");
		
		for(int i = 0; i < pt.length; i++) {
			//��� ó��
			((PayTable)pt[i]).calc();
			//���
			((PayTable)pt[i]).out();
		}
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println("�ο��� : " + Salary.getCount() + "��");

	}

}
