package day1127;

public class ssnCheck {

	public String ssn;
	
	public ssnCheck(String ssn) {
		//1-1 �����ڴ� �ֹι�ȣ�� �޾� instance������ �Ҵ��Ѵ�.
		this.ssn=ssn;
	}
	
	public boolean checklen() {
		//1-2 �ֹι�ȣ�� ����üũ�Ͽ� 14�ڰ� �ƴϸ� false��ȯ
		boolean cl=false;
		if(!(ssn.length()==14)) {
			cl=false;
		}else {
			cl=true;
		}
		return cl;
	}
	
	public boolean checkhyphen() {
//		1-3 �ֹι�ȣ�� 6��° �ڸ���'-'�ƴϸ� false ��ȯ.
		boolean ch=false;
		if(!(ssn.indexOf("-")==6)) {
			ch=false;
		}else {
			ch=true;
		}
		return ch;
	}
	
	public boolean checkval() {
		//1-4 �ֹι�ȣ�� ��ȿ�������Ͽ� ��ȿ�ϸ� t/f��ȯ.
		boolean cv=false;

		//ssn.charAt(0)=>�ƽ�Ű�ڵ�� 0�Ǵ� 48�� ���־�� ���ϴ� ���ڰ� ���´�.
		//�ƽ�Ű�ڵ尪�� ���ͼ� 1�� ���� 49��� �ڵ� ���� ���´�.
		//���� ���ϴ� ���ڸ� �������� 48�̳� �������� '0'�� ���־��� ���ϴ� ���� 1�� ������ �ִ�.
		
//		int last=0;
//		last=((ssn.charAt(0)-'0')*2)+(ssn.charAt(1)*3)+(ssn.charAt(2)*4)+
//				(ssn.charAt(3)*5)+(ssn.charAt(4)*6)+(ssn.charAt(5)*7)+
//				(ssn.charAt(7)*8)+(ssn.charAt(8)*9)+(ssn.charAt(9)*1)+
//				(ssn.charAt(10)*2)+(ssn.charAt(11)*3)+(ssn.charAt(12)*4);
////		System.out.println(last);
//		last=(11-(last%11))%10;
//		
//		if(ssn.charAt(13)==last) {
//			cv=true;
//		}

		int last=0;
		int sum=0;
		for(int i=0;i<6;i++) {
			last=(ssn.charAt(i)-48)*(2+i);
			sum=sum+last;
		}
//		System.out.println(sum);
		for(int i=7;i<13;i++) {
			if(i<=9) {
				last=(ssn.charAt(i)-'0')*(i+1);
			}else {
				last=(ssn.charAt(i)-'0')*(i-9);
			}
			sum=sum+last;
		}
//		System.out.println(sum);
		sum=(11-(sum%11))%10;
//		System.out.println(sum);
		if((ssn.charAt(13)-'0')==sum) {
			cv=true;
		}
		return cv;
	}
	
	public String birth() {
		//1-5 ������� ��ȯ �ϴ� �� "1988-11-11"
		//mail+"���� ���� �ּҸ� ��� "+mail.substring(0, mail.indexOf("@"));
		String bir;
		bir = ssn.substring(0, 2);

		switch (ssn.charAt(7)) {
		case '0':
		case '9':
			bir = "18" + bir;
			break;
		case '1':
		case '2':
		case '5':
		case '6':
			bir = "19" + bir;
			break;
		case '3':
		case '4':
		case '7':
		case '8':
			bir = "20" + bir;
			break;
		}
		
		bir=bir+"-"+ssn.substring(2,4)+"-"+ssn.substring(4,6);
		return bir;
	}
	
	public int age() {
		//1-6 ���̸� ��ȯ�ϴ� �� 31
		int age;
		String year;
		year=birth().substring(0, 4);
//		System.out.println(year);
		age=2018-Integer.valueOf(year)+1;
		return age;
	}
	
	public String gender() {
		//1-7 ������ ��ȯ   ��/�� Ȧ������ / ¦������
		String gender="����";
		int num=Integer.valueOf(ssn.substring(7,8));
		if(num%2==0) {
			gender="����";
		}else {
			gender="����";
		}
		return gender;
	}
	
	public String nation() {
		//1-8 ������/�ܱ��� ��ȯ 
		String nation;
		int num=Integer.valueOf(ssn.substring(7,8));
//		System.out.println(num);
		if(num==1||num==2||num==3||num==4||num==0||num==9) {
			nation="������";
		}else
			nation="�ܱ���";
		return nation;
	}
	
	public String czs() {
		//1-9 �츦 ��ȯ  "���"
		//0~11
		//11 : ���, 10 : ��, 9: ��,8 :�� ,7 :�䳢 , 6 : ȣ����, 5: ��, 4: ��,
		//3: ����, 2: ��, 1:   �� ,0 : ������
		int year=Integer.valueOf(birth().substring(0, 4));
		String[] czs = new String[] {"������","��","��","����","��","��",
								"ȣ����","�䳢","��","��","��","���"};
//		System.out.println(year%11);
		return czs[year%12];
	}
	
	
	
	
	public static void main(String[] args) {
		String ssn = "940925-2069314";
		
		//            012345678910111213
		//            234567 8912345
		ssnCheck ssnc = new ssnCheck(ssn);
		if(ssnc.checklen()) {
			if(ssnc.checkhyphen()) {
				if(ssnc.checkval()) {
					System.out.println(ssnc.checkval());
//					System.out.println("��ȿ�� �ֹι�ȣ�Դϴ�.");
					System.out.println(ssnc.birth());
					System.out.println(ssnc.age());
					System.out.println(ssnc.gender());
					System.out.println(ssnc.nation());
					System.out.println(ssnc.czs());
				}else {
					System.out.println("�߸��� �ֹι�ȣ �Դϴ�.");
				}//end else
			}else {
				System.out.println("-(������)�� ��ġ�� Ʋ���ϴ�.");
			}//end else
		}else {
			System.out.println("�ֹι�ȣ�� ���̰� Ʋ���ϴ�.");
		}//end else
		
	}//main
}//class
