package day0423;

public class TestService2 {
	//������ ���Թ��� ��ü�� ����� �� �ֵ��� Instance ������ �������ְ� �ȴ�.
	private TestDao td;
	private TestDao2 td2;
	
	public TestService2(TestDao td, TestDao2 td2) { //interface(�θ�)�� ������ ���� ������ ������� �ȴ�. 
		//������ ������ �θ�(�������̽�)�� ������ ������̵ȴ�.
		//������ ������ ������ ��κ� ���� �÷��ش�.
		//new �� �̾ȿ��� ���� �ʴ´�.
		this.td=td;
		this.td2=td2;
		System.out.println("�Ű������� �������� �������� ������ ����");
	}//TestService
	
	//method injectoin�� �ƴϴϱ� �Ʒ��� �����ش�
	
}//class
