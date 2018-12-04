package day1119;

/**
 * switch~case : 정수를 비교할 때.(JDK1.7에서부터는 문자열도 비교가능)<br>
 * 문법) switch(변수명 {<br>
 *         case 상수 : 수행문장;<br>
 *         case 상수 : 수행문장;<br>
 *                 .<br>
 *                 .<br>
 *         default : 일치하는 상수가 없을 때 수행문장;<br>
 *      }<br>
 * @author owner
 */
public class TestSwitchCase {

	public static void main(String[] args) {
		//String i = "1";	//JDK1.7에서부터 사용가능
		//long은 넣을수 없다.int로 변환되는 형만 가능
		//char '1'은 유니코드 45가 나와 default로 간다.
		//String 일때는 case 상수에도 다 쌍따옴표!
		//컴파일러의 버전을 바꿀수있다 프로젝에서 오른쪽
		int i = 0;
		
		//switch에 입력되는 변수의 데이터형은 byte, short, int, char, String
		switch(i) {	
		//case는 입력되는 변수에 따라 다른 범위를 가진다.
		//signed value 인것...
		case 0:System.out.println("새벽");	//0인경우 다출력
		case 1:System.out.println("아침");	//1인경우 점심저녁새벽
		case 32767:System.out.println("점심");	//2인경우 저녁 새벽
		default : System.out.println("저녁");		//3~이상은 다 새벽
		}//end switch
	}//main
}//class
