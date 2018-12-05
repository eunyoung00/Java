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
		
		//YEAR =>Constant : 가독성 향상
		int i = cal.get(1);//나오긴 나오는데 가독성 거지...뭔지 몰라.
		int year = cal.get(Calendar.YEAR);
		System.out.println(year+" "+i);
		
		
	}//UseCalendar
	
	public static void main(String[] args) {
		new UseCalendar();
	}//main

}//class
