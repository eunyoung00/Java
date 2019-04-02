package day0402;

import java.util.HashMap;
import java.util.Map;

public class Run {

	/**
	 * is a 관계를 사용했을 때
	 **is a -자식은 부모이다.(자식클래스로 부모를 얻어 사용하는것) 
	 */
	public void useIsA() {
		Map<String, Person> map=new HashMap<String,Person>();
		//값 할당
		map.put("gong", new SeonUi());
		map.put("lee", new JeaHyun());
		map.put("Jung", new TeackSung());
		
		//키
		String key="Jung";
		//Is a -객체 다형성을 사용하여 부모에 얻어낸 자식을 저장한다.
		if(map.containsKey(key)) {//nullPoint 방지
			Person person=map.get(key);
			System.out.println(person.execute());
		}//end if
	}//useIsA
	
	/**
	 * is a 관계를 사용하지 않고 객체를 사용할 때
	 **is a 안쓰고 ->코드가 더 줄어듦
	 */
	public void notUseIsA() {
		Map<String, Object> map=new HashMap<String,Object>();
		//값 할당
		map.put("gong", new SeonUi());
		map.put("lee", new JeaHyun());
		map.put("Jung", new TeackSung());
		
		//값 사용
		//is a 를 쓰지 않으면 값 사용하는 코드가 길어진다.
		String key="gong"; //입력하는 값 = 커멘드=commend  
		//gong이 아니면 SeonUi는 Error 따라서 if로 확인해주어야 한다.
		if("gong".equals(key)) { //문자열은 널포인트 방지로 앞에두고 비교한다.
			SeonUi su=(SeonUi)map.get(key);
			System.out.println(su.execute());
		}//end if
		if("lee".equals(key)) {
			JeaHyun jh=(JeaHyun)map.get(key);
			System.out.println(jh.execute());
		}//end if
		if("Jung".equals(key)) { 
			TeackSung ts=(TeackSung)map.get(key);
			System.out.println(ts.execute());
		}//end if
	}//notUseIsA
	
	
	public static void main(String[] args) {
		Run run=new Run();
		run.useIsA();
		System.out.println("=======================================");
		run.notUseIsA();
	}//main
}//class
