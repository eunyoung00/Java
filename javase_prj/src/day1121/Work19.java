package day1121;

public class Work19 {
	
//	숙제
//	1.  while을 사용하여 구구단 전체 단을 출력하는  instance method를
//	    작성하고, 호출하세요.
	public void gugudanMethod() {
		int i=2;
		while(i<10) {
			int j =1;
			while(j<10) {
				System.out.println(i+"*"+j+" = "+i*j);
				j++;
			}
			i++;
		}
	}//gugudanMethod
	//int j를 안에서 정의한게 다시 초기화역할을 해주어서 초기화할 필요가 없없음

//	2.  do~while을 사용하여 아래의 형태의  *을 출력하는  static method를
//    작성하여 호출하세요.
//    *
//    **
//    ***
//    ****
	public static void twoMethod() {
		int a = 1;
		int b = 0;
//		do {
//			for (b=0; b<a; b++) {
//				System.out.print("*");
//			}			
//			System.out.println();
//			a++;
//		}while(a<5);	
// 		for (b=0;여기서 계속 초기화를 해주기 때문에 값을 늘릴수 있었음
		
/*		while(a<5) {
			b=0;
			while(b<a){
				System.out.print("*");
				b++;
			}
			a++;
			System.out.println();*/
		
		do {
			//int b=0;
			b=0;
			do {
				System.out.print("*");
				b++;
			}while(b<a);
			a++;
			System.out.println();
		}while(a<5);
	}//twoMethod
	//do 밖에서 초기화 했기 때문에 안에서 다시 초기화해주어야 0부터 증가할수 있다.
	//이중일때 안에들어가는 변수는 안에다 선언&초기화 해주는게 while문에서는 좋겠다.
	
	
	public static void main(String[] args) {
		Work19 gu = new Work19();//1번 객체화
		gu.gugudanMethod();      //1번 호출
		
		Work19.twoMethod();//2번 호출


	}//main
}//class
