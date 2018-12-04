package day1121;

/**
  * Instance Variable의 Access Modifier 사용<br>
  * public : 클래스 외부에서 접근 가능.<br>
  * protected : 같은 패키지에서 접근 가능, 패키지가 다르면 상속 관계의 자식클래스만 접근 가능.<br>
  * private : 클래스 안에서만 접근 가능.<br>
  * default : 같은 패키지에서 접근 가능, 패키지가 다르면 접근 불가<br>
  * @author owner
 */
public class InstAccModifi {
	public int pub_i;
	protected int pro_i;
	private int pri_i;//클래스안에서 불리지 않으면 밖에 쓰일수도 없다.
	//안에서 선언(언급)해 줘야 주의표시 없어짐
	int def_i;

	public static void main(String[] args) {
		//객체화
		InstAccModifi ivam = new InstAccModifi();
		//변수를 가지고 있는 클래스 안에서 객체화가 되면 접근지정자에 상관없이 모두 사용가능.
		System.out.println("public : "+ivam.pub_i);
		System.out.println("protected : "+ivam.pro_i);
		System.out.println("private : "+ivam.pri_i);
		System.out.println("default : "+ivam.def_i);//자동초기화
		
	}//main
}//class
