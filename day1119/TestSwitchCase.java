package day1119;

/**
 * switch~case : ������ ���� ��.(JDK1.7�������ʹ� ���ڿ��� �񱳰���)<br>
 * ����) switch(������ {<br>
 *         case ��� : ���๮��;<br>
 *         case ��� : ���๮��;<br>
 *                 .<br>
 *                 .<br>
 *         default : ��ġ�ϴ� ����� ���� �� ���๮��;<br>
 *      }<br>
 * @author owner
 */
public class TestSwitchCase {

	public static void main(String[] args) {
		//String i = "1";	//JDK1.7�������� ��밡��
		//long�� ������ ����.int�� ��ȯ�Ǵ� ���� ����
		//char '1'�� �����ڵ� 45�� ���� default�� ����.
		//String �϶��� case ������� �� �ֵ���ǥ!
		//�����Ϸ��� ������ �ٲܼ��ִ� ���������� ������
		int i = 0;
		
		//switch�� �ԷµǴ� ������ ���������� byte, short, int, char, String
		switch(i) {	
		//case�� �ԷµǴ� ������ ���� �ٸ� ������ ������.
		//signed value �ΰ�...
		case 0:System.out.println("����");	//0�ΰ�� �����
		case 1:System.out.println("��ħ");	//1�ΰ�� �����������
		case 32767:System.out.println("����");	//2�ΰ�� ���� ����
		default : System.out.println("����");		//3~�̻��� �� ����
		}//end switch
	}//main
}//class
