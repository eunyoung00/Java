package day1127;

public class UseString1 {
	//�̸����� �Է¹޾� �̸����� ��ȿ���� �����Ͽ� boolean������ ����� ����� 
	//��ȯ�ϴ� ���� �ϴ� method�����
	//5�� �̻��̸鼭 @,.�������־�� ��.
	public boolean checkmail(String mail) {
		boolean check=false;
		if(mail.length()>6) {
			if(!(mail.indexOf("@")==-1)) {
				if(!(mail.indexOf(".")==-1)) {
					check=true;
				}
			}
		}
		return check;
	}//checkmail
	//method�� �ϸ��ϰ� ����� ������ ����� ���ִ� �޼ҵ�� �ϳ��� ����.
	
	private boolean validEmail(String email) {
		//private�� ���� Ŭ���������� �θ��� �ִµ� �θ��� �ʾƼ� ���,
		//public�� ��𼭳��θ����ֱ⶧���� �ȶߴ°��̴�.
		boolean flag=false;
//		boolean flag=email.length()>5 && email.indexOf("@")!=-1 
//				&& email.indexOf(".")!=-1; //������
		
		if(email.length()>5 && email.indexOf("@")!=-1 
				&& email.indexOf(".")!=-1) {
			flag=true;
//		}else {
//			flag=false;
		}
		flag=email.length()>5 && email.indexOf("@")!=-1 
				&& email.indexOf(".")!=-1;//if ���� ����
//		email.contains("@")=email.indexOf("@")!=-1//�ΰ��� ����. 
		flag=email.length()>5 && email.contains("@") 
				&& email.contains(".");
		return flag;
//		return email.length()>5 && email.indexOf("@")!=-1 
//				&& email.indexOf(".")!=-1; //������~!
	}//valid
	
	
	
	//"��,��,������"�� �ּҸ� n�� �Է� �޾� ��������� �ƴ����� �Ǵ��Ͽ� ����ϴ� method
//	public void 
	//valiable~? �� �迭���¶� �迭��
	
	
	
	
	
	public static void main(String[] args) {
		boolean checkp=false;
		UseString1 us1 = new UseString1();
		checkp=us1.checkmail("beebee1170@naver.com");
		System.out.println(checkp);
		
		
		//�ܴ�
		UseString1 us2=new UseString1();
		String email="ruro@daum.net";
		if(us2.validEmail(email)) {
			System.out.println(email+"��ȿ");
		}else {
			System.out.println(email+"��ȿ");
		}//end else
		
		String email1="@.";
		if(us2.validEmail(email1)) {
			System.out.println(email1+"��ȿ");
		}else {
			System.out.println(email1+"��ȿ");
		}//end else
		
		
	}//main
}//class
