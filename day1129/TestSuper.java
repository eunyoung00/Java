package day1129;

/**
 * ��� ������ �θ�Ŭ���� : ��� �ڽ��� ������ �� ���� Ư¡ ����
 * �θ𿡰� ���ǵ� �ڵ�� �ڽĿ��Լ� ����� �� �ִ�.
 * @author owner
 */
public class TestSuper {

	public int pub_i;//��� �ִ� �ڽ��̵� �ڽĿ��� ��밡��
	protected int pro_i;//���� ��Ű���� �ڽ�, �ٸ� ��Ű���� �ڽĿ��� ��� ����
	@SuppressWarnings("unused")
	private int pri_i;//��� �ֵ簣�� �θ�Ŭ���� �ȿ����� ��밡��
	int def_i;//���� ��Ű���� �ڽĿ��� ��밡�������� ��Ű���� �ٸ��� ���Ұ�.
	
	public TestSuper() {
		System.out.println("�θ�Ŭ������ �⺻������");
	}//TestSuper
	
	public void superMethod() {
		System.out.println("�θ�Ŭ������ method");
	
	}
	
}//class
