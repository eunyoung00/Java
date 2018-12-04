package day1126;


/**
 * 클래스가 객체로 생성될 때 기본적으로 가지고 있어야할 기본값을 설정하거나, 
 * 기본적으로 수행될 코드를 정의하는 method의 일종.(객체초기화값으로 생각하면 된다.)<br>
 * @author owner
 */
public class TestConstructor {
	
	/**
	 * 기본생성자 : 클래스를 작성할때 생성자를 하나도 정의하지 않으면
	 * 컴파일러가 매개변수 없는 Default Constructor를 생성한다.((하나라도 정의되면 만들어주지 않는다.
	 */
	public TestConstructor() {
		System.out.println("기본생성자");
//		TestConstructor(300);//생성자는 method 호출하듯 호출할수 없다. 
		//<생성자는 객체화를 통해서만 부를수 있다.!!~!~
	}//TestConstructor

	/**
	 * 외부의 입력값을 가지고 생성하는 인자있는 생성자 :생성자의 Overload
	 * @param i 임의의 값.
	 */
	public TestConstructor(int i) {//<생성자의 오버로딩 일반 오버로딩과 같음.
		System.out.println("인자있는 생성자 : "+i);
	}//TestConstructor
	
	public void test() {//<인스턴스 메소드 =>고정적일
		System.out.println("test method!!!");
		temp();//method는 그냥부르면된다. method 호출<  =>생성자는 이렇게 불리지 않는다.
	}//test
	
	public void temp() {
		System.out.println("-------------------temp method!!!");
	}//temp
	
	
	public static void main(String[] args) {
//		new testConstructor();//<컨트롤누르면 위 클래스로 올라간다.
//		new TestConstructor();//<컨트롤누르고 누르면 정의된 생성자로
		TestConstructor tc  = new TestConstructor(); //기본생성자
		TestConstructor tc1  = new TestConstructor(26); //인자있는 생성자.
		
		System.out.println(tc);//<heap에 생성된 주소가 나온다.
		System.out.println(tc1);//<heap에 생성된 주소가 나온다.
		//Overloading 된 생성자를 사용하여 객체화를 다양하게 할 수 있음.
		
		tc.test();//<temp메소드 호출을 보기위한 호출
		
		
	}//main
}//class
