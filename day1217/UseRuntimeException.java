package day1217;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * JVM�� �ڵ����� ���ܸ� ó���� �ִ� RuntimeException
 * @author owner
 */
public class UseRuntimeException {

	public static void main(String[] args) {

		//1.JTextArea ����( ���, �÷���)
		JTextArea jta = new JTextArea(10,40);
		jta.setEditable(false);
		jta.append("wow");
		//2.
		JScrollPane jsp=new JScrollPane(jta);
		//3.MessageDialog�� �ι��� �Ű������� ������Ʈ�� �Ҵ�
		JOptionPane.showMessageDialog(null, jsp);
		
		try {
		int num1=Integer.parseInt(args[0]);
		int num2=Integer.parseInt(args[1]);
		int result =0;
		
		result = num1/num2;
		
		System.out.println(num1+"/"+num2+"="+result);
		
		}catch (ArrayIndexOutOfBoundsException aioobe) {
//			System.err.println("�迭�� �ε����� �߸��Ǿ����ϴ�.");//err�� �ٲٸ� �۾��� ���������� ��µȴ�.
			System.err.println("��������... �߸��Ǿ����ϴ�.");//err�� �ٲٸ� �۾��� ���������� ��µȴ�.
			System.err.println("������ ���� : "+aioobe.getMessage());//1�� ��·�ٴ°��� �˼� ����...
			System.err.println("����ó�� Ŭ������� ���� : "+aioobe);
			aioobe.printStackTrace();//�ſ� �ڼ��� ���� 
			
		}catch (NumberFormatException nfe) {
			System.err.println("�Է°��� ���� ���°� �ƴմϴ�.");
			System.err.println("������ ���� : "+nfe.getMessage());
			System.err.println("����ó�� Ŭ������� ���� : "+nfe);
			nfe.printStackTrace();
		}catch (ArithmeticException ae) {
			System.err.println("0���� ���� �� �����ϴ�.");
			ae.printStackTrace();
		
		}catch (Exception e) {
			System.err.println("�����ڰ� �������� ���� ����."); //��翹�ܸ� ��´�..!
			e.printStackTrace();
		}//<�� ���ܸ� ����ó���ϰ� ������ĸ� : ���ܰ� �߻����������� �ĺ��ؼ� �ٸ��� ó���Ϸ���..
		finally {
			System.out.println("�ݵ�� ����Ǿ�� �� �ڵ�");
		}
		
		//�� ������3���� �ִµ�,
		// java.lang.ArrayIndexOutOfBoundsException: 0  =>��Ÿ�ӿ��� try catch ���ص� ��.
		// java.lang.NumberFormatException: For input string: "��"   =>����Ʈ����Ʈ���̽��� ���� �ڼ��� �����°�.
		// java.lang.ArithmeticException: / by zero =>
		
	}//main

}//class