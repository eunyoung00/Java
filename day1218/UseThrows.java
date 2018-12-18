package day1218;

import java.util.Random;

/**
 * throws)
 * method������ �߻��� ���ܸ� method�� ȣ���� ������ ó���ϴ� throws�� ���.
 * @author owner
 */
public class UseThrows{
	public void test() throws ClassNotFoundException {
		//throws�� ���ܸ� ������ method�ȿ� try~catch�� �� �ʿ䰡 ����.
		String className="day1217.UseRuntimeException";
//		System.out.println("Ŭ���� field : "+obj);
		if(new Random().nextBoolean()) {
			className="java.lang.Integer";
		}//end if
		
		Object obj=Class.forName(className);
		System.out.println("Ŭ������ �ε��Ǿ����ϴ�. "+obj);
	}//test
	
	
	public static void main(String[] args) {
		UseThrows ut=new UseThrows();
		try {
			ut.test();//method�� ȣ���Ͽ� ���� �����ϴٺ��� ������ �߻��� ���� �ִ�.=>try~catch
		} catch (ClassNotFoundException cnfe) {
			System.err.println("�˼��մϴ�.");
			cnfe.printStackTrace();
			System.out.println("�������");
		}//end catch
	}//main

}//class
