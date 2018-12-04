package day1127;

public class UseString1 {
	//이메일을 입력받아 이메일의 유효성을 검증하여 boolean형으로 결과를 만들어 
	//반환하는 일을 하는 method만들기
	//5자 이상이면서 @,.가지고있어야 함.
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
	//method는 일만하고 결과만 내주지 출력을 해주는 메소드는 하나도 없음.
	
	private boolean validEmail(String email) {
		//private는 같은 클래스에서만 부를수 있는데 부르지 않아서 경고,
		//public은 어디서나부를수있기때문에 안뜨는것이다.
		boolean flag=false;
//		boolean flag=email.length()>5 && email.indexOf("@")!=-1 
//				&& email.indexOf(".")!=-1; //도가능
		
		if(email.length()>5 && email.indexOf("@")!=-1 
				&& email.indexOf(".")!=-1) {
			flag=true;
//		}else {
//			flag=false;
		}
		flag=email.length()>5 && email.indexOf("@")!=-1 
				&& email.indexOf(".")!=-1;//if 보다 간편
//		email.contains("@")=email.indexOf("@")!=-1//두개가 같다. 
		flag=email.length()>5 && email.contains("@") 
				&& email.contains(".");
		return flag;
//		return email.length()>5 && email.indexOf("@")!=-1 
//				&& email.indexOf(".")!=-1; //도가능~!
	}//valid
	
	
	
	//"시,군,구형태"의 주소를 n개 입력 받아 서울시인지 아닌지를 판단하여 출력하는 method
//	public void 
	//valiable~? 은 배열형태라 배열후
	
	
	
	
	
	public static void main(String[] args) {
		boolean checkp=false;
		UseString1 us1 = new UseString1();
		checkp=us1.checkmail("beebee1170@naver.com");
		System.out.println(checkp);
		
		
		//쌤답
		UseString1 us2=new UseString1();
		String email="ruro@daum.net";
		if(us2.validEmail(email)) {
			System.out.println(email+"유효");
		}else {
			System.out.println(email+"무효");
		}//end else
		
		String email1="@.";
		if(us2.validEmail(email1)) {
			System.out.println(email1+"유효");
		}else {
			System.out.println(email1+"무효");
		}//end else
		
		
	}//main
}//class
