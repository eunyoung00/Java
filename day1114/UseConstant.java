package day1114;
/*
	�ٸ�Ŭ������ �ִ� ����� ����غ������� Ŭ����
*/

class UseConstant{
	public static void main(String[] args) {
		//System.out.println(Constant.MAX_SCORE);
		//�ٸ�Ŭ������ �����ϴ� ����� �� �ݵ�� "Ŭ������.�����"�� ������ ������.

		System.out.println(Constant.MAX_SCORE+" / "+Constant.MIN_SCORE);

		int doci = 15;
		int octal = 017;
		int hex = 0xF;
		int hex1 = 0xf;
		//�츮�� �ڹ�â���� �����ִ� ������ �̼������� �����̴�.

		System.out.println(doci+" / "+octal+" / "+hex+ " / "+ hex1 );

		int tel = 01012345677;
		System.out.println(tel);

		int tel1 = 1238;
		System.out.println(tel1);


	}//main
}//class
