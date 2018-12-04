package day1122;

public class Work20 {
//	숙제 
//	아래의 업무를 처리하는 method를 type에 알맞게 작성하고 API주석을
//	 설정한 후 호출하여 결과를 본 후 Java Doc을 생성해보세요.
//	- API주석은 어떤 형태의 method인지를 주석으로 기술할것.
//	1.입력받는다는이야기가없으니까 고정값-반환형o_String 매개변수 x 
//	2.가변값-반환형o_int 매개변수o _int
//	3.가변값-반환형o_int 매개변수 o_char
//	4.가변일-반환형 o void 매개변수 o_int	
//	5.고정일-반환형x, 매개변수 x   <진짜 집주소.....
//	6.가변일-반환형x_void 매개변수 o variable Arguments

	/**
	 * 1. 자신의 이름을 반환하는 method작성.
	 * @return 이름 반환
	 */
	public String name() {
		String name1 = "박은영";
		System.out.println(name1);
		return name1;
	}

	/**
	 * 2. 나이를 입력받아 태어난 해를 반환하는  method 작성.
	 * @param age 입력받은 나이
	 * @return 태어난해 
	 */
	public int year(int age) {
		int year1 = 2018-age+1;
		System.out.println("태어난 해 : "+year1);
		return year1;
	}

	/**
	 * 3. 문자를 입력받아 해당 문자의 Unicode 값을 반환하는 method 작성.
	 * @param c unicode로 변환할 문자
	 * @return 해당 문자의 unicode
	 */
	public String uni(char c) {
		String code = Integer.toHexString(c);
		System.out.println(c+"의 Unicode는 : "+code);
		return code;
	}

	/**
	 * 4. 숫자를 입력받아 숫자가  영문자, 숫자의 범위에 있을 때 해당 숫자의 문자를
	 *   출력하는 일을 하는 method  작성
	 * @param num 영문자, 숫자의 범위의 숫자
	 */
	public void character(int num) {
		char c = (char)num;
		//if(num >=65 && num<123 || num>=48&&num<58) {
		if(num >='A' && num<='Z' || num>='0'&&num<='9'||num >='a' && num<='z') {
		
			System.out.println(c);
		}else {
			System.out.println("범위를 벗어났습니다.");
		}
	}
	
	/**
	 * 5. 호출하면 자신의 주소를 출력하는  method 작성.
	 * @param w20 클래스를 데이터형으로 w20은 임의의 변수명
	 */
	public void local(Work20 w20) {
//		System.out.println("c:\\dec\\scr\\javase_prj");
		System.out.println(w20);
	}
	
	/**
	 * 6. 친구의 이름을 입력받아 출력하는  method 작성<br>
	 *     (친구는 n명 입니다.)
	 * @param n 친구의 이름
	 */
	public void fname(String ...n) {
		System.out.println("친구는 "+n.length+"명 입니다.");

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
		hw.fname("박은영","박소영","김민정");//6
		
	}//main
}//class
//일은 그일을 하고 보여줄 뿐이지만 값은 리턴 값이 메소드에 대치되서 나간다 
