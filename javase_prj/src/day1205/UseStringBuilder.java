package day1205;

/**
 * StringBuffer, StringBuilder(JDK1.5)<br>
 * ���ڿ��� �޸𸮿�(heap�� ����)�����ϰ� ����ϴ� Ŭ���� <br>
 * @author owner
 */
public class UseStringBuilder {
	public void useStringBuffer() {
		//1.Ŭ������ ����
		StringBuffer sb = new StringBuffer();
		//2.��(����,�Ǽ�,����,boolean,���ڿ�,,,) �߰�
		sb.append("������ ");//���ڿ�
		sb.append(12);//����
		sb.append("�� 5�� ").append("������ �Դϴ�.");
		System.out.println(sb);
		System.out.println(sb.indexOf("��"));
		
		//3.�� ����
		//������ 12�� 5�ϼ����� �Դϴ�.(�ڿ� �մ°� append, ���̿� �����ϴ°� insert)
		//01 234567
		sb.insert(4, "2018��");
		System.out.println(sb);
		
		//4.�� ���� : delete(�����ε���, ���ε���+1) ������ ���ڿ��� �ڸ� ���ڿ�����
		//null�ڸ� ������ +1�� ���־�� �ν��ؼ� �ڸ��� �ִ�.
		//������ 2018��12�� 5�� ������ �Դϴ�.
		sb.delete(0, 3);
		System.out.println(sb);
//		sb.delete(0, sb.length());//�� ������ �߶󳾼��� �ִ�.
//		System.out.println(sb);
		
		//��������.
		sb.reverse();
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
		//�������ڿ��� ����ȴ�.

	}//useStringBuffer
	
	
	public void useStringBuilder() {
		//1.Ŭ������ ����
		StringBuilder sb = new StringBuilder();
		//2.��(����,�Ǽ�,����,boolean,���ڿ�,,,) �߰�
		sb.append("������ ");//���ڿ�
		sb.append(12);//����
		sb.append("�� 5�� ").append("������ �Դϴ�.");
		System.out.println(sb);
		System.out.println(sb.indexOf("��"));
		
		//3.�� ����
		//������ 12�� 5�ϼ����� �Դϴ�.(�ڿ� �մ°� append, ���̿� �����ϴ°� insert)
		//01 234567
		sb.insert(4, "2018��");
		System.out.println(sb);
		
		//4.�� ���� : delete(�����ε���, ���ε���+1) ������ ���ڿ��� �ڸ� ���ڿ�����
		//null�ڸ� ������ +1�� ���־�� �ν��ؼ� �ڸ��� �ִ�.
		//������ 2018��12�� 5�� ������ �Դϴ�.
		sb.delete(0, 3);
		System.out.println(sb);
		
		//��������.
		sb.reverse();
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
		
		//<�������ڿ��� ����ȴ�~!~!
		
	}//useStringBuilder

	public static void main(String[] args) {
		UseStringBuilder usb = new UseStringBuilder();
		usb.useStringBuffer();
		System.out.println("--------------------------------------");
		usb.useStringBuilder();
		
		
		
		String str="�ȳ��ϼ���?";//ª�� ���ڿ��� String �� �����Ѵ�.
		System.out.println(str);
		String str1="��";
		//���ڿ��� +�� �پ��� �� ���ڿ��� �ȴ�.
		System.out.println(str1+"��"+"��"+"��"+"��?");
		//new StringBilder().append(str1),append("��").append("��"),,,
		//String�� +���� �ʴ´�! �ӵ�����
		
		
	}//main
}//class
