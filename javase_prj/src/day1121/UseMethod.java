package day1121;

/**
 * Method : 업무를 구분하여 정의하며,중복코드를 최소화 할 때 사용.
 * 
 * @author owner
 */
public class UseMethod {
	
	//instance method
	public void instanceMethod() {
		System.out.println("객체화 하여 사용하는 method");
	}//instMethod
	
	//static method
	public static void staticMethod() {
		System.out.println("객체화 없이 직접 호출하여 사용하는 method");
	}//staticMethod
	
	public static void main(String[] args) {
		//instanceMethod(); //객체화 이후에 객체명으로 호출할 수 있다.
//		staticMethod(); 괜찮긴한데,
		
		UseMethod um = new UseMethod();
		um.instanceMethod();
//		um.staticMethod();//<static방식으로 불러주라함
		//static method는 특정객체에 속해있는 method가 아니므로 객체명으로 호출하지 않는다.
		UseMethod.staticMethod();	

	}//main
}//class
