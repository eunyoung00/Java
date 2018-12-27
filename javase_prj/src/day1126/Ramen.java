package day1126;

/**
 * Work21
 * �ʱ��� ��¡��«�� �Ŷ�� �� ������� class �ۼ�
 * �������Ư¡ : ���� ������,���,����,�̸�  , ����,��Ű��   ((   �齺����Ű��
 * ��������Ư¡ : ������ ,  �Ǹŵȴ�,���δ�,�ѽŴ�      (( ���δٻѽŴ�
 * 
 * ��üȭ) Ramen men = new Ramen();
 * @author owner
 */
public class Ramen {
	private String maker,name;
	private int men,msg;
	
	/**
	 * 11-26-2018 �߰�
	 */
	public Ramen() {
		this("���","�ʱ���",1,1);
	}//������
	
	public Ramen(String maker, String name, int men, int msg) {
		this.maker=maker;
		this.name=name;
		this.men=men;
		this.msg=msg;
	}//������.
	
	
	/**
	 * ������ ��� ��ü�� �����縦 �����ϴ� �� 
	 * ����̶�� ������ۿ� ���� ����.
	 * @param maker ������
	 */
	public void setMaker(String maker) {
		if(maker.equals("���")) {
			this.maker = maker;
		}else {
			this.maker="���";
		}

		//=>�̷��Դ� ���� ����..? maker�� ���� null�� �ʱ�ȭ �Ǿ��ִµ� �װ� �־����?
	}//setMaker
	
	/**
	 * ������ ��� ��ü�� �̸��� �����ϴ� �� 
	 * �Ŷ��,��¡��«��,�ʱ����� ������ �ְ�,�׿��ǰ��� �ʱ����� ����.
	 * @param name ����̸�
	 */
	public void setName(String name) {
		if(!(name.equals("�Ŷ��")||name.equals("��¡��«��")||name.equals("�ʱ���"))) {
			name="�ʱ���";
		}
		this.name = name;
	}//setName
	
	/**
	 * ������ ��� ��ü�� ���� ��.
	 * ���� 1�� �ϼ��ۿ� ����, �׿��� ���� 1�� ����.
	 * @param men ���� ����
	 */
	public void setMen(int men) {
		if(!(men==1)) {
			men=1;
		}
		this.men = men;
	}//setMen
	
	/**
	 * ������ ��鰴ü�� ���� ��.
	 * 1~5������ ���� �ְ� �׿��� ���� 1�� ����.
	 * @param msg ���� ����
	 */
	public void setMsg(int msg) {
		if(!(msg>=1&&msg<=5)) {
			msg = 1;
		}
		this.msg = msg;
	}//setMsg
	
	public String getMaker() {
		return maker;
	}//getMaker
	
	public String getName() {
		return name;
	}//getName
	
	public int getMen() {
		return men;
	}//getMen
	
	public int getMsg() {
		return msg;
	}//getMsg
	
//	public String eat(String menu,int price) {
//		return name+"��(��) �Ĵ翡�� "+menu+"�� ������ "+price+"�� ���� ��Դ´�.";
//	}//eat
	public String eaten() {
		return maker+"\""+name+"\"����� ����� ��"+men +"���� ����"+msg+"���� �Բ� ���� �Ծ���.";
	}//eaten
	
	
}//class
