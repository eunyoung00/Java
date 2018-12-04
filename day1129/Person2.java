package day1129;

/**
 * ����� �߻�ȭ�Ͽ� ���� Ŭ����<br>
 * �������Ư¡ : ��,��,��,�̸�<br>
 * ��������Ư¡ : �Դ´�. <br>
 * 
 * ��üȭ) Person ��ü�� =new Person();<br>
 *       ������ ��ü�� �Դ����� �� ���ִ�.
 * ..��ɸ�, ȥ�ڻ����� �ʴ´�.
 * @author owner
 */
public class Person2 {
	private String name;//�̸�
	private int eye,nose,mouth;//��,��,��
	//�ۿ��� ���� ������ �������� setter method
	
	/**
	 * ���Ŭ������ �⺻������.<br>
	 * ��2��, ��1��, ��1���� ���� ��� ��ü�� ����
	 */
	public Person2() {
		this(2,1,1);
//		eye=2;
//		nose=1;
//		mouth=1;		
	}//Person
	
	/**
	 * ��2��, ��1��, ��1���� �ƴ� ��� ��ü�� ������ �� ����ϴ� ������.
	 * @param eye ���� ��
	 * @param nose ���� ��
	 * @param mouth ���� ��
	 */
	public Person2(int eye, int nose, int mouth) {
		this.eye=eye; 
		this.nose=nose;
		this.mouth=mouth;		
	}//Person
	
	
	
	/**
	 * ������ ��� ��ü�� �̸��� �����ϴ� ��
	 * @param name �̸�
	 */
	public void setName(String name) {
		this.name = name;
	}//setName
	
	/**
	 * ������ ��� ��ü�� ���� �����ϴ� ��<br>
	 * ������ ���� ������ �ִ� 3�� ���� ������ �� �ִ�.<br>
	 * 3���� �Ѿ�� 2���� �����Ѵ�.
	 * @param eye ���� ����
	 */
	public void setEye(int eye) {
		if(eye>3) {
			eye=2;
		}//end if
		this.eye = eye;
	}//setEye
	
	/**
	 * ������ ��� ��ü�� �ڸ� �����ϴ� ��.
	 * @param nose ���� ����
	 */
	public void setNose(int nose) {
		this.nose = nose;
	}//setNose
	
	/**
	 * ������ ��� ��ü�� ���� ���� �����ϴ� ��
	 * @param mouth ������ ���� ����
	 */
	public void setMouth(int mouth) {
		this.mouth = mouth;
	}//setMouth
	//instance method
	
	/**
	 * ������ ��� ��ü�� �̸��� ��ȯ�ϴ� ��.
	 * @return �̸�
	 */
	public String getName() {
		return name;
	}//getName
	
	/**
	 * ������ ��� ��ü�� ������ �ִ� ���� ���� ��ȯ
	 * @return ���� ����.
	 */
	public int getEye() {
		return eye;
	}//getEye
	
	/**
	 * ������ ��� ��ü�� ������ �ִ� ���� ���� ��ȯ
	 * @return ���� ����.
	 */
	public int getNose() {
		return nose;
	}//getNose
	
	/**
	 * ������ ��� ��ü�� ������ �ִ� ���� ���� ��ȯ
	 * @return ���� ����.
	 */
	public int getMouth() {
		return mouth;
	}//getMouth
	
	/**
	 * ������ Ư¡
	 * ������ �����ü�� ������ ���� �Դ� �� ����
	 * @return ���
	 */
	public String eat() {
		return name+"��(��) ������ ���� �Դ´�.";
	}//eat
	
	/**
	 * method overload(overloading) : ������-�����̸��� method�� ������ �����ϴ� ���.<br>
	 * ������ ��� ��ü�� �Ĵ翡 �ֹ��� ������ �Դ� ���� ����.
	 * @param menu ������ ����
	 * @param price ������ ����
	 * @return ���
	 */
	public String eat(String menu,int price) {
		return name+"��(��) �Ĵ翡�� "+menu+"�� ������ "+price+"�� ���� ��Դ´�.";
	}//eat
	
}//class
