package day1130;

/**
 * Override(Overriding)
 * �θ�Ŭ������ �����ϴ� ����� �ڽ�Ŭ������ ���� �ʴ´ٸ� �ڽ�Ŭ�������� �θ�Ŭ������ method�� ������ method�� 
 * �����Ͽ� ����ϴ°�.
 * @author owner
 */
public class OverrideToString {
	
	@Override//�� �̰� �׷�����̾���...���...
	public String toString() {
//		toString();//Error, �θ��� toString �̾�,,,,
		
		return "�ּҰ� �ƴ϶� OverrideToString Ŭ����"+super.toString();//super.toString() �θ��� �ּ�
		//�׳ɛ����� ���ȣ��
	}//toString

	
}//class
