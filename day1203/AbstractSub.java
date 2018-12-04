package day1203;

/**
 * 추상 클래스를 부모로 하는 자식클래스<br>
 * 자식클래스는 반드시 부모클래스의 모든 추상method를 반드시 Override해야한다.
 * @author owner
 */
public class AbstractSub extends AbstractSuper{
	
	
	public void subMethod() {
		System.out.println("자식 method!!!!");
	}//subMethod
	
//	public abstract void absMethod();//추상 class에서만 정의가능
	@Override
	//Override 규칙 : 접근지정자는 달라도 되고(광의의) 반환형, method명 매개변수는 같아야 한다.
	public void absMethod() {
		//추상 method는 super로 호출할 수 없다. <불러봐야 일을 할수 없어서
//		absMethod();//재귀호출
//		super.absMethod();//Error=>불러봐야 일을 할수 없어서
		//<일반메소드는 얼마든지 super로 부를수 있다.
		System.out.println("Override한 자식의 absMethod");
	}//absMethod
	
	@Override
	public String absMethod1(int param_i) {
//		return param_i+"";//O
		return String.valueOf(param_i).concat("-자식");
	}//absMethod
	

	public static void main(String[] args) {
		//자식클래스가 객체화되면, 추상클래스는 객체화가 된다.
		//<자식클래스가 되지않고는 될수없다.
		//<추상클래스는 super로 부를수 없다.
		AbstractSub as = new AbstractSub();
		//자식클래스로 객체화 : 부모의 변수,method,자식의 변수,method 다.
		//<이름이 같다면 자식의것 사용.
		
		as.i=12;//부모의 변수
		as.method();//부모의 method
		
		//Override된 method는 자식에서 구현한 것이므로 자식의 method가 호출된다.
		as.absMethod();//같은 이름으로 존재한다면 자식의 method호출.
		System.out.println(as.absMethod1(3));//같은 이름으로 존재한다면 자식의 method호출.
		as.subMethod();

		//is a 관계의 객체화 : 객체다형성을 쓰기위한 객체화
		
		//부모클래스명 객체명 = new 자식생성자();
		AbstractSuper as1 = new AbstractSub();
		//부모의 자원 호출 가능
		as1.i=100;//<as1.찍어보면 뒤에 나올수 있는게 Super와 Object클래스뿐이 없다.
		as1.method();//<부모의 일을 하는 일반 method
		
		//Override된 method가 존재한다면 자식의 method를 호출 할 수 있다.
		//추상 method는 body가 없지만 호출하게되면 자식의 method가 호출된다.
		as1.absMethod();//<Override한 자식의 absMethod
		System.out.println(as1.absMethod1(2018));
		
		//is a 관계로 객체화 하면 자식이 가진 method는 호출 불가.
//		as1.subMethod();//<Error=>ㄴㄴ불가능. Override한것만.
		
		//<자식을 통해서만 객체화가 될수 있다.
		
		
		
		
	}//main
}//class
