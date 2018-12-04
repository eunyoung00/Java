package day1114;
/*
	강제형변환(Casting) : 변수의 데이터형을을 일시적으로 변환하여 사용하는 것./원하는 값으로 변환!
*/

class UseCasting{
	public static void main(String[] args) {
		byte b1 = 10, b2 = 20;	//자동형변환
		byte result = (byte)(b1*b2);	//연산의 결과가 int로 자동형변환//(byte)b1*b2;도 안돼닌데 괄호는 연산의 우선순위가 높아 바이트로 먼저바꾸고 연산해 버림
		//연산의 결과가 int로 자동형변환 되는것을 byte로 강제형변환
		System.out.println(b1 + " * " + b2 + " = " + result);

		double d = 11.14;
		float f = (float)d;
		System.out.println("double : " + d + ", float : " + f);
		//변수에는 형명시안돼고 캐스팅만 된다. L붙이면 dL이라는 변수 찾음

		float f1=(float)2018.11;	//상수앞에도 사용가능 리터널자체가 바뀌는것은 아님?
		System.out.println("f1 : " +f1);

		//long l = (long)2147483648;	//상수값이 literal보다 크다면 casting을 실행하기전에 Error발생.
		//<리터널자체가 안들어가기때문에 캐스팅해봤자 무쓸모 =>아예안됨

		//int i = f1;	//캐스팅필요
		//<담고있는 값의형태가 달라서 들어가지 않는다
		int i = (int)f1;	//값손실 발생(실수부의 값이 모두 사라져 할당)
		System.out.println("int : " + i + " , float : " + f1);

		char c = 'A';
		System.out.println(c+"의 unicode(ASCII code_숫자,영어에 한해)값 : "+ (int)c);

		//형이(기본형<->참조형 ㄴㄴ) 다르면 강제형변환이 되지 않는다.
//		String s = "11"; //참조형
//		int i = (int)s;	//기본형
		//<문자열이 숫자일때 오라클은 잘바꾸어주었지만 자바는 바꾸어주지 않는다

		//boolean형은 boolean형 끼리만 변환가능
		boolean b = true;
		//i = (int)b;	//error
		boolean bc = (boolean)b;	//<나를 나로바꾼다?? 아무 의미가 없다
		System.out.println(bc);
		


	}//main
}//class
