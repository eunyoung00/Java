package day1203;

public class TestSub2 extends TestSuper {
	int i;
	public TestSub2() {
//		super();//���� �Ⱥ������� ����.this(); �� ��밡��.
		System.out.println("�ڽ��� ������2222");
	}//TestSub
	
	public void subMethod() {
		System.out.println("�ڽ��� subMethod2222");
	}//subMethod
	
	@Override
	public void printI() {
		System.out.println("�ڽ�2222�� Override�� method "+i/*=this.i*/
				 			+",�θ��� i ="+super.i+" 2222");
	}//printI
	
	

}//class
