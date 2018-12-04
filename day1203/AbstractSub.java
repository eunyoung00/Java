package day1203;

/**
 * �߻� Ŭ������ �θ�� �ϴ� �ڽ�Ŭ����<br>
 * �ڽ�Ŭ������ �ݵ�� �θ�Ŭ������ ��� �߻�method�� �ݵ�� Override�ؾ��Ѵ�.
 * @author owner
 */
public class AbstractSub extends AbstractSuper{
	
	
	public void subMethod() {
		System.out.println("�ڽ� method!!!!");
	}//subMethod
	
//	public abstract void absMethod();//�߻� class������ ���ǰ���
	@Override
	//Override ��Ģ : ���������ڴ� �޶� �ǰ�(������) ��ȯ��, method�� �Ű������� ���ƾ� �Ѵ�.
	public void absMethod() {
		//�߻� method�� super�� ȣ���� �� ����. <�ҷ����� ���� �Ҽ� ���
//		absMethod();//���ȣ��
//		super.absMethod();//Error=>�ҷ����� ���� �Ҽ� ���
		//<�Ϲݸ޼ҵ�� �󸶵��� super�� �θ��� �ִ�.
		System.out.println("Override�� �ڽ��� absMethod");
	}//absMethod
	
	@Override
	public String absMethod1(int param_i) {
//		return param_i+"";//O
		return String.valueOf(param_i).concat("-�ڽ�");
	}//absMethod
	

	public static void main(String[] args) {
		//�ڽ�Ŭ������ ��üȭ�Ǹ�, �߻�Ŭ������ ��üȭ�� �ȴ�.
		//<�ڽ�Ŭ������ �����ʰ�� �ɼ�����.
		//<�߻�Ŭ������ super�� �θ��� ����.
		AbstractSub as = new AbstractSub();
		//�ڽ�Ŭ������ ��üȭ : �θ��� ����,method,�ڽ��� ����,method ��.
		//<�̸��� ���ٸ� �ڽ��ǰ� ���.
		
		as.i=12;//�θ��� ����
		as.method();//�θ��� method
		
		//Override�� method�� �ڽĿ��� ������ ���̹Ƿ� �ڽ��� method�� ȣ��ȴ�.
		as.absMethod();//���� �̸����� �����Ѵٸ� �ڽ��� methodȣ��.
		System.out.println(as.absMethod1(3));//���� �̸����� �����Ѵٸ� �ڽ��� methodȣ��.
		as.subMethod();

		//is a ������ ��üȭ : ��ü�������� �������� ��üȭ
		
		//�θ�Ŭ������ ��ü�� = new �ڽĻ�����();
		AbstractSuper as1 = new AbstractSub();
		//�θ��� �ڿ� ȣ�� ����
		as1.i=100;//<as1.���� �ڿ� ���ü� �ִ°� Super�� ObjectŬ�������� ����.
		as1.method();//<�θ��� ���� �ϴ� �Ϲ� method
		
		//Override�� method�� �����Ѵٸ� �ڽ��� method�� ȣ�� �� �� �ִ�.
		//�߻� method�� body�� ������ ȣ���ϰԵǸ� �ڽ��� method�� ȣ��ȴ�.
		as1.absMethod();//<Override�� �ڽ��� absMethod
		System.out.println(as1.absMethod1(2018));
		
		//is a ����� ��üȭ �ϸ� �ڽ��� ���� method�� ȣ�� �Ұ�.
//		as1.subMethod();//<Error=>�����Ұ���. Override�Ѱ͸�.
		
		//<�ڽ��� ���ؼ��� ��üȭ�� �ɼ� �ִ�.
		
		
		
		
	}//main
}//class
