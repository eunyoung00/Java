package day1114;
/*
기본형 데이터형
정수형 : byte, short, int, long(int, long많이)
문자형 : char
실수형 : float, double(double많이)
불린형 : boolean(많이)
*/

class PrimitiveDataType {
	public static void main(String[] args) {
		//<자바는 괄호를 그행에 끝에 적는다. 잘내려적지 않는다.
		//정수형
		byte a = 10;
		short b = 20;
		int c = 30;
		long d = 40;	//할당되는 값이 4byte내 이므로 literal을 변환할 필요가 없다.
		long e = 21474836478L;
		//literal의 저장이 되지 않으므로 literal의 크기를 변경 => 형명시 

		System.out.println("byte : " + a + ", short : " + b + ", int : " + c + ", long : " + d + ", " +e);

		//문자형 : unicode 값 : \u0000 => 십진수로 바뀌어 나온다.
		//char f = 'A';	//할당은 unicode가 되고
		char f = 66;	//unicode값을 넣어서 10진수로 할당도 가능하다.
		char g = '0';	//<0은 정수상수 '0'은 문자상수 "0"은 문자열 상수로 다다른 값들이다!
		char h = '가';
		//출력은 unicode에 대한 문자 출력
		System.out.println("char : " + f + ", " + g + ", " + h);

		//실수 
		float i = 3.14F;	//형명시 - 실수 literal은 8byte이고, float 데이터형은 4byte이므로 값할당이 되지 않는다.
							//따라서 F,f로 형명시
		//<4byte의 크기를 갖는데 리터널의 크기는 8byte이므로 값자체가 들어가지 않는다. 동일한 형 , 동일한 크기 이어야한다.l은 늘리고 f는 줄인다.
		double j = 3.14;	//리터널과 데이터형이 같으므로 형명시 생략할 수 있다.
		//<형명시 잘하지 않는다 해도그만 안해도 그만
		double k = 3.14d;	
		
		System.out.println("float : " + i + ", double : " + j + ", " + k);

		//불린형
		boolean l = true;	//<c처럼 1과 0이 들어가지 않는다
		boolean m = false;
		System.out.println("boolean : " + l + ", " + m);

		//자동형변환
		byte b1 = 10, b2 = 20;	//, result = 0;
		//result = b1 + b2;	//이것도 자동형변환 byte나 short까지 형변환이 필요하다면 너무불편해 자동으로 되게끔 만들어져있다..?
		//결과값이 byte가 아니라 int로 발생되어 할당되지 않는다.
		int result = b1 + b2;
		short c1 = 20;
		int result2 = b1+c1;	//연산이 된다. 하지만 int 로 담아야 byte를 2byte로 인식해 연산하지만 큰쪽으로 바꾸여 연산해줌

		System.out.println(result+", "+result2);

		

	}//main
}//class
