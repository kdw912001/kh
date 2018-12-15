package test.calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateCalculator {
	public DateCalculator() {}
	
	public boolean isLeapYear(int year) {
		boolean result = false;
		
		if(year % 4 == 0 && year % 100 != 0 ||	year % 400 == 0)
			result = true;
		
		return result;
	}
	
	public long getDays() {
		long sumDays = 0L;
		
		GregorianCalendar today = 
			new GregorianCalendar();
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH) + 1;
		int day = today.get(Calendar.DAY_OF_MONTH);
		
		//���⵵������ �� ����
		for(int y = 1; y < year; y++) {
			if(this.isLeapYear(y))
				sumDays += 366;
			else
				sumDays += 365;
		}
		
		//���� ���������� �� ����
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
		
		//���� ���� ��¥ ���
		sumDays += day;
		return sumDays;
	}
}



