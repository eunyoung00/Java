package day1115;
/*
 숙제
1. 변수에 할당된 값이 양수일때만 2진수로 출력하고 음수라면 ~를 사용하여
    양수로 변경하고 입력된 그대로의 10진수로 출력.
    출력 예)  " 양수 인경우"  10은  1010
                 "음수 인경우"  -10 은 10
				 
2. 2147483647의 값에서 상위 2byte와 하위 2byte 값을 분리하여 출력해보세요. 
    출력 예) 상위 2byte -> 32767=0111 1111 1111 1111
                하위 2byte -> 65535=1111 1111 1111 1111

3. ||를 사용했을 때 전항이 true라면 후항을 연산하지 않는 것을 증명할 수 있는
     코드를 작성하세요.
*/

class Work16 {
	public static void main(String[] args) {
		//1번
		int i = Integer.parseInt(args[0]);
		//System.out.println(Integer.toBinaryString(i) );//1011
		//System.out.println(i+ "는(은) "+ (i>=0?"양수":"음수"));
		System.out.println(i>=0?"양수 인경우 "+i+"은(는) "+Integer.toBinaryString(i) :"음수 인경우 "+i+"은(는) "+(~i+1));

		//2번
		int j = 2147483647;
		System.out.println("상위2byte "+(j>>16));	//0111 1111 1111 1111=>32767
		System.out.println("하위2byte "+ ~(j<<16));	//1111 1111 1111 1111=>65535
//      System.out.println("하위2byte "+ j&0x0000ffff);	//1111 1111 1111 1111=>65535
		//0x0000ffff 로 16진수일때 원하는 값이 나와서 &로 값을 날려먹을수 있다. 0은 생략하고 ffff만 써도 알아서 앞자리를 비워서 생각한다.?
		//System.out.println("하위2byte "+ j&0x0000ffff);

		//3번
		boolean flag1 = true, flag2 = false, flag3 = true, flag4 = false;
		System.out.println(flag1+" || " +flag3 + " = " + (flag1||flag3));	//tt true
		System.out.println(flag1+" || " +flag2 + " = " + (flag1||flag2));	//tf true
		//전항이 true라면 후항을 연산하지 않는 것을 증명
		flag2 = true;
		System.out.println(flag1+" || " +flag2 + " = " + (flag1||flag2));	//tt true
		
		System.out.println(flag2+" || " +flag1 + " = " + (flag2||flag1));	//ft true
		System.out.println(flag2+" || " +flag4 + " = " + (flag2||flag4));	//ff flase  

		int a = 5, b = 0;
		System.out.println("a는 "+a +", b는 "+b);
		System.out.println("a!=0 || ++b!=0 = "+(a!=0 || ++b!=0));
		//a는 5라서 0이 아니니 true, b는 1인 상태로 저장되어야한다. 하지만 결과는 0 계산 안됨!
        System.out.println("a는 "+a +", b는 "+b);
  
	}//main
}//class
