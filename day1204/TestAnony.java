package day1204;

/**
 * �������̽�(�߻�Ŭ������ Ŭ������ ����)�� method�� �Ű������϶� �����ϰ� ����ϴ� ���.<br>
 * (((�����ϰ� ���������� 1ȸ��. ���뼺 ��. 1ȸ��..)))<br>
 * 
 * @author owner
 */
public class TestAnony {
	public void useAnonyInter(AnonyInter ai) {
		System.out.println(ai.getMsg()+" "+ai.getName());
	}//useAnonyInter
	
	public static void main(String[] args) {
//		AnonyInter ai = new AnonyInter(); //��üȭ�� �ȵȴ�.
		//�������̽��� ���� �ִ°� ���, abstractor method
		//Ŭ������ �� �� �ִ°� ������ method.
		
		//1.�������̽��� ������ Ŭ������ ����.=>AnonyImpl�����.
		//2.����Ŭ������ ��ü�� ����.
		AnonyInter ai = new AnonyImpl();//is a ������ �ν��Ͻ�ȭ.
		//AnonyInter ��� AnonyImpl�� ����.
		//3.�Ű������� ���� method�� ȣ���ϱ� ���� ��ü�� ����.
		TestAnony ta = new TestAnony();
		//4.method�� ȣ��
		ta.useAnonyInter(ai);//�ڽ��̶� �ڵ����� ��
		ta.useAnonyInter(ai);//������ ȣ���Ϸ��� �� �����̸� �Ǵµ�,
		//====> ������.
		
		
		//�׷��� ���°� anonymous inner class�̴�~!~!
		System.out.println("-------------- anonymous innerclass---------------");
		//anonymous inner class�� ����ϸ� Ŭ������ ���� �����ʿ䰡 ����.
//		ta.useAnonyInter(new AnonyInter());//<�Ϲ����� �ν��Ͻ�ȭ�ε�,
//		//<�������̽��� ��üȭ�� ���� �ʴ´�.
		ta.useAnonyInter(new AnonyInter() {//<�� ��ȣ���� �θ� AnonyInter�� �ȴ�.
			@Override
			public String getName() {
				return "������"+test();
			}//getName
			
			@Override
			public String getMsg() {
				return "������";
			}//getMsg
			
			public String test() {
				return "�ڽ� method";
			}//<�������� override�� �ֿ켱������ �θ��°����� ��� �ۿ��� �θ��� ����.
		});
		
		ta.useAnonyInter(new AnonyInter() {
			@Override
			public String getName() {
				return "������"+test();
			}//getName
			
			@Override
			public String getMsg() {
				return "������";
			}//getMsg
			
			public String test() {
				return "�ڽ� method";
			}
		});
		//������ �Ϸ��� ���ڵ带 �� �ѹ��� �����..(���ѹ��θ����� ����,�������� ����)
		
	}//main
}//class
