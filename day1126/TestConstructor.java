package day1126;


/**
 * Ŭ������ ��ü�� ������ �� �⺻������ ������ �־���� �⺻���� �����ϰų�, 
 * �⺻������ ����� �ڵ带 �����ϴ� method�� ����.(��ü�ʱ�ȭ������ �����ϸ� �ȴ�.)<br>
 * @author owner
 */
public class TestConstructor {
	
	/**
	 * �⺻������ : Ŭ������ �ۼ��Ҷ� �����ڸ� �ϳ��� �������� ������
	 * �����Ϸ��� �Ű����� ���� Default Constructor�� �����Ѵ�.((�ϳ��� ���ǵǸ� ��������� �ʴ´�.
	 */
	public TestConstructor() {
		System.out.println("�⺻������");
//		TestConstructor(300);//�����ڴ� method ȣ���ϵ� ȣ���Ҽ� ����. 
		//<�����ڴ� ��üȭ�� ���ؼ��� �θ��� �ִ�.!!~!~
	}//TestConstructor

	/**
	 * �ܺ��� �Է°��� ������ �����ϴ� �����ִ� ������ :�������� Overload
	 * @param i ������ ��.
	 */
	public TestConstructor(int i) {//<�������� �����ε� �Ϲ� �����ε��� ����.
		System.out.println("�����ִ� ������ : "+i);
	}//TestConstructor
	
	public void test() {//<�ν��Ͻ� �޼ҵ� =>��������
		System.out.println("test method!!!");
		temp();//method�� �׳ɺθ���ȴ�. method ȣ��<  =>�����ڴ� �̷��� �Ҹ��� �ʴ´�.
	}//test
	
	public void temp() {
		System.out.println("-------------------temp method!!!");
	}//temp
	
	
	public static void main(String[] args) {
//		new testConstructor();//<��Ʈ�Ѵ����� �� Ŭ������ �ö󰣴�.
//		new TestConstructor();//<��Ʈ�Ѵ����� ������ ���ǵ� �����ڷ�
		TestConstructor tc  = new TestConstructor(); //�⺻������
		TestConstructor tc1  = new TestConstructor(26); //�����ִ� ������.
		
		System.out.println(tc);//<heap�� ������ �ּҰ� ���´�.
		System.out.println(tc1);//<heap�� ������ �ּҰ� ���´�.
		//Overloading �� �����ڸ� ����Ͽ� ��üȭ�� �پ��ϰ� �� �� ����.
		
		tc.test();//<temp�޼ҵ� ȣ���� �������� ȣ��
		
		
	}//main
}//class
