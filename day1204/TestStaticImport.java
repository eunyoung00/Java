package day1204;

import static java.lang.Integer.MAX_VALUE;
//import static java.lang.Byte.MAX_VALUE;
//같은 이름의 상수는 하나만 static import받는다. Error

//method는 method명만 기술한다.
import static java.lang.Integer.parseInt;
import static java.lang.Integer.toBinaryString;
/**
 * static import : 
 * 다른 클래스의 static변수(상수=Constant)나 method를 현재 클래스에 있는 것처럼 사용할 때.<br>
 * 문법) import static 패키지명.클래스명.변수명|method명;
 * @author owner
 */
public class TestStaticImport {

	public static void main(String[] args) {
//		int i=Integer.MAX_VALUE;
		int i=MAX_VALUE;
		System.out.println(i);
//		System.out.println(Integer.MAX_VALUE);
		System.out.println(MAX_VALUE);
		
		String year = "2018";
		String month = "12";
		String day = "4";
		
		int intYear = parseInt(year);
		int intMonth = parseInt(month);
		int intDay = parseInt(day);
		
		System.out.println(intYear +" / "+intMonth+" / "+intDay);
		//2진수로.
		System.out.println(toBinaryString(intYear) +" / "+ toBinaryString(intMonth)+" / "+toBinaryString(intDay));
		//<integer가 아니어도 가져다 쓸수 있다~
		
	}//main
}//class
