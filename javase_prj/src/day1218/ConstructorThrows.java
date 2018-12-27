package day1218;

/**
 * 생성자에서 예외를 날리는 경우
 * @author owner
 */
public class ConstructorThrows {
	public ConstructorThrows() throws ClassNotFoundException{
		Class.forName("java.lang.Object");
		System.out.println("객체 생성");
	}//ConstructorThrows
	
	public static void main(String[] args) {
		try {
			ConstructorThrows ct = new ConstructorThrows();
			System.out.println("객체화 성공 : " +ct);
		} catch (ClassNotFoundException cnfe) {
			System.out.println("객체화 중 에러 발생!!!");
		}//end catch
	}//main

}//class
