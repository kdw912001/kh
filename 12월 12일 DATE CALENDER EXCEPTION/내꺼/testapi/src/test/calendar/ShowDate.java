package test.calendar;

import java.util.Calendar;

public class ShowDate {

	public static void main(String[] args) {
		DateCalculator totalDay = new DateCalculator();
		Calendar year;
		year = Calendar.getInstance();
		
		System.out.println(totalDay.isLeapYear(year.get(Calendar.YEAR))==true?"À±³â":"Æò³â");
		long total = totalDay.getDays();
		System.out.println("ÃÑ³¯Â¥¼ö : "+total);
	}

}
