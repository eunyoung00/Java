package day1203;

public class UseInstance {
	
	public TestSuper test1() {
		//<��� ������ ��üȭ .
		//is a ������ ��üȭ : �θ��� �ڿ���, �ڽ��� Overrride�� method ���.
		//�θ�Ŭ������ ��ü�� = new �ڽ�Ŭ����������();
		TestSuper ts = new TestSub();
		//<����ts�� TestSuper�� method ��밡��.
		return ts;	 
	}//test1
	
	public TestSuper test2() {
		//is a ������ ��üȭ : �θ��� �ڿ���, �ڽ��� Overrride�� method ���.
		//�θ�Ŭ������ ��ü�� = new �ڽ�Ŭ����������();
		TestSuper ts = new TestSub2();

		return ts;
	}//test2

	public static void main(String[] args) {
		System.out.println("--��Ӱ��迡���� �ڽ�Ŭ������ ��üȭ--");
		//<��Ӱ��迡���� �ڽ�Ŭ������ ��üȭ�� �Ѵ�.
		//�ڽ�Ŭ������ ��ü�� �����Ͽ� ���.
		//�ڽ�Ŭ������ ��ü�� = new �ڽ��ǻ�����(); �� �Ϲ���
		//�� ��ü�� ��밡���Ѱ�, �θ�Ŭ������ ����,method,�ڽ�Ŭ������ ����,method ��밡��.
		TestSub ts = new TestSub();
		ts.i = 100;  //�θ�� ���� �̸��� ������ �ڽ��� ���� ���.
		//<super�� static�����ȿ����� ���Ұ�.��ü�ȿ����� ���������� �ۿ����� �ڽ��� �� ���.
		ts.pMethod();//�θ��� method���.
		ts.subMethod();//�ڽ��� method ���.
		ts.printI();//�ڽ��� Override�� method�� ��� �ڽ��� methodȣ��
		
		System.out.println("----�θ��� �̸����� ��üȭ : ��ü ������----");
		//<�������� �޼ҵ� �������� ��ü ������ 2������ �ִ�.
		//��ü ������ : �����̸��� Ŭ������ �پ��ϰ� ����ϴ°�.
		//�θ� ����� �� ������ �ȴ�. 
		//<�ڽ��� 100���̻��̵� 1000���� �θ� �˸� �� �����ִ�.=>���Ǽ�
		UseInstance ui = new UseInstance();
		
		TestSuper ts1 = ui.test1();
		TestSuper ts2 = ui.test2();
		//<���� ��ü.. ���� Ŭ������ ���� ��ü�� �پ��ϰ� ���..=>��ü������
		//<�ڽ��� �����Ŀ� ���� �����̸��� �ٸ��� ���,
		//<<<�θ�Ŭ���������� �ڽ�Ŭ������ �����ڷ� ���� override�� ����� �پ��ϰ� ���� �ִ�.??
		//<<<�ڽ��� �θ��̱� ������ ?
		
		//Override�� method ȣ��
		ts1.printI();
		ts2.printI();
		
		
	}//main
	
}//class
