package day1120;

/**
 * �پ��� for�� ����
 * @author owner
 */
public class TestFor2 {

	public static void main(String[] args) {
		//���� loop
//		for( ; ; ) {
//			System.out.println("���� loop");
//			//�ڿ��� ���ɶ�����
//		}//end for
//		System.out.println("");//Error

		//�����ϴ� ���� ���� ����loop
//		for(int i=0;;i++){
//			System.out.println("���� loop" + i);
//		}//end for
//		//���������� ���⿡ �ڵ���� Error
		
		//�����ϴ� ���� ���� ����loop�϶� break
		for(int i=0; ;i++) {
			System.out.println("���� loop" + i);
			if(i==50) {
				break;	//���� �αٿ� �����ϴ� �ݺ����� ���� ������.
			}//end if
		}//end for
		System.out.println("");	//����¿͵� �������� �ʴ´�.
		//break�� ������ if���� �پ� ���� ������ �׳� �� ���� ������ => break�� �� ���ǹ��� �Բ� ���!!
		//Ư�� ������ �����ϸ� ������~~�׷�,
		
		
		//�����ϴ� ���� ���� ����loop�϶�, if��ġ �ٲپ� ����, i������ ������ ������ �ʴ°� ��..
		//int i=0;
		for(int i=0; ;i++) {
			System.out.println("���� loop" + i);
		//}//end for
			if(i==50) {
				break;	//���� �αٿ� �����ϴ� �ݺ����� ���� ������.=>Error if���̸� �ݺ������?
			}//end if
		System.out.println("");
		}//end for
		//for �� i�� ������ �������� �ʴ´�. HDD�� ������ ���� ???
		
		//�������� �ʱⰪ�� ����ϴ� for
		for(int i=0,j=10,k=30; i<10 && j==30; i++,j++,k--) {
			//<�׳���(�ĸ��δ�) �������� &&�����ڷ� i<10 && j==30 �ٿ��ټ� �ִ�.
			System.out.println(i+" "+j+" "+k);
		}//end for
	
	
		//���ǽ��� �߸� �����ϸ� ����loop
//		for(int i=0; i<10; i--) {
//			System.out.println(i);
//		}//end for ������ �־����� ���ǿ� �´� �ڵ尡 �ƴ϶� ���ѷ���.
		
		
		int i=0;
		for(i=0;i<10;i++);{	//<�����ݷ��� ����־� ���� ������ ���� �����Ѵ�.(���������� �����ѵ�)
			System.out.println("�ݺ��� " +i);//�̷��� �����ݷ��� �߸� ���� ��찡 �߻��ϱ⵵ �Ѵ�.
		}//<�߰�ȣ�� �ν��Ͻ� �����̶�°� ���߿� �˰Եȴ�.
	
	
		
	}//main
}//class
