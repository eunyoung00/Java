package day1122;

/**
 * Ư������ : ���ڿ� �� \(��������)�� �����ϴ� ����� ���� ����.
 * @author owner
 */
public class UseEscapeCaracter {

	public static void main(String[] args) {
		System.out.println("��\t ����");//\t : tab
		System.out.println("��\t\t ����");
		System.out.println("��\n �ü�");//\n : new line
		System.out.println("��\r �ü�");//\r : return(Ŀ���� ���������� �����쿡�� ���� �ٲ�)
		System.out.println("������ \"�޿���\" �Դϴ�.");//\" : "�� �浹�� ���� "�� �ν��ϰ� ����
		System.out.println("������ '''''�޿���' �Դϴ�.");//\' : '�� �浹�� �Ͼ�� �ʾ� ����..
		//\'�� �ڹٽ�ũ��Ʈ���� �߿� 
//		System.out.println("c:\dev\workspace\javase_prj\src\day1122\Test.java");//\���ĺ��� ���� Error �������� �������
		System.out.println("c:\\dev\\workspace\\javase_prj\\src\\day1122\\Test.java");//\\ : �������� ������ �ΰ�~! 
		//������� \,/ ��� ǥ������ �Ѵ� ����.
		System.out.println("������\b");//\b : ���������� �ʴ´�.Ư�����ڰ� ���û�
		System.out.println("������\f");//\f : �ٺ������ �ʴ´� printf�� �ƴ϶� Ư������.
		
	}//main
}//class
