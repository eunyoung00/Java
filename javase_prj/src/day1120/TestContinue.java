package day1120;

/**
 * continue : 반복문내의 반복 실행 코드의 수행을 건너 뛰는 일.<br>
 *    
 * @author owner
 */
public class TestContinue {

	public static void main(String[] args) {
		
		 //0~100까지 홀수만 출력하고 싶을때
		 for(int i=0; i<100; i++) {
			 //System.out.println("i ="+i); <반복수행코드 사이에 들어갈수도 있다.가능..
			 if(i%2==0){
				 continue;
			 }//end if
				 
			 //continue;//<이것만 있으면 아래코드를 무조건 건너 뛰어서  Error
			 System.out.println("i ="+i);
			 //continue;//아래쪽에 코드가 없어서 건너뛸게 없어 실행시 똑같이 나온다.
		 }//end for
		
	}//main
}//class
