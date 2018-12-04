package day1115;
/*
	단항연산자(Unary)
	~, !, +, -, ++, --
*/

class Operator1 {
	public static void main(String[] args) 	{
		//자바어플리케이션 메인메소드가 들어있는것? 이것만으로도 돌아가서?
		
		int i = 11;
		int j = -11;
		
		//~ (tilde) : 1의 보수 연산
		//~양수 : 부호변경 1증가
		System.out.println("~"+i+" = "+ ~i);	//-12   <"+ ~i 틸드 띄어쓰기 주의
		//~음수 : 부호변경 1감소
		System.out.println("~"+j+" = "+ ~j);	//10
		//일반연산엔 잘안쓰고 암호화에 사용

		//! (NOT) : true->false, false->true
		boolean b = true;
		boolean c = false;
		System.out.println("!"+b+" = "+ !b);	//false
		System.out.println("!"+c+" = "+ !c);	//true
		//!는 t/f에만 쓸수있다!
		System.out.println(!(11>15));	//!11이렇게 인식되어 int는 대상체로 될수 없다고 Error
		//!은 boolean에만 사용가능하다. (casting도 안됀다고 생각하면되고_값을 까먹을 수도 있다_참조형의 캐스팅 더많이씀)

		//+ : 형식적인 제공
		System.out.println("+" +i+ "="+ +i);	//11
		System.out.println("+" +j+ "="+ +j);	//-11
		//일을 안한건아닌데 해도 바뀌는게 없다

		//- : 2의 보수연산, 부호바꿈 연산
		System.out.println("-" +i+ "="+ -i);	//-11
		System.out.println("-" +j+ "="+ -j);	//11
		//+와 다르게 일을한다(하는게 보인다) 부호바꿀일이 있다면 그냥 - 적으면된다.
		
		//++ : 증가연산(대상체의 값을 1씩 증가)
		i = 0;
		j = 10;
		//전위연산 : 연산자 대상체;
		++i;	//0->1
		--j;	//10->9
		System.out.println("전위연산 후 : i = " +i+ ", j = "+ j);	
		//후위연산 : 대상체 연산자;
		i++;	//1->2
		j--;	//9->8
		System.out.println("후위연산 후 : i = " +i+ ", j = "+ j);	
		//증가연산자와 감소연산자는 대입연산자와 함께 사용되면 전위와 후위가 다른값을 대입한다.
		j=0;
		//전위 : 내것먼저
		j=++i;	
		System.out.println("전위연산 후 i : "+ i +", 대입 j : "+ j);	//서로 같은값 가짐
		//후위 : 남의 것 먼저
		j=0;
		j=i++;
		System.out.println("후위연산 후 i : "+ i +", 대입 j : "+ j);
		

	}//main
}//class
