package day1130;

public class RunConstr {
	
	public static void main(String[] args) {
/*		SubConstr sc = new SubConstr();
		//자식의 기본생성자. 아무런 연관이 없는 같은 레벨의 클래스 
		
		//상속을 받자 부모기본-자식기본
		SubConstr sc1 = new SubConstr(200);
		//여기에 200을 넣으면 자식만 인자 부모는 기본.
		//subConstr에 super를 넣고 인자를 위아래 다 넣어주면 인자있는 생성자가 나온다.
*/		
		SubConstr sc = new SubConstr();
//		new SubConstr();//가능
		//부모기본, 부모 인자300 / 자식인자200, 자식 기본
		//자식기본->this(200);->SubConstr(200)->자식200->super(300);->
		//SuperConstr(300)->this();->부모300->SuperConstr()->부모기본
		//반장님설명: 오브젝트를 다녀오면서 출력되고 닫힘괄호를 만나 다음출력쪽으로 가 실행되고 닫힘괄호 만나~~
		//나:거꾸로 타고 들어가며 스택에 차곡차곡 담아 오브젝트 찍고 나오면서 코드 실행되어 쭉 다시 타고나온다?
		//강사님: 제일먼저 object가 만들어 지고,나를부른쪽으로 가서 나머지 코드 수행->닫힘괄호만나
		//호출된곳으로 , 쮹쮹...
		System.out.println("----------------------------------------");
		SubConstr sc1 = new SubConstr(100);
//		new SubConstr(100);//가능
		//부모 인자 100, 부모기본 / 자식 기본, 자식인자100
		//자식100->this();->자식기본->(super();->생략가능)부모기본->this(100);->부모100
		//->super->object 까지 해야함.
		//설명 : 닫힘괄호를 만나 호출되었던 곳으로 돌아가는것/
		//뒤에서 보면 편하더라...
		
		
	}

}
