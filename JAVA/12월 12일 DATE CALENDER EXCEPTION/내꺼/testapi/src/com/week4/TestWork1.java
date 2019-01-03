package com.week4;

import java.util.Calendar;

public class TestWork1 {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;//Calendar의 month는 0~11
		int date = c.get(Calendar.DATE);
		int hour = c.get(Calendar.HOUR);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		
		int day = c.get(Calendar.DAY_OF_WEEK);//1일요일
		String days = null;
		switch(day) {
		case 1: days = "일요일"; break;
		case 2: days = "월요일"; break;
		case 3: days = "화요일"; break;
		case 4: days = "수요일"; break;
		case 5: days = "목요일"; break;
		case 6: days = "금요일"; break;
		case 7: days = "토요일"; break;
		}
		System.out.println(year+"년 "+month+"월 "+date+"일 "+days);

	}

}
