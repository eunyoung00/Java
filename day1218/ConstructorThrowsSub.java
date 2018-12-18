package day1218;

public class ConstructorThrowsSub extends ConstructorThrows{

	//부모클래스의 생성자가 컴파일 예외를 날리면 자식클래스의 생성자에서도 (같은?)예외를 날려야 한다. <<상속이면~!>>
	public ConstructorThrowsSub() throws ClassNotFoundException {
//		super();//여기서의 try~catch는 super가 첫번째 줄이 안돼기 때문에 던져주어야 한다. 
//		try {
//			super();//super는 생성자의 첫번째 줄에서만 기술할 수 있으므로 부모클래스의 생성자가 Compile Exception을 throws로 날리면
					//생성자를 호출하는 자식클래스에서는 반드시 예외를 처리해야하는 문법상 에러가 발생하게 된다. 
//		}catch(ClassNotFoundException cnfe) {
//			
//		}
		super();
		//<생성자에서 예외처리하는 경우는 많이 없지만 하게된다면 자식에서도 해주어야 한다. 
		
	}//ConstructorThrowsSub
	public static void main(String[] args) {
		
	}//main
}//class
