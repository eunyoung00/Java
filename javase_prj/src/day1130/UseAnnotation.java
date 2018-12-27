package day1130;

import java.util.ArrayList;
import java.util.List;

/**
 * JDK 1.5에서 부터 추가된 annotation의 사용.<br>
 * Deprecated, Override, SuppressWarnings<br>
 * 나머진 1.7에서 나왔당
 * @author owner
 */
public class UseAnnotation {
	
	/**
	 * 이 method는 자라서 문제를 발생시킬수 있습니다.(아닐수도)
	 */
	@Deprecated //오, 적으니까 메소드명이 -그어진다. //문제가 있어보이니까 쓰지마~
	public void test() {
		System.out.println("오락가락 하는 method");
		System.out.println("차후에 문제가 발생될 method");
	}//test
	
	@Override
	public String toString() {
		return "온뇨쇼초몬도";
	}
	
	@SuppressWarnings({"rawtypes","unused"})
	//method위에 설정하면 method내의 모든 경고 상황을 무시한다.
//	@SuppressWarnings("unused")
	public void temp() {
		//unused : 변수를 사용하지 않을 때 경고를 무시.
//		@SuppressWarnings("unused")
		int i=0;//경고를 보지 않는것보다, 지우거나 하는게 좋다.
		
		//rawtypes : Generic을 사용하지 않을때 경고를 무시.
//		@SuppressWarnings("rawtypes")
		List l = new ArrayList();
		
		
		//rawtypes : Generic을 사용하지 않을때 경고를 무시.
//		@SuppressWarnings({"rawtypes","unused"})
		//변수위에 설정하면 바로 아래있는 변수만 경고를 무시하고, 
		List ll = new ArrayList();
		
		int j=0;
		System.out.println("temp j="+j);
	}
	

	public static void main(String[] args) {
		UseAnnotation ua=new UseAnnotation();
		ua.test();
		System.out.println(ua);

	}//main
}//class
