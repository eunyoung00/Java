package day1203;

/**
 * interface�� �����ϴ� class(�ڽ� Ŭ�����̰� interface���� ��� �߻�method�� 
 * Override�ϴ� Ŭ����)
 * ���� interface�� �θ� interface�� �����ٸ� �������� �ڽ�Ŭ���������� 
 * ��� �߻� method�� �����ؾ��Ѵ�.
 * 
 * @author owner
 */
//<extends�ڿ��� class��.
//<extends SuperInterface=>Error.=>interface�̱� ������ implements
public class InterfaceImpl implements SuperInterface{
//<InterfaceImpl [extends object�� �����Ǿ�����.] implements
	
//<�� ���� �ִ� ��� �θ��� �߻� method�� ��� override
	//�� Ŭ������ �������� �������� �߻� method���ִٸ� ��� override�ؾ��ϴµ�,
	//interface�������� override�ص� �ƹ� �ҿ���⶧���� �ڽ��� �θ��������̽��� �߻�޼ҵ带 ���� ���� �ʴ´�.
	//<�غ��� �θ�� �Ȱ�����̶� ���� �ʴ´�.
	@Override
	public String msg() {//InterA
		return "������ ȭ����";
	}//msg
	
	@Override
	public String msgB() {//InterB
		return "������ ������";
	}//msgB
	
	@Override
	public void mehtodA() {//SuperInterface
		System.out.println("methodA");
		
	}//mehtodA
	
	@Override
	public void methodB(int i) {//SuperInterface
		System.out.println("methodB");
		
	}//methodB
	
	public void test() {
		
	}

	
	public static void main(String[] args) {
		//�ڽ� Ŭ������ ��üȭ : ��� mehtod�� ȣ���� �� �ִ�.
		//ii.msg(),ii.msgB(),ii.methodA(),ii.methodB(),ii.test()
		InterfaceImpl ii = new InterfaceImpl();
		ii.methodB(12);
		
		//is a ������ ��üȭ(�θ� �տ��ΰ� ��üȭ)
		//1.InterA 2.InterB 3.SuperInterface 4.��δ�    ������ 4!~!~!
		//<�� ��� �ٿ� �ִ°� ��� �� �ü� �ִ�.
		//SuperInterface�� ��üȭ�� �ϸ� Override�� method�� ȣ��.
		//�θ��� method�� ��� ȣ�� ����.
		//si.msg(),si.msgB(),si.methodA(),si.methodB()
		SuperInterface si = new InterfaceImpl();
		System.out.println(si.msg());
		
		//InterA�� ��üȭ �ϸ� ia.mag()�� ȣ�� ����.
		//<�տ� ���������� �����̳Ŀ� ���� ȣ�Ⱑ���� method�� �� ���ٸ���.
		InterA ia = new InterfaceImpl();
		System.out.println(ia.msg());
		
		//InterB�� ��üȭ �ϸ� ib.magB()�� ȣ�� ����.
		InterB ib = new InterfaceImpl();
		System.out.println(ib.msgB());
		
		//<is a ������ ��üȭ�� �����ڰ� �߿��Ѱ� �ƴ϶� ��Ƴ��� �������������� ȣ���� �޶����Ƿ�
		//<���������� �߿�
		//Object o = new InterfaceImpl();//��� �ڽ��� �� ������ �ִ�.
		//interface�� ��üȭ ���� �ʴ´�.
//		InterA ia1= new InterA();
//		SuperInterface si1 = new SuperInterface();
		//<interface�� �ڽ��� ���ؼ��� ��ü�� ���������.
		
	}//main

}//class
