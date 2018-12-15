package com.oop.controller;

import com.oop.model.dto.Employee;

public class EmpArrayTest {

	public static void main(String[] args) {
		Employee[] ear=new Employee[3];
		ear[0]=new Employee();
		ear[1]=new Employee(201503, "박길동", null, null, 29, 'M', 0, 0.0, "010-1234-5678", "경기도 의정부시");
		ear[2]=new Employee(201004, "김철수", "개발부", "과장", 34, 'M', 4500000, 0.15, "010-2143-9876", "서울시 노원구 노원동 123");
		System.out.println("ear[0]: "+ear[0].empInformation());
		System.out.println("ear[1]: "+ear[1].empInformation());
		System.out.println("ear[2]: "+ear[2].empInformation());	
		System.out.println("---------------------------------");
		
		ear[0].setEmpNo(201305);
		ear[0].setEmpName("이영희");
		ear[0].setDept("총무부");
		ear[0].setJob("대리");
		ear[0].setAge(28);
		ear[0].setGender('F');
		ear[0].setSalary(3750000);
		ear[0].setBonusPoint(0.1);
		ear[0].setPhone("010-9512-7534");
		ear[0].setAddress("경기도 동두천");
		
		ear[1].setDept("기획부");
		ear[1].setJob("사원");
		ear[1].setSalary(2900000);
		ear[1].setBonusPoint(0.05);
		
		System.out.println("ear[0]: "+ear[0].empInformation());
		System.out.println("ear[1]: "+ear[1].empInformation());
		System.out.println("---------------------------------");
		
		int yearSalary1=(int) ((ear[0].getSalary()+(ear[0].getSalary()*ear[0].getBonusPoint()))*12);
		int yearSalary2=(int) ((ear[1].getSalary()+(ear[1].getSalary()*ear[1].getBonusPoint()))*12);
		int yearSalary3=(int) ((ear[2].getSalary()+(ear[2].getSalary()*ear[2].getBonusPoint()))*12);
		
		System.out.println(ear[0].getEmpName()+"의 연봉 : "+yearSalary1);
		System.out.println(ear[1].getEmpName()+"의 연봉 : "+yearSalary2);
		System.out.println(ear[2].getEmpName()+"의 연봉 : "+yearSalary3);
		System.out.println("---------------------------------");
		
		System.out.println("직원들의 연봉의 평균 : "+(yearSalary1+yearSalary2+yearSalary3)/3);
	}

}
