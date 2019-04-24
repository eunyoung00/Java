package day0423;

public class TestService {
	private TestDao td;//의존성 주입받은 객체를 사용할 수 있도록 Instance 변수로 선언해주게 된다.
	
	public TestService(TestDao td) { //interface(부모)를 의존성 주입 받으면 약결합이 된다. 
		//지금은 강결합 부모(인터페이스)를 받으면 약결합이된다.
		//의존성 주입을 받으면 대부분 위에 올려준다.
		//new 를 이안에서 하지 않는다.
		this.td=td;
		System.out.println("생성자 의존성 주입");
	}//TestService
	
	
	public TestService() {
		System.out.println("기본 생성자를 사용하여 객체 생성");
	}
	
	//method 의존성 주입 : 반드시 기본 생성자가 존재해야한다.
	public void setTd(TestDao td) {
		this.td=td;
	}//setTd
	
	public TestDao getTd() {
		return td; //의존성 주입받지 않은 td는 null (객체가 생성되지 않음) 
	}//getTd
}
