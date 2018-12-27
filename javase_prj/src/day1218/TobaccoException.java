package day1218;

/**
 * 사용자정의 예외처리 클래스 )
 * @author owner
 */

//1.Exception이나 RuntimeException을 상속받는다. 
@SuppressWarnings("serial")
public class TobaccoException extends RuntimeException{
	
	public TobaccoException() {
		super("담배 예외-폐암의 원인 흡연! 그래도 피우시겠습니까?");
//		this("담배 예외-폐암의 원인 흡연! 그래도 피우시겠습니까?");//this와도 같다. 지금은~!
	}
	public TobaccoException(String msg) {
		super(msg);
	}
}//class
