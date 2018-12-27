package day1113;
//표준 출력 method 사용
class UsePrint{
	public static void main(String[] args){
	//라인수가 딱 떨어진다. 컨트롤 g로 줄자리 
		/*
		System.out.print("안녕");
		System.out.print("하세요");
		*/
		System.out.println(11);//정수 상수
		System.out.println(11.13);//실수 상수
		System.out.println('a');//문자 상수(한자밖에 못쓴다.)
		System.out.println("ABC 오늘은");//문자열 상수
		
		int i=11; //지역변수
		String s="오늘은 화요일"; //변수
		
		System.out.println(i);//기본형 데이터형 변수
		System.out.println(s);//참조형 데이터형 변수
		
		System.out.println(11+13); //연산식=연산된결과가 나온다.		
		//메세지 연산식 
		System.out.println("11+13");	//있는 그대로 나오게 된다.
		System.out.println("11+13="+(11+13));	//괄호로 먼저 묶어야 연산.

		
		
		
		
			
	}//main

}