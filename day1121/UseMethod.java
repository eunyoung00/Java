package day1121;

/**
 * Method : ������ �����Ͽ� �����ϸ�,�ߺ��ڵ带 �ּ�ȭ �� �� ���.
 * 
 * @author owner
 */
public class UseMethod {
	
	//instance method
	public void instanceMethod() {
		System.out.println("��üȭ �Ͽ� ����ϴ� method");
	}//instMethod
	
	//static method
	public static void staticMethod() {
		System.out.println("��üȭ ���� ���� ȣ���Ͽ� ����ϴ� method");
	}//staticMethod
	
	public static void main(String[] args) {
		//instanceMethod(); //��üȭ ���Ŀ� ��ü������ ȣ���� �� �ִ�.
//		staticMethod(); �������ѵ�,
		
		UseMethod um = new UseMethod();
		um.instanceMethod();
//		um.staticMethod();//<static������� �ҷ��ֶ���
		//static method�� Ư����ü�� �����ִ� method�� �ƴϹǷ� ��ü������ ȣ������ �ʴ´�.
		UseMethod.staticMethod();	

	}//main
}//class
