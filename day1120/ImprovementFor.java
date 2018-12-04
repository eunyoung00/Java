package day1120;

import java.util.ArrayList;
import java.util.List;

/**
 * 개선된/향상된 for : 배열이나 Collection들의 모든 방의 값을 처음부터 끝까지 순차적으로 출력하기 위해 제공되는 for.<br>
 *                 개선된 for문은 JDK1.5에서부터 사용가능, 그때 나왔다<br>
 * 문법) for(데이터형 변수명 : 배열명(Collection명)) {<br>
 *           변수명;(배열(Collection)방의 값을 사용할수 있다.)<br>
 *      }<br>
 *     // 인덱스는 쓸수 없다.<br>
 * @author owner
 */
public class ImprovementFor {

	public static void main(String[] args) {
		
		int[] tempArr= {2018,11,20,16,5};	//05는 8진수
		
		//이전의 for로 모든 방의 값을 출력
		for(int i=0; i<tempArr.length; i++) {
			System.out.println(tempArr[i]);
		}//end for
		
		System.out.println("--------------개선된 for---------------");
		
		//개선된 for 로 모든 방의 값 출력
		for(int value : tempArr) {
			System.out.println(value);
		}//end for 끝방부터 찍어라 이런거 못함 짝수번째 이런것도 ㄴㄴ무조건 처음부터 끝까지
		
		//Collection인데 list? <나중에 JCF할때??
		List<Integer> list = new ArrayList<>();	//<1.7이상..
		list.add(10);
		list.add(20);
		list.add(110);
		list.add(1);
		list.add(1000);
		System.out.println("==============List 이전    for==============");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}//end for
		
		System.out.println("==============List 향상된 for==============");
		for(int i : list) {
			System.out.println(i);
	 	}//end for
		//<이전의 기본 for와 향상for문은 결과는 같다. 코드의 간편함이 다름
		
	}//main
}//class
