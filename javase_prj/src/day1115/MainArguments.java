package day1115;
/*
	Java 프로그램 외부에서 Java 프로그램 내부로 값을 전달할 때 main method의 Arguments 사용.
	실행 : java 클래스파일명(바이트코드명) 값 값 값...(최대 21억개_인덱스가 21억개까지 가능)
*/

class MainArguments {
	public static void main(String[] args) {

		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[0]+args[1]);	//문자열은 + 합쳐져서~!이것만 되고, *는 되지 않는닷

		//int i = args[0];  int i = (int)args[0]; ㄴㄴㄴ
		//기본형 참조형 형이 달라 들어가지 않는다.캐스팅(int)도 되지않는다.
		//문자열을 정수로 변환
		//Integer.parseInt(문자열); Integer클래스의 parseInt메소드면, 문자열을 구분하여 int형으로 변환한후 그값을 반환하는 일을 한다. 
		//되게많이쓴다.★★★
		int i = Integer.parseInt(args[0]);	//다쳐내고 필요한것만 잘라내옴, 숫자형태의 문자열은 가능하지만 아니라면(문자같은건) Error
		int j = Integer.parseInt(args[1]);	
		Integer.parseInt("ddd");

		System.out.println(i*j);
        //이렇게 Arguments 받아봄~!

		System.out.println(args[2] +"님 안녕하세요");//인자쓸때는 인덱스를 주의 없는거면 Error /3번째로 넣은건 인덱스 2이다/더넣은건상관x
        

        
	}//main
}//class
