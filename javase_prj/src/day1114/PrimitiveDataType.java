package day1114;
/*
�⺻�� ��������
������ : byte, short, int, long(int, long����)
������ : char
�Ǽ��� : float, double(double����)
�Ҹ��� : boolean(����)
*/

class PrimitiveDataType {
	public static void main(String[] args) {
		//<�ڹٴ� ��ȣ�� ���࿡ ���� ���´�. �߳������� �ʴ´�.
		//������
		byte a = 10;
		short b = 20;
		int c = 30;
		long d = 40;	//�Ҵ�Ǵ� ���� 4byte�� �̹Ƿ� literal�� ��ȯ�� �ʿ䰡 ����.
		long e = 21474836478L;
		//literal�� ������ ���� �����Ƿ� literal�� ũ�⸦ ���� => ����� 

		System.out.println("byte : " + a + ", short : " + b + ", int : " + c + ", long : " + d + ", " +e);

		//������ : unicode �� : \u0000 => �������� �ٲ�� ���´�.
		//char f = 'A';	//�Ҵ��� unicode�� �ǰ�
		char f = 66;	//unicode���� �־ 10������ �Ҵ絵 �����ϴ�.
		char g = '0';	//<0�� ������� '0'�� ���ڻ�� "0"�� ���ڿ� ����� �ٴٸ� �����̴�!
		char h = '��';
		//����� unicode�� ���� ���� ���
		System.out.println("char : " + f + ", " + g + ", " + h);

		//�Ǽ� 
		float i = 3.14F;	//����� - �Ǽ� literal�� 8byte�̰�, float ���������� 4byte�̹Ƿ� ���Ҵ��� ���� �ʴ´�.
							//���� F,f�� �����
		//<4byte�� ũ�⸦ ���µ� ���ͳ��� ũ��� 8byte�̹Ƿ� ����ü�� ���� �ʴ´�. ������ �� , ������ ũ�� �̾���Ѵ�.l�� �ø��� f�� ���δ�.
		double j = 3.14;	//���ͳΰ� ���������� �����Ƿ� ����� ������ �� �ִ�.
		//<����� ������ �ʴ´� �ص��׸� ���ص� �׸�
		double k = 3.14d;	
		
		System.out.println("float : " + i + ", double : " + j + ", " + k);

		//�Ҹ���
		boolean l = true;	//<có�� 1�� 0�� ���� �ʴ´�
		boolean m = false;
		System.out.println("boolean : " + l + ", " + m);

		//�ڵ�����ȯ
		byte b1 = 10, b2 = 20;	//, result = 0;
		//result = b1 + b2;	//�̰͵� �ڵ�����ȯ byte�� short���� ����ȯ�� �ʿ��ϴٸ� �ʹ������� �ڵ����� �ǰԲ� ��������ִ�..?
		//������� byte�� �ƴ϶� int�� �߻��Ǿ� �Ҵ���� �ʴ´�.
		int result = b1 + b2;
		short c1 = 20;
		int result2 = b1+c1;	//������ �ȴ�. ������ int �� ��ƾ� byte�� 2byte�� �ν��� ���������� ū������ �ٲٿ� ��������

		System.out.println(result+", "+result2);

		

	}//main
}//class
