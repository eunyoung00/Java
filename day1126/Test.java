package day1126;

public class Test {
	int i ;
	public void temp(int i) {
		System.out.println(i);
//		i=i;
		
	}
	public void temp(int i,Test t){
		//�Ű����� parameter ����, �ּ� //���������� ����
	    System.out.println(i);//1000
//	    i=i//��������=��������
	    t.i=i;//���������� ����Ʈ�Ͻ� �����̸��� ���� �������� �� ��������.
	    //10������ ���� �״�� ������ �ּҸ�
	    
	}

	public static void main(String[] args) {
		Test t = new Test();
//	    t.temp=1000;
		t.temp(1000, t);
	    System.out.println(t.i);//0->1000
	}
//�Ű������� �ν��Ͻ� ������ �̸��� ������ heap�� stack�� �������� ��Ȯ�� ���־���ϴµ�,
//heap���� �׻� �ּҸ� �ٿ�����ϰ� �ȴ�.
//
}
