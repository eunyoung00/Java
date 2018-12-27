package day1122;

/**
 * 특수문자 : 문자열 내 \(역슬래쉬)로 시작하는 기능을 가진 문자.
 * @author owner
 */
public class UseEscapeCaracter {

	public static void main(String[] args) {
		System.out.println("이\t 재현");//\t : tab
		System.out.println("이\t\t 재현");
		System.out.println("정\n 택성");//\n : new line
		System.out.println("정\r 택성");//\r : return(커서가 앞으로지만 윈도우에선 줄이 바뀜)
		System.out.println("오늘은 \"급여일\" 입니다.");//\" : "의 충돌을 막아 "로 인식하게 해줌
		System.out.println("오늘은 '''''급여일' 입니다.");//\' : '는 충돌이 일어나지 않아 딱히..
		//\'는 자바스크립트에서 중요 
//		System.out.println("c:\dev\workspace\javase_prj\src\day1122\Test.java");//\알파벳이 없어 Error 역슬래쉬 쓰려면▼
		System.out.println("c:\\dev\\workspace\\javase_prj\\src\\day1122\\Test.java");//\\ : 역슬래쉬 쓰려면 두개~! 
		//윈도우는 \,/ 경로 표현으로 둘다 가능.
		System.out.println("이재현\b");//\b : 지워지지는 않는다.특수문자가 나올뿐
		System.out.println("이재현\f");//\f : 줄변경되지 않는다 printf가 아니라 특수문자.
		
	}//main
}//class
