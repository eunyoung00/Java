package day1121;

/**
 * static(class)���� : &gt;���뺯��, � �������� �������� ��������
 *                   Ŭ������ ����Ǹ� ���� ó�� �޸�(method)�� �ö󰡰�, 
 *                   ��� ��ü�� �ϳ���  ������ �����Ͽ� ����� ���� 
 * 
 * @author owner
 */
public class UseStaticVariable {
	static int i;	//static variable(����) => �ٷλ��.
	int j;	//instance variable(����) => ��üȭ �Ͽ� ���.
	
	public void test() {
		i=100;
		j=200;
		System.out.println(i+" / "+j);
		
	}//test

	public static void main(String[] args) {
		//static int i;//���������� ���������ڰ� ������ ����.
		
		//class �������. Ŭ������.������
		UseStaticVariable.i = 2000;
		//i=100; ���� �������� ����
		System.out.println(i+"/"+UseStaticVariable.i);//�Ѵ� ����
		
		UseStaticVariable usv = new UseStaticVariable();
		UseStaticVariable usv1 = new UseStaticVariable();
		usv.j = 5000;//instance ������ ������ ��ü�� ���� ����Ѵ�.
		usv1.j = 10000;
		
		UseStaticVariable.i=20;
//		usv.i=20;//�ٹٲ�����..���뺯���� �ٶ������� �ʴ�.
		//��ü������ ����ϸ� Ư�� ��ü�� ����(member ����)�� �ƴϹǷ� ����� ���������� �����ϴ� ������
		//�ƴϴ�.
//		System.out.println("usv��ü �ν��Ͻ����� : "+usv.j+", static ����"+usv.i);
		System.out.println("usv��ü �ν��Ͻ����� : "+usv.j+", static ����"+UseStaticVariable.i);
//		System.out.println("usv1��ü �ν��Ͻ����� : "+usv1.j+", static ����"+usv1.i);
		System.out.println("usv1��ü �ν��Ͻ����� : "+usv1.j+", static ����"+UseStaticVariable.i);
		
		
//		j=200;//static ������ �ƴ϶� ���� ����
//		System.out.println(i+" / "+j);

	}//main
}//class
