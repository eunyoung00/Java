package day0107;

/**
 * 사용자 정의 예외처리 클래스<br>
 * Exception(RuntimeException) 을 상속받는다.
 * @author owner
 */
@SuppressWarnings("serial")
public class LoginException extends Exception {//exception class는 꼭 클래스명에 Exception을 붙여 확실히 알게 정의한다.
	
	public LoginException() {
		this("로그인 실패");
	}//LoginException
	
	public LoginException(String msg) {
		super(msg);//이래야 예외처리 객체를 사용하여 예외 메세지를 출력할 수 있게된다.
	}//LoginException
}//class
