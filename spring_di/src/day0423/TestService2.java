package day0423;

public class TestService2 {
	//의존성 주입받은 객체를 사용할 수 있도록 Instance 변수로 선언해주게 된다.
	private TestDao td;
	private TestDao2 td2;
	
	public TestService2(TestDao td, TestDao2 td2) { //interface(부모)를 의존성 주입 받으면 약결합이 된다. 
		//지금은 강결합 부모(인터페이스)를 받으면 약결합이된다.
		//의존성 주입을 받으면 대부분 위에 올려준다.
		//new 를 이안에서 하지 않는다.
		this.td=td;
		this.td2=td2;
		System.out.println("매개변수가 여러개인 생성자의 의존성 주입");
	}//TestService
	
	//method injectoin이 아니니까 아래는 지워준다
	
}//class
