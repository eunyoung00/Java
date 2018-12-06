package day1205;

import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 * Calendar : 단일 날짜 정보를 얻을 때.
 * 
 * @author owner
 */
public class UseCalendar {

	public UseCalendar() {
		//Calendar 클래스의 인스턴스 얻기 
		//1.getInstance 사용
//		Calendar cal = new Calendar;//추상클래스라 인스턴스가 될수 없다.
		Calendar cal =Calendar.getInstance();
		//GregorianCalendar을써서 객체화했음을 알수 있음. //출력주소를 보면.
		//2.is a 관계 객체화
		Calendar cal1 = new GregorianCalendar();
		//3.자식만으로 객체화
		GregorianCalendar gc = new GregorianCalendar();
		System.out.println(cal);
		System.out.println(cal1);
		System.out.println(gc);
		
		//<YEAR =>Constant : 가독성 향상(filed)
		//Constant를 사용하면 가독성 향상
		int i = cal.get(1);//나오긴 나오는데 가독성 거지...뭔지 몰라.
		int year = cal.get(Calendar.YEAR);
		//자바에서는 월의 시작이 0월. 이라 12월이지만11월.따라서+1
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DATE);
		int day2 = cal.get(Calendar.DAY_OF_MONTH);
		
		int day_of_year = cal.get(Calendar.DAY_OF_YEAR);
		//요일 : 일-1, 월-2, 화-3, 수-4, 목-5, 금-6, 토-7 
		int day_of_week = cal.get(Calendar.DAY_OF_WEEK);
		System.out.printf("%d-%d-%d 오늘은 올해에 %d번째 날\n", year,month,
							day2,day_of_year);
		System.out.printf("%d요일", day_of_week);
		
/*		String week="";
		switch(day_of_week) {
//		case 1 :System.out.println("일요일");	break;
		case Calendar.SUNDAY : 
			//이렇게 쓰는게 가독성이 훠어어어얼씬 좋다.
//			System.out.println("일요일");	break;
				week="일요일"; break;
				//이렇게쓰는게 출력보다 값에 넣어줘 좋다.
//		case 2 :System.out.println("월요일");	break;
		case Calendar.MONDAY :
			System.out.println("월요일");	break;
		case 3 :System.out.println("화요일");	break;
		case 4 :System.out.println("수요일");	break;
		case 5 :System.out.println("목요일");	
				week="목요일"; break;
		case 6 :System.out.println("금요일");
				week="금요일"; break;
		case 7 :System.out.println("토요일");	
		}//end switch
		
		System.out.printf("%s", week);		
*/
		
		String[] weekTitle = {"일","월","화","수","목","금","토"};
		System.out.printf(" %s\n",weekTitle[day_of_week-1]);//배열이라서 -1
		int am_pm=cal.get(Calendar.AM_PM);//1오후, 0오전
//		switch (am_pm) {
//		case Calendar.AM/*상수*/:
//			System.out.println("오전");
//			break;
//		case Calendar.PM:
//			System.out.println("오후");
//			break;
//		}
		System.out.printf("%d, %s\n",am_pm,am_pm==Calendar.AM?"오전":"오후");//상함연산자로 참이면 오전,f면 오후
		//3항연산자로 도 편하게 쓸수 있다. 값이 2가지로 나뉘니까.
		
		//시간
		int hour=cal.get(Calendar.HOUR);
		int hour24=cal.get(Calendar.HOUR_OF_DAY);
		int minute=cal.get(Calendar.MINUTE);
		int second=cal.get(Calendar.SECOND);
		System.out.printf("%d(%d):%d:%d\n", hour, hour24,minute,second);
		//하나하나는 calendar, 형식이있는 날짜 =>SimpleDateFormat,Date

		
		System.out.println("------------------------------------------------");
		System.out.printf("설정전 %d-%d-%d %s요일\n",
				cal1.get(Calendar.YEAR),cal1.get(Calendar.MONTH)+1,
				cal1.get(Calendar.DAY_OF_MONTH),
				"일,월,화,수,목,금,토".split(",")[cal1.get(Calendar.DAY_OF_WEEK)-1]);
		//년
		cal1.set(Calendar.YEAR, 2019);//2019-12-06
		//월 : 사람이 생각하는 월보다 1작게 설정
		cal1.set(Calendar.MONTH, 5-1);//2019-05-06
		//일 : 해당 일에 존재하지 않는 다음 일자가 설정되면 자동으로 다음달 1일로 설정
		cal1.set(Calendar.DAY_OF_MONTH, 15);//2019-05-15
		
		System.out.printf("설정후 %d-%d-%d %s요일",
				cal1.get(Calendar.YEAR),cal1.get(Calendar.MONTH)+1,
				cal1.get(Calendar.DAY_OF_MONTH),
				"일,월,화,수,목,금,토".split(",")[cal1.get(Calendar.DAY_OF_WEEK)-1]);
		
		System.out.println("\n이번달의 마지막날 : "+cal1.getActualMaximum(Calendar.DATE));
		
		
		
	}//UseCalendar
	
	public static void main(String[] args) {
		new UseCalendar();
	}//main

}//class
