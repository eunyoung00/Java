package day1203;

/**
 * ����� �߻�ȭ�Ͽ� ���� Ŭ����<br>
 * �������Ư¡ : ��,��,��,�̸�<br>
 * ��������Ư¡ : �Դ´�. <br>
 * 
 * ��üȭ) Person ��ü�� =new Person();<br>
 *       ������ ��ü�� �Դ����� �� ���ִ�.<br>
 * ..��ɸ�, ȥ�ڻ����� �ʴ´�.<br>
 * 
 * 12.03.2018
 * Person�� �Ϲ� Ŭ�������� abstractŬ������ ����.<br>
 * ��� ����� ������ �Դ� �ϰ� �ۿ��� ��Դ� ��,�� �ݵ�� ������. 
 * @author owner
 */
public abstract class Person {
	private String name;//�̸�
	private int eye,nose,mouth;//��,��,��
	//�ۿ��� ���� ������ �������� setter method
	private String[] language;//����ϴ� ���
	
	/**
	 * ���Ŭ������ �⺻������.<br>
	 * ��2��, ��1��, ��1���� ���� ��� ��ü�� ����
	 */
	public Person() {
		this(2,1,1);
//		eye=2;
//		nose=1;
//		mouth=1;		
	}//Person
	
	/**
	 * ��2��, ��1��, ��1���� �ƴ� ��� ��ü�� ������ �� ����ϴ� ������.
	 * �� �߰� �� �� �ֵ��� 
	 * @param eye ���� ��
	 * @param nose ���� ��
	 * @param mouth ���� ��
	 * @param language 
	 */
	public Person(int eye, int nose, int mouth) {
		this.eye=eye; 
		this.nose=nose;
		this.mouth=mouth;	
		language=new String[10];
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
	
	public String[] getLanguage() {
		return language;
	}//getLanguage
	
	
	/**
	 * ������ Ư¡
	 * ������ �����ü�� ������ ���� �Դ� �� ����
	 * @return ���
	 */
	public abstract String eat();
	
	/**
	 * method overload(overloading) : ������-�����̸��� method�� ������ �����ϴ� ���.<br>
	 * ������ ��� ��ü�� �Ĵ翡 �ֹ��� ������ �Դ� ���� ����.
	 * @param menu ������ ����
	 * @param price ������ ����
	 * @return ���
	 */
	public abstract String eat(String menu,int price);
	
	/**
	 * ����� �� ������ �� �� �ִ�.
	 * @return �� �� �ִ� ���.
	 */
//	public abstract String[] language(String lang);
//	@Override//���� �ø��Ŵϱ� �̰� ������ �Ǿ� override �ƴ�
	public String[] language(String lang) {
//		String[] lang = {"����","�ܰ��"};
		String[] tempLang=getLanguage();
		
		int idx=0;
//		for(String temp : tempLang) {
		for(int i=0; i<tempLang.length; i++) {
//			System.out.println(temp);
			if(tempLang[i] != null) {//���ʷ� �� ������ ���?//������ ����� �����ε����� ��� ����
				//������ �� �����Ѵٸ� �����ε����� ��´�.
				if(lang.equals(tempLang[i])) {
					//�Էµ� �� �̹� ������ ����� �ݺ����� �������� �ش�濡 ����� �ִ� �ε����� ������.
					break;
				}//end if
				idx++;
			}//end if
		}//end if
		//������ �߰��ǰ� �ִٸ� �����. : upsert
		tempLang[idx] = lang;
		return tempLang;
	}//language<�����丵�� ����̵� �ڽĻ��̿��� �ߺ�!! �θ�� �÷���..

		
	
}//class
