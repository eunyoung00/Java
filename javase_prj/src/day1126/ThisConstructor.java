package day1126;

/**
 * this를 사용한 생성자 호출<br>
 * @author owner
 */
public class ThisConstructor {
	
	public ThisConstructor() {
//		this();//<나를 다시 부르겠습니다. 해서 재귀호출되버림=>Error
//		this(26);//<컨트롤 눌러보면 아래로 인자있는 생성자로 감
		System.out.println("기본 생성자");
	}//ThisConstructor

	public ThisConstructor(int i) {
//		this();//<컨트롤 눌러보면 기본 생성자로 감
		System.out.println("인자있는 생성자");
//		this();//this는 생성자의 첫줄에서 만 사용가능.
	}//ThisConstructor
	
	public static void main(String[] args) {
//		new ThisConstructor();//this(26); 일때 
		//<앞에서는 객체에 저장을 했는데, 애같은 경우 메소드도 변수도 없어 생성만 하면 끝나기 때문에 
		//<객체를 저장해서 사용할 일이 없을때 이런 인스턴스 화 하게 된다.
		//<인자있는 이 먼저나오고 기본이 나중에 나오는걸 볼수 있다.

		new ThisConstructor(22);//this(); 활성화 되어있을때
		//<기본-인자 순
		
		//<this는 한쪽에만 써 어느순간 되돌아 갈수 있게 만들어야 한다. 재귀호출Error
		
		//this의 사용으로 코드를 좀 줄일수 있다.
		
	}//main
}//class
