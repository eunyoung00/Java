package day1126;

/**
 * method�� �Ű������� ������ �������� (class, ���ڿ�, array)�� ���
 * Arguments�� ������ ������ �ϳ��� �ּҰ� �Ҵ�ȴ�.<br>
 * (���� �����ϸ� ������ ��ü�� ���� ���� ����ȴ�.)
 * @author owner
 */
public class CallByReference {

	private int i;
	private int j;
	
	public void swap(CallByReference cbr) {//<�ּҰ� �״�� ����.
		int temp = 0;
		temp=cbr.i;
		cbr.i=cbr.j;
		cbr.j=temp;
		System.out.println("swap method�� i="+i+", j="+j);
	}//swap
	
	public static void main(String[] args) {
		CallByReference cbr = new CallByReference();
		cbr.i=11;
		cbr.j=26;
		System.out.println("swap�� i="+cbr.i+", j="+cbr.j);
		//<static method������ instance������ �������� ���ұ?
		//<������ ���� �ȵ��� ����ƽ�� ���� �����Ǵ� �ֺ��̶� ����?
		//<����ƽ ������ ���α׷��� ���۵ɶ� �������, �ν��Ͻ��� ������ ���� �ʾұ� ������ �������� ����.

		cbr.swap(cbr);//�ּҰ� �״�� ���޵�
		System.out.println("swap�� i="+cbr.i+", j="+cbr.j);
	}//main
}//class
