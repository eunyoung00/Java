package day1203;

/**
 * ���� Ŭ����(�ڽ�Ŭ����)���� �ݵ�� �����ؾ��ϴ� ���� ��ϸ� �����ϴ� interface�� ����.
 * (������ ������)
 * @author owner
 */
//interface�� �θ� ������ ���� �� �ִ�.
public interface SuperInterface extends InterA,InterB{
	//��� Constant : ������ ���ó�� ���.
//	int i;//������ �ۼ��� �� ����.Error =>����� ������ ���� �ʴ´�.
	public static final int FLAG_VALUE=12;
	
	//�߻� method ����
	//�Ϲ� method�� ���� �� ����. Error
//<	public void test() {} <"{}"�̺κ� body�� ������ ����.

//	�������̽��� ��ӿ��� �߻� method�� Override���� �ʴ´�.
//	//�����Ҽ� ������ ���� body����� �Ȱ��� method�� ���ѹ� ����°Ϳ� ��ģ��.
//	@Override
//	public String msg();//�����ʴ´�.�غ��� �ո� ����--
	
	//abstract�� ������� �ʾƵ� �ȴ�.
	public void mehtodA();
	//abstract�� ����ص� �ȴ�.
	public abstract void methodB(int i);
	
	

}//interface
