package day1203;

public class TestSub extends TestSuper {
	int i;
	public TestSub() {
//		super();//���� �Ⱥ������� ����.this(); �� ��밡��.
		System.out.println("�ڽ��� ������");
	}//TestSub
	
	public void subMethod() {
		System.out.println("�ڽ��� subMethod");
	}//subMethod
	
	@Override
	public void printI() {
		System.out.println("�ڽ��� Override�� method "+i/*=this.i*/
				 			+",�θ��� i ="+super.i);
	}//printI
	

}//class
