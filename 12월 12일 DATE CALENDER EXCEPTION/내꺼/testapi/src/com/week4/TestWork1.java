package com.week4;

import java.util.Calendar;

public class TestWork1 {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;//Calendar�� month�� 0~11
		int date = c.get(Calendar.DATE);
		int hour = c.get(Calendar.HOUR);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		
		int day = c.get(Calendar.DAY_OF_WEEK);//1�Ͽ���
		String days = null;
		switch(day) {
		case 1: days = "�Ͽ���"; break;
		case 2: days = "������"; break;
		case 3: days = "ȭ����"; break;
		case 4: days = "������"; break;
		case 5: days = "�����"; break;
		case 6: days = "�ݿ���"; break;
		case 7: days = "�����"; break;
		}
		System.out.println(year+"�� "+month+"�� "+date+"�� "+days);

	}

}
