package day1218;

import java.util.Random;

/**
 * Throw : ���ܸ� ������ �߻�
 * @author owner
 */
public class TestThrow {

	/**
	 * ���� ���ٰ� ��踦 �ǿ�� �л��� ���� ���ǻ�ȸ�� �����Ѵ�.
	 */
	public void teacksung() throws Exception {
		String[] grade= {"�ʵ��л�","���л�","����л�"};
		String randomGd=grade[new Random().nextInt(grade.length)];
		
		if(randomGd.equals("�ʵ��л�")) {
//			try {//try~���ϸ� ȥ�ڸ� �˰��־� ȥ�ڼ����� �̾߱� �ѰͰ� �ٸ��� �ʱ� ������ throws�� �����ش�.
				throw new Exception(randomGd+"��Ե� �ݿ��ؾ��ϴ� �κ� ������?");
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
		}else {
			System.out.println(randomGd+ "�� ��踦 �ǿ�� ��ô ��������.(\" )( \")");
			
		}//end else
	}//teacksung
	
	public void teacksung2() /*throws TobaccoException =>Runtime���ܴ� throws���� �ʾƵ� ������ ����.������ Compile���ܴ� ����~!ó���� �־���Ѵ�.*/{
		String[] grade= {"�ʵ��л�","���л�","����л�"};
		String randomGd=grade[new Random().nextInt(grade.length)];
		
		if(randomGd.equals("�ʵ��л�")) {
//			try {//try~���ϸ� ȥ�ڸ� �˰��־� ȥ�ڼ����� �̾߱� �ѰͰ� �ٸ��� �ʱ� ������ throws�� �����ش�.
//				throw new TobaccoException(randomGd+"��Ե� �ݿ��ؾ��ϴ� �κ� ������?");
				throw new TobaccoException();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
		}else {
			System.out.println(randomGd+ "�� ��踦 �ǿ�� ��ô ��������.(\" )( \")");
			
		}//end else
	}//teacksung2
	
	public static void main(String[] args) {
		TestThrow tt= new TestThrow();
		try {
			tt.teacksung();
		} catch (Exception e) {//�������� ��Ȯ�ϰ� ���ܰ� �߻��Ѱ����� �˼� ����..���� ȭ���������� �˼� ����.
			e.printStackTrace();
		}//end catch
		
		System.out.println("-------------------------------------------");
//		try {
			tt.teacksung2();
//		} catch (TobaccoException te) {
//			te.printStackTrace();
//		}//end catch
			
			/*�̷��� ������ ��Ʈ�� �߸��� �ִ�. println�� �ٷ� �ٷ� ����̶�~!
			java.lang.Exception: �ʵ��л���Ե� �ݿ��ؾ��ϴ� �κ� ������?
					-------------------------------------------
					���л��� ��踦 �ǿ�� ��ô ��������.(" )( ")
						at day1218.TestThrow.teacksung(TestThrow.java:20)
						at day1218.TestThrow.main(TestThrow.java:50)*/
	}//main

}//class
