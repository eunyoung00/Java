package day1204;

/**
 * method�ȿ� Ŭ������ �����ϴ� ����class�� ���.<br>
 * ������ ��ü�� ��������ó�� ����ϴ� Ŭ����.
 * @author owner
 */
public class LocalOuter {
	int i;
	
	public LocalOuter() {
		System.out.println("�ٱ� Ŭ������ ������");
	}//LocalOuter
	
	public void method(int param_i, final int param_j) {
		//�Ķ���ʹ� �� ���������� ����. �޼ҵ� �ȿ��� ����?�����Ǿ� ���Ǵ� ����
		int local_i=0;//<�̾ȿ��� ������������� �ۿ��� ������� warning<��~�������
		final int local_j=0;
		/*-------------- Local class ����-------------------------*/
		//<method �ȿ��� mehtod�� ������µ�, class�� ����.=>����class
		class Local{//<��üȭ ���� ������ �ۿ��� ������� Ŭ������ �θ� warning
			int loc_i;
			
			public Local() {
				System.out.println("���� Ŭ������ ������");
			}//Local
			public void locMethod() {
				System.out.println("���� Ŭ������ method loc_i="+loc_i);
				System.out.println("�ܺ� Ŭ������ �ν��Ͻ� ���� i="+i);//����.
				//������ final�� ���� �Ű������� ����Ҽ� �ִ�.
				//<   ->JDK 1.8���� final�Ⱥپ ���Ǽ� ���鿡�� ��밡������.
				System.out.println("�Ű�����(Parameter) param_i="+param_i
									+", param_j="+param_j);
				//������ final�� ���� ���������� ����� �� �־���...
				//JDK1.8���������� final�� ���� ��������,�Ű������� ����� �� �ִ�.
				System.out.println("�������� local_i="+local_i+
									", local_j="+local_j);
				//<1.7:local_i=>Cannot refer to the non-final local 
				//<variable local_i defined in an enclosing scope
//				local_i=2018;//JDK 1.8�������ʹ� final�� �پ��������� ����������
				//����� ���������� �� �Ҵ��� ���� �ʴ´�.
				//<final�� �پ����� �ʴ��� finaló�� ���Ե�
				
			}//locMethod
		
		}//class
		/*-------------- Local class ��  -------------------------*/
		///////�߰� : ����Ŭ������ ��üȭ
		Local lo = new Local();
		//<���� Ŭ������ ������ �� �߰���.
		//������ ��ü�� Ŭ���� ���� �ڿ��� ����� �� �ִ�.
//		loc_i=100;//Error<�׳��� ������~
		//<������ ��ü�� ���.
		//���� �������� �������Ұ�.
		lo.loc_i=100;
		lo.locMethod();
		
		System.out.println("�ٱ� Ŭ������ method ȣ��");
	}//method
	
	public static void main(String[] args) {
		LocalOuter lo = new LocalOuter();
		lo.method(12, 4);
		//<�̽����� ��� : �ٱ� Ŭ������ ������ & method ȣ��
		//<�޼ҵ带 �ҷ��ٰ� �����ڰ� �ҷ������� �ʴ´�(��üȭ�� �ȵ�)
		//<����Ŭ������ �������Ѵٸ� �޼ҵ忡�� ��üȭ�� ���־�� �Ѵ�.=>"����Ŭ������ ��üȭ"�κ�
		
	}//main
}//class
