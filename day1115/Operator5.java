package day1115;
/*
	논리연산지 :
	 일반논리
		&& (AND): 전항과 후항이 모두 true일때만 true반환.이외f
		|| (OR): 전항과 후항이 모두 false일때만 false반환.이외t
	 비트논리 
	 	& (AND): 상위비트와 하위비트 모두 1인경우 1내림
		| (OR): 상위비트와 하위비트 모두 0인 경우 0내림
		^ (XOR)-Exclusive OR: 상위비트와 하위비트 둘중 하나만 1인경우 1내림.
*/

class Operator5 {
	public static void main(String[] args) 	{
		boolean flag1 = true, flag2 = false, flag3 = true, flag4 = false;
		int i = 0, j = 0;
		//변수는 묶어서 한쪽에 만드는게 좋다.

		System.out.println("------------&&------------");
		System.out.println(flag1+" && " +flag3 + " = " + (flag1&&flag3));	//true
		System.out.println(flag1+" && " +flag2 + " = " + (flag1&&flag2));	//flase
		//전항이 false이면 후항을 계산하지 않고 false인 결과를 만든다.
		System.out.println(flag2+" && " +flag1 + " = " + (flag2&&flag1));	//flase
		System.out.println(flag2+" && " +flag4 + " = " + (flag2&&flag4));	//flase

		System.out.println("------------||------------");
		System.out.println(flag1+" || " +flag3 + " = " + (flag1||flag3));	//true
		System.out.println(flag1+" || " +flag2 + " = " + (flag1||flag2));	//true
		//전항이 true이면 후항을 계산하지 않고 true인 결과를 만든다.
		System.out.println(flag2+" || " +flag1 + " = " + (flag2||flag1));	//true
		System.out.println(flag2+" || " +flag4 + " = " + (flag2||flag4));	//flase      
		
		System.out.println("-----------------------------------");
		flag1 = false;
		flag2 = false;
		flag3 = false;

		flag3 = (flag1=3<4) && (flag2=5<4);	//flag1에 3<4값이 들어감 그리고 같은지 비교
		System.out.println("전항 : " +flag1+", 후항 : " +flag2+ ", 판정 : " +flag3);	//true

		flag3 = (flag1=3>4) && (flag2=5>4);	//flag1에 3<4값이 들어감 그리고 같은지 비교
		System.out.println("전항 : " +flag1+", 후항 : " +flag2+ ", 판정 : " +flag3);	//false
		//처리를 더빠르게 하는것을 돕는다.
		//전항이 true면 뒤항 계산ㄴㄴ


		System.out.println("-----------------------------------");
		System.out.println(9&3);
		// 1001  0011=>0001=1
		System.out.println(9|3);
		// 1001  0011=>1011=11
		System.out.println(9^3);
		// 1001  0011=>1010=10
		//이진수로 바꿀줄알면 계산이 쉽다. 마찬가지로 거의 쓸일 없다.
		System.out.println("-----------------------------------");

        
        
		System.out.println("-----------------------------------");
		i=28;
		j=48;
		System.out.println(i +" & " +j+ " = " +(i&j));
		//0001 1100 & 0011 0000 = 0001 0000 = 16
		i=16;
		j=3;
		System.out.println(i +" | " +j+ " = " +(i|j));
		//0001 0000 | 0000 0011 = 0001 0011 = 19
        i=10;
		j=12;
		System.out.println(i +" ^ " +j+ " = " +(i^j));
		//0000 1010 ^ 0000 1100 = 0000 0110 = 
        
		System.out.println("-----------------------------------");
	}//main
}//class
