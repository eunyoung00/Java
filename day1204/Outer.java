package day1204;

/**
 * 
 * @author owner
 */
public class Outer {
	int i;
	
	public Outer() {
		System.out.println("�ٱ� Ŭ������ ������");
	}//Outer
	
	public void outMethod() {
		System.out.println("�ٱ� Ŭ������ method i="+i);
//		System.out.println("���� Ŭ������ ���� j="+j);//Error
		//���� Ŭ������ ��üȭ
		Outer.Inner in = this.new Inner();//this: �ν��Ͻ� �ּҷ� ��ġ����.
		//this : �ڱ��ڽ��� ���ο��� ���� �����Ҷ�, ���� ȣ���Ҷ�.
		in.j=100;
		in.inMethod();
		
	}//outMethod
	
	/*--------------���� Ŭ���� ����------------------------*/
	public class Inner{
		int j;
		
		public Inner() {
			System.out.println("���� Ŭ������ ������");
		}//Inner
		public void inMethod() {
			System.out.println("���� Ŭ������ method�� j="+j+
								", �ٱ� Ŭ������ ���� i="+i);
//			outMethod();//�ٱ�Ŭ������ method�� ��밡��~//���ȣ��Ǿ� ����..
		}//inMethod
		//<Ư¡ : �ٱ�Ŭ������ �ڿ��� ������� ��밡��, �ݴ�� ������δ� �ƴ�.
		
	}//class
	/*--------------���� Ŭ���� ��-------------------------*/
	public static void main(String[] args) {
		//1.�ٱ� Ŭ������ ��üȭ
		Outer out = new Outer();
		//<������ ���� : "�ٱ� Ŭ������ ������" ��
		out.i=10;
		out.outMethod();
//		out.j=100;//Error=>���� Ŭ������ �ڿ��� ���������Ͽ� ����� �� ����.
//		out.inMethod();//Error=>���� Ŭ������ �ڿ��� ���������Ͽ� ����� �� ����.
		
		//2.���� Ŭ������ ��üȭ : 
		//<main�� �ٱ� Ŭ�����ϱ�, ���� �ڿ��� ����Ϸ��� ��üȭ�� �ؾ��Ѵ�~!~!
		//--�ٱ� Ŭ�������� ���� Ŭ������ �ڿ��� ����Ҽ� �ִ�.<<<<<<��üȭ�� �� �Ŀ�~~
		//�ٱ�Ŭ������.����Ŭ������ ��ü�� = �ٱ�Ŭ�����ǰ�ü��.new ���ʻ�����();
//		Outer.Inner in = new Inner();//e.g. x.new A(); where x is an instance of Outer
/*		�ٱ�Ŭ�������� ��üȭ �Ѱ� ���� ���� �����ܶ� �ּ�����.
		Outer.Inner in = out.new Inner();
//		Inner in = out.new Inner();//�ٱ� Ŭ�������� ������ �� �ִ�.
		
		in.j=12;
		in.inMethod();
*/		
		
	}//main
}//class
