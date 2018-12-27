package day1205;

import java.util.StringTokenizer;

/**
 * StringTokenizer : 
 * 문자열을 짧은 마디로 구분하는 StringTokenizer의 사용.
 * @author owner
 */
public class UseStirngTokenizer {
	
	public UseStirngTokenizer() {
		String msg="오늘은 수요일 입니다. 날씨는 -5입니다.";
		//공백으로 구분하고 싶을때 : 매개변수 하나인 생성자 사용.
		StringTokenizer stk = new StringTokenizer(msg);
		
		System.out.println(stk.countTokens()+"개");
		System.out.println(stk.nextToken());//오늘은
		//하나 남겨도 포인터를 이미넘겨서 다를바 없이 출력
//		System.out.println(stk.nextToken());//수요일
//		System.out.println(stk.nextToken());//입니다.
//		System.out.println(stk.nextToken());
//		System.out.println(stk.nextToken());
		//몇개인지 그때그때 다 알수 없는데,넘어가면 Error나기 때문에 이렇게는 ㄴㄴ
		//그래서 쓰는게 while
		
		while(stk.hasMoreTokens()) {//토큰이 존재하는지?
			//토큰을 얻고 포인터를 다음으로 이동
			System.out.println(stk.nextToken());
		}//end while
		
		String names="이재현,이재찬~정택성,김희철.김정운~김정윤,공선의";
		//특정문자로 토큰 구분  : 매개변수 두개인 생성자.
		StringTokenizer stk1 = new StringTokenizer(names, ",");
		System.out.println("--------------------------------");
		System.out.println("토큰의 수 : "+stk1.countTokens());
		while(stk1.hasMoreTokens()) {
			System.out.println(stk1.nextToken());
		}
		//or기능이있어 두개를 넣어도~3개를 넣어도 잘 잘린다.split보다 강력~!
		//공백마저도 자를수 있다. 훨씬더 기능이 좋다.
		System.out.println("--------------------------------");
//		StringTokenizer stk2 = new StringTokenizer(names, ",~ .");
		StringTokenizer stk2 = new StringTokenizer(names, "김");
		
		System.out.println("토큰의 수 : "+stk2.countTokens());
		while(stk2.hasMoreTokens()) {
			System.out.println(stk2.nextToken());
		}
		//특정문자로 토큰 구분, 구분된 문자열도 토큰으로 처리: 매개변수 3개인 생성자
		//true 면 토큰으로 취급하고, flase면 버려진다.
		StringTokenizer stk3 = new StringTokenizer(names, ",.~",false);
		while(stk3.hasMoreTokens()) {
			System.out.println(stk3.nextToken());
//			System.out.println(stk3.nextToken());
			//두개를 넣으면 두개씩 넘어갈수도 있는데 개수가 맞지않아 Error발생 가능성이 높아 잘쓰지 않는다.
		}
		
		
		
	}//UseStirngTokenizer

	public static void main(String[] args) {
		new UseStirngTokenizer();
		
		
		
		
	}//main
}//class
