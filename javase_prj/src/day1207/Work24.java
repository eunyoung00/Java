package day1207;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Work24 {
//	숙제 1.
//	main method의 arguments로 날짜를 여러개 입력 받아 입력받은 날짜의
//	 요일을 저장하고 출력하는 method 를 작성하세요.
//
//	예) java Test 4 12 30 32 35 15 4   
//
//	출력) 4 화
//	     12 수
//	     15 토
//	     30 일  입력한대로 출력되진않는다.
//	Map, Set사용하면 편리

	// Set :검색의 기능이 없으며(get X), 중복값을 저장하지 않는(유일) 기능을 가짐.
	Set<String> set;
	Calendar cal1;
	Iterator<String> ita;
	String days;

	// Set을 만들고 값을 넣어 제어권을 ita에 넘김.
	public Work24() {
//		Map<String, String> map = new HashMap<String,String>();
		set = new HashSet<String>();
//		set.add(4);
//		set.add(12);
//		set.add(30);
//		set.add(32);
//		set.add(35);
//		set.add(15);
//		set.add(4);
		ita = set.iterator();// 제어권을 넘김.

	}// Work24

	// Set에 넣어진값으로 날짜를 변경하고 출력해줌
	public void printSet(String[] args) {
		for (int i = 0; i < args.length; i++) {
			set.add(args[i]);
		}
		ita = set.iterator();
		while (ita.hasNext()) {// Iterator가 참조하는 Set의 요소가 존재한다면
			days = ita.next();// 해당 요소의 값을 얻고 다음 포인터로 이동.
			cal1 = new GregorianCalendar();// os의 날짜 가져오기.
			cal1.set(Calendar.DAY_OF_MONTH, Integer.parseInt(days));// days일로 변경

//			System.out.println("\n이번달의 마지막날 : "+cal1.getActualMaximum(Calendar.DATE));
			if (Integer.parseInt(days) < cal1.getActualMaximum(Calendar.DATE)) {// 마지막날보다 작으면 출력.
				System.out.printf("%d %s\n", cal1.get(Calendar.DAY_OF_MONTH),
						"일,월,화,수,목,금,토".split(",")[cal1.get(Calendar.DAY_OF_WEEK) - 1]);
				// 변경값 출력.
			} // end if
		} // end while
	}// printSet

	public static void main(String[] args) {
		Work24 hw = new Work24();
		hw.printSet(args);

	}// main
}// class
