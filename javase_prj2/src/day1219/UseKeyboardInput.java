package day1219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 사용자가 입력한 키보드의 값을 처리하는 System.in
 * @author owner
 */
public class UseKeyboardInput {
	public UseKeyboardInput() {
	
		System.out.println("아무키나 누르고 엔터");
		//3.입력된 모든 문자열 을 받고 싶다!!
		//3.8bit Stream과 16bit Stream을 연결
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));//으로 Stream연결
		
		try {
			//1.입력값중 최초 입력 문자 하나 받기
//			int input=System.in.read();
			//<read 는 블록method 차후 동작이있어야 아래로 진행이되는 method이다.
			//read는 8bit라 한번에 하나..(맞나?)
//			System.out.println("입력값 : "+input);//<a가 눌린지 키보드는 모른다?키코드 값65만 알뿐. 
			//키코드에대한 유니코드?읽어주는거라고?
			//키보드 버퍼는 키코드 값을 가지고 들어가는데, os에서 key가 눌리기전에 key에대한 조합을 문자로 변경해 유니코드값으로 자바가상머신이 읽게된다.
			//그래서 대문자 소문자가 다른 유니코드를 가지기때문에 다른결과가 나오는것.
			//키를 누르면 os로 갔다가 자바가 빼오는것?ㄷ
			
			//2.입력된 모든 문자열 받기 : 한글은 받을수 없다.
//			int input=0;
//			while(true) {
//				input =System.in.read();
//				System.out.print((char)input);//char로 캐스팅하면 넣은대로 나온다..문제는 한글이 안됌..
//				if(input==13/*Enter의 값*/) {
//					break;
//				}//end if
//				//if문을 막으면 13과 10이 나오는데, \n과 \r이 출력되는것. window에는 붙는다?
//			}//end while
			
			//16bit Stream을 사용하여 입력된 데이터를 줄단위로 읽어 들인다.
			String str=br.readLine();
			System.out.println(str);
			//스트림 사용이 끝났으면 스트림의 연결을 끊는다.
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//UseKeyboardInput

	public static void main(String[] args) {
		new UseKeyboardInput();
	}//main

}//class
