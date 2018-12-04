package day1203;

/**
 * 상속을 목적으로 만드는 부모 클래스.<br>
 * 객체화가 되지 않는다.<br>
 * 자식클래스가 반드시 구현해야할 abstract method를 가지는 클래스.<br>
 * =))구현의 강제성.<br>
 * @author owner
 */
public abstract class AbstractSuper {

	int i;
	
	public AbstractSuper() {
		//자식클래스가 생성 될때만 호출된다.
		System.out.println("AbstractSuper 부모생성자");
	}//AbstractSuper
	
//	public void method() ;//method는 반드시 body필요.
	public void method() {
		System.out.println("부모 일을 하는 일반 method");
	}//method
	
	//abstract method는 자식이 반드시 구현해야할 일의 목록정의
//	public abstract void absMethod() {};//추상method종류는 body를 가질수 없다.
	public abstract void absMethod();//추상method
	public abstract String absMethod1(int i);//가능.
	//<반드시 자식에서 Override하게 됨.(접근지정자는 바뀔수 있다.)
	
	public static void main(String[] args) {
//		new AbstractSuper();//<클래스에 abstract붙이는 순간 객체화될 수 없다.
		//객체화 될 수 없다.
		
	}//main
}//class
