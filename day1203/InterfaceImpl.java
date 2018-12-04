package day1203;

/**
 * interface를 구현하는 class(자식 클래스이고 interface내에 모든 추상method를 
 * Override하는 클래스)
 * 구현 interface가 부모 interface를 가진다면 최종적인 자식클래스에서는 
 * 모든 추상 method를 구현해야한다.
 * 
 * @author owner
 */
//<extends뒤에는 class만.
//<extends SuperInterface=>Error.=>interface이기 떄문에 implements
public class InterfaceImpl implements SuperInterface{
//<InterfaceImpl [extends object가 생략되어있음.] implements
	
//<내 위에 있는 모든 부모의 추상 method를 모두 override
	//내 클래스의 계층에서 위쪽으로 추상 method가있다면 모두 override해야하는데,
	//interface내에서는 override해도 아무 소용없기때문에 자식은 부모인터페이스의 추상메소드를 구현 하지 않는다.
	//<해봤자 부모와 똑같울뿐이라 하지 않는다.
	@Override
	public String msg() {//InterA
		return "내일은 화요일";
	}//msg
	
	@Override
	public String msgB() {//InterB
		return "오늘은 월요일";
	}//msgB
	
	@Override
	public void mehtodA() {//SuperInterface
		System.out.println("methodA");
		
	}//mehtodA
	
	@Override
	public void methodB(int i) {//SuperInterface
		System.out.println("methodB");
		
	}//methodB
	
	public void test() {
		
	}

	
	public static void main(String[] args) {
		//자식 클래스로 객체화 : 모든 mehtod를 호출할 수 있다.
		//ii.msg(),ii.msgB(),ii.methodA(),ii.methodB(),ii.test()
		InterfaceImpl ii = new InterfaceImpl();
		ii.methodB(12);
		
		//is a 관계의 객체화(부모를 앞에두고 객체화)
		//1.InterA 2.InterB 3.SuperInterface 4.모두다    정답은 4!~!~!
		//<내 상속 줄에 있는건 모두 다 올수 있다.
		//SuperInterface로 객체화를 하면 Override된 method만 호출.
		//부모의 method도 모두 호출 가능.
		//si.msg(),si.msgB(),si.methodA(),si.methodB()
		SuperInterface si = new InterfaceImpl();
		System.out.println(si.msg());
		
		//InterA로 객체화 하면 ia.mag()만 호출 가능.
		//<앞에 데이터형이 무엇이냐에 따라서 호출가능한 method가 ㄷ ㅏ다르다.
		InterA ia = new InterfaceImpl();
		System.out.println(ia.msg());
		
		//InterB로 객체화 하면 ib.magB()만 호출 가능.
		InterB ib = new InterfaceImpl();
		System.out.println(ib.msgB());
		
		//<is a 관계의 객체화는 생성자가 중요한게 아니라 담아내는 데이터형에따라 호출이 달라지므로
		//<데이터형이 중요
		//Object o = new InterfaceImpl();//모든 자식을 다 담을수 있다.
		//interface는 객체화 되지 않는다.
//		InterA ia1= new InterA();
//		SuperInterface si1 = new SuperInterface();
		//<interface는 자식을 통해서만 객체가 만들어진다.
		
	}//main

}//class
