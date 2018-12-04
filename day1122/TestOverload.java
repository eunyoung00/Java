package day1122;

/**
 * ������ : method Overload<br>
 *   �ϳ��� Ŭ�������� ���� �̸��� method�� ������ �ۼ��ϴ°�<br>
 *   ��Ģ) ���������� ��ȯ�� method���� �����ϰ�  �����,
 *       �Ű������� �ٸ��� �ۼ�.
 * @author owner
 */
public class TestOverload {
	
	/**
	 * ���� �ϳ� ����ϴ� ��
	 */
	public void printStar() {
		System.out.println("��");
	}//printStar
	
//	public void printStars() {
//		����ڴ� s�� �ٿ� ���� ���������� �ƴ��� �˼� ����
//	}//printStar
	
	/**
	 * �ԷµǴ� ���� ���� ���� ������ ����ϴ� ��
	 * @param count ����� ���� ����
	 */
	public void printStar(int count) {
		for(int i=0; i<count; i++) {
			System.out.print("��");
		}//end for
	}//printStar

	/**
	 * ������ 3���� ����ϴ� method
	 */
	public void gugudan() {
		for(int i=3;i<4;i++) {
			for(int j=1;j<10;j++) {
				System.out.println(i+"*"+j+" = "+i*j);
			}
		}
	}
	
	/**
	 * �Է��ϴ� ���� 2~9�� �����϶� �ش���� ����ϴ� method<br>
	 * ������ 3�� method�� overload�Ͽ� ����
	 * �޼ҵ�ȿ� �޼ҵ带 ����� ��ø���Ǵ� ���� �ʴ´�.
	 * @param i 2~9���� 
	 */
	public void gugudan(int i) {
		if(i>1 && i<10) {
			for(int a=i;a<10;a++) {
				for(int j=1;j<10;j++) {
					System.out.println(a+"*"+j+" = "+a*j);
				}
			}
		}else {
			System.out.println("���� 2~9������ ���ڸ� �Է°����մϴ�.");
		}
	}
	
	public static void main(String[] args) {
		TestOverload to = new TestOverload();
		//�� ������(5) ���
		to.printStar(5);
		//�� 1�� ���
		to.printStar();//ctrl�� ������ Ŭ������ �ٿ��� ã�ư�
		
		//������ 3���� ����ϴ� method
		to.gugudan();
		
		//�Է��ϴ� ���� 2~9�� �����϶� �ش�ܺ��� 9�ܱ����� ����ϴ� method
		to.gugudan(8);
		
	}//main
}//class
