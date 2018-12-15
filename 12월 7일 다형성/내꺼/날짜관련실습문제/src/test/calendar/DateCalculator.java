package test.calendar;

public class DateCalculator {
	public int getDays() {
		long sumDays = 0L;
		for(int i=1;i<=2017;i++) {
			sumDays+=(31*7)+(30*4);
			if(isLeapYear(i)) {
				sumDays+=29;
			}
			else
				sumDays+=28;
		}
		return (int)sumDays;
	}
	public boolean isLeapYear(int i) {
		if(i%4==0 && i%100!=0 && i%400==0) {
			return true;
		}
		else
			return false;
	}
}
