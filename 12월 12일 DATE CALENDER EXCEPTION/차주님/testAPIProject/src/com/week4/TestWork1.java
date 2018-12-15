package com.week4;

import java.util.Calendar;

public class TestWork1 {

	public static void main(String[] args) {
		// 실습문제 1
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
		case 1:	weekStr = "일";	break;
		case 2:	weekStr = "월";	break;
		case 3:	weekStr = "화";	break;
		case 4:	weekStr = "수";	break;
		case 5:	weekStr = "목";	break;
		case 6:	weekStr = "금";	break;
		case 7:	weekStr = "토";	break;
		}
		
		System.out.println(year + "년 " + month + "월 "
				+ day + "일 " + weekStr + "요일 " +
				hour + "시 " + minute + "분 " + 
				second + "초");

	}

}
