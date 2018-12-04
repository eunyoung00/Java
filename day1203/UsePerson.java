package day1203;

import java.util.Arrays;

//import java.util.Date;

public class UsePerson {

	public static void main(String[] args) {
		HongGilDong gd = new HongGilDong();
		gd.setName("홍길동");//부모의 method사용.
		System.out.println("눈 : "+gd.getEye()+", 코 : "+gd.getNose()+
							", 입 : "+gd.getMouth());
		

		System.out.println(gd.eat());
		System.out.println(gd.eat("국밥",1));
		//자신만의 특징
		
		System.out.println(gd.fight(6));//7>8
		System.out.println(gd.fight(7));//8>9
		System.out.println(gd.fight(9));//비김
		System.out.println(gd.fight(10));//진다. 9>8
		System.out.println(gd.fight(9));//진다. 8>7
		
		System.out.println("----------------------------------------");
		
		Clark superman = new Clark();//자식이 생성되면 부모클래스가 먼저 생성된 후 자식이 생성된다.
		//자식의 객체로 부모클래스의 자원(변수, method)를 자식의 것처럼 사용할 수 있다-코드의 재 사용성
		superman.setName("클락");
		System.out.println(superman.getEye()+" / "+superman.getNose()+
				" / "+superman.getMouth()+" / "+superman.getName());
		System.out.println(superman.eat());
		System.out.println(superman.eat("스테이크", 10));
		
		//자식(자신)의 자원 (method, 변수)
		String stone="짱돌";
		System.out.println(stone+"을 맞은 결과 "+superman.power(stone)+", 힘의 변화 : "
							+superman.power);
		
		stone="클립토나이트";
		System.out.println(stone+"을 맞은 결과 "+superman.power(stone)+", 힘의 변화 : "
				+superman.power);
		
		stone="다이아몬드";
		System.out.println(stone+"을 맞은 결과 "+superman.power(stone)+", 힘의 변화 : "
				+superman.power);
		
		System.out.println("----------------------------------------");
		
//		Me eunyoung = new Me();
//		eunyoung.setName("박은영");
//		System.out.println(eunyoung.getEye()+" / "+eunyoung.getNose()+
//				" / "+eunyoung.getMouth()+" / "+eunyoung.getName());
//		System.out.println(eunyoung.eat());
//		System.out.println(eunyoung.eat("초코라떼",3000));
		
//		int cnt=10;
//		System.out.println(cnt+"만큼 반복한 결과"+eunyoung.dexterity(cnt));
//		cnt=3;
//		System.out.println(cnt+"만큼 반복한 결과"+eunyoung.dexterity(cnt));
//		
//		System.out.println(gd);//주소가 출력된다.
//		System.out.println(gd.toString());//주소가 출력된다.
//		System.out.println(eunyoung.toString());//주소가 출력된다.
//		String s= new String("오늘은 금요일 입니다.");
//		System.out.println(s.toString());//문자열이 출력된다.
//		
//		Date d = new Date();
//		System.out.println(d.getYear());//일을 하긴하는데 만든지 오래된언어라 잘 동작하지않아서.
//		//잘못된 일을 하는 메소드라고 비추천메소드라는 표시.
//		@SuppressWarnings("unused")
//		int i;
		
		//인스턴스변수와 지역변수 언제만들까여..?
		//파라미터도 하나의 지역변수
		//인스턴스 변수 : 이객체가 끝까지 소멸되기 전까지 가지고 가야할 값이있다면,
		//지역변수 : 잠깐 사용될것.이라면 지역변수로..
		
		String[] clarkLang=superman.language("외계어");
		clarkLang=superman.language("영어");
		clarkLang=superman.language("불어");
		clarkLang=superman.language("한국어");
		clarkLang=superman.language("영어");
		clarkLang=superman.language("한국어");
		
//		clarkLang=
		System.out.println(Arrays.toString(clarkLang));
		
		
		
		String[] hongLang=gd.language("한국어");
		hongLang=gd.language("중국어");
		hongLang=gd.language("수화");
		
		System.out.println(Arrays.toString(hongLang));
		System.out.println("--------------------------------------------");
		
		//Clark는 interface를 구현하였으므로 비행가능.
		System.out.println(superman.speed("빠르"));
		System.out.println(superman.height("높"));
		//<사람이면서 나는쪽으로 기능확장.
		
		
	}//main
	
	
}//class
