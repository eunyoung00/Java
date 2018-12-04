package day1120;

import java.util.ArrayList;
import java.util.List;

/**
 * ������/���� for : �迭�̳� Collection���� ��� ���� ���� ó������ ������ ���������� ����ϱ� ���� �����Ǵ� for.<br>
 *                 ������ for���� JDK1.5�������� ��밡��, �׶� ���Դ�<br>
 * ����) for(�������� ������ : �迭��(Collection��)) {<br>
 *           ������;(�迭(Collection)���� ���� ����Ҽ� �ִ�.)<br>
 *      }<br>
 *     // �ε����� ���� ����.<br>
 * @author owner
 */
public class ImprovementFor {

	public static void main(String[] args) {
		
		int[] tempArr= {2018,11,20,16,5};	//05�� 8����
		
		//������ for�� ��� ���� ���� ���
		for(int i=0; i<tempArr.length; i++) {
			System.out.println(tempArr[i]);
		}//end for
		
		System.out.println("--------------������ for---------------");
		
		//������ for �� ��� ���� �� ���
		for(int value : tempArr) {
			System.out.println(value);
		}//end for ������� ���� �̷��� ���� ¦����° �̷��͵� ���������� ó������ ������
		
		//Collection�ε� list? <���߿� JCF�Ҷ�??
		List<Integer> list = new ArrayList<>();	//<1.7�̻�..
		list.add(10);
		list.add(20);
		list.add(110);
		list.add(1);
		list.add(1000);
		System.out.println("==============List ����    for==============");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}//end for
		
		System.out.println("==============List ���� for==============");
		for(int i : list) {
			System.out.println(i);
	 	}//end for
		//<������ �⺻ for�� ���for���� ����� ����. �ڵ��� �������� �ٸ�
		
	}//main
}//class
