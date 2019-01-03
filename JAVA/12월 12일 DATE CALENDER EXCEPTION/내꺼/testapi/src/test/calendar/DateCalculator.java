package test.calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateCalculator {
	public DateCalculator() {}
	public boolean isLeapYear(int year) {
		if(year%4==0&& year%100!=0 ||year%400==0)
			return true;
		return false;
	}
	public long getDays() {//선생님꺼 보기
	
		
		long sumDays = 0L;
		GregorianCalendar today = 	new GregorianCalendar();
			int year = today.get(Calendar.YEAR);
			int month = today.get(Calendar.MONTH) + 1;
			int day = today.get(Calendar.DAY_OF_MONTH);
		
			//전년도까지의 총 날수
			for(int y = 1; y < year; y++) {
				if(this.isLeapYear(y))
					sumDays += 366;
				else
					sumDays += 365;
			}
			
			//올해 전월까지의 총 날수
			for(int m = 1; m < month; m++) {
				if(m == 2) { 
					if(this.isLeapYear(year))
						sumDays += 29;
					else
						sumDays += 28;
				}
				
				if(m == 1 || m == 3 || m == 5 
					|| m == 7 || m == 8 || 
					m == 10 || m == 12)
					sumDays += 31;
				
				if(m == 4 || m == 6 || m == 9
					|| m == 11)
					sumDays += 30;
			}
			
			//현재 월의 날짜 계산
			sumDays += day;
			
			return sumDays;
		/*for(int i=0; i<year;i++) {//2017년까지
			sumDays+=(31*7)+(30*4);
			if(isLeapYear(i)) {
				sumDays+=29;
			}
			else {
				sumDays+=28;
			}
		}
		
		
		int dayOfYear = c.get(Calendar.DAY_OF_YEAR);
		
		sumDays+= (31*6)+(30*4)+28+12;
		//sumDays+= c.get(Calendar.DAY_OF_YEAR);
			
		return sumDays;*/
	}
	


}
