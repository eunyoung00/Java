package day1114;
/*
	다른클래스에 있는 상수를 사용해보기위한 클래스
*/

class UseConstant{
	public static void main(String[] args) {
		//System.out.println(Constant.MAX_SCORE);
		//다른클래스에 존재하는 상수는 꼭 반드시 "클래스명.상수명"의 형식을 가진다.

		System.out.println(Constant.MAX_SCORE+" / "+Constant.MIN_SCORE);

		int doci = 15;
		int octal = 017;
		int hex = 0xF;
		int hex1 = 0xf;
		//우리가 자바창에서 쓸수있는 진법은 이세가지가 전부이다.

		System.out.println(doci+" / "+octal+" / "+hex+ " / "+ hex1 );

		int tel = 01012345677;
		System.out.println(tel);

		int tel1 = 1238;
		System.out.println(tel1);


	}//main
}//class
