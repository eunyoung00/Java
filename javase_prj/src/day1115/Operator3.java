package day1115;
/*
	����Ʈ������
	<< (left shift) : ��Ʈ�� �������� �а� �о ��ĭ�� �׻� 0���� ä���.
	>> (right shift) : ��Ʈ�� ���������� �а� �о ��ĭ�� �ֻ��� ��ȣ��Ʈ�� ���� ����� 0��, ������ 1�� ä���.
	>>> (unsigned right shift) : ��Ʈ�� ���������� �а� �о ��ĭ�� �׻� 0���� ä���.
*/

class Operactor3 {
	public static void main(String[] args) {
		//method :  <�̸� �����ص� Ŭ������ ����?
		//method : static method ���   <�޼ҵ忡 ���������ڿ� ����ƽ�� �پ�������
		//Ŭ������.method��(��)      <�ٸ�Ŭ�������� ���� ����� ������� ����  �Լ�=�޼ҵ�?
		int i = 11;
		System.out.println(Integer.toBinaryString(i) );//1011
		System.out.println(Integer.toOctalString(i) );//013
		System.out.println(Integer.toHexString(i) );//0xb
        
		i=9;
		System.out.println(i+"<<3 = "+ (i<<3));	//72
		//(i+"<<3 = "+ i<<3)�� ���ڿ��� �Ǿ� ������� �ʴ´�. ��ȣ!
		i=36;
		System.out.println(i+">>3 = "+ (i>>3));	//4
		i=120;
		System.out.println(i+">>>4 = "+ (i>>>4));	//7

		i=1;
		System.out.println(i<<1);	//2
		System.out.println(i<<2);	//4
		System.out.println(i<<31);	//-21��~
		System.out.println(i<<32);	//1
		//31��ŭ �о�� �ֻ��� ��ȣ��Ʈ�� ����
		i=-1;
		System.out.println(i>>1);	//-1
		System.out.println(i>>2);	//-1
		System.out.println(i>>31);	//-1
		System.out.println(i>>100);	//-1
		//�ֻ��� ��ȣ��Ʈ ����
		System.out.println(i>>>1);	//����� ������ �ִ� �ְ� 21��~//�ֻ��� ��ȣ��Ʈ���� 0���� ����ȴ�.
		//
		
		
        

        
		
        
		
        
        
	}//main
}//class
