package day1121;

/**
 * do~while : 시작과 끝을 모를때 사용하는 반복문<br>
 *            최소 1번 수행~최대 조건까지 수행<br>
 * 문법) do{  <br>
 *         반복 수행 문장들;<br>
 *      }while(조건식);<br>
 *      
 * @author owner
 */
public class TestDoWhile {

	public static void main(String[] args) {
		//지금쓰는건 for형식
		int i=1000;//초기값
		do {
			System.out.println("i="+i);//반복수행문장
			i++;//증가식      <여기까지 무조건 1번~!~!
		}while(i<10);//조건식
		
		
		//입력되는 단으로 구구단 출력
		i = Integer.parseInt(args[0]);
		//i=9;//test
		
//		float f = Float.parseFloat(args[0]);   //래퍼클래스!!! 다 있기는 있다.
//		double d = Double.parseDouble(args[0]);
		
		if(i>1 && i<10) {//2단에서 9단 사이
			//System.out.println(i);//test
			System.out.println(i+"단");
			int j = 1;
			do {
				System.out.println(i+"*"+j +" = "+i*j);
				j++;
			}while(j<10);
			
		}else{
			System.out.println("단은 2단에서 9단까지 입력해 주세요.");
		}//end if
		
	}//main
}//class
