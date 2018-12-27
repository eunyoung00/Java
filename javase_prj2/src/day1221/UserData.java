package day1221;

import java.io.Serializable;

/**
 * ������(value Object=VO)�� ������ �ִ� Ŭ������ ����ȭ��� Ŭ����(�Ϲ�Ŭ������ ����ȭ�� ���� �ʴ´�) 
 * @author owner
 */
public class UserData implements Serializable{ //����ȭ ���Ұ�ü?
	/**
	 * �ڵ��� �����̳� ������������ �ֱ⶧���� ������ ���� Ȯ���ϰ� �ȴ�
	 * (�ؽ�(������ �ٿ��� ���ڷ� �����)�ڵ� �ε� Ȯ��)=>�����ϰ� ������
	 * Ư�������� ������ ����?�� ��? �� �־� �����϶�� ���̴�.
	 */
	private static final long serialVersionUID = -3782985689772130133L;//���������� ������ ID

	private int age;
	private /*transient*/ double weigth;//����ȭ�� �Ǵ°��� ������ �ִ�.
	private /*transient*/ String name;
	//transient : ����ȭ ���� Ű����, ���� JVM�ܺη� ���޵��� �ʴ´�.(���� ������ ������ ���Ѵ�.)
	
	public UserData() {
	}

	public UserData(int age, double weigth, String name) {
		this.age = age;
		this.weigth = weigth;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWeigth() {
		return weigth;
	}

	public void setWeigth(double weigth) {
		this.weigth = weigth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() { //�ּҰ� �ƴ϶� ���� ������ �������
		return "UserData [age=" + age + ", weigth=" + weigth + ", name=" + name + "]";
	}
	
}//UserData
