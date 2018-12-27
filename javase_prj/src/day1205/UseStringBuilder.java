package day1205;

/**
 * StringBuffer, StringBuilder(JDK1.5)<br>
 * 문자열을 메모리에(heap에 직접)저장하고 사용하는 클래스 <br>
 * @author owner
 */
public class UseStringBuilder {
	public void useStringBuffer() {
		//1.클래스를 생성
		StringBuffer sb = new StringBuffer();
		//2.값(정수,실수,문자,boolean,문자열,,,) 추가
		sb.append("오늘은 ");//문자열
		sb.append(12);//정수
		sb.append("월 5일 ").append("수요일 입니다.");
		System.out.println(sb);
		System.out.println(sb.indexOf("은"));
		
		//3.값 삽입
		//오늘은 12월 5일수요일 입니다.(뒤에 잇는게 append, 사이에 삽입하는게 insert)
		//01 234567
		sb.insert(4, "2018년");
		System.out.println(sb);
		
		//4.값 삭제 : delete(시작인덱스, 끝인덱스+1) 사이의 문자열을 자름 문자열끝의
		//null자리 때문에 +1을 해주어야 인식해서 자를수 있다.
		//오늘은 2018년12월 5일 수요일 입니다.
		sb.delete(0, 3);
		System.out.println(sb);
//		sb.delete(0, sb.length());//로 끝까지 잘라낼수도 있다.
//		System.out.println(sb);
		
		//값뒤집기.
		sb.reverse();
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
		//원본문자열이 변경된다.

	}//useStringBuffer
	
	
	public void useStringBuilder() {
		//1.클래스를 생성
		StringBuilder sb = new StringBuilder();
		//2.값(정수,실수,문자,boolean,문자열,,,) 추가
		sb.append("오늘은 ");//문자열
		sb.append(12);//정수
		sb.append("월 5일 ").append("수요일 입니다.");
		System.out.println(sb);
		System.out.println(sb.indexOf("은"));
		
		//3.값 삽입
		//오늘은 12월 5일수요일 입니다.(뒤에 잇는게 append, 사이에 삽입하는게 insert)
		//01 234567
		sb.insert(4, "2018년");
		System.out.println(sb);
		
		//4.값 삭제 : delete(시작인덱스, 끝인덱스+1) 사이의 문자열을 자름 문자열끝의
		//null자리 때문에 +1을 해주어야 인식해서 자를수 있다.
		//오늘은 2018년12월 5일 수요일 입니다.
		sb.delete(0, 3);
		System.out.println(sb);
		
		//값뒤집기.
		sb.reverse();
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
		
		//<원본문자열이 변경된다~!~!
		
	}//useStringBuilder

	public static void main(String[] args) {
		UseStringBuilder usb = new UseStringBuilder();
		usb.useStringBuffer();
		System.out.println("--------------------------------------");
		usb.useStringBuilder();
		
		
		
		String str="안녕하세요?";//짧은 문자열은 String 에 저장한다.
		System.out.println(str);
		String str1="안";
		//문자열에 +가 붙엉서 긴 문자열이 된다.
		System.out.println(str1+"녕"+"하"+"세"+"요?");
		//new StringBilder().append(str1),append("녕").append("하"),,,
		//String에 +쓰지 않는다! 속도문제
		
		
	}//main
}//class
