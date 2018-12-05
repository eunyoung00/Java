package day1205;

import java.util.StringTokenizer;

/**
 * StringTokenizer : 
 * ���ڿ��� ª�� ����� �����ϴ� StringTokenizer�� ���.
 * @author owner
 */
public class UseStirngTokenizer {
	
	public UseStirngTokenizer() {
		String msg="������ ������ �Դϴ�. ������ -5�Դϴ�.";
		//�������� �����ϰ� ������ : �Ű����� �ϳ��� ������ ���.
		StringTokenizer stk = new StringTokenizer(msg);
		
		System.out.println(stk.countTokens()+"��");
		System.out.println(stk.nextToken());//������
		//�ϳ� ���ܵ� �����͸� �̹̳Ѱܼ� �ٸ��� ���� ���
//		System.out.println(stk.nextToken());//������
//		System.out.println(stk.nextToken());//�Դϴ�.
//		System.out.println(stk.nextToken());
//		System.out.println(stk.nextToken());
		//����� �׶��׶� �� �˼� ���µ�,�Ѿ�� Error���� ������ �̷��Դ� ����
		//�׷��� ���°� while
		
		while(stk.hasMoreTokens()) {//��ū�� �����ϴ���?
			//��ū�� ��� �����͸� �������� �̵�
			System.out.println(stk.nextToken());
		}//end while
		
		String names="������,������~���ü�,����ö.������~������,������";
		//Ư�����ڷ� ��ū ����  : �Ű����� �ΰ��� ������.
		StringTokenizer stk1 = new StringTokenizer(names, ",");
		System.out.println("--------------------------------");
		System.out.println("��ū�� �� : "+stk1.countTokens());
		while(stk1.hasMoreTokens()) {
			System.out.println(stk1.nextToken());
		}
		//or������־� �ΰ��� �־~3���� �־ �� �߸���.split���� ����~!
		//���鸶���� �ڸ��� �ִ�. �ξ��� ����� ����.
		System.out.println("--------------------------------");
//		StringTokenizer stk2 = new StringTokenizer(names, ",~ .");
		StringTokenizer stk2 = new StringTokenizer(names, "��");
		
		System.out.println("��ū�� �� : "+stk2.countTokens());
		while(stk2.hasMoreTokens()) {
			System.out.println(stk2.nextToken());
		}
		//Ư�����ڷ� ��ū ����, ���е� ���ڿ��� ��ū���� ó��: �Ű����� 3���� ������
		//true �� ��ū���� ����ϰ�, flase�� ��������.
		StringTokenizer stk3 = new StringTokenizer(names, ",.~",false);
		while(stk3.hasMoreTokens()) {
			System.out.println(stk3.nextToken());
//			System.out.println(stk3.nextToken());
			//�ΰ��� ������ �ΰ��� �Ѿ���� �ִµ� ������ �����ʾ� Error�߻� ���ɼ��� ���� �߾��� �ʴ´�.
		}
		
		
		
	}//UseStirngTokenizer

	public static void main(String[] args) {
		new UseStirngTokenizer();
		
		
		
		
	}//main
}//class
