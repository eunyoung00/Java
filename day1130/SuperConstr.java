package day1130;

public class SuperConstr {
	int i;
	
	public SuperConstr() {
//		super();
		this(100);//2��
		System.out.println("�θ��� �⺻ ������");
	}//�⺻�����ڰ� ������ �ڽĻ����ڿ��� Error ���ڸ� ������..?
	//������ �����ε�
	public SuperConstr(int i) {
//		this();//1��
		this.i=i;
		System.out.println("�θ��� ���� ������"+i);
	}
}
