package day0423;

public class TestService {
	private TestDao td;//������ ���Թ��� ��ü�� ����� �� �ֵ��� Instance ������ �������ְ� �ȴ�.
	
	public TestService(TestDao td) { //interface(�θ�)�� ������ ���� ������ ������� �ȴ�. 
		//������ ������ �θ�(�������̽�)�� ������ ������̵ȴ�.
		//������ ������ ������ ��κ� ���� �÷��ش�.
		//new �� �̾ȿ��� ���� �ʴ´�.
		this.td=td;
		System.out.println("������ ������ ����");
	}//TestService
	
	
	public TestService() {
		System.out.println("�⺻ �����ڸ� ����Ͽ� ��ü ����");
	}
	
	//method ������ ���� : �ݵ�� �⺻ �����ڰ� �����ؾ��Ѵ�.
	public void setTd(TestDao td) {
		this.td=td;
	}//setTd
	
	public TestDao getTd() {
		return td; //������ ���Թ��� ���� td�� null (��ü�� �������� ����) 
	}//getTd
}
