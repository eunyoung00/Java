package day1119; //��Ű���� ���� �ۺ��� Ŭ������ �پ���.�ڹٴ� ���鶧 �ۺ� �Ⱥ����� �ȳ��´�.

//<br> ���ּ����� �־�� �Ѵ�. �ٹٲ�
/**
 * ���ǹ��� ���<br>
 * ���� if�� : ���ǿ� �´� ��쿡�� �ڵ鸦 �����ؾ��Ҷ�.<br>
 * ����) if (���ǽ�) {<br>
 * 			���ǿ� ������ ���� �����...;<br>
 *	   }<br>
 * �ڹٴ�= ���ּ�(alt shift j)<br>
 * �̰ɷ� ���߿� ���� ����� �ȴ�?doc?<br>
 * 
 * @author owner
 */
public class TestIf {
	
	//Constant : ������ ���ó�� ����Ҷ�.(���� �������� ���ϴ� ����) �ٲ��� �ʾƾ� �ϴ°���
	public static final int FLAG_VALUE = 1250;
	public static final int FLAG_CNT = 20;
	//constant���� �빮��!!����� ctrl shift x �빮��~!
	//ctrl shift y �ҹ���

	public static void main(String[] args) {
/*
		int i = 10;

		if (i < 0) {//���� if ex
			i = -i;
		} // end if

		System.out.println("i= " + i);
*/
		//�̸��� �Է¹޾� �̸��� �������̸� �̸��� ����ϱ����� ������ ����ϰ� �׷��� �ʴٸ� �̸��� ��� 
		//�Է¹޴°��̱� ������ Run�� ȭ��ǥ configuration ������ Argument�� �Է�
		if (args[0].equals("������")) {
			System.out.print("���� ");			
		}//end if
		System.out.println(args[0]);
		
		//���������� ���ڿ��� ������ ��ȯ�ϰ� ������ Parse double���ְ� long���ְ� �����żҵ� ����
		int i = Integer.parseInt(args[1]);
		int j = Integer.parseInt(args[2]);
		
		System.out.println(i+" + "+j +" = "+(i+j));
		
		//args[3]�� �Է¹޾� �׼��� 20�̳���� 1250�� �Է¼��� ���Ͽ� ����ϰ�
		//�׷��� ������ 20���� ũ�ٸ� 1250�� 10%�� ���� ���� �Է¼��� ���Ͽ� ���.
//		int ii = Integer.parseInt(args[3]);
//		if (ii<=20) {
//			System.out.println("args[3]�� 20�̳� " + ii*1250);
//		}
//		if (ii>20) {
//			System.out.println("args[3]�� 20�� " + (1250+(1250*0.1))*ii);
//		}
//		//������ �����϶� ĳ����~!
//		//�ڹٴ� �������ؼ� ����Ŭ���� ����
		
		//��)
		//<���ذ��� constant => ��� => �ʵ忡 ����
		//java day1119.TestIf ���ڿ� ���� ���� ����  <Ÿ������� args�� ���ڿ��̶� �񱳰� ���� �ʴ´�.
		//                     0   1  1  3
		int input_value = Integer.parseInt(args[3]);
		int sum = TestIf.FLAG_VALUE;
		
		if(input_value>TestIf.FLAG_CNT) {
			sum = (int)(TestIf.FLAG_VALUE + TestIf.FLAG_VALUE* 0.1);
			//0.1�� 8byte�� �ڸ��� �ٸ� ���鸶����  8byte�� double�� �ٹٲ�� ������ �Ǿ� casting����
		}//end if
		System.out.println(sum*input_value);
		
	}// main

}// class
