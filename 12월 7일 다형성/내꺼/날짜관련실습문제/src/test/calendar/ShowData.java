package test.calendar;
import java.util.*;
public class ShowData {

	public static void main(String[] args) {
		DateCalculator totalDay = new DateCalculator();
		
		//올해가 윤년인지?평년인지? 출력확인
		System.out.println();
		////1년 1월 1일부터 오늘까지의 총 날수 계산 출력
		long total = totalDay.getDays();
		System.out.println("총 날짜 수 : "+total);
		
	}

}
