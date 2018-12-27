package day1203;

/**
 * 구현 클래스(자식클래스)에서 반드시 구현해야하는 일의 목록만 정의하는 interface의 사용법.
 * (구현의 강제성)
 * @author owner
 */
//interface는 부모를 여러개 가질 수 있다.
public interface SuperInterface extends InterA,InterB{
	//상수 Constant : 변수를 상수처럼 사용.
//	int i;//변수는 작성할 수 없다.Error =>상수는 에러가 나지 않는다.
	public static final int FLAG_VALUE=12;
	
	//추상 method 구성
	//일반 method는 가질 수 없다. Error
//<	public void test() {} <"{}"이부분 body를 가질수 없다.

//	인터페이스간 상속에는 추상 method를 Override하지 않는다.
//	//일을할수 있으면 몰라도 body가없어서 똑같은 method를 또한번 만드는것에 그친다.
//	@Override
//	public String msg();//하지않는다.해봐야 손만 아픔--
	
	//abstract을 사용하지 않아도 된다.
	public void mehtodA();
	//abstract을 사용해도 된다.
	public abstract void methodB(int i);
	
	

}//interface
