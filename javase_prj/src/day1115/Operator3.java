package day1115;
/*
	쉬프트연산자
	<< (left shift) : 비트를 왼쪽으로 밀고 밀어서 빈칸을 항상 0으로 채운다.
	>> (right shift) : 비트를 오른쪽으로 밀고 밀어서 빈칸을 최상위 부호비트에 따라 양수면 0을, 음수면 1을 채운다.
	>>> (unsigned right shift) : 비트를 오른쪽으로 밀고 밀어서 빈칸을 항상 0으로 채운다.
*/

class Operactor3 {
	public static void main(String[] args) {
		//method :  <미리 선언해둔 클래스와 같다?
		//method : static method 사용   <메소드에 접근지정자에 스테틱이 붙어있으면
		//클래스명.method명(값)      <다른클래스에서 쓰는 상수와 사용방법이 같다  함수=메소드?
		int i = 11;
		System.out.println(Integer.toBinaryString(i) );//1011
		System.out.println(Integer.toOctalString(i) );//013
		System.out.println(Integer.toHexString(i) );//0xb
        
		i=9;
		System.out.println(i+"<<3 = "+ (i<<3));	//72
		//(i+"<<3 = "+ i<<3)은 문자열이 되어 연산되지 않는다. 괄호!
		i=36;
		System.out.println(i+">>3 = "+ (i>>3));	//4
		i=120;
		System.out.println(i+">>>4 = "+ (i>>>4));	//7

		i=1;
		System.out.println(i<<1);	//2
		System.out.println(i<<2);	//4
		System.out.println(i<<31);	//-21억~
		System.out.println(i<<32);	//1
		//31만큼 밀어내니 최상위 부호비트가 변경
		i=-1;
		System.out.println(i>>1);	//-1
		System.out.println(i>>2);	//-1
		System.out.println(i>>31);	//-1
		System.out.println(i>>100);	//-1
		//최상위 부호비트 유지
		System.out.println(i>>>1);	//양수가 가질수 있는 최고값 21억~//최상위 부호비트부터 0으로 변경된다.
		//
		
		
        

        
		
        
		
        
        
	}//main
}//class
