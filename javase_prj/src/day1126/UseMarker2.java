package day1126;

/**
 * ��ī���� ������ Ŭ������ ����ϴ� Ŭ����.<br>
 * 4.��ü ����<br>
 * 5.������ ��ü ���
 * @author owner
 */
public class UseMarker2 {

	public static void main(String[] args) {
		//������ ��ī�� 1�� ����
		Marker2 black = new Marker2();
//		System.out.printf("������ ��ī�� ��[%s], �Ѳ�[%d], ��ü[%d]",
//				black.getColor(),black.getCap(),black.getBody());
		//<   =>�ڵ��ʱ�ȭ�� �� ����

//		black.setColor("������");
//		black.setCap(1);
//		black.setBody(1);
		
		
		
		System.out.printf("������ ��ī�� ��[%s], �Ѳ�[%d], ��ü[%d]\n",
				black.getColor(),black.getCap(),black.getBody());
		
		//������ ��ü�� ���
		System.out.println(black.write("�ȳ��ϼ���?"));
		System.out.println("----------------------------------");
		
		Marker2 red = new Marker2("������",5,5);
		
		//������ ��ī�� ��ü�� 5�� ������ ���� ���
/*		Marker2 red = new Marker2();
//		red.color = "������";//<�̷��� ���������
//		red.color = "���";//<�ƹ��ų� ������.
		//���������ڰ� public�̶�� �ܺο��� ���� ���������Ҽ� �����Ƿ� �߸��Ȱ��� �Էµ� �� �ִ�.
//		red.setColor("������");
		red.setColor("���");//<������ ���� ��� �������� ������ �ȴ�.
		//<������ �� ����~!~!
		//=>color�� ĸ��ȭ�Ͽ� �ۿ��� �Ⱥ��̴�??? private�� �ϰ� �Ȱ�
		//<���������ڷ� ĸ��ȭ
		red.setBody(5);
		red.setCap(5);
*/
		System.out.printf("������ ��ī�� ��[%s], �Ѳ�[%d], ��ü[%d]\n",
				red.getColor(),red.getCap(),red.getBody());
		System.out.println(red.write("������"));
		
	}//main
}//class
