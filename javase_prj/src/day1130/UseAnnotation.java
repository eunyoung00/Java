package day1130;

import java.util.ArrayList;
import java.util.List;

/**
 * JDK 1.5���� ���� �߰��� annotation�� ���.<br>
 * Deprecated, Override, SuppressWarnings<br>
 * ������ 1.7���� ���Դ�
 * @author owner
 */
public class UseAnnotation {
	
	/**
	 * �� method�� �ڶ� ������ �߻���ų�� �ֽ��ϴ�.(�ƴҼ���)
	 */
	@Deprecated //��, �����ϱ� �޼ҵ���� -�׾�����. //������ �־�̴ϱ� ������~
	public void test() {
		System.out.println("�������� �ϴ� method");
		System.out.println("���Ŀ� ������ �߻��� method");
	}//test
	
	@Override
	public String toString() {
		return "�´����ʸ�";
	}
	
	@SuppressWarnings({"rawtypes","unused"})
	//method���� �����ϸ� method���� ��� ��� ��Ȳ�� �����Ѵ�.
//	@SuppressWarnings("unused")
	public void temp() {
		//unused : ������ ������� ���� �� ��� ����.
//		@SuppressWarnings("unused")
		int i=0;//��� ���� �ʴ°ͺ���, ����ų� �ϴ°� ����.
		
		//rawtypes : Generic�� ������� ������ ��� ����.
//		@SuppressWarnings("rawtypes")
		List l = new ArrayList();
		
		
		//rawtypes : Generic�� ������� ������ ��� ����.
//		@SuppressWarnings({"rawtypes","unused"})
		//�������� �����ϸ� �ٷ� �Ʒ��ִ� ������ ��� �����ϰ�, 
		List ll = new ArrayList();
		
		int j=0;
		System.out.println("temp j="+j);
	}
	

	public static void main(String[] args) {
		UseAnnotation ua=new UseAnnotation();
		ua.test();
		System.out.println(ua);

	}//main
}//class
