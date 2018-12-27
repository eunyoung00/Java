package day1119; //패키지가 들어갔고 퍼블릭이 클래스에 붙었다.자바닥 만들때 퍼블릭 안붙은건 안나온다.

//<br> 닥주석에는 넣어야 한다. 줄바꿈
/**
 * 조건문의 사용<br>
 * 단일 if문 : 조건에 맞는 경우에만 코들를 실행해야할때.<br>
 * 문법) if (조건식) {<br>
 * 			조건에 맞을때 수행 문장들...;<br>
 *	   }<br>
 * 자바닥= 닥주석(alt shift j)<br>
 * 이걸로 나중에 닥을 만들게 된다?doc?<br>
 * 
 * @author owner
 */
public class TestIf {
	
	//Constant : 변수를 상수처럼 사용할때.(값을 변경하지 못하는 변수) 바뀌지 않아야 하는값들
	public static final int FLAG_VALUE = 1250;
	public static final int FLAG_CNT = 20;
	//constant명은 대문자!!블럭잡고 ctrl shift x 대문자~!
	//ctrl shift y 소문자

	public static void main(String[] args) {
/*
		int i = 10;

		if (i < 0) {//단일 if ex
			i = -i;
		} // end if

		System.out.println("i= " + i);
*/
		//이름을 입력받아 이름이 이재찬이면 이름을 출력하기전에 반장을 출력하고 그렇지 않다면 이름만 출력 
		//입력받는것이기 때문에 Run의 화살표 configuration 눌러서 Argument값 입력
		if (args[0].equals("이재찬")) {
			System.out.print("반장 ");			
		}//end if
		System.out.println(args[0]);
		
		//숫자형태의 문자열을 정수로 변환하고 싶을때 Parse double도있고 long도있고 여러매소드 존재
		int i = Integer.parseInt(args[1]);
		int j = Integer.parseInt(args[2]);
		
		System.out.println(i+" + "+j +" = "+(i+j));
		
		//args[3]을 입력받아 그수가 20이내라면 1250과 입력수를 곱하여 출력하고
		//그렇지 않으면 20보다 크다면 1250에 10%를 더한 값과 입력수를 곱하여 출력.
//		int ii = Integer.parseInt(args[3]);
//		if (ii<=20) {
//			System.out.println("args[3]은 20이내 " + ii*1250);
//		}
//		if (ii>20) {
//			System.out.println("args[3]은 20외 " + (1250+(1250*0.1))*ii);
//		}
//		//무조건 정수일땐 캐스팅~!
//		//자바는 형에대해서 오라클보다 엄격
		
		//답)
		//<기준값은 constant => 상수 => 필드에 선언
		//java day1119.TestIf 문자열 정수 정수 정수  <타고들어오는 args가 문자열이라 비교가 되지 않는다.
		//                     0   1  1  3
		int input_value = Integer.parseInt(args[3]);
		int sum = TestIf.FLAG_VALUE;
		
		if(input_value>TestIf.FLAG_CNT) {
			sum = (int)(TestIf.FLAG_VALUE + TestIf.FLAG_VALUE* 0.1);
			//0.1은 8byte의 자리로 다른 값들마저도  8byte의 double로 다바뀌어 연산이 되어 casting해줌
		}//end if
		System.out.println(sum*input_value);
		
	}// main

}// class
