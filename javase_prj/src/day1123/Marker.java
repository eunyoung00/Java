package day1123;
//> = &gt;
/**
 * ��ī���� ������� �����Ͽ�, �߻�ȭ�� �����ϰ� ������� Ŭ����<br>
 * ��ī��- ����� Ư¡ : ��, ��ü, �Ѳ� =&gt; ����<br>
 *       ������ Ư¡ : ���� =&gt; method (�޼ҵ�,�޼���)<br>
 *       
 * ����)<br>
 * 		�⺻�����ڸ� ����Ͽ� ��ü�� ������ �� Setter Method�� ȣ���Ͽ� ���� ������ �� ����Ѵ�.<br>
 *      Marker m= new Marker();<br>
 *      m.setXxx(��);<br>
 *      ��üȭ�� Ư���� ��쿡 �����ϴ°� �����ְ� �ȴ�.
 * class�� ��������� �ڷ����̸�, ������ �������� �̴�.<br>
 * @author owner
 */
public class Marker {
	private String color; //��ī���� ��
//	public String color; //��ī���� ��
	private int body; //��ī���� ��ü�� ����
	private int cap; //��ī���� �Ѳ��� ����
	//�ۿ����� ������ �������� private
	
	/**
	 * �⺻�����ڷ� ��ī�� ��ü�� �����Ǹ� ������, �Ѳ� 1��, ��ü 1���� ��ī�� ��ü�� �����մϴ�.<br>
	 * 11-26-2018 �ڵ��߰�(�� ���� �̷�)
	 */
	public Marker() {
		color = "������";
		body = 1;
		cap = 1;
	}//Marker <  =>�ɰ��̿� ���� ���� �߻�=>�����ε����� �ذ�
	
	/**
	 * �����ִ� ������ - ������,�Ѳ��� ��ü�� 1���ϼ������� 1�����ƴ� ��ī���� �����Ҷ� ����ϴ� ������<br>
	 * ��,�Ѳ��� ��,��ü�� ���� �Է¹޾� ��ī���� ����.<br>
	 * 11-26-2018 �ڵ��߰�
	 * @param color ��ī���� ��
	 * @param cap ��ī���� �Ѳ�
	 * @param body ��ī���� ��ü
	 */
	public Marker(String color, int cap, int body) {
		this.color=color;
		this.body=body;
		this.cap=cap;
	}//marker
	
	
	/**
	 * ������ ��ī�� ��ü�� ���� �����ϴ� ��<br>
	 * ������,�Ķ���,�������� �����Ѵ�. ���̿��� ���� ���������� ó���Ѵ�.
	 * @param color ������ ��
	 */
	public void setColor(String color) {
		//�ν��Ͻ������� ������ �������� ��������.
		if( !(color.equals("������")||color.equals("�Ķ���")||color.equals("������"))) {
			color = "������";
		}//end if
		this.color = color;
	}//setColor
	
	/**
	 * ������ ��ī�� ��ü�� ��ü�� ������ �����ϴ� ��
	 * @param body ��ü�� ����
	 */
	public void setBody(int body) {
//		if() {
			this.body = body;
//		}
	}//setBody
	
	/**
	 * ������ ��ī���� ��ü�� �Ѳ� ������ �����ϴ� ��.
	 * @param cap �Ѳ��� ��
	 */
	public void setCap(int cap) {
		this.cap = cap;
	}//setCap
	
	/**
	 * ������ ��ī�� ��ü�� ������ �ִ� ���� ��ȯ�ϴ� ��
	 * @return ��
	 */
	public String getColor() {
		return color;
	}//getColor
	
	/**
	 * ������ ��ī�� ��ü�� ������ �ִ� ��ü�� ������ ��ȯ�ϴ� ��
	 * @return ��ü�� ����
	 */
	public int getBody() {
		return body;
	}//getBody
	
	/**
	 * ������ ��ī�� ��ü�� ������ �ִ� �Ѳ��� ����
	 * @return �Ѳ��� ����
	 */
	public int getCap() {
		return cap;
	}//getCap
	//ctrl+O outline
	
	/**
	 * �Էµ� �޼����� ������ ��ī������ ĥ�ǿ� ���� ��.
	 * @param msg ĥ�ǿ� �� �޼���
	 * @return ���
	 */
	public String write(String msg) {
		return color+"�� ��ī������ ĥ�ǿ�\""+msg+"\"�� ����.";
	}//write
	
}//class=>���̾�׷� ������� ����
