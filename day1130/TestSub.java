package day1130;

/**
 * TestSuper�� �ڽ�Ŭ���� 
 * @author owner
 */
public class TestSub extends TestSuper{
	
	int p_j;
	
	@Override
	public void method() {
		p_i=400;//��� ->�ڵ��� ���뼺
		super.p_j=500;// �ڽ��� ��. ���� �̸��� ������ �����ϸ� �ڽ��� ���� ���.
		System.out.println("�ڽ��� method "+/* p_i +*/this.p_i+"/"+
						this.p_j);//p_i�� �θ��� ����
//		method();//�����ΰ���.=>Error
		super.method();
		
		System.out.println(this);
//		System.out.println(super);//Error super�� �ּҴ� ����� �� ����.
		//����Ű�� �ּҰ��ٸ�...(�������� �ٸ���)/��������̶� �˷������ʴ´�.
		System.out.println(super.toString());//this�� ���� ���´�.
		
	}//method

	public static void main(String[] args) {
		TestSub ts = new TestSub();
		//�θ��� �⺻������
		//�θ� ���� ���������.
		ts.method();//���� ����
		//�θ��� �⺻ ������
		//�ڽ��� method
	}//main
}//class
