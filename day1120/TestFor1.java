package day1120;

/**
 * ���� for : �ε����� ������ ����ؾ��ϴ� ���<br>
 * ����) for(���۰�; ����; ����,���ҽ�){<br>
 * 	        for(���۰�; ����; ����,���ҽ�){<br>
 *             �ݺ����๮���;<br>
 *          }<br>
 *      }<br>
 * 
 * @author owner
 */
public class TestFor1 {

	public static void main(String[] args) { //<�����ؼ� ��������ϱ� ����
		for(int i=0; i<6; i++) {
			//<����for�� �������� ���� for�� ���� ���� ����� �� ���´�.
			for(int j=0; j<7; j++) {//����for <���� ���� ������ ���� �ε��� ������� �޶�� �Ѵ�.
				System.out.println("i : "+i+", j : "+j);
			}//end for
			//<���� for ����
			System.out.println("==============");
		}//end for
		
		//������ ���� ���
		for(int i=2; i<10; i++) {	//��
			System.out.println(i+"�� ����");
			for(int j=1;j<10; j++) {
				System.out.println(i+"*"+j+" = "+i*j);
			}
			System.out.println(i+"�� ��");
		}//end for
		
//		ijijijij
//		00
//		1011
//		202122
//		30313233
		for(int i=0; i<4; i++) {
			for(int j=0; j<i+1; j++) {
				System.out.print(i+""+j);
			}
			System.out.println();
		}//end for
		
		System.out.println("============");
		
//		ijijijij
//		121314
//		2324
//		34
		for(int i=1; i<4; i++) {
			for(int j=i+1; j<5; j++) {
				System.out.print(i+""+j);
			}
			System.out.println();	
		}//end for
				

	}//main

}//class
