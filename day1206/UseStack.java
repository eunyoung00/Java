package day1206;

import java.util.Stack;

/**
 * LIFO(Last Input First Output)을 구현한 클래스 
 * @author owner
 */
public class UseStack {
	
	public UseStack() {
		//생성)
		Stack<String> stk= new Stack<String>();
		//값할당)
//		stk.add("부모");//부모클래스가  제공하는 기능은 Stack의 고유기능을 해칠수 있어 사용하지 않는다.(get도 쓸수는 있다.)
		stk.push("하셨습니다.");//1		
		stk.push("수고");		//2
		stk.push("오늘도");	//3
		System.out.println(stk);
		System.out.println("크기 : "+stk.size());//vector(부모)에게 있는거라 size가 없다고 생각하면된다.
//		System.out.println(stk.pop());
//		System.out.println(stk.pop());
//		System.out.println(stk.pop());
////		System.out.println(stk.pop());//오버되면 Error&매번 수를 알수 없으니까.while로.
		
/*		//부모클래스가 제공하는 기능을 사용하면 stack의 고유기능을 사용할 수 없게 된다.
		for(int i=0; i<stk.size();i++) {
			System.out.println(stk.get(i));
		}//<넣은순서대로 나오고 값이 사라지지도 않는다.
*/		
		System.out.println(stk.empty());
		while(!stk.empty()) {
			System.out.println(stk.pop());//stack에서 데이터를 꺼내면 다음번에는 그데이터를 사용할 수 없다.
		}//end while
		
	}//UseStack

	public static void main(String[] args) {
		new UseStack();
	}//main

}//class
