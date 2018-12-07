package day1206;

import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

public class Work23 {
//	1.아래의 데이터를 처리하는 프로그램을 작성하세요.
//	백인재, 이봉현,이재찬,정택성,이재현,김정운 의 데이터가 존재하고,
//	점수는 0~100점 사이로 발생할 수 있습니다.
//	
//	프로그램이 실행되면 위의 사람중에 2명이상이 성적처리 대상자 이고 n명의 이름과 점수를 저장하여 
//	출력하는 일을 하는 프로그램을 작성.
//	중복이름은 들어갈 수 없다.
//	출력 예)
//	이재찬 89
//	정택성 77
//	김정운 90
//	총점 xx점

//	List/난수    성적처리 method와 출력method 구분.

	ArrayList<String> nameList, printList;
	Random rd;
	String[] arr;
	int total;

	public Work23() {
		nameList = new ArrayList<String>();
		printList = new ArrayList<String>();
		rd = new Random();

	}

	// list,array에 이름 넣기.
	public String[] Token(String name) {
		StringTokenizer stk = new StringTokenizer(name, ",");
		arr = new String[stk.countTokens()];
		int i = 0;
		while (stk.hasMoreTokens()) {
			arr[i] = stk.nextToken();
//			System.out.print(arr[i]+" ");
			nameList.add(arr[i]);
			i++;
		}
//		System.out.println(nameList);
		return arr;
	}// Token

	public void printname() {
		int person = rd.nextInt(nameList.size() - 2) + 2;// 2명이상
		int name = 0;
		int score = 0;
		
		total = 0;
		for (int i = 0; i < person; i++) {
			name = rd.nextInt(nameList.size());// 0~5
			score = rd.nextInt(101);// 0~100

			printList.add(nameList.get(name) + " " + score);

			nameList.remove(name);
			
			total = total + score;
			System.out.println(printList.get(i));

		}
		System.out.println("총점 " + total + " 점");
	}

	public static void main(String[] args) {
		Work23 hw = new Work23();
		hw.Token("백인재,이봉현,이재찬,정택성,이재현,김정운");
		hw.printname();
		// 지금상태~~총점 안더해 지고, 이름 중복!
		// 데이터를발생 vs 데이터를 출력하는 저장,출력

	}// main

}// class
