package test.datetime;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class TestLocale {

	public static void main(String[] args) {
		// GregorianCalendar 에 Locale 적용
		GregorianCalendar newyork =
			new GregorianCalendar(
			TimeZone.getTimeZone("America/New_York"),Locale.US);
		printDate(newyork);
		
		GregorianCalendar london = 
			new GregorianCalendar(TimeZone.getTimeZone("Europe/London"),Locale.UK);
		printDate(london);		
	}
	
	public static void printDate(Calendar today) {
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH) + 1;
		int day = today.get(Calendar.DAY_OF_MONTH);
		int weekDay = today.get(Calendar.DAY_OF_WEEK);
		int hour = today.get(Calendar.HOUR);
		int minute = today.get(Calendar.MINUTE);
		int second = today.get(Calendar.SECOND);
		int ampm = today.get(Calendar.AM_PM);
		
		String week = null;
		switch(weekDay) {
		case 1:	week = "일요일"; break;
		case 2:	week = "월요일"; break;
		case 3:	week = "화요일"; break;
		case 4:	week = "수요일"; break;
		case 5:	week = "목요일"; break;
		case 6:	week = "금요일"; break;
		case 7:	week = "토요일"; break;
		}
		
		System.out.println(year + "년 "+ month + "월 "+ day + "일 " + week + 
				(ampm == 0? " 오전 ": " 오후 ")	+ hour + "시 "+ minute + "분 "+ second + "초");
	}
}
