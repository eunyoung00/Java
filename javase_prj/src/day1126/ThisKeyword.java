package day1126;

/**
 * method�� ȣ���ϴ� ��ü�� �ּҷ� ����Ǿ� ���Ǵ� this.<br>
 * 
 * @author owner
 */
public class ThisKeyword {

	int i;//<�ν��Ͻ����� �Ķ���
	/**
	 * parameter�� �̸��� instance������ �̸��� ������,
	 * this�� ������� �ʰ� parameter�ǰ��� instance������ ������ ��.  ((���ŷο�
	 */
//	public void useInstance(int i) {
	public void useInstance(int i, ThisKeyword t) {
//		i=100;//<���⼭�� �ڱⲨ������ ���� �ѿ��� ���� ����.
		t.i=i;//<The assignment to variable i has no effect
		//�Ķ���� ������ ��(stack�� ��)�� �ν��Ͻ�����(heap)�� �Ҵ� �ϰڴ�.(�ø��ڴ�)
		System.out.println("���� ���� ��ü "+t);
		
	}//useInstance
	
	/**
	 * �Ķ������ �̸��� �ν��Ͻ� ������ �̸��� ���� ������ ��ü�� �ѱ�� �޾Ƽ� ����Ϸ��� <br>
	 * (�ڵ��� ���� �ѹ��� ������ �־�� �Ѵ�)�ڵ��� �������� ����´�. 
	 * �����ϱ� ���� this ����.<br>
	 * @param i
	 */
	public void useThis(int i) {
//		i=100;//<�ν��Ͻ� ������ �ν�
		//this�� �żҵ带 ȣ���ϴ� ��ü�� �ּҷ� ��!��! ��ȯ�Ǵ� Ű����
		//�Ű������� ��ü�� ���� �ʿ䰡 ����.
		this.i=i;//tk�� ��..
		System.out.println("method�� ȣ���� ��ü�� �ּ� : "+this);
	}//useThis
	
	public static void test() {//����!~!~!static method Ŭ������.�޼ҵ�
//		this.i=10;//tk�� �Ἥ �θ��� �ƴ϶� ��ü�ɰ� ���� Error
		//static method�ȿ����� this keyword����� �� ����.
		System.out.println("static method");
	}
	
	public static void main(String[] args) {
		ThisKeyword tk = new ThisKeyword();
		System.out.println("������ ��ü "+tk);
		tk.useInstance(300, tk);
		//<������ ��ü day1126.ThisKeyword@1db9742
		//<���� ���� ��ü day1126.ThisKeyword@1db9742
		//<���� ����� ���´�.
		
		//�̸��� ���ٰ� �Ҷ����� �̷��� ���־�� �ϸ� ����..���� �׷��� ���°� this��.
		System.out.println("������ ��ü�� �ν��Ͻ� ������ �� "+tk.i);
		System.out.println("-----------------------------------");
		tk.useThis(900);
		System.out.println("this�� ����Ͽ� ������ �ν��Ͻ� ������ �� :"+tk.i);
		
		ThisKeyword.test();//static �� ��𿡵� ������¡����
		
	}//main
}//class
