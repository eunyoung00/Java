package day1218;

/**
 * Compile Exception : byte code�� ���������� �����ϱ� ���� ��.
 * �����ڰ� �ݵ�� ���ܻ�Ȳ�� ó���ؾ��ϴ� ����.(���������� Error)
 * @author owner
 */
public class UseCompileException {

	public static void main(String[] args) {
		//<�ٸ�Ŭ������ ����Ϸ��� new �� �ؾ��ϴµ�, new �����ʰ� ��ü�� ��� ���� �ִ� ������ִ�.
		//<forName(String className)  ����~! java.lang.reflect.Method?�� �ҷ�??
		//<Ŭ������ ���������� (��Ÿ)�� ��츦 ����ؾ��Ѵ�.
		try {
//			Object obj/*Class c�� �θ����� ����*/ =Class.forName("java.lang.String");
			Object obj =Class.forName("day1217.UseRuntimeException");//sum�翡�� ����͵�,��������͵� ����.
			//<ClassNotFoundException ó���ؾ�~!�Ѵ�~!Error
			System.out.println("�ε��� Ŭ���� "+obj);//new�� ���� �ʾƵ� ��ü�� ���� �ִ�.
		} catch (ClassNotFoundException cnfe) {
			System.err.println("�˼��մϴ�.");//<����ڿ��� ���������� ������ �������� �ʴ´�.(���������� ����� �� �־)
			System.err.println("���� �޼��� ��� : "+cnfe.getMessage());
			System.err.println("����ó�� ��ü�� �޼��� : "+cnfe);
			cnfe.printStackTrace();//<�ſ��: stack�� ���� ��ô�� ���, println�� ���� ���� ���߿� ������ ��¼����� ���ϼ� �ִ�.
//			System.out.println("---5465465fgd65f");//<��ô�ϴ� ������ �� ������ ����
			//pirntln�� printStackTrace���� ���� ��µȴ�.
			//<�󼼸޼��� �߿� �����ۼ��� Ŭ������ ã���� �ȴ�.
			
			//<<����ڿ��Դ� �˼��մϴٸ� ���� printStackTrace�� ���� ���ÿ� �����ش�~!~!
			//<<��Ÿ�ӿ����� �� ��ư�,����ó�� �ÿ� ���� ����θ� �ǹ̰� ������ ��ó���� �ش�.
		}finally{
			System.out.println("����� �ּż� ����");
		}//end catch

	}//main
}//class
