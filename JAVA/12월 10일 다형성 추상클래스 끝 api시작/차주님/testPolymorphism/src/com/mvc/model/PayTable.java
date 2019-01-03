package com.mvc.model;

import com.mvc.view.Output;

public class PayTable extends Salary implements Calculate, Output {

	public PayTable() {
	}

	public PayTable(String name, long pay, int family, int overtime) {
		super(name, pay, family, overtime);
	}

	@Override
	public void out() {
		System.out.println(this.getName()
				+ "   " + this.getPay()
				+ "   " + this.getFamily()
				+ "   " + this.getFamilyP()
				+ "   " + this.getOvertime()
				+ "   " + this.getOvertimeP()
				+ "   " + this.getTax()
				+ "   " + Salary.getIncentive()
				+ "   " + this.getIncenP()
				+ "   " + this.getTotalPay()
				);
	}

	@Override
	public void calc() {
		// 1. �������� : 
		//������ 3�� �̸��̸� ������ *20000, 
		//3�� �̻��̸� ������ 60000
		this.setFamilyP(this.getFamily() >= 3? 60000: this.getFamily() * 20000);
		
		// 2. �ð��ܼ��� : �ð��ܱٹ� * 5000
		this.setOvertimeP(this.getOvertime() * 5000);
		
		// 3. ���� : �⺻���� 10%
		this.setTax((long)(this.getPay() * 0.1));
		
		// 4. ������ : �μ�Ƽ�� * �⺻��
		this.setIncenP((long)(this.getIncentive() * this.getPay()));
		
		// 5. �Ǽ��ɾ� : �⺻�� + �������� + ������ + �ð��ܼ��� - ����
		this.setTotalPay(this.getPay() + 
			this.getFamilyP() + this.getIncenP()
			+ this.getOvertimeP() - this.getTax());
	}

}
