package day1126;

/**
 * ���ڿ��� ���� ��
 * @author owner
 */
public class TestString {

	public static void main(String[] args) {
		String str="ABC";//�⺻�� ������ ���
		
		//�⺻�� �������� ������ ���ڿ��� ���ڿ� ������� �ּҸ� �����ϱ� ������
		//==�񱳷� �������� ���� �񱳸� ������ �� �ִ�.
		if(str=="ABC") {
			System.out.println("�⺻�� == ����");
		}else {
		System.out.println("�⺻��  == �ٸ�");
		}//end else
		
		String str1=new String("ABC");//������ ������ ���
		
		//������ �������� ����ϸ� ������ heap�� �ּҸ� �����ϰ�
		//heap�� ������� ��ü�� ���ڿ� ������� �ּҸ� �����Ѵ�.

		if(str1=="ABC") {
			System.out.println("������  == ����");
		}else {
			System.out.println("������  == �ٸ�");
		}//end else
		
		System.out.println("-----------------------------------------------");
		
		//��� ����� �񱳸� �ϰ�ʹٸ� equals
		if(str.equals("ABC")) {
			System.out.println("�⺻�� equals �� ����");
		}else {
		System.out.println("�⺻�� equals �� �ٸ�");
		}//end else
		
		if(str1.equals("ABC")) {
			System.out.println("������ equals �� ����");
		}else {
			System.out.println("������ equals �� �ٸ�");
		}//end else
		//�������� ���ٰ� �� ���´�.
		//��� ����������� Ȯ���� �ȵȴٸ� equals�� ���°� ��Ȯ�ϰ� �ȴ�.
		
		
	}//main
}//class
