package day1121;

/**
 * static(class)변수 : &gt;공용변수, 어떤 변수에도 속해있지 않은변수
 *                   클래스가 실행되면 가장 처음 메모리(method)에 올라가고, 
 *                   모든 객체가 하나의  변수를 참조하여 사용한 변수 
 * 
 * @author owner
 */
public class UseStaticVariable {
	static int i;	//static variable(변수) => 바로사용.
	int j;	//instance variable(변수) => 객체화 하여 사용.
	
	public void test() {
		i=100;
		j=200;
		System.out.println(i+" / "+j);
		
	}//test

	public static void main(String[] args) {
		//static int i;//지역변수는 접근지정자가 있을수 없다.
		
		//class 변수사용. 클래스명.변수명
		UseStaticVariable.i = 2000;
		//i=100; 위의 형식으로 변경
		System.out.println(i+"/"+UseStaticVariable.i);//둘다 가능
		
		UseStaticVariable usv = new UseStaticVariable();
		UseStaticVariable usv1 = new UseStaticVariable();
		usv.j = 5000;//instance 변수는 생성된 객체가 각각 사용한다.
		usv1.j = 10000;
		
		UseStaticVariable.i=20;
//		usv.i=20;//다바꿔진다..공용변수라서 바람직하지 않다.
		//객체명으로 사용하면 특정 객체에 속한(member 변수)가 아니므로 사용은 가능하지만 권장하는 문법이
		//아니다.
//		System.out.println("usv객체 인스턴스변수 : "+usv.j+", static 변수"+usv.i);
		System.out.println("usv객체 인스턴스변수 : "+usv.j+", static 변수"+UseStaticVariable.i);
//		System.out.println("usv1객체 인스턴스변수 : "+usv1.j+", static 변수"+usv1.i);
		System.out.println("usv1객체 인스턴스변수 : "+usv1.j+", static 변수"+UseStaticVariable.i);
		
		
//		j=200;//static 변수가 아니라 쓸수 없음
//		System.out.println(i+" / "+j);

	}//main
}//class
