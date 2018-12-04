package day1120;

/**
 * 다중 for : 인덱스를 여러개 사용해야하는 경우<br>
 * 문법) for(시작값; 끝값; 증가,감소식){<br>
 * 	        for(시작값; 끝값; 증가,감소식){<br>
 *             반복수행문장들;<br>
 *          }<br>
 *      }<br>
 * 
 * @author owner
 */
public class TestFor1 {

	public static void main(String[] args) { //<실행해서 결과볼꺼니까 메인
		for(int i=0; i<6; i++) {
			//<단일for의 영역으로 안의 for문 돌기 전에 출력할 것 적는다.
			for(int j=0; j<7; j++) {//다중for <쓸떄 안쪽 변수는 밖의 인덱스 변수명과 달라야 한다.
				System.out.println("i : "+i+", j : "+j);
			}//end for
			//<단일 for 영역
			System.out.println("==============");
		}//end for
		
		//구구단 전단 출력
		for(int i=2; i<10; i++) {	//단
			System.out.println(i+"단 시작");
			for(int j=1;j<10; j++) {
				System.out.println(i+"*"+j+" = "+i*j);
			}
			System.out.println(i+"단 끝");
		}//end for
		
//		ijijijij
//		00
//		1011
//		202122
//		30313233
		for(int i=0; i<4; i++) {
			for(int j=0; j<i+1; j++) {
				System.out.print(i+""+j);
			}
			System.out.println();
		}//end for
		
		System.out.println("============");
		
//		ijijijij
//		121314
//		2324
//		34
		for(int i=1; i<4; i++) {
			for(int j=i+1; j<5; j++) {
				System.out.print(i+""+j);
			}
			System.out.println();	
		}//end for
				

	}//main

}//class
