package day1121;

/**
 * Instance(member) 변수 (의사용)<br>
 *    객체가 생성될때 메모리(heap)에 할당 되고,그 주소를 저장한 변수(객체,instance,object)를 
 *    사용하여 접근하는 변수.
 *    자동 초기화가 된다. &gt;접근지정자를 사용하여 접근 권한을 달리할 수 있다.
 *    
 * @author owner
 */
public class UseInstanceVarible {
	
	int i;//정수형 초기화값 0
	int j;
	double d;//실수형 초기화값 0.0
	char c;//문자형 초기화값 \u0000
	boolean b;//불형 초기화값 false
	String str;//참조형 초기화값 null
	UseInstanceVarible jaehyun;//참조형 초기화값 null

	public static void main(String[] args) {
		//static 영역은 가정 먼저 메모리(method영역)에 로드 되므로, 생성될지 모르는 instance변수를 직접 사용할 수 없다.
		//<코드상에서 보이긴 보이나 사용불가
		//i=300;//쓸수없다. static을 i 변수에 붙이라고 나오는데, 옳지 않다.
		
		//객체화를 하면 객체가 메모리(heap)에 생성되고, 그 주소를 메모리(stack)에 저장
		//<    =>객체화~
		//객체화 문법 : 클래스명 객체명 = new 클래스명();
		UseInstanceVarible uiv = new UseInstanceVarible();
		//uiv는 스텍에, 뒤에 new는 hepa에 생성
		UseInstanceVarible uiv1 = new UseInstanceVarible();
		System.out.println("객체출력(heap주소) "+uiv);
		System.out.println("객체출력(heap주소) "+uiv1);
		//<주소는 4byte 주소체계 _앞에 0나오면 8진수같아 나오지 않는다. 변환하면 10진수로 알수도 있다.

		
		//heap에 생성된 instance variable을 사용.
		uiv.i = 11;
		uiv.j = 21;
		System.out.println("uiv객체의 멤버변수 i=" +uiv.i);
		System.out.println("uiv객체의 instance 변수 j="+uiv.j);
		
		//instance(member)변수는 자동초기화된다.
		System.out.println("uiv1객체 i : "+ uiv1.i + ", uiv1객체 j: "+uiv1.j);
		
		System.out.println("---------자동초기화 값-----------------");
		System.out.println("정수형 : "+ uiv1.i);
		System.out.println("실수형 : "+ uiv1.d);
		System.out.println("문자형 : "+ uiv1.c);
		System.out.println("불린형 : "+ uiv1.b);
		System.out.println("참조형1 : "+ uiv1.str);
		System.out.println("참조형2 : "+ uiv1.jaehyun);
		
		

	}//main
}//class
