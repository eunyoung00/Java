package day1115;
/*
	�������� :
	 �Ϲݳ�
		&& (AND): ���װ� ������ ��� true�϶��� true��ȯ.�̿�f
		|| (OR): ���װ� ������ ��� false�϶��� false��ȯ.�̿�t
	 ��Ʈ�� 
	 	& (AND): ������Ʈ�� ������Ʈ ��� 1�ΰ�� 1����
		| (OR): ������Ʈ�� ������Ʈ ��� 0�� ��� 0����
		^ (XOR)-Exclusive OR: ������Ʈ�� ������Ʈ ���� �ϳ��� 1�ΰ�� 1����.
*/

class Operator5 {
	public static void main(String[] args) 	{
		boolean flag1 = true, flag2 = false, flag3 = true, flag4 = false;
		int i = 0, j = 0;
		//������ ��� ���ʿ� ����°� ����.

		System.out.println("------------&&------------");
		System.out.println(flag1+" && " +flag3 + " = " + (flag1&&flag3));	//true
		System.out.println(flag1+" && " +flag2 + " = " + (flag1&&flag2));	//flase
		//������ false�̸� ������ ������� �ʰ� false�� ����� �����.
		System.out.println(flag2+" && " +flag1 + " = " + (flag2&&flag1));	//flase
		System.out.println(flag2+" && " +flag4 + " = " + (flag2&&flag4));	//flase

		System.out.println("------------||------------");
		System.out.println(flag1+" || " +flag3 + " = " + (flag1||flag3));	//true
		System.out.println(flag1+" || " +flag2 + " = " + (flag1||flag2));	//true
		//������ true�̸� ������ ������� �ʰ� true�� ����� �����.
		System.out.println(flag2+" || " +flag1 + " = " + (flag2||flag1));	//true
		System.out.println(flag2+" || " +flag4 + " = " + (flag2||flag4));	//flase      
		
		System.out.println("-----------------------------------");
		flag1 = false;
		flag2 = false;
		flag3 = false;

		flag3 = (flag1=3<4) && (flag2=5<4);	//flag1�� 3<4���� �� �׸��� ������ ��
		System.out.println("���� : " +flag1+", ���� : " +flag2+ ", ���� : " +flag3);	//true

		flag3 = (flag1=3>4) && (flag2=5>4);	//flag1�� 3<4���� �� �׸��� ������ ��
		System.out.println("���� : " +flag1+", ���� : " +flag2+ ", ���� : " +flag3);	//false
		//ó���� �������� �ϴ°��� ���´�.
		//������ true�� ���� ��ꤤ��


		System.out.println("-----------------------------------");
		System.out.println(9&3);
		// 1001  0011=>0001=1
		System.out.println(9|3);
		// 1001  0011=>1011=11
		System.out.println(9^3);
		// 1001  0011=>1010=10
		//�������� �ٲ��پ˸� ����� ����. ���������� ���� ���� ����.
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
