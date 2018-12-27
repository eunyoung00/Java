package day1207;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Work24 {
//	���� 1.
//	main method�� arguments�� ��¥�� ������ �Է� �޾� �Է¹��� ��¥��
//	 ������ �����ϰ� ����ϴ� method �� �ۼ��ϼ���.
//
//	��) java Test 4 12 30 32 35 15 4   
//
//	���) 4 ȭ
//	     12 ��
//	     15 ��
//	     30 ��  �Է��Ѵ�� ��µ����ʴ´�.
//	Map, Set����ϸ� ��

	// Set :�˻��� ����� ������(get X), �ߺ����� �������� �ʴ�(����) ����� ����.
	Set<String> set;
	Calendar cal1;
	Iterator<String> ita;
	String days;

	// Set�� ����� ���� �־� ������� ita�� �ѱ�.
	public Work24() {
//		Map<String, String> map = new HashMap<String,String>();
		set = new HashSet<String>();
//		set.add(4);
//		set.add(12);
//		set.add(30);
//		set.add(32);
//		set.add(35);
//		set.add(15);
//		set.add(4);
		ita = set.iterator();// ������� �ѱ�.

	}// Work24

	// Set�� �־��������� ��¥�� �����ϰ� �������
	public void printSet(String[] args) {
		for (int i = 0; i < args.length; i++) {
			set.add(args[i]);
		}
		ita = set.iterator();
		while (ita.hasNext()) {// Iterator�� �����ϴ� Set�� ��Ұ� �����Ѵٸ�
			days = ita.next();// �ش� ����� ���� ��� ���� �����ͷ� �̵�.
			cal1 = new GregorianCalendar();// os�� ��¥ ��������.
			cal1.set(Calendar.DAY_OF_MONTH, Integer.parseInt(days));// days�Ϸ� ����

//			System.out.println("\n�̹����� �������� : "+cal1.getActualMaximum(Calendar.DATE));
			if (Integer.parseInt(days) < cal1.getActualMaximum(Calendar.DATE)) {// ������������ ������ ���.
				System.out.printf("%d %s\n", cal1.get(Calendar.DAY_OF_MONTH),
						"��,��,ȭ,��,��,��,��".split(",")[cal1.get(Calendar.DAY_OF_WEEK) - 1]);
				// ���氪 ���.
			} // end if
		} // end while
	}// printSet

	public static void main(String[] args) {
		Work24 hw = new Work24();
		hw.printSet(args);

	}// main
}// class
