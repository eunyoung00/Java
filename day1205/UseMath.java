package day1205;

/**
 * ��ü�� �������� �ʰ� ����ϴ� Ŭ���� Math(����� ���ִ�.)
 * ��κ� static method�� ���Ե�
 * @author owner
 */
public class UseMath {

	public UseMath() {
//		Math m =new Math();//��ü�� ����� Ŭ������ �ƴ�.
		int i=-12;
		System.out.println(i+"�� ���밪 : "+Math.abs(i));
		System.out.println(Math.ceil(10.1));//��ȯ�� double
		System.out.println(Math.ceil(10.0));//0�� �ø��� �ʴ´�.
		System.out.println(Math.round(10.4));
		System.out.println(Math.round(10.544445));//�Ҽ������� ù�ڸ�����.
		System.out.println(Math.floor(10.5));//�Ҽ������� ù�ڸ�����.
		
		double d = Math.random();
		System.out.println("�߻��� ����: "+d);
		System.out.println("������ ������ ���� : "+d*5);
		System.out.println("������ ������ �������� ���� : "+(int)(d*5));
		
		//A(65)-Z(90), a(97)-z(122)�� �ϳ��� ���ڸ� ��ȯ�ϴ� ��.26���� ���;�.
		System.out.println((char)((int)(d*26)+65));
		
		
		//����
		System.out.println((char)((int)(d*10)+48));
		//�ҹ���
		System.out.println((char)((int)(d*26)+97));
		
	}//UseMath	
	
	public char[] createPassword1() {
		//xxxxx****** or ������й�ȣ�ϱ�
		char[] tempPass=new char[8];
		//�����ڴ빮��, �ҹ���,���ڷ� �̷���� ������ ��й�ȣ 8�ڸ��� �����Ͽ� ��ȯ�ϴ���.

		char[] arr = new char[3];
		int num =0;
		for(int i =0;i<tempPass.length; i++) {
			arr[0]=(char)((int)(Math.random()*26)+65);
			arr[1]=(char)((int)(Math.random()*10)+48);
			arr[2]=(char)((int)(Math.random()*26)+97);
			num =(int)(Math.random()*3);//0,1,2
			tempPass[i]=arr[num];//���� ���� �־��ַ��� arr[0|1|2]
			System.out.print(tempPass[i]);
		}
//		System.out.println();
//		System.out.println(num);
		return tempPass;
	}//createPassword1
	
	
	public char[] createPassword() {
		char[] tempPass=new char[8];
		//�����ڴ빮��, �ҹ���,���ڷ� �̷���� ������ ��й�ȣ 8�ڸ��� �����Ͽ� ��ȯ�ϴ���.
		String flag="ABCDEFGHIJKLMOPQRSTUVWXWZabcdefghijklmopqrstuvwxwz0123456789";
		for(int i=0;i<tempPass.length; i++) {
			tempPass[i]=flag.charAt((int)(Math.random()*flag.length()));
			System.out.print(tempPass[i]);
			//ctrl shift x �빮��~!
		     //ctrl shift y �ҹ���
		}//end for
		
				
				
		return tempPass;
	}//createPassword
	
	public static void main(String[] args) {
		new UseMath().createPassword1();
		

	}//main
}//class
