package day0107;

/**
 * ����� ���� ����ó�� Ŭ����<br>
 * Exception(RuntimeException) �� ��ӹ޴´�.
 * @author owner
 */
@SuppressWarnings("serial")
public class LoginException extends Exception {//exception class�� �� Ŭ������ Exception�� �ٿ� Ȯ���� �˰� �����Ѵ�.
	
	public LoginException() {
		this("�α��� ����");
	}//LoginException
	
	public LoginException(String msg) {
		super(msg);//�̷��� ����ó�� ��ü�� ����Ͽ� ���� �޼����� ����� �� �ְԵȴ�.
	}//LoginException
}//class
