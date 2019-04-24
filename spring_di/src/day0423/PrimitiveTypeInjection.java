package day0423;

public class PrimitiveTypeInjection {
	
	public PrimitiveTypeInjection(int i) {
		System.out.println("기본형 데이터형 int 매개변수로 Injection i="+i);
	}//PrimitiveTypeInjection
	
	public PrimitiveTypeInjection(long l) {
		System.out.println("기본형 데이터형 long 매개변수로 Injection l="+l);
	}//PrimitiveTypeInjection
	
	public PrimitiveTypeInjection(String s) {
		System.out.println("String을 매개변수로 받는 Injection s="+s);
	}//PrimitiveTypeInjection
	
}//class
