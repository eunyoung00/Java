package day1122;

/**
 * Variable Arguments : 
 * 매개변수는 하나인데 인수를 여러개 넣을 수 있는 기능.<br>
 *  method내에서는 배열로 처리된다.<br>
 * 정의) "데이터형 ... 파라미터명" 의 형식으로 정의 
 * @author owner
 */
public class VariableArguments {

	/**
	 * 동일 데이터형으로 된 인수값을 여러개 사용할 때.
	 * @param param 가변 인수형
	 */
	public void test(int ... param) {	//컴파일러를1.4로  변경하면 Error나는걸 볼수있다.
		for(int val : param) {
			System.out.println(val);
		}//end for
		System.out.println("test method called!!!");
	}//test
	
	/**
	 * 가변인수를 받기 위한 매개변수는 가장 마지막에만 사용할수 있다.(정의할 수 있다.)
	 * @param i 처음
	 * @param d 두번째
	 * @param j 세번째
	 */
	public void test1(int i, double d, int ... j) {
		System.out.println("처음 매개변수 : "+i);
		System.out.println("두번째 매개변수 : "+d);
		System.out.println("세번째 매개변수 : "+j); //j가 배열처럼 들어가 참조형이라 주소가 나온다.
		for(int idx=0; idx<j.length; idx++) {
			System.out.println(j[idx]);
		}//end for
	}//test
	
	//문자열을 입력받을수 있는 매개변수로 선언해 사용 
	public void printName(String name) {
		System.out.println(name+"님 안녕하세요?");
	}//printName
	
	public static void main(String[] args) {
		VariableArguments va = new VariableArguments();
//		va.test();
//		va.test(1,2,3,4,5);//개수에 맞게 호출 잘 됨
//		va.test(1,5,88,6665,594223);//몇개가 들어가는지 잘모를때 쓰게된다.
		va.test();//이건 위쪽거
//		va.test1();//는에러
		va.test1(1,1.1);//가능 마지막건 배열로 참조형이되어 주소가 같이나온다?
		va.test1(1, 3.14, 10,20,30,40,50);
		
		String name = "이재찬";//문자열을 변수에 저장하고 메소드로 넘겨 출력할수 있다.
		va.printName(name);
//		System.out.println(name);
		
		String path="c:\temp\new_file.txt";
//		String path="c:\temp\kkk_file.txt";//\k가 지원되지 않아 Error		
		System.out.println(path);
		
//		String test = "안녕하세요";
		System.out.println("안녕하세요");
		System.out.println("'안녕하세요'");
		System.out.println("\"안녕하세요\"");
		//문자열은 " "이안에 들어가는 많은 문자열을 묶게 되는데 홀따옴표는 헷갈리지않아서(간섭ㄴ)출력되지만
		//"는 ""가 하나의 문자열이 되어 간섭받아 Error난다.
		//안녕하세요 라는 변수명이고+였을때 에 에러안남
		//간섭받지 않기 위해 특수문자 이용
		
		System.out.println("\t\t\t오늘은 ");
		System.out.println("\t\t\u0000\0오늘은 ");
		
		//정수하나 실수하나만 꼭 들어가면 그뒤로는 몇개가 들어가도 상관없다.
	}//main
}//class
