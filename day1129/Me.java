package day1129;

public class Me extends Person2{
	public int dexterity;//������
	public int fatigability;//�Ƿε�
	
	public Me() {
		dexterity=8;
		fatigability=0;
	}//me
	
	public String dexterity(int cnt) {
		String result="";
		//�Ƿε��� Ƚ������ ������ �� ����� ���� ������ �ϼ����� ��������.
		//�Ƿε��� 1~10������ �ѹ� ����ɶ����� �����Ѵ�.
		
		if(fatigability<cnt) {
			result="�� �������. s('.^)V";
			fatigability++;
			if(fatigability>10) {
				fatigability=10;
			}//end if
		}else if(fatigability>cnt) {
			result = "�ϼ����� ��������.";
			fatigability++;
			if(fatigability>10) {
				fatigability=10;
			}//end if
		}else {
			result="�ϼ��Ǿ���";
		}//end else
		
	
		return result;
	}
}
