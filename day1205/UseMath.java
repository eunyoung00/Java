package day1205;

/**
 * 객체를 생성하지 않고 사용하는 클래스 Math(몇가지가 더있다.)
 * 대부분 static method를 갖게됨
 * @author owner
 */
public class UseMath {

	public UseMath() {
//		Math m =new Math();//객체를 만드는 클래스가 아님.
		int i=-12;
		System.out.println(i+"의 절대값 : "+Math.abs(i));
		System.out.println(Math.ceil(10.1));//반환형 double
		System.out.println(Math.ceil(10.0));//0은 올리지 않는다.
		System.out.println(Math.round(10.4));
		System.out.println(Math.round(10.544445));//소수점이하 첫자리에서.
		System.out.println(Math.floor(10.5));//소수점이하 첫자리에서.
		
		double d = Math.random();
		System.out.println("발생한 난수: "+d);
		System.out.println("범위를 설장한 난수 : "+d*5);
		System.out.println("범위를 설장한 난수에서 정수 : "+(int)(d*5));
		
		//A(65)-Z(90), a(97)-z(122)중 하나의 문자를 반환하는 일.26개가 나와야.
		System.out.println((char)((int)(d*26)+65));
		
		
		//숫자
		System.out.println((char)((int)(d*10)+48));
		//소문자
		System.out.println((char)((int)(d*26)+97));
		
	}//UseMath	
	
	public char[] createPassword1() {
		//xxxxx****** or 난수비밀번호니까
		char[] tempPass=new char[8];
		//영문자대문자, 소문자,숫자로 이루어진 임의의 비밀번호 8자리를 생성하여 반환하는일.

		char[] arr = new char[3];
		int num =0;
		for(int i =0;i<tempPass.length; i++) {
			arr[0]=(char)((int)(Math.random()*26)+65);
			arr[1]=(char)((int)(Math.random()*10)+48);
			arr[2]=(char)((int)(Math.random()*26)+97);
			num =(int)(Math.random()*3);//0,1,2
			tempPass[i]=arr[num];//랜덤 수를 넣어주려면 arr[0|1|2]
			System.out.print(tempPass[i]);
		}
//		System.out.println();
//		System.out.println(num);
		return tempPass;
	}//createPassword1
	
	
	public char[] createPassword() {
		char[] tempPass=new char[8];
		//영문자대문자, 소문자,숫자로 이루어진 임의의 비밀번호 8자리를 생성하여 반환하는일.
		String flag="ABCDEFGHIJKLMOPQRSTUVWXWZabcdefghijklmopqrstuvwxwz0123456789";
		for(int i=0;i<tempPass.length; i++) {
			tempPass[i]=flag.charAt((int)(Math.random()*flag.length()));
			System.out.print(tempPass[i]);
			//ctrl shift x 대문자~!
		     //ctrl shift y 소문자
		}//end for
		
				
				
		return tempPass;
	}//createPassword
	
	public static void main(String[] args) {
		new UseMath().createPassword1();
		

	}//main
}//class
