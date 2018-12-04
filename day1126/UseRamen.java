package day1126;

/**
 * 라면을 추상화하여 만든 Ramen클래스를 사용하는 클래스
 * @author owner
 */
public class UseRamen {

	public static void main(String[] args) {
		Ramen men1 = new Ramen();
//		System.out.printf("생성된 라면객체 정보 : 제조사[%s], 이름[%s], 면[%d],스프[%d]\n", 
//				men1.getMaker(),men1.getName(),men1.getMen()
//				,men1.getMsg());
		men1.setMaker("농심");
		men1.setName("오징어 짬뽕");
		men1.setMen(1);
		men1.setMsg(1);

		
		System.out.printf("생성된 라면객체 정보 : 제조사[%s], 이름[%s], 면[%d],스프[%d]\n", 
				men1.getMaker(),men1.getName(),men1.getMen()
				,men1.getMsg());
		
		Ramen men11 = new Ramen();
		System.out.printf("생성된 라면객체 정보 : 제조사[%s], 이름[%s], 면[%d],스프[%d]\n", 
				men11.getMaker(),men11.getName(),men11.getMen()
				,men11.getMsg());
		
		
		Ramen men2 = new Ramen("팔도","비빔면",0,10);
//		men2.setMaker("팔도");
//		men2.setName("비빔면");
//		men2.setMen(0);
//		men2.setMsg(10);
		System.out.printf("생성된 라면객체 정보 : 제조사[%s], 이름[%s], 면[%d],스프[%d]\n", 
				men2.getMaker(),men2.getName(),men2.getMen()
				,men2.getMsg());
		
		Ramen men3 = new Ramen("농심","오징어 짬뽕",2,3);
//		men3.setMaker("농심");
//		men3.setName("오징어짬뽕");
//		men3.setMen(1);
//		men3.setMsg(3);
		System.out.printf("생성된 라면객체 정보 : 제조사[%s], 이름[%s], 면[%d],스프[%d]\n", 
				men3.getMaker(),men3.getName(),men3.getMen()
				,men3.getMsg());
		
		System.out.println(men1.eaten());
		System.out.println(men2.eaten());
		System.out.println(men3.eaten());
		
	}//main
}//class
