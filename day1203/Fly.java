package day1203;

/**
 * 나는 것 들의 일.<br>
 * 나는 것은 속도, 높이를 가진다. 
 * @author owner
 */
public interface Fly {
	/**
	 * 나는 속도
	 * @param speed
	 * @return
	 */
	public abstract String speed(String speed);

//	protected String height(String height);
	//<interface의 추상메소드는 public만 가능하다.
	
	/**
	 * 나는 높이
	 * @param height
	 * @return
	 */
	public String height(String height);
	
}//interface
