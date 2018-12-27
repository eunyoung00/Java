package day1130;

/**
 * TestSuper의 자식클래스 
 * @author owner
 */
public class TestSub extends TestSuper{
	
	int p_j;
	
	@Override
	public void method() {
		p_i=400;//상속 ->코드의 재사용성
		super.p_j=500;// 자식의 것. 같은 이름의 변수가 존재하면 자식의 것을 사용.
		System.out.println("자식의 method "+/* p_i +*/this.p_i+"/"+
						this.p_j);//p_i는 부모의 변수
//		method();//내껄로간다.=>Error
		super.method();
		
		System.out.println(this);
//		System.out.println(super);//Error super의 주소는 출력할 수 없다.
		//가르키는 주소가다름...(시작점이 다르다)/영업비밀이라 알려주지않는다.
		System.out.println(super.toString());//this와 같게 나온다.
		
	}//method

	public static void main(String[] args) {
		TestSub ts = new TestSub();
		//부모의 기본생성자
		//부모가 먼저 만들어진것.
		ts.method();//내꺼 먼저
		//부모의 기본 생성자
		//자식의 method
	}//main
}//class
