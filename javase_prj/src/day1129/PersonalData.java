package day1129;

public class PersonalData {

//	��ȣ,�̸�,�ּ�,����,������  ������ �� �ִ� Ŭ������ ����� 
//	�Ʒ��� ���� ���� �Է��մϴ�.
//
//	�Է°�
//	1, ������, ����� ������ ���ﵿ, 28,����
//	2, ������, ����� ���빮�� ��ʸ���, 27,����
//	3, ������, ������ ���뱸 ���뵿, 26,����
//	4, ���ü�, ����� ���α� ���ε�,27, ����
//	5, ���ü�, ����� ���۱� �󵵵�,29,����
//	6, �����, ��⵵ ��õ�� ��õ��,26,����
//	7, �����, ����� ������ �����絿,27,����
//	 ����� ������ x��
//	 ���� �� x��
//	 �ְ���� "���ü�(����)"
//	 
//	1. ���ǰ��� �迭�� �Է��ϴ� method�� �ۼ��Ұ�.
//	2. �迭�� �Էµ� ���� ����ϴ� method �� �ۼ��Ұ�.
//	   2�� method ���� ����ÿ� ��� �ִ� �ο����� ��� �Ұ�.
//	   2�� method ���� ������ ���� ��� �Ұ�.
//	   2�� method ���� ���� ���̰� ���� ����� �̸��� ��� �� ��.
	
	private int num;
	private String name;
	private String addr;
	private int age;
	private String gender;
	
	public PersonalData() {
	}//PersonalData
	public PersonalData(int num, String name, String addr, int age, String gender) {
		this.num=num;
		this.name=name;
		this.addr=addr;
		this.age=age;
		this.gender=gender;
	}//PersonalData
	
	
	public void setNum(int num) {
		this.num = num;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	public int getNum() {
		return num;
	}
	public String getName() {
		return name;
	}
	public String getAddr() {
		return addr;
	}
	public int getAge() {
		return age;
	}
	public String getGender() {
		return gender;
	}
	
	
	
//	
//	public static void main(String[] args) {
//
//	}
}
