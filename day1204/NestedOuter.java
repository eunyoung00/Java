package day1204;

/**
 * 내부클래스를 static 변수처럼 사용할 수 있는 중첩클래스.
 * @author owner
 */
public class NestedOuter {
	
	int i;
	static int j;
	
	public NestedOuter() {
		System.out.println("바깥 클래스의 생성자");
	}//NestedOuter
	
	public void outInstMethod() {
		System.out.println("바깥 클래스의 instance method");
	}//outInstMethod

	public static void outStatMethod() {
		System.out.println("바깥 클래스의 static method");
	}//outStatMethod
	
	/*--------------Nested class 시작-------------------------*/
	static class NestedInner{
		//<클래스 접근지정자가 static이라고 안쪽의 영역이 static인것은 아님.
		//<기본이 instance영역 인것.
//		int in_i;//instance 변수 (인스턴스 영역)//<권장ㄴㄴ
		static int in_j;//static 변수
		
//		public NestedInner() {
//			//만들수는 있는데, 권장 하지 않는다.
//			//<내부 클래스의 자원은 가급적이면 static으로 만들어 사용하기 때문에 사용할수 있으나
//			//<인스턴스화가 필요해서 복잡해지고 나중에가면 헷깔려진다. 
//		}//NestedInner
		
		public void inMethod() {
			System.out.println("안쪽 클래스의 instance method");
		}//inMethod
		
		public static void inStatMethod() {
			System.out.println("안쪽 클래스의 static method");
			System.out.println("안쪽 클래스에서 바깥 클래스의 자원 사용. i=사용불가, j="
								+j/*j==NestedOuter.j*/);
			//<i는 아무리 안쪽클래스라고 할지라도 static영역에서는 사용불가
//			outInstMethod();//Error=>instance영역의 method이므로 사용할 수 없다.
//			outStatMethod();//<사용 가능하나 가능하면 출처 밝히는게 좋음
			NestedOuter.outStatMethod();//이렇게~
		}//inStatMethod
	
	
	}//class
	/*--------------Nested class 끝  -------------------------*/

	public static void main(String[] args) {
		//static 영역을 사용할 때에는, 객체화 없이 클래스명.변수명, 
		//클래스명.method명으로 사용한다.
//		instatMethod();//<영역이 같다고 생각했으나 부르지못한다.inner class이기 때문에.
		NestedInner.inStatMethod();//<static->instance는 반드시 객체화!
		//<같은영역이기 때문에 클래스명.method명으로 사용가능한것.
	}//main
}//class
