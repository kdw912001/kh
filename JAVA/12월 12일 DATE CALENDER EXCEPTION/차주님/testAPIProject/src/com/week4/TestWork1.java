package com.week4;

import java.util.Calendar;

public class TestWork1 {

	public static void main(String[] args) {
		// �ǽ����� 1
		Calendar today = Calendar.getInstance();
		
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH) + 1;
		int day = today.get(Calendar.DAY_OF_MONTH);
		int hour = today.get(Calendar.HOUR_OF_DAY);
		int minute = today.get(Calendar.MINUTE);
		int second = today.get(Calendar.SECOND);
		int weekDay = today.get(Calendar.DAY_OF_WEEK);
		
		String weekStr = null;
		switch(weekDay){
		case 1:	weekStr = "��";	break;
		case 2:	weekStr = "��";	break;
		case 3:	weekStr = "ȭ";	break;
		case 4:	weekStr = "��";	break;
		case 5:	weekStr = "��";	break;
		case 6:	weekStr = "��";	break;
		case 7:	weekStr = "��";	break;
		}
		
		System.out.println(year + "�� " + month + "�� "
				+ day + "�� " + weekStr + "���� " +
				hour + "�� " + minute + "�� " + 
				second + "��");

	}

}
