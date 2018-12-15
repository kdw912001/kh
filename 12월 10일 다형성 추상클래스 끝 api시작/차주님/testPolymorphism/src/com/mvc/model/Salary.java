package com.mvc.model;

public class Salary {
	//Field
	private String name; 	//이름
    private long pay;  	//기본급      
    private long familyP;	//가족수당    
    private long overtimeP;	//시간외수당   
    private long incenP;	//성과금   
    private long tax;		//세금  
    private long totalPay;	//실수령액
    private int family; 	//가족수    
    private int overtime;	//초과근무시간
    private static float incentive = 0.5f; //인센티브 - 초기값(0.5)
    private static int count = 0;       //총인원 - 초기값(0)
    
    //Constructor
    public Salary() {
    	super();
    	count++;
    }

	public Salary(String name, 
			long pay, int family, 
			int overtime) {
		super();
		this.name = name;
		this.pay = pay;
		this.family = family;
		this.overtime = overtime;
		
		count++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPay() {
		return pay;
	}

	public void setPay(long pay) {
		this.pay = pay;
	}

	public long getFamilyP() {
		return familyP;
	}

	public void setFamilyP(long familyP) {
		this.familyP = familyP;
	}

	public long getOvertimeP() {
		return overtimeP;
	}

	public void setOvertimeP(long overtimeP) {
		this.overtimeP = overtimeP;
	}

	public long getIncenP() {
		return incenP;
	}

	public void setIncenP(long incenP) {
		this.incenP = incenP;
	}

	public long getTax() {
		return tax;
	}

	public void setTax(long tax) {
		this.tax = tax;
	}

	public long getTotalPay() {
		return totalPay;
	}

	public void setTotalPay(long totalPay) {
		this.totalPay = totalPay;
	}

	public int getFamily() {
		return family;
	}

	public void setFamily(int family) {
		this.family = family;
	}

	public int getOvertime() {
		return overtime;
	}

	public void setOvertime(int overtime) {
		this.overtime = overtime;
	}

	public static float getIncentive() {
		return incentive;
	}

	public static void setIncentive(
			float incentive) {
		Salary.incentive = incentive;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Salary.count = count;
	}
    
    
}









