package day1122;

public class Work20 {
//	���� 
//	�Ʒ��� ������ ó���ϴ� method�� type�� �˸°� �ۼ��ϰ� API�ּ���
//	 ������ �� ȣ���Ͽ� ����� �� �� Java Doc�� �����غ�����.
//	- API�ּ��� � ������ method������ �ּ����� ����Ұ�.
//	1.�Է¹޴´ٴ��̾߱Ⱑ�����ϱ� ������-��ȯ��o_String �Ű����� x 
//	2.������-��ȯ��o_int �Ű�����o _int
//	3.������-��ȯ��o_int �Ű����� o_char
//	4.������-��ȯ�� o void �Ű����� o_int	
//	5.������-��ȯ��x, �Ű����� x   <��¥ ���ּ�.....
//	6.������-��ȯ��x_void �Ű����� o variable Arguments

	/**
	 * 1. �ڽ��� �̸��� ��ȯ�ϴ� method�ۼ�.
	 * @return �̸� ��ȯ
	 */
	public String name() {
		String name1 = "������";
		System.out.println(name1);
		return name1;
	}

	/**
	 * 2. ���̸� �Է¹޾� �¾ �ظ� ��ȯ�ϴ�  method �ۼ�.
	 * @param age �Է¹��� ����
	 * @return �¾�� 
	 */
	public int year(int age) {
		int year1 = 2018-age+1;
		System.out.println("�¾ �� : "+year1);
		return year1;
	}

	/**
	 * 3. ���ڸ� �Է¹޾� �ش� ������ Unicode ���� ��ȯ�ϴ� method �ۼ�.
	 * @param c unicode�� ��ȯ�� ����
	 * @return �ش� ������ unicode
	 */
	public String uni(char c) {
		String code = Integer.toHexString(c);
		System.out.println(c+"�� Unicode�� : "+code);
		return code;
	}

	/**
	 * 4. ���ڸ� �Է¹޾� ���ڰ�  ������, ������ ������ ���� �� �ش� ������ ���ڸ�
	 *   ����ϴ� ���� �ϴ� method  �ۼ�
	 * @param num ������, ������ ������ ����
	 */
	public void character(int num) {
		char c = (char)num;
		//if(num >=65 && num<123 || num>=48&&num<58) {
		if(num >='A' && num<='Z' || num>='0'&&num<='9'||num >='a' && num<='z') {
		
			System.out.println(c);
		}else {
			System.out.println("������ ������ϴ�.");
		}
	}
	
	/**
	 * 5. ȣ���ϸ� �ڽ��� �ּҸ� ����ϴ�  method �ۼ�.
	 * @param w20 Ŭ������ ������������ w20�� ������ ������
	 */
	public void local(Work20 w20) {
//		System.out.println("c:\\dec\\scr\\javase_prj");
		System.out.println(w20);
	}
	
	/**
	 * 6. ģ���� �̸��� �Է¹޾� ����ϴ�  method �ۼ�<br>
	 *     (ģ���� n�� �Դϴ�.)
	 * @param n ģ���� �̸�
	 */
	public void fname(String ...n) {
		System.out.println("ģ���� "+n.length+"�� �Դϴ�.");

		for(int idx=0; idx<n.length; idx++) {
			System.out.println(n[idx]);
		}//end for
	}

	public static void main(String[] args) {
		Work20 hw = new Work20();
		hw.name();//1
		hw.year(25);//2
		hw.uni('5');//3
		hw.character(90);//4
		hw.character(57);//4
		hw.character(122);//4
		hw.local(hw);//5
		hw.fname("������","�ڼҿ�","�����");//6
		
	}//main
}//class
//���� ������ �ϰ� ������ �������� ���� ���� ���� �޼ҵ忡 ��ġ�Ǽ� ������ 
