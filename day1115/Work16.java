package day1115;
/*
 ����
1. ������ �Ҵ�� ���� ����϶��� 2������ ����ϰ� ������� ~�� ����Ͽ�
    ����� �����ϰ� �Էµ� �״���� 10������ ���.
    ��� ��)  " ��� �ΰ��"  10��  1010
                 "���� �ΰ��"  -10 �� 10
				 
2. 2147483647�� ������ ���� 2byte�� ���� 2byte ���� �и��Ͽ� ����غ�����. 
    ��� ��) ���� 2byte -> 32767=0111 1111 1111 1111
                ���� 2byte -> 65535=1111 1111 1111 1111

3. ||�� ������� �� ������ true��� ������ �������� �ʴ� ���� ������ �� �ִ�
     �ڵ带 �ۼ��ϼ���.
*/

class Work16 {
	public static void main(String[] args) {
		//1��
		int i = Integer.parseInt(args[0]);
		//System.out.println(Integer.toBinaryString(i) );//1011
		//System.out.println(i+ "��(��) "+ (i>=0?"���":"����"));
		System.out.println(i>=0?"��� �ΰ�� "+i+"��(��) "+Integer.toBinaryString(i) :"���� �ΰ�� "+i+"��(��) "+(~i+1));

		//2��
		int j = 2147483647;
		System.out.println("����2byte "+(j>>16));	//0111 1111 1111 1111=>32767
		System.out.println("����2byte "+ ~(j<<16));	//1111 1111 1111 1111=>65535
//      System.out.println("����2byte "+ j&0x0000ffff);	//1111 1111 1111 1111=>65535
		//0x0000ffff �� 16�����϶� ���ϴ� ���� ���ͼ� &�� ���� ���������� �ִ�. 0�� �����ϰ� ffff�� �ᵵ �˾Ƽ� ���ڸ��� ����� �����Ѵ�.?
		//System.out.println("����2byte "+ j&0x0000ffff);

		//3��
		boolean flag1 = true, flag2 = false, flag3 = true, flag4 = false;
		System.out.println(flag1+" || " +flag3 + " = " + (flag1||flag3));	//tt true
		System.out.println(flag1+" || " +flag2 + " = " + (flag1||flag2));	//tf true
		//������ true��� ������ �������� �ʴ� ���� ����
		flag2 = true;
		System.out.println(flag1+" || " +flag2 + " = " + (flag1||flag2));	//tt true
		
		System.out.println(flag2+" || " +flag1 + " = " + (flag2||flag1));	//ft true
		System.out.println(flag2+" || " +flag4 + " = " + (flag2||flag4));	//ff flase  

		int a = 5, b = 0;
		System.out.println("a�� "+a +", b�� "+b);
		System.out.println("a!=0 || ++b!=0 = "+(a!=0 || ++b!=0));
		//a�� 5�� 0�� �ƴϴ� true, b�� 1�� ���·� ����Ǿ���Ѵ�. ������ ����� 0 ��� �ȵ�!
        System.out.println("a�� "+a +", b�� "+b);
  
	}//main
}//class
