package test.datetime;

import java.util.*;

public class TestCalendar {

	public static void main(String[] args) {
		// java.util.Calendar 클래스 테스트
		//Calendar클래스는 추상클래스 이므로 직접 객체생성은 못함(new는 못하고)
		//후손 클래스인 GregorianCalendar
		//사용 테스트
		Calendar today;//추상 클래스임 new선언은 못하고 인퍼런스 선언만 가능
		today = Calendar.getInstance();
		System.out.println(today); //후손을 생성시켜서 후손의 toString()을 리턴함
		//java.util.GregorianCalendar[time=1544599729077,areFieldsSet=true,areAllFieldsSet=true,lenient=true,
		//zone=sun.util.calendar.ZoneInfo[id="Asia/Seoul",offset=32400000,dstSavings=0,useDaylight=false,transitions=22,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,
		//YEAR=2018,MONTH=11,WEEK_OF_YEAR=50,WEEK_OF_MONTH=3,DAY_OF_MONTH=12,DAY_OF_YEAR=346,DAY_OF_WEEK=4,DAY_OF_WEEK_IN_MONTH=2,AM_PM=1,HOUR=4,HOUR_OF_DAY=16,MINUTE=28,SECOND=49,
		//MILLISECOND=77,ZONE_OFFSET=32400000,DST_OFFSET=0]
		//[Field값들]
		//MONTH가 0~11로 나옴->11은 12월을 의미 실제 사용시 +1해야함 
		//SET할 때는 -1로 해서 적용해야 함.
		//WEEK_OF_YEAR = 1년에 몇 번째 주인지
		//DAY_OF_WEEK=4 일요일이1 지금이 수요일이므로 4
		//DAY_OF_WEEK_IN_MONTH=2  오늘에 해당되는 요일이 한달 안에서 몇 번째 요일인지 
		//18년12월12일 12월에서 두번째 수요일이므로 2

		//get(int field) return (int) 
		//get메소드는 static이 없으므로 레퍼런스.get() 
		
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH)+1; //MONTH 0~11이므로 지금 12월이니 +1
		int day = today.get(Calendar.DAY_OF_MONTH);
		int weekDay = today.get(Calendar.DAY_OF_WEEK);
		int hour = today.get(Calendar.HOUR); //HOUR OF DAY 는 24시간 HOUR는 12시간
		int minute = today.get(Calendar.MINUTE);
		int second = today.get(Calendar.SECOND);
		int ampm = today.get(Calendar.AM_PM);
		
		String week = null;
		switch(weekDay) {
		case 1: week = "일요일"; break;
		case 2: week = "월요일"; break;
		case 3: week = "화요일"; break;
		case 4: week = "수요일"; break;
		case 5: week = "목요일"; break;
		case 6: week = "금요일"; break;
		case 7: week = "토요일"; break;
		
		}
		System.out.println(year + "년 " +month+"월 " + day+"일 "+week+" "+
				(ampm==0?"오전":"오후")+" "+hour+"시 "+minute+"분 "+second+"초");
	}

}
