package day1218;

/**
 * Compile Exception : byte code를 정상적으로 생성하기 위한 것.
 * 개발자가 반드시 예외상황을 처리해야하는 예외.(하지않으면 Error)
 * @author owner
 */
public class UseCompileException {

	public static void main(String[] args) {
		//<다른클래스를 사용하려면 new 를 해야하는데, new 하지않고도 객체를 얻어 쓸수 있는 방법이있다.
		//<forName(String className)  으로~! java.lang.reflect.Method?가 불러??
		//<클래스가 없었을때의 (오타)의 경우를 대비해야한다.
		try {
//			Object obj/*Class c와 부모관계라 가능*/ =Class.forName("java.lang.String");
			Object obj =Class.forName("day1217.UseRuntimeException");//sum사에서 만든것도,내가만든것도 가능.
			//<ClassNotFoundException 처리해야~!한다~!Error
			System.out.println("로딩한 클래스 "+obj);//new를 하지 않아도 객체를 얻어쓸수 있다.
		} catch (ClassNotFoundException cnfe) {
			System.err.println("죄송합니다.");//<사용자에게 에러에대한 정보를 제공하지 않는다.(악의적으로 사용할 수 있어서)
			System.err.println("예외 메세지 출력 : "+cnfe.getMessage());
			System.err.println("예외처리 객체외 메세지 : "+cnfe);
			cnfe.printStackTrace();//<매우상세: stack에 담긴걸 추척해 출력, println과 같이 쓰면 나중에 쓰여도 출력순서가 꼬일수 있다.
//			System.out.println("---5465465fgd65f");//<추척하는 과정이 더 느리기 때문
			//pirntln은 printStackTrace보다 먼저 출력된다.
			//<상세메세지 중에 내가작성한 클래스만 찾으면 된다.
			
			//<<사용자에게는 죄송합니다만 나는 printStackTrace로 보고 운용시엔 지워준다~!~!
			//<<런타임에러가 더 어렵고,예외처리 시에 블럭을 비워두면 의미가 없으니 잘처리해 준다.
		}finally{
			System.out.println("사용해 주셔서 ㄳㄳ");
		}//end catch

	}//main
}//class
