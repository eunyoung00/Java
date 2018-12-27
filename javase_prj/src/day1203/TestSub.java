package day1203;

public class TestSub extends TestSuper {
	int i;
	public TestSub() {
//		super();//눈에 안보이지만 존재.this(); 도 사용가능.
		System.out.println("자식의 생성자");
	}//TestSub
	
	public void subMethod() {
		System.out.println("자식의 subMethod");
	}//subMethod
	
	@Override
	public void printI() {
		System.out.println("자식이 Override한 method "+i/*=this.i*/
				 			+",부모의 i ="+super.i);
	}//printI
	

}//class
