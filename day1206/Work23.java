package day1206;

import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

public class Work23 {
//	1.�Ʒ��� �����͸� ó���ϴ� ���α׷��� �ۼ��ϼ���.
//	������, �̺���,������,���ü�,������,������ �� �����Ͱ� �����ϰ�,
//	������ 0~100�� ���̷� �߻��� �� �ֽ��ϴ�.
//	
//	���α׷��� ����Ǹ� ���� ����߿� 2���̻��� ����ó�� ����� �̰� n���� �̸��� ������ �����Ͽ� 
//	����ϴ� ���� �ϴ� ���α׷��� �ۼ�.
//	�ߺ��̸��� �� �� ����.
//	��� ��)
//	������ 89
//	���ü� 77
//	������ 90
//	���� xx��

//	List/����    ����ó�� method�� ���method ����.

	ArrayList<String> nameList, printList;
	Random rd;
	String[] arr;
	int total;

	public Work23() {
		nameList = new ArrayList<String>();
		printList = new ArrayList<String>();
		rd = new Random();

	}

	// list,array�� �̸� �ֱ�.
	public String[] Token(String name) {
		StringTokenizer stk = new StringTokenizer(name, ",");
		arr = new String[stk.countTokens()];
		int i = 0;
		while (stk.hasMoreTokens()) {
			arr[i] = stk.nextToken();
//			System.out.print(arr[i]+" ");
			nameList.add(arr[i]);
			i++;
		}
//		System.out.println(nameList);
		return arr;
	}// Token

	public void printname() {
		int person = rd.nextInt(nameList.size() - 2) + 2;// 2���̻�
		int name = 0;
		int score = 0;
		
		total = 0;
		for (int i = 0; i < person; i++) {
			name = rd.nextInt(nameList.size());// 0~5
			score = rd.nextInt(101);// 0~100

			printList.add(nameList.get(name) + " " + score);

			nameList.remove(name);
			
			total = total + score;
			System.out.println(printList.get(i));

		}
		System.out.println("���� " + total + " ��");
	}

	public static void main(String[] args) {
		Work23 hw = new Work23();
		hw.Token("������,�̺���,������,���ü�,������,������");
		hw.printname();
		// ���ݻ���~~���� �ȴ��� ����, �̸� �ߺ�!
		// �����͸��߻� vs �����͸� ����ϴ� ����,���

	}// main

}// class
