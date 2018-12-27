package day1206;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import javax.swing.plaf.synth.SynthSeparatorUI;

/**
 * List : <br>
 * 중복값을 허용하며 검색의 기능이있고, 순서대로 값을 입력하는 가변길이형.
 * 
 * @author owner
 */
public class UseList {
	
	public UseList() {
/*		//JDK 1.4에서는 Generic이 제공되지 않고 객체만 저장된다.
		List list = new ArrayList();
		//값추가 : JDK 1.5이하 에서는 객체로만 값을 넣을 수 있다.
//		list.add(10);//<1.4버전은 객체만 받아서 Error
		list.add(new Integer(10));
		list.add(new Short((short)10));
		list.add("공선의");
		
		System.out.println(list.size());//=>3
		//값얻기
//		System.out.println(list.get(0)+10);//객체는 연산되지 않는다...구버전에서.
		System.out.println(((Integer)list.get(0)).intValue()+10);
*/
		//JDK 1.5+(이상) 에서의 사용 : Generic, autoboxing, unboxing
		List list = new ArrayList();
		list.add(10);//autoboxing이 되었기 때문에~!~Error안남
		//=>list.add(new Integer(10)); compiler가 해줌..
		list.add(20);
		list.add("김건하");
		
		System.out.println("크기"+list.size());
		System.out.println((Integer)list.get(0)+10);//만약2번방이되면 Error 그래서 Generic권장.
		
		System.out.println("----------Generic---------------");
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(10);
		list1.add(20);
		list1.add(new Integer(30));
//		list1.add("김건하");//<Error, 데이터형을 일치시키는것.
		//Generic으로 설정된 형이 아닌 데이터형을 추가할 수 없다.
		System.out.println("크기"+list1.size());
		System.out.println(list1.get(0)+10); //나오는것도 Integer이기 때문에 casting이 필요없음.
		
		for(int i=0;i<list.size(); i++) {
			System.out.println(list1.get(i));
		}//end for

	}//UseList
	
	/**
	 * ArrayList의 사용 : Multi Thread 환경에서 동시 접근 가능.(동기화가 되어있지 않다.) 
	 */
	public void useArrayList() {
		//1.생성
		ArrayList<String> al = new ArrayList<String>();//capa x =방0개
		List<String> al1 = new ArrayList<>(100);//생략가능. 적어주는걸 권장.
		//방100개.
		
		System.out.println(al+" / "+al1);//주소가 나오지 않은 이유는???
		//toString 을 Overriding 해서.(((주소가 안나오는건 다 override한것)))
		
		//값추가 : 순서대로 추가된다.
		al.add("이재현");
		al.add("정택성");
		al.add("김정윤");
		al.add("김건하");
		al.add("김정윤");	//중복값 저장가능.
		al.add("노진경");
		al.add("김정윤");	//중복값 저장가능.
		al.add("공선의");
		System.out.println(al+" / "+al1);
		//size() : 데이터의 크기 (방의크기가 아니라 값이 들어있는것의 크기)
		System.out.println("al의 크기 "+al.size()+"/ al1의크기 : "+al1.size());
		
		//배열에 복사
		String[] names = new String[al.size()];
		al.toArray(names);
		
		//방의 값을 삭제
		//인덱스로 삭제 : 특정인덱스 방의 값이 삭제.
		al.remove(4);
		System.out.println(al.size()+" / "+al);
		
		//방의 내요으로 삭제.
		al.remove("김정윤");//<가장 첫방이 삭제. vs 가장끝방의 값이 삭제된다.vs 모두삭제 된다.=>1번~!~!
		//L->R으로 진행하면서 일치하는 첫방의 값만 삭제.
		System.out.println(al.size()+" / "+al);
		
		//개선된 for loop
		for( String name : al) {
			System.out.println(name);
		}//end for
		
		//모든 방의 값 삭제:  
		al.clear();
		System.out.println("전체 삭제 후 : "+al.size()+"/"+al);
		
		//배열의 값
		for(int i=0;i<names.length;i++) {
			System.out.printf("%s\n",names[i]);
		}//end for
		
		
	}//useArrayList
	
