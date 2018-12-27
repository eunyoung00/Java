package day1221;

import java.io.Serializable;

/**
 * 데이터(value Object=VO)를 가지고 있는 클래스로 직렬화대상 클래스(일반클래스는 직렬화가 되지 않는다) 
 * @author owner
 */
public class UserData implements Serializable{ //직렬화 당할객체?
	/**
	 * 코드의 변형이나 가공이있을수 있기때문에 검증을 거쳐 확인하게 된다
	 * (해쉬(파일을 줄여서 숫자로 만든것)코드 로도 확인)=>안전하게 쓰세여
	 * 특정기한이 지나면 파훼?할 될? 수 있어 변경하라는 것이다.
	 */
	private static final long serialVersionUID = -3782985689772130133L;//내가생성한 파일의 ID

	private int age;
	private /*transient*/ double weigth;//직렬화가 되는것을 막을수 있다.
	private /*transient*/ String name;
	//transient : 직렬화 방지 키워드, 값이 JVM외부로 전달되지 않는다.(값이 밖으로 나가지 못한다.)
	
	public UserData() {
	}

	public UserData(int age, double weigth, String name) {
		this.age = age;
		this.weigth = weigth;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWeigth() {
		return weigth;
	}

	public void setWeigth(double weigth) {
		this.weigth = weigth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() { //주소가 아니라 값이 나가게 만들어줌
		return "UserData [age=" + age + ", weigth=" + weigth + ", name=" + name + "]";
	}
	
}//UserData
