package day1114;
class Work_15_2 {
	public static void main(String[] args) {

		//기본 데이터형을 객체로 생성할수있는 클래스, 이를 wrapper 클래스라함
		System.out.println("byte의 최소값 :  "+ Byte.MIN_VALUE +"  최대값 : "+ Byte.MAX_VALUE );
		System.out.println("short의 최소값 :  "+ Short.MIN_VALUE +"  최대값 : "+ Short.MAX_VALUE );
		System.out.println("int의 최소값 :  "+ Integer.MIN_VALUE +"  최대값 : "+ Integer.MAX_VALUE );
		System.out.println("long 최소값 : "+ Long.MIN_VALUE+ "  최대값 : " + Long.MAX_VALUE);

		System.out.println("char의 최소값 :  "+ (int)Character.MIN_VALUE +"  최대값 : "+ (int)Character.MAX_VALUE );
		System.out.println("float의 최소값 :  "+ Float.MIN_VALUE +"  최대값 : "+ Float.MAX_VALUE );
		System.out.println("double의 최소값 :  "+ Double.MIN_VALUE +"  최대값 : "+ Double.MAX_VALUE );
		System.out.println("boolean 최소값 : "+ Boolean.FALSE + "  최대값 : " + Boolean.TRUE);		
	}
}
