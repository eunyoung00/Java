package day1204;

/**
 * 인터페이스(추상클래스도 클래스도 가능)가 method의 매개변수일때 간단하게 사용하는 방법.<br>
 * (((간단하게 쓸수있지만 1회성. 재사용성 꽝. 1회용..)))<br>
 * 
 * @author owner
 */
public class TestAnony {
	public void useAnonyInter(AnonyInter ai) {
		System.out.println(ai.getMsg()+" "+ai.getName());
	}//useAnonyInter
	
	public static void main(String[] args) {
//		AnonyInter ai = new AnonyInter(); //객체화가 안된다.
		//인터페이스에 들어갈수 있는건 상수, abstractor method
		//클래스에 들어갈 수 있는건 변수와 method.
		
		//1.인터페이스를 구현한 클래스를 생성.=>AnonyImpl만든거.
		//2.구현클래스로 객체를 생성.
		AnonyInter ai = new AnonyImpl();//is a 관계의 인스턴스화.
		//AnonyInter 대신 AnonyImpl도 가능.
		//3.매개변수를 가진 method를 호출하기 위해 객체를 생성.
		TestAnony ta = new TestAnony();
		//4.method를 호출
		ta.useAnonyInter(ai);//자식이라 자동으로 들어감
		ta.useAnonyInter(ai);//여러번 호출하려면 이 한줄이면 되는데,
		//====> 불편함.
		
		
		//그래서 나온게 anonymous inner class이다~!~!
		System.out.println("-------------- anonymous innerclass---------------");
		//anonymous inner class를 사용하면 클래스를 따로 만들필요가 없음.
//		ta.useAnonyInter(new AnonyInter());//<일반적인 인스턴스화인데,
//		//<인터페이스는 객체화가 되지 않는다.
		ta.useAnonyInter(new AnonyInter() {//<이 괄호안의 부모가 AnonyInter가 된다.
			@Override
			public String getName() {
				return "공선의"+test();
			}//getName
			
			@Override
			public String getMsg() {
				return "은뇨쇼";
			}//getMsg
			
			public String test() {
				return "자식 method";
			}//<나머지는 override해 최우선적으로 부르는것으로 얘는 밖에서 부를수 없다.
		});
		
		ta.useAnonyInter(new AnonyInter() {
			@Override
			public String getName() {
				return "공선의"+test();
			}//getName
			
			@Override
			public String getMsg() {
				return "은뇨쇼";
			}//getMsg
			
			public String test() {
				return "자식 method";
			}
		});
		//여러번 하려면 긴코드를 또 한번더 적어야..(딱한번부를때만 좋음,여러번은 ㄴㄴ)
		
	}//main
}//class
