package day1127;

/**
 * 문자열 저장소의 주소를 저장하고, 문자열을 다루는 기능을 제공하는 String class의 사용<br>
 * java에서 제공하는 클래스의 이름과 내가만든 클래스의 이름이 같다면 내가만든 클래스를 먼저 사용하게 된다.<br>
 * java에서 제공하는 클래스를 사용할 때마다, "full path:패키지 명을 모두 기술하여 클래스를 사용하는것"
 * 로 사용해야 한다.
 * 패키지명.클래스명
 * =))번거로움 귀찮음 같은이름의 클래스를 안만들면 된당. 특히 lang에있는것 주의
 * @author owner
 */
public class UseString {

	
	public static void main(String[] args) { 
		//<이름이 같을때 내것을 먼저썼기 떄문에
		//<자바.랭.스트링을  써야하는데 내가만든 스트림을 사용하게됨.
//		System.out.println("안녕?");//Error 내클래스명때문에.
		
		//기본형 형식 사용. String s ="문자열";
//		java.lang.String s="ABCD"; //풀패스 사용할 때 이렇게 사용하게 됨.
		String str="AbcdEfg";
		
		//참조형 형식 사용. String s=new String("문자열");
		String mail=new String("beebee1170@naver.com");
		//rurouni5181@daum.net
		
		System.out.println(str);
		System.out.println(mail); //끝에 널문자가 들어감을 잊지말자. 
		
		System.out.println(str+"의 길이 "+str.length());
		System.out.println(mail+"의 길이 "+mail.length());
		
		System.out.println(str+"을 모두 대문자 "+str.toUpperCase());
		System.out.println(str+"을 모두 소문자 "+str.toLowerCase());
		//"AbcdEfg"
		// 0123456 7
		//indexOf는 왼->오 로 진행하면 가장처음 찾아지는 문자열의 인덱스를 얻는다.(L->R)
		System.out.println(str+"에서 'd'의 인덱스 : "+str.indexOf("d"));//있으면있는거
		System.out.println(str+"에서 'd'의 인덱스 : "+str.indexOf("dEf"));
		System.out.println(str+"에서 'z'의 인덱스 : "+str.indexOf("z"));//없으면 -1
		
		System.out.println(mail+"에서 \"@\"의 인덱스 : "+mail.indexOf("@"));
		str="AbcdEfAg";
		//lastIndexOf는 오->외 방향으로 진행하면서 가장처음 찾아지는 문자열의 인덱스를 얻는다.(R->L)
		System.out.println(str+"문자열에서 뒤로부터'A'의 인덱스 : "+
							str.lastIndexOf("A"));
		
		//특정 인덱스의 문자 얻기
		char temp =str.charAt(2);
		System.out.println(str+"에서 2번째 인덱스에 해당하는 문자 "+temp);
//		char temp2 =str.charAt(200);//없는자리 넣으면 Error
//		System.out.println(str+"에서 200번째 인덱스에 해당하는 문자 "+temp2);
		
		//자식문자열 자르기
		//str="AbcdEfAg";
		System.out.println(str+"에서 인덱스가 2~5번째 해당하는 문자열 "+
							str.substring(2,5));//f자리에 null이 덮어씀.
		System.out.println(str+"에서 인덱스가 2~5번째 해당하는 문자열 "+
				str.substring(2,6));//f까지 나오려면 +1
		
		//"beebee1170 @n a v e r . c o m"
		// 012345678910111213141516171819 <- String index
		System.out.println(mail+"에서 메일 주소만 얻기 "+mail.substring(0, 10));//사람마다 다름으로 @찾는게 좋다.
		System.out.println(mail+"에서 메일 주소만 얻기 "+mail.substring(0, mail.indexOf("@")));
		System.out.println(mail+"에서 도메인 주소만 얻기 "+mail.substring(11,20));
		System.out.println(mail+"에서 도메인 주소만 얻기 "+mail.substring(mail.indexOf("@")+1,mail.length()));
		//substring는 시작인덱스만 넣으면 끝까지 잘라낸다.
		System.out.println(mail+"에서 도메인 주소만 얻기 "+mail.substring(mail.indexOf("@")+1));
		
		//앞뒤 공백 자르기, <사이공백은 자를수 없다.
		str="   A BC    ";
		System.out.println("["+str+"]에서 앞뒤 공백 제거["+str.trim()+"]");
		
		//문자열 붙이기, <concat도 +도 모두 가능.
		str="Abcd";
		String str1=str.concat("Efg");
		String str2=str+"Efg";
		System.out.println(str1);
		System.out.println(str2);
		
		//문자열이 완벽하게 같은지 비교
//		str="이재찬";
		str="이재현";
		System.out.println(str+"은(는) "+(str.equals("이재찬")?"반장":"평민"));
		
		//문자열이 이 문자열로 시작하는지
//		str="피씨방";
		str="씨방새리";
		if(str.startsWith("씨방")) {
			System.out.println("욕은 사용하실수 없습니다.");
		}else {
			System.out.println(str);
		}//end else
		
		str="서울시 강남구";
		str1="수원시 팔달구";
		System.out.println(str+"은(는) "+
					(str.startsWith("서울")?"서울시 입니다.":"서울이 아닙니다."));
		
		//특정문자열로 끝났는지
		str="서울시 강남구 역삼동";
		str1="경기도 김포시 김포리";
		System.out.println(str+"은(는) "+
							(str.endsWith("동")?"도시":"시골"));
		System.out.println(str1+"은(는) "+
							(str1.endsWith("동")?"도시":"시골"));
		
		//치환 : 문자열 내의 모든 문자열 찾아서 "치환"
		//replaceAll or replace
		//replaceAll(String regex(정규식의 약자), String replacement)  
		str="나 지금 피씨방인데 넌 어디니 씨방새야!";
		str="나 지금 피씨방인데 넌 어디니 씨 방새야!";
		str="나 지금 피씨방인데 넌 어디니 ㅆ ㅣ 방새야!";
		
//		System.out.println(str.replace("씨방", "**"));
		System.out.println(str.replaceAll("씨방", "**"));
		//method를 연결해서 호출하는 것을 method chain ▼
		System.out.println(str.replace("씨", "*").replaceAll("방", "*"));
		
		str="  A BC  ";
		System.out.println(str.replace(" ", ""));//ABC나옴.
		
		int i=27;
//		str=i;//<형이 달라 담기지 않는다.//int는 String으로 할당 될 수 없다.
		//기본형 데이터형을 문자열로 변환
		str=String.valueOf(i);//저장하지않고?그래서 static method
		System.out.println(str);
		double d= 11.27;
//		str=d;//<형이 달라 담기지 않는다.
		str=d+""; //문자열이 붙으면 문자열이 된다.c에서 주로쓰고 자바에선 권장ㄴㄴ
		System.out.println(str);
		
//		str="11";
		str="";
		System.out.println(str.isEmpty());
		
		//객체생성을 하지 않았을 때 그 클래스가 제공하는 method를 사용할수 없다. Error 
		//<클래스랑 객체는 같지 않고 설계도와 구현체는 다른거다.
//		str=null;//heap의 주소를 저장하지 않았습니다.=>생성하지 않음.
//		System.out.println(str.isEmpty());//Error
		
		///////////////////////11-28-2018 split 사용 코드 추가/////////////
		String data="이재찬,이재현,정택성~공선의~김건하.최지우,노진경,김정운.김정윤";
		//split은 한번에 하나의 문자로 구분하여 자른다.
		String[] arr=data.split("[.]");//한글도 구분되지만 .은 그냥 쓰면구분되지 않는다.
		//[]로 묶어서 쓴다=>[.]로 가능
		System.out.println("구분된 배열 방의 갯수 : "+arr.length);
		for(String name : arr) {
			System.out.println(name);
		}//end for
		//<여러개를 한꺼번에 자를수없다. 한번에 하나 틸드면틸드, 컴마면 컴마
		
		
		
	}//main
}//class
