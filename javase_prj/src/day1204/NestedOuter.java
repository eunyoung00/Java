package day1204;

/**
 * ����Ŭ������ static ����ó�� ����� �� �ִ� ��øŬ����.
 * @author owner
 */
public class NestedOuter {
	
	int i;
	static int j;
	
	public NestedOuter() {
		System.out.println("�ٱ� Ŭ������ ������");
	}//NestedOuter
	
	public void outInstMethod() {
		System.out.println("�ٱ� Ŭ������ instance method");
	}//outInstMethod

	public static void outStatMethod() {
		System.out.println("�ٱ� Ŭ������ static method");
	}//outStatMethod
	
	/*--------------Nested class ����-------------------------*/
	static class NestedInner{
		//<Ŭ���� ���������ڰ� static�̶�� ������ ������ static�ΰ��� �ƴ�.
		//<�⺻�� instance���� �ΰ�.
//		int in_i;//instance ���� (�ν��Ͻ� ����)//<���夤��
		static int in_j;//static ����
		
//		public NestedInner() {
//			//������� �ִµ�, ���� ���� �ʴ´�.
//			//<���� Ŭ������ �ڿ��� �������̸� static���� ����� ����ϱ� ������ ����Ҽ� ������
//			//<�ν��Ͻ�ȭ�� �ʿ��ؼ� ���������� ���߿����� ��������. 
//		}//NestedInner
		
		public void inMethod() {
			System.out.println("���� Ŭ������ instance method");
		}//inMethod
		
		public static void inStatMethod() {
			System.out.println("���� Ŭ������ static method");
			System.out.println("���� Ŭ�������� �ٱ� Ŭ������ �ڿ� ���. i=���Ұ�, j="
								+j/*j==NestedOuter.j*/);
			//<i�� �ƹ��� ����Ŭ������� ������ static���������� ���Ұ�
//			outInstMethod();//Error=>instance������ method�̹Ƿ� ����� �� ����.
//			outStatMethod();//<��� �����ϳ� �����ϸ� ��ó �����°� ����
			NestedOuter.outStatMethod();//�̷���~
		}//inStatMethod
	
	
	}//class
	/*--------------Nested class ��  -------------------------*/

	public static void main(String[] args) {
		//static ������ ����� ������, ��üȭ ���� Ŭ������.������, 
		//Ŭ������.method������ ����Ѵ�.
//		instatMethod();//<������ ���ٰ� ���������� �θ������Ѵ�.inner class�̱� ������.
		NestedInner.inStatMethod();//<static->instance�� �ݵ�� ��üȭ!
		//<���������̱� ������ Ŭ������.method������ ��밡���Ѱ�.
	}//main
}//class
