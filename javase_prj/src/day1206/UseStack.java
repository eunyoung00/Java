package day1206;

import java.util.Stack;

/**
 * LIFO(Last Input First Output)�� ������ Ŭ���� 
 * @author owner
 */
public class UseStack {
	
	public UseStack() {
		//����)
		Stack<String> stk= new Stack<String>();
		//���Ҵ�)
//		stk.add("�θ�");//�θ�Ŭ������  �����ϴ� ����� Stack�� ��������� ��ĥ�� �־� ������� �ʴ´�.(get�� ������ �ִ�.)
		stk.push("�ϼ̽��ϴ�.");//1		
		stk.push("����");		//2
		stk.push("���õ�");	//3
		System.out.println(stk);
		System.out.println("ũ�� : "+stk.size());//vector(�θ�)���� �ִ°Ŷ� size�� ���ٰ� �����ϸ�ȴ�.
//		System.out.println(stk.pop());
//		System.out.println(stk.pop());
//		System.out.println(stk.pop());
////		System.out.println(stk.pop());//�����Ǹ� Error&�Ź� ���� �˼� �����ϱ�.while��.
		
/*		//�θ�Ŭ������ �����ϴ� ����� ����ϸ� stack�� ��������� ����� �� ���� �ȴ�.
		for(int i=0; i<stk.size();i++) {
			System.out.println(stk.get(i));
		}//<����������� ������ ���� ��������� �ʴ´�.
*/		
		System.out.println(stk.empty());
		while(!stk.empty()) {
			System.out.println(stk.pop());//stack���� �����͸� ������ ���������� �׵����͸� ����� �� ����.
		}//end while
		
	}//UseStack

	public static void main(String[] args) {
		new UseStack();
	}//main

}//class
