package day1126;

/**
 * method의 매개변수가 참조형 데이터형 (class, 문자열, array)인 경우
 * Arguments를 넣으면 생성된 하나의 주소가 할당된다.<br>
 * (값을 변경하면 생성된 객체가 가진 값이 변경된다.)
 * @author owner
 */
public class CallByReference {

	private int i;
	private int j;
	
	public void swap(CallByReference cbr) {//<주소가 그대로 전달.
		int temp = 0;
		temp=cbr.i;
		cbr.i=cbr.j;
		cbr.j=temp;
		System.out.println("swap method내 i="+i+", j="+j);
	}//swap
	
	public static void main(String[] args) {
		CallByReference cbr = new CallByReference();
		cbr.i=11;
		cbr.j=26;
		System.out.println("swap전 i="+cbr.i+", j="+cbr.j);
		//<static method에서는 instance변수를 직접쓰지 못할까여?
		//<선언이 될지 안될지 스테틱은 먼저 생성되는 붑분이라 몰라서?
		//<스테틱 영역은 프로그램이 시작될때 가장먼저, 인스턴스는 실행이 되지 않았기 떄문에 누가올지 몰라서.

		cbr.swap(cbr);//주소가 그대로 전달됨
		System.out.println("swap후 i="+cbr.i+", j="+cbr.j);
	}//main
}//class
