package day1130;

public class SubConstr extends SuperConstr {
	int i;
	public SubConstr() {
//		super(300);
//		this(200);//1��
		System.out.println("�ڽ��� �⺻������");
	}//SubConstr
	
	public SubConstr(int i) {
//		super(300);//1��
		this();//2��
		System.out.println("�ڽ��� ���ڻ�����"+i);
	}//SubConstr
}
