package day1218;

public class ConstructorThrowsSub extends ConstructorThrows{

	//�θ�Ŭ������ �����ڰ� ������ ���ܸ� ������ �ڽ�Ŭ������ �����ڿ����� (����?)���ܸ� ������ �Ѵ�. <<����̸�~!>>
	public ConstructorThrowsSub() throws ClassNotFoundException {
//		super();//���⼭�� try~catch�� super�� ù��° ���� �ȵű� ������ �����־�� �Ѵ�. 
//		try {
//			super();//super�� �������� ù��° �ٿ����� ����� �� �����Ƿ� �θ�Ŭ������ �����ڰ� Compile Exception�� throws�� ������
					//�����ڸ� ȣ���ϴ� �ڽ�Ŭ���������� �ݵ�� ���ܸ� ó���ؾ��ϴ� ������ ������ �߻��ϰ� �ȴ�. 
//		}catch(ClassNotFoundException cnfe) {
//			
//		}
		super();
		//<�����ڿ��� ����ó���ϴ� ���� ���� ������ �ϰԵȴٸ� �ڽĿ����� ���־�� �Ѵ�. 
		
	}//ConstructorThrowsSub
	public static void main(String[] args) {
		
	}//main
}//class
