package day1122;

/**
 * Method�� 4���� ����<br>
 * @author owner
 */
public class MethodType {
	
	/**
	 * ��ȯ�� ���� �Ű����� ���� ��=&gt;���� ���� ����=&gt;���� ��<br>
	 * �޾Ƶ��̴°͵� �������°͵� ����.
	 */
	public void typeA() {
		System.out.println("�ȳ��ϼ���?");
	}//typeA
	
	/**
	 * ��ȯ�� ���� �Ű����� �ִ� ��=&gt;�ԷµǴ� �������� �ٸ���=&gt;������<br>
	 * @param i ����ϰ� ���� ��
	 */
	public void typeB(int i) {
		System.out.println(i+"�� �ȳ�");
	}//typtB

	/**
	 * ��ȯ�� �ְ�, �Ű����� ������=&gt;���� ��<br>
	 * ���� �޾� ����ϴ� �ڵ尡 �ʿ�.<br>
	 * @return ��.���� �Ǽ������� ��ȯ
	 */
	public double typeC() {	//Ÿ���� �� �־� �� ������ ���� �Ѵٰ� ���.
//		int i=11;
//		return i;
//		return 2018.11f;
//		return (float)2018.11;//double�� ĳ������ �ʿ������ double�������
		return 2018.11;//�Ǽ��� ������ Ÿ������ ����.
//		return "������"//���̴޶� ���������� Error
//		System.out.println("111");//return���� �Ʒ��� �ڵ尡 ���ǵɼ� ����.
	}//typeC
	
	/**
	 * ��ȯ�� �ְ�, �Ű����� �ִ� ��=&gt;���� ��<br>
	 * @param d  ������ ����� ���� �Ǽ� ��
	 * @return   ������ ��ȯ�� ��
	 */
	public int typeD(double d) {  //Ÿ���� �� ���� ����
		
		int i = (int)d;//���սǹ߻�
		return i;
	}//typeD
	
/*	public int typeD(double d) {  //����� ������ ���� ���� �ٸ����� �ȵ�
									//�����̸��� �޼ҵ�� ����� ����.
		return 33333;
	}//typeD
*/	
	public static void main(String[] args) {//������
		MethodType mt = new MethodType();
		//1.������ �ϴ� method ȣ��
		mt.typeA();
		mt.typeA();//������ص� �׻� ������
		mt.typeA();
		//2.������ method ȣ��
		mt.typeB(22);
		mt.typeB(21);//�ԷµǴ� �������� �ٸ���
		mt.typeB(202);
		//3.������ method ȣ�� - ��ȯ���� ��ġ�ϴ� ������ ���� �� ����
//		mt.typeC();//1���� ���ƺ��̳�..��ȯ���� �������� ���ѻ���
//		int i =mt.typeC();//���� �ٸ���
//		double i=mt.typeC();  //������µ�
		double i=mt.typeC()+1;// typeC=�� �� �̶� ����ٷ� ��������..����
								//�׷��� �ٷ���µ� �����Ҵ絵 �Ǵ°� 
//		int j = mt.typeA();//typeA�� ���� �ƴ϶� �ٷ� ������ �Ҵ���� �ʴ´�.
		System.out.println("������ "+i);//�ѹ��θ��� �������θ��� ������
		//4.������ method ȣ�� - ��ȯ���� ��ġ�ϴ� ������ ���� �� ����
		int j = mt.typeD(300.003);
		System.out.println("������ "+j);

	}//main
}//class
