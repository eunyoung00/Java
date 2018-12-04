package day1130;

/**
 * 부모클래스 : 자식이 사용할 공통코드를 정의.
 * @author owner
 */
public class TestSuper {
	int p_i;
	int p_j;
	
	public TestSuper() {
		System.out.println("부모의 기본 생성자");
	}//TestSuper
	
	public void method() {
		System.out.println("부모의 method p_i : "+p_i+", p_j : "+p_j);
		//생성자는 상속되지 않는다.
		
	}//method
}//class
