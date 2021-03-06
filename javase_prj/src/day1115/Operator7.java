package day1115;
/*
	대입연산자
	=
	+=, -=, *=, /=, %= 
	<<=, >>=, >>>= 
	&=, |=, ^= 
*/

class Operator7 {
	public static void main(String[] args) {
		
		int i = 3;	//(순수)대입

		//산술대입
		i+=2;	//i=i+2; =5
		i-=1;	//i=i-1; =4
		i*=2;	//i=i*2; =8
		//<오라클은 정수/정수는 때에따라 실수가 나오기도 하지만 자바는 무조건 정수가 나온다.
		i/=3;	//i=i/2; =2	// 정수 / 정수=정수(실수나올수없다)
		i%=3;	//i=i%3; =2

		//쉬프트대입
		i<<=4;	//i=i<<4;	// 0000 0010<<4 = 0010 0000 = 32
		i>>=1;	//i=i>>1;	// 0010 0000>>1 = 0001 0000 = 16
		i>>>=2;	//i=i>>>2;	// 0001 0000>>>2 = 0000 0100 = 4

		//비트논리대입
		i &= 12;	//i=i&12;	//0100 & 1100 = 0100 = 4
		i |= 11;	//i=i|11;	//0100 | 1011 = 1111 = 15
		i ^=  5;	//i=i^5;	//1111 ^ 0101 = 1010 = 10

		System.out.println(i);
	}//main
}//class
