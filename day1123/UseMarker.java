package day1123;

/**
 * ��ī���� ������ Ŭ������ ����ϴ� Ŭ����.<br>
 * 4.��ü ����<br>
 * 5.������ ��ü ���
 * @author owner
 */
public class UseMarker {

	public static void main(String[] args) {
		//������ ��ī�� 1�� ����
		Marker black = new Marker();
//		System.out.printf("������ ��ī�� ��[%s], �Ѳ�[%d], ��ü[%d]",
//				black.getColor(),black.getCap(),black.getBody());
		//<   =>�ڵ��ʱ�ȭ�� �� ����

		black.setColor("������");
		black.setCap(1);
		black.setBody(1);
		
		System.out.printf("������ ��ī�� ��[%s], �Ѳ�[%d], ��ü[%d]\n",
				black.getColor(),black.getCap(),black.getBody());
		
		//������ ��ü�� ���
		System.out.println(black.write("�ȳ��ϼ���?"));
		
		//������ ��ī�� ��ü�� 5�� ������ ���� ���
		Marker red = new Marker();
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
		System.out.printf("������ ��ī�� ��[%s], �Ѳ�[%d], ��ü[%d]\n",
				red.getColor(),red.getCap(),red.getBody());
		System.out.println(red.write("������"));
		
	}//main
}//class
