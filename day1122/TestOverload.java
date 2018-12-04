package day1122;

/**
 * 다형성 : method Overload<br>
 *   하나의 클래스에서 같은 이름의 method를 여러개 작성하는것<br>
 *   규칙) 접근지정자 반환형 method명은 동일하게  만들고,
 *       매개변수만 다르게 작성.
 * @author owner
 */
public class TestOverload {
	
	/**
	 * ★을 하나 출력하는 일
	 */
	public void printStar() {
		System.out.println("★");
	}//printStar
	
//	public void printStars() {
//		사용자는 s를 붙여 쓸지 여러개인지 아닌지 알수 없음
//	}//printStar
	
	/**
	 * 입력되는 값에 따라 ★을 여러개 출력하는 일
	 * @param count 출력할 별의 갯수
	 */
	public void printStar(int count) {
		for(int i=0; i<count; i++) {
			System.out.print("☆");
		}//end for
	}//printStar

	/**
	 * 구구단 3단을 출력하는 method
	 */
	public void gugudan() {
		for(int i=3;i<4;i++) {
			for(int j=1;j<10;j++) {
				System.out.println(i+"*"+j+" = "+i*j);
			}
		}
	}
	
	/**
	 * 입력하는 단이 2~9단 사이일때 해당단을 출력하는 method<br>
	 * 구구단 3단 method를 overload하여 만듦
	 * 메소드안에 메소드를 만드는 중첩정의는 되지 않는다.
	 * @param i 2~9사이 
	 */
	public void gugudan(int i) {
		if(i>1 && i<10) {
			for(int a=i;a<10;a++) {
				for(int j=1;j<10;j++) {
					System.out.println(a+"*"+j+" = "+a*j);
				}
			}
		}else {
			System.out.println("단은 2~9사이의 숫자만 입력가능합니다.");
		}
	}
	
	public static void main(String[] args) {
		TestOverload to = new TestOverload();
		//별 여러개(5) 출력
		to.printStar(5);
		//별 1개 출력
		to.printStar();//ctrl을 누르고 클릭으로 근원지 찾아감
		
		//구구단 3단을 출력하는 method
		to.gugudan();
		
		//입력하는 단이 2~9단 사이일때 해당단부터 9단까지를 출력하는 method
		to.gugudan(8);
		
	}//main
}//class
