package day1114;
/*
	Constant(변수를 상수처럼 사용하는것 =>줄여서 상수) 의 사용
	선언 : class field에서만 가능
*/

class Constant {
	//Constant선언
	public static final int MAX_SCORE=100;	//<final 이 값을 고정시키는데 일조, 없으면 값을 넣을수 있다.
	public static final int MIN_SCORE=0;

	public static void main(String[] args) {
		//public static final int MIN_SCORE=0;	//상수는 method내에서 선언할수 없다. Error

		//상수의 사용: 상수명   <내 클레스에 있을때~!~!
		System.out.println(MAX_SCORE +" / "+ MIN_SCORE);

		System.out.println(Constant.MAX_SCORE +" / "+ Constant.MIN_SCORE);

		int my_score = 95;
		my_score = 93;
		//MAX_SCORE=90;	//상수는 값할당이 되지 않는다.
		
		my_score = 83;
		//<변수는 원하는대로 내키는데로 몇번이든 값할당 가능

		System.out.println("정수의 최고점은 " +Constant.MAX_SCORE+ " 점이고, 최저점은 " +MIN_SCORE+ 
		"입니다. 획득점수는 " +my_score+ " 이고, 최고과 획득점수의 차이는 " +(Constant.MAX_SCORE-my_score));
		//<변수와 상수의 구분이 잘간다.

		System.out.println("long 최대값 : "+ Long.MAX_VALUE+ "/ 최소값 : " + Long.MIN_VALUE);
		//<외우는게 좋은데 MAX_VALUE,MIN_VALUE이렇게 찍어서 값이 나오게 할수 있다.

	}//main
}//class
