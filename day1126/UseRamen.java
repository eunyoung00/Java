package day1126;

/**
 * ����� �߻�ȭ�Ͽ� ���� RamenŬ������ ����ϴ� Ŭ����
 * @author owner
 */
public class UseRamen {

	public static void main(String[] args) {
		Ramen men1 = new Ramen();
//		System.out.printf("������ ��鰴ü ���� : ������[%s], �̸�[%s], ��[%d],����[%d]\n", 
//				men1.getMaker(),men1.getName(),men1.getMen()
//				,men1.getMsg());
		men1.setMaker("���");
		men1.setName("��¡�� «��");
		men1.setMen(1);
		men1.setMsg(1);

		
		System.out.printf("������ ��鰴ü ���� : ������[%s], �̸�[%s], ��[%d],����[%d]\n", 
				men1.getMaker(),men1.getName(),men1.getMen()
				,men1.getMsg());
		
		Ramen men11 = new Ramen();
		System.out.printf("������ ��鰴ü ���� : ������[%s], �̸�[%s], ��[%d],����[%d]\n", 
				men11.getMaker(),men11.getName(),men11.getMen()
				,men11.getMsg());
		
		
		Ramen men2 = new Ramen("�ȵ�","�����",0,10);
//		men2.setMaker("�ȵ�");
//		men2.setName("�����");
//		men2.setMen(0);
//		men2.setMsg(10);
		System.out.printf("������ ��鰴ü ���� : ������[%s], �̸�[%s], ��[%d],����[%d]\n", 
				men2.getMaker(),men2.getName(),men2.getMen()
				,men2.getMsg());
		
		Ramen men3 = new Ramen("���","��¡�� «��",2,3);
//		men3.setMaker("���");
//		men3.setName("��¡��«��");
//		men3.setMen(1);
//		men3.setMsg(3);
		System.out.printf("������ ��鰴ü ���� : ������[%s], �̸�[%s], ��[%d],����[%d]\n", 
				men3.getMaker(),men3.getName(),men3.getMen()
				,men3.getMsg());
		
		System.out.println(men1.eaten());
		System.out.println(men2.eaten());
		System.out.println(men3.eaten());
		
	}//main
}//class
