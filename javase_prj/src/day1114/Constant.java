package day1114;
/*
	Constant(������ ���ó�� ����ϴ°� =>�ٿ��� ���) �� ���
	���� : class field������ ����
*/

class Constant {
	//Constant����
	public static final int MAX_SCORE=100;	//<final �� ���� ������Ű�µ� ����, ������ ���� ������ �ִ�.
	public static final int MIN_SCORE=0;

	public static void main(String[] args) {
		//public static final int MIN_SCORE=0;	//����� method������ �����Ҽ� ����. Error

		//����� ���: �����   <�� Ŭ������ ������~!~!
		System.out.println(MAX_SCORE +" / "+ MIN_SCORE);

		System.out.println(Constant.MAX_SCORE +" / "+ Constant.MIN_SCORE);

		int my_score = 95;
		my_score = 93;
		//MAX_SCORE=90;	//����� ���Ҵ��� ���� �ʴ´�.
		
		my_score = 83;
		//<������ ���ϴ´�� ��Ű�µ��� ����̵� ���Ҵ� ����

		System.out.println("������ �ְ����� " +Constant.MAX_SCORE+ " ���̰�, �������� " +MIN_SCORE+ 
		"�Դϴ�. ȹ�������� " +my_score+ " �̰�, �ְ��� ȹ�������� ���̴� " +(Constant.MAX_SCORE-my_score));
		//<������ ����� ������ �߰���.

		System.out.println("long �ִ밪 : "+ Long.MAX_VALUE+ "/ �ּҰ� : " + Long.MIN_VALUE);
		//<�ܿ�°� ������ MAX_VALUE,MIN_VALUE�̷��� �� ���� ������ �Ҽ� �ִ�.

	}//main
}//class