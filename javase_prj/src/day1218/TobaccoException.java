package day1218;

/**
 * ��������� ����ó�� Ŭ���� )
 * @author owner
 */

//1.Exception�̳� RuntimeException�� ��ӹ޴´�. 
@SuppressWarnings("serial")
public class TobaccoException extends RuntimeException{
	
	public TobaccoException() {
		super("��� ����-����� ���� ��! �׷��� �ǿ�ðڽ��ϱ�?");
//		this("��� ����-����� ���� ��! �׷��� �ǿ�ðڽ��ϱ�?");//this�͵� ����. ������~!
	}
	public TobaccoException(String msg) {
		super(msg);
	}
}//class
