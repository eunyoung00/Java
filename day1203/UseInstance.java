package day1203;

public class UseInstance {
	
	public TestSuper test1() {
		//<상속 관계의 객체화 .
		//is a 관계의 객체화 : 부모의 자원과, 자식이 Overrride한 method 사용.
		//부모클래스명 객체명 = new 자식클래스생성자();
		TestSuper ts = new TestSub();
		//<따라서ts는 TestSuper의 method 사용가능.
		return ts;	 
	}//test1
	
	public TestSuper test2() {
		//is a 관계의 객체화 : 부모의 자원과, 자식이 Overrride한 method 사용.
		//부모클래스명 객체명 = new 자식클래스생성자();
		TestSuper ts = new TestSub2();

		return ts;
	}//test2

	public static void main(String[] args) {
		System.out.println("--상속관계에서는 자식클래스로 객체화--");
		//<상속관계에서는 자식클래스로 객체화를 한다.
		//자식클래스를 객체로 생성하여 사용.
		//자식클래스명 객체명 = new 자식의생성자(); 가 일반적
		//이 객체로 사용가능한건, 부모클래스의 변수,method,자식클래스의 변수,method 사용가능.
		TestSub ts = new TestSub();
		ts.i = 100;  //부모와 같은 이름의 변수는 자식의 것을 사용.
		//<super는 static영역안에서는 사용불가.객체안에서는 가능하지만 밖에서는 자식의 것 사용.
		ts.pMethod();//부모의 method사용.
		ts.subMethod();//자식의 method 사용.
		ts.printI();//자식이 Override한 method인 경우 자식의 method호출
		
		System.out.println("----부모의 이름으로 객체화 : 객체 다형성----");
		//<다형성은 메소드 다형성과 객체 다형성 2가지가 있다.
		//객체 다형성 : 같은이름의 클래스를 다양하게 사용하는것.
		//부모만 사용할 수 있으면 된다. 
		//<자식이 100개이상이든 1000개든 부모만 알면 다 쓸수있다.=>편의성
		UseInstance ui = new UseInstance();
		
		TestSuper ts1 = ui.test1();
		TestSuper ts2 = ui.test2();
		//<같은 객체.. 같은 클래스로 만든 객체를 다양하게 사용..=>객체다형성
		//<자식이 누구냐에 따라 같은이름을 다르게 사용,
		//<<<부모클래스만으로 자식클래스를 생성자로 취해 override된 결과를 다양하게 볼수 있다.??
		//<<<자식은 부모이기 때문에 ?
		
		//Override한 method 호출
		ts1.printI();
		ts2.printI();
		
		
	}//main
	
}//class
