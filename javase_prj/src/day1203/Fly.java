package day1203;

/**
 * ���� �� ���� ��.<br>
 * ���� ���� �ӵ�, ���̸� ������. 
 * @author owner
 */
public interface Fly {
	/**
	 * ���� �ӵ�
	 * @param speed
	 * @return
	 */
	public abstract String speed(String speed);

//	protected String height(String height);
	//<interface�� �߻�޼ҵ�� public�� �����ϴ�.
	
	/**
	 * ���� ����
	 * @param height
	 * @return
	 */
	public String height(String height);
	
}//interface
