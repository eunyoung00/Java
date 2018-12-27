package day1127;

public class ssnCheck {

	public String ssn;
	
	public ssnCheck(String ssn) {
		//1-1 생성자는 주민번호를 받아 instance변수에 할당한다.
		this.ssn=ssn;
	}
	
	public boolean checklen() {
		//1-2 주민번호의 길이체크하여 14자가 아니면 false반환
		boolean cl=false;
		if(!(ssn.length()==14)) {
			cl=false;
		}else {
			cl=true;
		}
		return cl;
	}
	
	public boolean checkhyphen() {
//		1-3 주민번호의 6번째 자리가'-'아니면 false 반환.
		boolean ch=false;
		if(!(ssn.indexOf("-")==6)) {
			ch=false;
		}else {
			ch=true;
		}
		return ch;
	}
	
	public boolean checkval() {
		//1-4 주민번호의 유효성검증하여 유효하면 t/f반환.
		boolean cv=false;

		//ssn.charAt(0)=>아스키코드라서 0또는 48을 빼주어야 원하는 숫자가 나온다.
		//아스키코드값이 나와서 1이 들어가도 49라는 코드 값이 나온다.
		//따라서 원하는 숫자를 얻으려면 48이나 같은값인 '0'을 빼주어어야 원하는 수인 1을 얻을수 있다.
		
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
		//1-5 생년월일 반환 하는 일 "1988-11-11"
		//mail+"에서 메일 주소만 얻기 "+mail.substring(0, mail.indexOf("@"));
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
		//1-6 나이를 반환하는 일 31
		int age;
		String year;
		year=birth().substring(0, 4);
//		System.out.println(year);
		age=2018-Integer.valueOf(year)+1;
		return age;
	}
	
	public String gender() {
		//1-7 성별을 반환   남/여 홀수남자 / 짝수여자
		String gender="여자";
		int num=Integer.valueOf(ssn.substring(7,8));
		if(num%2==0) {
			gender="여자";
		}else {
			gender="남자";
		}
		return gender;
	}
	
	public String nation() {
		//1-8 내국인/외국인 반환 
		String nation;
		int num=Integer.valueOf(ssn.substring(7,8));
//		System.out.println(num);
		if(num==1||num==2||num==3||num==4||num==0||num==9) {
			nation="내국인";
		}else
			nation="외국인";
		return nation;
	}
	
	public String czs() {
		//1-9 띠를 반환  "양띠"
		//0~11
		//11 : 양띠, 10 : 말, 9: 뱀,8 :용 ,7 :토끼 , 6 : 호랑이, 5: 소, 4: 쥐,
		//3: 돼지, 2: 개, 1:   닭 ,0 : 원숭이
		int year=Integer.valueOf(birth().substring(0, 4));
		String[] czs = new String[] {"원숭이","닭","개","돼지","쥐","소",
								"호랑이","토끼","용","뱀","말","양띠"};
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
//					System.out.println("유효한 주민번호입니다.");
					System.out.println(ssnc.birth());
					System.out.println(ssnc.age());
					System.out.println(ssnc.gender());
					System.out.println(ssnc.nation());
					System.out.println(ssnc.czs());
				}else {
					System.out.println("잘못된 주민번호 입니다.");
				}//end else
			}else {
				System.out.println("-(하이픈)의 위치가 틀립니다.");
			}//end else
		}else {
			System.out.println("주민번호의 길이가 틀립니다.");
		}//end else
		
	}//main
}//class
