package day1205;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 형식이 있는 날짜 정보를 얻을 때.
 * 형식 -java.text.SimpleDateFormat
 * 날짜정보 -java.util.Date
 * 형식이 있는 날짜정보로 쓰려면 이 두개를 같이 써야 만들수 있다. 혼자는 만들지 않는다.
 * @author owner
 */
public class UseDate {

	public UseDate() {
		Date date = new Date();
		System.out.println(date);
		//객체를 출력했는데 주소가아니라 출력된 이유 : Object의 toString를 Override.
		//긴 날짜 정보를 원하는게 아니라서.
//		System.out.println(1900+date.getYear());//비추천 method가 많다.
		//나오긴 나오는데 1900을 더해주어야 한다.비추천된 이유..!
		//고치는게 아니라 비추천이 됨.

		SimpleDateFormat sdf = new SimpleDateFormat
//				("yyyy년M월d일 a HH(hh,kk):mm:ss EEEE");
		("yyyy년M월d일 a EEEE HH(hh,kk):mm:ss",Locale.JAPAN);
		String formatDate = sdf.format(date);//date랑 has a 관계
		System.out.println(formatDate);
		
		//Locale: 다른나라의 날짜형식으로 변경하여 제공할 때.
		//util package
		
	
	
	}//UseDate
	
	public static void main(String[] args) {
		new UseDate();
	}//main
}//class
