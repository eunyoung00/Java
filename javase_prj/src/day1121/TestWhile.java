package day1121;

/**
 * while : 시작과 끝을 모를때 사용하는 반복문<br>
 *         최소 0번 수행~최대 조건까지 수행<br>
 * 문법) while(조건식){<br>
 *         반복수행문장;<br>
 *      }<br>
 * @author owner
 */
public class TestWhile {

	public static void main(String[] args) {
		int i=0; //초기값    while이라고 볼수 없다. for 인것
		
		while(i<10) {
			System.out.println("i="+i);//반복수행문장
			//만약 증감식이 없다면 무한루프
			i++;//증가식
		}//end while
		
		System.out.println("-------------------------------------");
		//구구단의 단을 입력받아 2~9단 사이라면 구구단을 출력 while로 
		int dan = Integer.parseInt(args[0]);
		if(dan>1 && dan<10) {
			int j = 1;
			while(j<10) {
				System.out.println(dan+"*"+j+" = "+ (dan*j));
				j++;
			}
		}
		
		//무한loop
//		while(true) {
//			System.out.println("무한 loop");
//		}//end while
//		//무한 루프아래코드는 실행 안돼서 적으면 Error
		while(true) {
			System.out.println("무한 loop");
			break;//들어가는 순간 무한 루프아니게됨 그냥 나가버리니깐
		}//end while
		
		i=0;
		while(true) {
			System.out.println("무한 loop");
			if(i==5) {
				break;//조건과 함께
			}//end if
			i++;
		}//end while

	}//main
}//class
