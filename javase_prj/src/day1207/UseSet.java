package day1207;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * Set :검색의 기능이 없으며(get X), 중복값을 저장하지 않는(유일) 기능을 가짐.  
 * 
 * @author owner
 */
public class UseSet {
	public UseSet() {
		//JDK 1.5 이하에서는 Generic이 지원되지 않고, 객체만 저장된다.
		//<List,Set,Map다. 
		//1.생성
		Set<String> set = new HashSet<String>();//is a 관계의 인스턴스화
		//<ctrl+shift+o import정리.
		//2.값 할당 : 순서대로 입력되지 않는다.
		set.add("정택성");
		set.add("이재현");
		set.add("공선의");
		set.add("김정운");
		set.add("노진경");
		set.add("최지우");//<순차적으로 들어가지 않는다.
		set.add("이봉현");//<index를 보장할 수 없음.
		set.add("김정운");
		set.add("김정운");
		set.add("김정운");//중복값을 저장하지 않는다.<<(값을 유일하게 관리)
		System.out.println(set.size()+" / "+set);//toString을 override해서.
		set.remove("김정운");//가변길이형.
		System.out.println(set.size()+" / "+set);//toString을 override해서.
		
		//배열로 복사
		String[] names = new String[set.size()];
		set.toArray(names);
		
		//set의 모든 방(Element,요소=e)의 값 출력
//		System.out.println(set.get("김정운"));//set자체에는 검색의 기능이 없다.
		//<향상된 for 문 으로는 iterator 필요없어짐.
		for(String temp : names) {
			System.out.print(temp+" ");
		}//하지만 Iterator가 속도가 빠르당....List도 Iterator로 넣을정도!
		System.out.println("=============Iterator===============");
		
		//iterator를 사용하여 값을 얻기
		Iterator<String> ita = set.iterator();//set의 제어권이 넘어간다.
		
		
		String name="";//""=mt
		while(ita.hasNext()) {//Iterator가 참조하는 Set의 요소가 존재한다면
			name=ita.next();//해당 요소의 값을 얻고 다음 포인터로 이동.
			System.out.println(name);
		}//end while
		
		//모든 방의 값 삭제
		set.clear();
		System.out.println("clear후 size:"+set.size()+" , 값:"+set);
		System.out.println("=============배열에 복사한 값===============");
		for(int i=0; i<names.length; i++) {
			System.out.println(names[i]);
		}
		
	}//UseSet
	
	public int[] lotto() {
		int[] tempLotto=new int[6];
		//여러판 할때에는 2차원배열로??
		
		Random random = new Random();
		for(int i=0; i<tempLotto.length; i++) {
			tempLotto[i]=random.nextInt(45)+1;//같은수가 발생할 수 있다.
			for(int j=0; j<i; j++) {//<가장처음엔 돌지 않겠죠
				if(tempLotto[i]==tempLotto[j]) {//방의 값이 같다.
					i--;//중복발생된 번호의 인덱스번째를 다시 발생시키기 위해
					//인덱스번호를 하나 줄인다.
					break;//반복문을 빠져나간다.
				}//end if
			}//end for
		}//end for
				
		return tempLotto;
	}//lotto
	
	public Integer[] lotto1() {
//		int[] tempLotto=new int[6];
		Integer[] tempLotto=new Integer[6];
		
		Set<Integer> set = new HashSet<Integer>();
		Random random = new Random();
//		for(; ;) {
		while(true) {
			set.add(random.nextInt(45)+1);//같은수가 추가되지 않는다.
			if(set.size()==6) {
				break;
			}//end if;
		}//end for
		set.toArray(tempLotto);
		return tempLotto;
	}//lotto
	
	public static void main(String[] args) {
		UseSet us=new UseSet();
		int[] temp = us.lotto();
		
		for(int i=0;i<temp.length; i++) {
			System.out.print(temp[i]+" ");
		}//end for
		
		System.out.println("\n--------------------------------");
		Integer[] temp1 = us.lotto1();
		for(int i=0;i<temp1.length; i++) {
			System.out.print(temp1[i]+" ");
		}//end for
		
	}//main
}//class
