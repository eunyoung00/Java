package day1129;

/**
 * TestSuper�� �ڽ�Ŭ����.
 * @author owner
 */
public class TestSub extends TestSuper {
	int i;
	
	public TestSub() {
		System.out.println("�ڽ��� ������");
	}
	
	public void subMethod() {
		System.out.println("�ڽ� method");
	}

	public static void main(String[] args) {
		//�ν��Ͻ�ȭ(��üȭ)�� �ڽ�Ŭ������ ����Ѵ�.
		TestSub ts = new TestSub();
		//�ڽİ� �θ� ���� ��Ű�� �����ϸ� �θ� ���� ������ method�� ���������ڰ� public,
		//protected, default�� �ڿ��� ����� �� �ִ�.
		ts.pub_i=10;//public
		ts.pro_i=20;//protected
		ts.def_i=30;//default
//		ts.pri_i//ã���� ����.
		ts.i=100;
		
		
		System.out.println("�θ��� �ڿ� "+ts.pub_i+" / "+ts.pro_i+" / "+ts.def_i);
		//�θ��� �ڿ��� ���� ������ó�� ���� �ִ�.=>�ڵ��� ���뼺
		ts.superMethod();
		System.out.println("�ڽ��� �ڿ� "+ts.i);
		
		
		
		
		
	}//main
}//class