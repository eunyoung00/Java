package day1126;

/**
 * this�� ����� ������ ȣ��<br>
 * @author owner
 */
public class ThisConstructor {
	
	public ThisConstructor() {
//		this();//<���� �ٽ� �θ��ڽ��ϴ�. �ؼ� ���ȣ��ǹ���=>Error
//		this(26);//<��Ʈ�� �������� �Ʒ��� �����ִ� �����ڷ� ��
		System.out.println("�⺻ ������");
	}//ThisConstructor

	public ThisConstructor(int i) {
//		this();//<��Ʈ�� �������� �⺻ �����ڷ� ��
		System.out.println("�����ִ� ������");
//		this();//this�� �������� ù�ٿ��� �� ��밡��.
	}//ThisConstructor
	
	public static void main(String[] args) {
//		new ThisConstructor();//this(26); �϶� 
		//<�տ����� ��ü�� ������ �ߴµ�, �ְ��� ��� �޼ҵ嵵 ������ ���� ������ �ϸ� ������ ������ 
		//<��ü�� �����ؼ� ����� ���� ������ �̷� �ν��Ͻ� ȭ �ϰ� �ȴ�.
		//<�����ִ� �� ���������� �⺻�� ���߿� �����°� ���� �ִ�.

		new ThisConstructor(22);//this(); Ȱ��ȭ �Ǿ�������
		//<�⺻-���� ��
		
		//<this�� ���ʿ��� �� ������� �ǵ��� ���� �ְ� ������ �Ѵ�. ���ȣ��Error
		
		//this�� ������� �ڵ带 �� ���ϼ� �ִ�.
		
	}//main
}//class
