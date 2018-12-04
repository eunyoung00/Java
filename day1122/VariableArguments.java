package day1122;

/**
 * Variable Arguments : 
 * �Ű������� �ϳ��ε� �μ��� ������ ���� �� �ִ� ���.<br>
 *  method�������� �迭�� ó���ȴ�.<br>
 * ����) "�������� ... �Ķ���͸�" �� �������� ���� 
 * @author owner
 */
public class VariableArguments {

	/**
	 * ���� ������������ �� �μ����� ������ ����� ��.
	 * @param param ���� �μ���
	 */
	public void test(int ... param) {	//�����Ϸ���1.4��  �����ϸ� Error���°� �����ִ�.
		for(int val : param) {
			System.out.println(val);
		}//end for
		System.out.println("test method called!!!");
	}//test
	
	/**
	 * �����μ��� �ޱ� ���� �Ű������� ���� ���������� ����Ҽ� �ִ�.(������ �� �ִ�.)
	 * @param i ó��
	 * @param d �ι�°
	 * @param j ����°
	 */
	public void test1(int i, double d, int ... j) {
		System.out.println("ó�� �Ű����� : "+i);
		System.out.println("�ι�° �Ű����� : "+d);
		System.out.println("����° �Ű����� : "+j); //j�� �迭ó�� �� �������̶� �ּҰ� ���´�.
		for(int idx=0; idx<j.length; idx++) {
			System.out.println(j[idx]);
		}//end for
	}//test
	
	//���ڿ��� �Է¹����� �ִ� �Ű������� ������ ��� 
	public void printName(String name) {
		System.out.println(name+"�� �ȳ��ϼ���?");
	}//printName
	
	public static void main(String[] args) {
		VariableArguments va = new VariableArguments();
//		va.test();
//		va.test(1,2,3,4,5);//������ �°� ȣ�� �� ��
//		va.test(1,5,88,6665,594223);//��� ������ �߸𸦶� ���Եȴ�.
		va.test();//�̰� ���ʰ�
//		va.test1();//�¿���
		va.test1(1,1.1);//���� �������� �迭�� �������̵Ǿ� �ּҰ� ���̳��´�?
		va.test1(1, 3.14, 10,20,30,40,50);
		
		String name = "������";//���ڿ��� ������ �����ϰ� �޼ҵ�� �Ѱ� ����Ҽ� �ִ�.
		va.printName(name);
//		System.out.println(name);
		
		String path="c:\temp\new_file.txt";
//		String path="c:\temp\kkk_file.txt";//\k�� �������� �ʾ� Error		
		System.out.println(path);
		
//		String test = "�ȳ��ϼ���";
		System.out.println("�ȳ��ϼ���");
		System.out.println("'�ȳ��ϼ���'");
		System.out.println("\"�ȳ��ϼ���\"");
		//���ڿ��� " "�̾ȿ� ���� ���� ���ڿ��� ���� �Ǵµ� Ȧ����ǥ�� �򰥸����ʾƼ�(������)��µ�����
		//"�� ""�� �ϳ��� ���ڿ��� �Ǿ� �����޾� Error����.
		//�ȳ��ϼ��� ��� �������̰�+������ �� �����ȳ�
		//�������� �ʱ� ���� Ư������ �̿�
		
		System.out.println("\t\t\t������ ");
		System.out.println("\t\t\u0000\0������ ");
		
		//�����ϳ� �Ǽ��ϳ��� �� ���� �׵ڷδ� ��� ���� �������.
	}//main
}//class