	public void useVector() {
		//1.생성
		Vector<String> vec = new Vector<String>();
		List<String> vec1 = new Vector<>(100);

		
		System.out.println(vec+" / "+vec1);//주소가 나오지 않은 이유는???
		//toString 을 Overriding 해서.(((주소가 안나오는건 다 override한것)))
		
		//값추가 : 순서대로 추가된다.
		vec.add("이재현");
		vec.add("정택성");
		vec.add("김정윤");
		vec.add("김건하");
		vec.add("김정윤");	//중복값 저장가능.
		vec.add("노진경");
		vec.add("김정윤");	//중복값 저장가능.
		vec.add("공선의");
		System.out.println(vec+" / "+vec1);
		//size() : 데이터의 크기 (방의크기가 아니라 값이 들어있는것의 크기)
		System.out.println("vec의 크기 "+vec.size()+"/ vec1의크기 : "+vec1.size());
		
		//배열에 복사
		String[] names = new String[vec.size()];
		vec.toArray(names);
		
		//방의 값을 삭제
		//인덱스로 삭제 : 특정인덱스 방의 값이 삭제.
		vec.remove(4);
		System.out.println(vec.size()+" / "+vec);
		
		//방의 내요으로 삭제.
		vec.remove("김정윤");//<가장 첫방이 삭제. vs 가장끝방의 값이 삭제된다.vs 모두삭제 된다.=>1번~!~!
		//L->R으로 진행하면서 일치하는 첫방의 값만 삭제.
		System.out.println(vec.size()+" / "+vec);
		
		//개선된 for loop
		for( String name : vec) {
			System.out.println(name);
		}//end for
		
		//모든 방의 값 삭제:  
		vec.clear();
		System.out.println("전체 삭제 후 : "+vec.size()+"/"+vec);
		
		//배열의 값
		for(int i=0;i<names.length;i++) {
			System.out.printf("%s\n",names[i]);
		}//end for
		
	}//useVector
	
	public void useLinkedList() {
		//1.생성
		LinkedList<String> ll = new LinkedList<String>();
		List<String> ll1 = new LinkedList<>();
		
		System.out.println(ll+" / "+ll1);//주소가 나오지 않은 이유는???
		//toString 을 Overriding 해서.(((주소가 안나오는건 다 override한것)))
		
		//값추가 : 순서대로 추가된다.
		ll.add("이재현");
		ll.add("정택성");
		ll.add("김정윤");
		ll.add("김건하");
		ll.add("김정윤");	//중복값 저장가능.
		ll.add("노진경");
		ll.add("김정윤");	//중복값 저장가능.
		ll.add("공선의");
		System.out.println(ll+" / "+ll1);
		//size() : 데이터의 크기 (방의크기가 아니라 값이 들어있는것의 크기)
		System.out.println("ll의 크기 "+ll.size()+"/ ll1의크기 : "+ll1.size());
		
		//배열에 복사
		String[] names = new String[ll.size()];
		ll.toArray(names);
		
		//방의 값을 삭제
		//인덱스로 삭제 : 특정인덱스 방의 값이 삭제.
		ll.remove(4);
		System.out.println(ll.size()+" / "+ll);
		
		//방의 내요으로 삭제.
		ll.remove("김정윤");//<가장 첫방이 삭제. vs 가장끝방의 값이 삭제된다.vs 모두삭제 된다.=>1번~!~!
		//L->R으로 진행하면서 일치하는 첫방의 값만 삭제.
		System.out.println(ll.size()+" / "+ll);
		
		//개선된 for loop
		for( String name : ll) {
			System.out.println(name);
		}//end for
		
		//모든 방의 값 삭제:  
		ll.clear();
		System.out.println("전체 삭제 후 : "+ll.size()+"/"+ll);
		
		//배열의 값
		for(int i=0;i<names.length;i++) {
			System.out.printf("%s\n",names[i]);
		}//end for
	}//useLinkedList
	
	public static void main(String[] args) {
		//method가 여러개라 객체를 저장할 필요가 있다.
		UseList ui = new UseList();
		System.out.println("------------------ArrayList--------------------");
		ui.useArrayList();
		System.out.println("--------------------Vector--------------------");
		ui.useVector();
		System.out.println("-------------------LinkedList--------------------");
		ui.useLinkedList();
		
	}//main
}//class
