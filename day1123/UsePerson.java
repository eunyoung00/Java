package day1123;

/**
 * ����� �߻�ȭ�Ͽ� ���� Person Ŭ������ ����ϴ� Ŭ����
 * @author owner
 */
public class UsePerson {

	public static void main(String[] args) {
		//��ü ����  :heap�� �����ǰ� instance������ �ڵ� �ʱ�ȭ.
		//<heap�� ���� �ּҸ� stack�� ��´�
		Person teacksung = new Person();
		//������ ���������� Person�� heap�� �ּҸ� ������ �ִ�.
		System.out.println("��ü�� ����ϸ� �ּҰ� ���"+teacksung);
		//<day1123.Person@1db9742
//		System.out.format("������ ��� ��ü ���� ��[%d],��[%d],��[%d],�̸�[%s]\n"
//				,teacksung.getEye(),teacksung.getNose(),teacksung.getMouth()
//				,teacksung.getName());
		teacksung.setName("���ü�");
		teacksung.setEye(2);
		teacksung.setNose(1);
		teacksung.setMouth(1);
		System.out.format("������ ��� ��ü ���� ��[%d],��[%d],��[%d],�̸�[%s]\n"
				,teacksung.getEye(),teacksung.getNose(),teacksung.getMouth()
				,teacksung.getName());
		//������ ��ü���� ���ǵ� ���� ���.
		System.out.println(teacksung.eat());
		System.out.println(teacksung.eat("��ȸ�����",8000));
		
		System.out.println("-------------------------------------------");
		Person jinban = new Person();
		jinban.setName("õ����");
		jinban.setEye(3);
		jinban.setNose(1);
		jinban.setMouth(1);
		
		System.out.println(jinban.eat());
		System.out.println(jinban.eat("����",1));
		
//<		System.out.println("��ü�� ����ϸ� �ּҰ� ���"+jinban);//�ּҰ� �ٸ��� �˼��ִ�.
	}//main
}//class
