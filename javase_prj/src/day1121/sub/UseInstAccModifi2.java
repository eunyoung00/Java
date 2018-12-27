package day1121.sub;

import day1121.InstAccModifi;

/**
 * 다른 패키지에 존재하는 클래스의 인스턴스변수 접근 사용.<br>
 * 상속 관계에 있다면 자식클래스로 생성하여 부모클래스가 가진 인스턴스변수의
 * 접근 지정자가 public, protected 인것만 사용 가능.<br>
 * 
 * @author owner
 */
public class UseInstAccModifi2 extends InstAccModifi {
	//변수가 하나도 없어 

	public static void main(String[] args) {
		UseInstAccModifi2 ivam = new UseInstAccModifi2();
		System.out.println("public : "+ivam.pub_i);
		System.out.println("protected : "+ivam.pro_i);
//		System.out.println("default : "+ivam.def_i);//사용 불가
//		System.out.println("private : "+ivam.pri_i);//사용 불가  <안보여서 쓸수 없다.

	}//main
}//class
