package day1204;

/**
 * method안에 클래스를 정의하는 지역class의 사용.<br>
 * 생성된 객체를 지역변수처럼 사용하는 클래스.
 * @author owner
 */
public class LocalOuter {
	int i;
	
	public LocalOuter() {
		System.out.println("바깥 클래스의 생성자");
	}//LocalOuter
	
	public void method(int param_i, final int param_j) {
		//파라미터는 곧 지역변수와 같다. 메소드 안에서 선언?생성되어 사용되는 변수
		int local_i=0;//<이안에서 사용하지않으면 밖에서 쓸수없어서 warning<왜~만들었엉
		final int local_j=0;
		/*-------------- Local class 시작-------------------------*/
		//<method 안에서 mehtod는 못만드는데, class는 만듦.=>지역class
		class Local{//<객체화 되지 않으면 밖에서 쓸수없어서 클래스명만 두면 warning
			int loc_i;
			
			public Local() {
				System.out.println("지역 클래스의 생성자");
			}//Local
			public void locMethod() {
				System.out.println("지역 클래스의 method loc_i="+loc_i);
				System.out.println("외부 클래스의 인스턴스 변수 i="+i);//가능.
				//원래는 final이 붙은 매개변수만 사용할수 있다.
				//<   ->JDK 1.8부터 final안붙어도 편의성 측면에서 사용가능해짐.
				System.out.println("매개변수(Parameter) param_i="+param_i
									+", param_j="+param_j);
				//원래는 final이 붙은 지역변수만 사용할 수 있었다...
				//JDK1.8이전에서는 final이 붙은 지역변수,매개변수만 사용할 수 있다.
				System.out.println("지역변수 local_i="+local_i+
									", local_j="+local_j);
				//<1.7:local_i=>Cannot refer to the non-final local 
				//<variable local_i defined in an enclosing scope
//				local_i=2018;//JDK 1.8에서부터는 final이 붙어있지않은 지역변수의
				//출력은 가능하지만 값 할당은 되지 않는다.
				//<final이 붙어있지 않더라도 final처럼 쓰게됨
				
			}//locMethod
		
		}//class
		/*-------------- Local class 끝  -------------------------*/
		///////추가 : 지역클래스의 객체화
		Local lo = new Local();
		//<지역 클래스의 생성자 가 추가됨.
		//생성된 객체로 클래스 내의 자원을 사용할 수 있다.
//		loc_i=100;//Error<그냥은 못쓰고~
		//<생성된 객체로 사용.
		//눈에 보이지만 직접사용불가.
		lo.loc_i=100;
		lo.locMethod();
		
		System.out.println("바깥 클래스의 method 호출");
	}//method
	
	public static void main(String[] args) {
		LocalOuter lo = new LocalOuter();
		lo.method(12, 4);
		//<이시점의 출력 : 바깥 클래스의 생성자 & method 호출
		//<메소드를 불렀다고 생성자가 불러지지는 않는다(객체화가 안됨)
		//<지역클래스를 쓰고자한다면 메소드에서 객체화를 해주어야 한다.=>"지역클래스의 객체화"부분
		
	}//main
}//class
