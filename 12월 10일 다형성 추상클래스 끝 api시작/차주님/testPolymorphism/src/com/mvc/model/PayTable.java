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
		// 1. 가족수당 : 
		//가족이 3명 미만이면 가족수 *20000, 
		//3명 이상이면 무조건 60000
		this.setFamilyP(this.getFamily() >= 3? 60000: this.getFamily() * 20000);
		
		// 2. 시간외수당 : 시간외근무 * 5000
		this.setOvertimeP(this.getOvertime() * 5000);
		
		// 3. 세금 : 기본급의 10%
		this.setTax((long)(this.getPay() * 0.1));
		
		// 4. 성과금 : 인센티브 * 기본급
		this.setIncenP((long)(this.getIncentive() * this.getPay()));
		
		// 5. 실수령액 : 기본급 + 가족수당 + 성과금 + 시간외수당 - 세금
		this.setTotalPay(this.getPay() + 
			this.getFamilyP() + this.getIncenP()
			+ this.getOvertimeP() - this.getTax());
	}

}
