package day1121;

public class Work19 {
	
//	����
//	1.  while�� ����Ͽ� ������ ��ü ���� ����ϴ�  instance method��
//	    �ۼ��ϰ�, ȣ���ϼ���.
	public void gugudanMethod() {
		int i=2;
		while(i<10) {
			int j =1;
			while(j<10) {
				System.out.println(i+"*"+j+" = "+i*j);
				j++;
			}
			i++;
		}
	}//gugudanMethod
	//int j�� �ȿ��� �����Ѱ� �ٽ� �ʱ�ȭ������ ���־ �ʱ�ȭ�� �ʿ䰡 ������

//	2.  do~while�� ����Ͽ� �Ʒ��� ������  *�� ����ϴ�  static method��
//    �ۼ��Ͽ� ȣ���ϼ���.
//    *
//    **
//    ***
//    ****
	public static void twoMethod() {
		int a = 1;
		int b = 0;
//		do {
//			for (b=0; b<a; b++) {
//				System.out.print("*");
//			}			
//			System.out.println();
//			a++;
//		}while(a<5);	
// 		for (b=0;���⼭ ��� �ʱ�ȭ�� ���ֱ� ������ ���� �ø��� �־���
		
/*		while(a<5) {
			b=0;
			while(b<a){
				System.out.print("*");
				b++;
			}
			a++;
			System.out.println();*/
		
		do {
			//int b=0;
			b=0;
			do {
				System.out.print("*");
				b++;
			}while(b<a);
			a++;
			System.out.println();
		}while(a<5);
	}//twoMethod
	//do �ۿ��� �ʱ�ȭ �߱� ������ �ȿ��� �ٽ� �ʱ�ȭ���־�� 0���� �����Ҽ� �ִ�.
	//�����϶� �ȿ����� ������ �ȿ��� ����&�ʱ�ȭ ���ִ°� while�������� ���ڴ�.
	
	
	public static void main(String[] args) {
		Work19 gu = new Work19();//1�� ��üȭ
		gu.gugudanMethod();      //1�� ȣ��
		
		Work19.twoMethod();//2�� ȣ��


	}//main
}//class
