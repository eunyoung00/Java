package day1126;

/**
 * method를 호출하는 객체의 주소로 변경되어 사용되는 this.<br>
 * 
 * @author owner
 */
public class ThisKeyword {

	int i;//<인스턴스변수 파란색
	/**
	 * parameter의 이름과 instance변수의 이름이 같을때,
	 * this를 사용하지 않고 parameter의값을 instance변수로 저장할 때.  ((번거로움
	 */
//	public void useInstance(int i) {
	public void useInstance(int i, ThisKeyword t) {
//		i=100;//<여기서는 자기꺼가져다 쓰지 넘에꺼 쓰지 않음.
		t.i=i;//<The assignment to variable i has no effect
		//파라미터 변수의 값(stack의 값)을 인스턴스변수(heap)에 할당 하겠다.(올리겠다)
		System.out.println("전달 받은 객체 "+t);
		
	}//useInstance
	
	/**
	 * 파라미터의 이름과 인스턴스 변수의 이름이 같을 때마다 객체를 넘기고 받아서 사용하려면 <br>
	 * (코딩할 때에 한번더 생각해 주어야 한다)코딩시 불편함이 따라온다. 
	 * 개선하기 위해 this 제공.<br>
	 * @param i
	 */
	public void useThis(int i) {
//		i=100;//<인스턴스 변수로 인식
		//this는 매소드를 호출하는 객체의 주소로 변!신! 반환되는 키워드
		//매개변수로 객체를 받을 필요가 없다.
		this.i=i;//tk가 됨..
		System.out.println("method를 호출한 객체의 주소 : "+this);
	}//useThis
	
	public static void test() {//공용!~!~!static method 클래스명.메소드
//		this.i=10;//tk를 써서 부른게 아니라서 대체될게 없어 Error
		//static method안에서는 this keyword사용할 수 없다.
		System.out.println("static method");
	}
	
	public static void main(String[] args) {
		ThisKeyword tk = new ThisKeyword();
		System.out.println("생성된 객체 "+tk);
		tk.useInstance(300, tk);
		//<생성된 객체 day1126.ThisKeyword@1db9742
		//<전달 받은 객체 day1126.ThisKeyword@1db9742
		//<같은 결과가 나온다.
		
		//이름이 같다고 할때마다 이렇게 해주어야 하면 귀찮..불편 그래서 나온게 this다.
		System.out.println("전달한 객체의 인스턴스 변수의 값 "+tk.i);
		System.out.println("-----------------------------------");
		tk.useThis(900);
		System.out.println("this를 사용하여 변경한 인스턴스 변수의 값 :"+tk.i);
		
		ThisKeyword.test();//static 은 어디에도 속해있징않음
		
	}//main
}//class
