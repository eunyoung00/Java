package day1114;
/*
	��������ȯ(Casting) : ������ ������������ �Ͻ������� ��ȯ�Ͽ� ����ϴ� ��./���ϴ� ������ ��ȯ!
*/

class UseCasting{
	public static void main(String[] args) {
		byte b1 = 10, b2 = 20;	//�ڵ�����ȯ
		byte result = (byte)(b1*b2);	//������ ����� int�� �ڵ�����ȯ//(byte)b1*b2;�� �ȵŴѵ� ��ȣ�� ������ �켱������ ���� ����Ʈ�� �����ٲٰ� ������ ����
		//������ ����� int�� �ڵ�����ȯ �Ǵ°��� byte�� ��������ȯ
		System.out.println(b1 + " * " + b2 + " = " + result);

		double d = 11.14;
		float f = (float)d;
		System.out.println("double : " + d + ", float : " + f);
		//�������� ����þȵŰ� ĳ���ø� �ȴ�. L���̸� dL�̶�� ���� ã��

		float f1=(float)2018.11;	//����տ��� ��밡�� ���ͳ���ü�� �ٲ�°��� �ƴ�?
		System.out.println("f1 : " +f1);

		//long l = (long)2147483648;	//������� literal���� ũ�ٸ� casting�� �����ϱ����� Error�߻�.
		//<���ͳ���ü�� �ȵ��⶧���� ĳ�����غ��� ������ =>�ƿ��ȵ�

		//int i = f1;	//ĳ�����ʿ�
		//<����ִ� �������°� �޶� ���� �ʴ´�
		int i = (int)f1;	//���ս� �߻�(�Ǽ����� ���� ��� ����� �Ҵ�)
		System.out.println("int : " + i + " , float : " + f1);

		char c = 'A';
		System.out.println(c+"�� unicode(ASCII code_����,��� ����)�� : "+ (int)c);

		//����(�⺻��<->������ ����) �ٸ��� ��������ȯ�� ���� �ʴ´�.
//		String s = "11"; //������
//		int i = (int)s;	//�⺻��
		//<���ڿ��� �����϶� ����Ŭ�� �߹ٲپ��־����� �ڹٴ� �ٲپ����� �ʴ´�

		//boolean���� boolean�� ������ ��ȯ����
		boolean b = true;
		//i = (int)b;	//error
		boolean bc = (boolean)b;	//<���� ���ιٲ۴�?? �ƹ� �ǹ̰� ����
		System.out.println(bc);
		


	}//main
}//class
