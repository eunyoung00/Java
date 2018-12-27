package day1204;

/**
 * 
 * @author owner
 */
public class Outer {
	int i;
	
	public Outer() {
		System.out.println("바깥 클래스의 생성자");
	}//Outer
	
	public void outMethod() {
		System.out.println("바깥 클래스의 method i="+i);
//		System.out.println("안쪽 클래스의 변수 j="+j);//Error
		//안쪽 클래스를 객체화
		Outer.Inner in = this.new Inner();//this: 인스턴스 주소로 대치가능.
		//this : 자기자신의 내부에서 나를 참조할때, 나를 호출할때.
		in.j=100;
		in.inMethod();
		
	}//outMethod
	
	/*--------------안쪽 클래스 시작------------------------*/
	public class Inner{
		int j;
		
		public Inner() {
			System.out.println("안쪽 클래스의 생성자");
		}//Inner
		public void inMethod() {
			System.out.println("안쪽 클래스의 method의 j="+j+
								", 바깥 클래스의 변수 i="+i);
//			outMethod();//바깥클래스의 method도 사용가능~//재귀호출되어 막음..
		}//inMethod
		//<특징 : 바깥클래스의 자원을 마음대로 사용가능, 반대는 마음대로는 아님.
		
	}//class
	/*--------------안쪽 클래스 끝-------------------------*/
	public static void main(String[] args) {
		//1.바깥 클래스의 객체화
		Outer out = new Outer();
		//<지금의 상태 : "바깥 클래스의 생성자" 뿐
		out.i=10;
		out.outMethod();
//		out.j=100;//Error=>안쪽 클래스의 자원을 직접접근하여 사용할 수 없다.
//		out.inMethod();//Error=>안쪽 클래스의 자원을 직접접근하여 사용할 수 없다.
		
		//2.안쪽 클래스의 객체화 : 
		//<main도 바깥 클래스니까, 안쪽 자원을 사용하려면 객체화를 해야한다~!~!
		//--바깥 클래스에서 안쪽 클래스의 자원을 사용할수 있다.<<<<<<객체화를 한 후에~~
		//바깥클래스명.안쪽클래스명 객체명 = 바깥클래스의객체명.new 안쪽생성자();
//		Outer.Inner in = new Inner();//e.g. x.new A(); where x is an instance of Outer
/*		바깥클래스에서 객체화 한걸 보기 위해 여러단락 주석걸음.
		Outer.Inner in = out.new Inner();
//		Inner in = out.new Inner();//바깥 클래스명은 생략할 수 있다.
		
		in.j=12;
		in.inMethod();
*/		
		
	}//main
}//class
