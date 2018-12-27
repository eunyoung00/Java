package day1121;

/**
 * 같은 패키지에 존재하는 다른 클래스의 인스턴스변수 접근 사용.<br>
 * 접근 지정자가 public, protected, default인것만 사용가능.<br>
 * 
 * @author owner
 */
public class UseInstAccModifi {

	public static void main(String[] args) {
		InstAccModifi ivam = new InstAccModifi();
		//ivam.def_i 잘뜬다
		System.out.println("public : "+ivam.pub_i);
		System.out.println("protected : "+ivam.pro_i);
		System.out.println("default : "+ivam.def_i);
//		System.out.println("private : "+ivam.pri_i);//사용 불가  <안보여서 쓸수 없다.

	}//main
}//class
