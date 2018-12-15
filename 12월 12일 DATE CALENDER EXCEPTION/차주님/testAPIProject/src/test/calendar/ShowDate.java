package test.calendar;

public class ShowDate {

	public static void main(String[] args) {
		// 날짜시간 실습문제
		DateCalculator totalDay = 
				new DateCalculator();
		//올해가 윤년인지? 평년인지? 출력 확인
		System.out.println(totalDay.isLeapYear(2018) == true? "윤년" : "평년");
		//1년 1월 1일부터 오늘까지의 총 날수 계산 출력
		long total = totalDay.getDays();
		System.out.println("총날짜수 : " + total + "일");

	}

}
