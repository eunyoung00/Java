package day1203;

/**
 * ����� �������� ����� �θ� Ŭ����.<br>
 * ��üȭ�� ���� �ʴ´�.<br>
 * �ڽ�Ŭ������ �ݵ�� �����ؾ��� abstract method�� ������ Ŭ����.<br>
 * =))������ ������.<br>
 * @author owner
 */
public abstract class AbstractSuper {

	int i;
	
	public AbstractSuper() {
		//�ڽ�Ŭ������ ���� �ɶ��� ȣ��ȴ�.
		System.out.println("AbstractSuper �θ������");
	}//AbstractSuper
	
//	public void method() ;//method�� �ݵ�� body�ʿ�.
	public void method() {
		System.out.println("�θ� ���� �ϴ� �Ϲ� method");
	}//method
	
	//abstract method�� �ڽ��� �ݵ�� �����ؾ��� ���� �������
//	public abstract void absMethod() {};//�߻�method������ body�� ������ ����.
	public abstract void absMethod();//�߻�method
	public abstract String absMethod1(int i);//����.
	//<�ݵ�� �ڽĿ��� Override�ϰ� ��.(���������ڴ� �ٲ�� �ִ�.)
	
	public static void main(String[] args) {
//		new AbstractSuper();//<Ŭ������ abstract���̴� ���� ��üȭ�� �� ����.
		//��üȭ �� �� ����.
		
	}//main
}//class
