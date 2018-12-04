package day1122;

/**
 * Method의 4가지 형태<br>
 * @author owner
 */
public class MethodType {
	
	/**
	 * 반환형 없고 매개변수 없는 형=&gt;같은 일을 수행=&gt;고정 일<br>
	 * 받아들이는것도 내보내는것도 없다.
	 */
	public void typeA() {
		System.out.println("안녕하세요?");
	}//typeA
	
	/**
	 * 반환형 없고 매개변수 있는 형=&gt;입력되는 값에따라 다른일=&gt;가변일<br>
	 * @param i 출력하고 싶은 값
	 */
	public void typeB(int i) {
		System.out.println(i+"번 안녕");
	}//typtB

	/**
	 * 반환형 있고, 매개변수 없는형=&gt;고정 값<br>
	 * 값을 받아 사용하는 코드가 필요.<br>
	 * @return 년.월을 실수형으로 반환
	 */
	public double typeC() {	//타입이 들어가 있어 꼭 리턴이 들어가야 한다고 뜬다.
//		int i=11;
//		return i;
//		return 2018.11f;
//		return (float)2018.11;//double은 캐스팅이 필요없으니 double사용하자
		return 2018.11;//실수는 정수를 타고나갈수 없다.
//		return "ㅋㅋㅋ"//형이달라 나갈수없다 Error
//		System.out.println("111");//return구문 아래에 코드가 정의될수 없다.
	}//typeC
	
	/**
	 * 반환형 있고, 매개변수 있는 형=&gt;가변 값<br>
	 * @param d  정수로 만들고 싶은 실수 값
	 * @return   정수로 변환된 값
	 */
	public int typeD(double d) {  //타입이 들어가 꼬옥 리턴
		
		int i = (int)d;//값손실발생
		return i;
	}//typeD
	
/*	public int typeD(double d) {  //헤더는 같은데 안의 일이 다른상태 안됨
									//같은이름의 메소드는 만들수 없다.
		return 33333;
	}//typeD
*/	
	public static void main(String[] args) {//가변일
		MethodType mt = new MethodType();
		//1.고정일 하는 method 호출
		mt.typeA();
		mt.typeA();//몇번을해도 항상 같은값
		mt.typeA();
		//2.가변일 method 호출
		mt.typeB(22);
		mt.typeB(21);//입력되는 값에따라 다른값
		mt.typeB(202);
		//3.고정값 method 호출 - 반환형과 일치하는 변수를 만들어서 값 저장
//		mt.typeC();//1번과 같아보이나..반환형을 가져오지 못한상태
//		int i =mt.typeC();//형이 다르다
//		double i=mt.typeC();  //정상출력됨
		double i=mt.typeC()+1;// typeC=곧 값 이라 연산바로 참여까지..가능
								//그래서 바로출력도 변수할당도 되는것 
//		int j = mt.typeA();//typeA는 값이 아니라 바로 변수에 할당되지 않는다.
		System.out.println("고정값 "+i);//한번부르나 여러번부르나 같은값
		//4.가변값 method 호출 - 반환형과 일치하는 변수를 만들어서 값 저장
		int j = mt.typeD(300.003);
		System.out.println("가변값 "+j);

	}//main
}//class
