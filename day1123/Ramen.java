package day1123;

/**
 * Work21
 * 너구리 오징어짬뽕 신라면 을 대상으로 class 작성
 * 명사적인특징 : 같은 제조사,라면,스프,이름  , 가격,패키지      면스프패키지
 * 동사적인특징 : 먹힌다 ,  판매된다,끓인다,뿌신다       끓인다뿌신다
 * 
 * 객체화) Ramen men = new Ramen();
 * @author owner
 */
public class Ramen {
	private String maker,name;
	private int men,msg;
	
	/**
	 * 생성된 라면 객체에 제조사를 설정하는 일 
	 * 농심이라는 제조사밖에 들어갈수 없다.
	 * @param maker 제조사
	 */
	public void setMaker(String maker) {
		if(maker.equals("농심")) {
			this.maker = maker;
		}else {
			this.maker="농심";
		}

		//=>이렇게는 쓸수 없다..? maker의 값이 null로 초기화 되어있는데 그걸 넣어버림?
	}//setMaker
	
	/**
	 * 생성된 라면 객체에 이름을 설정하는 일 
	 * 신라면,오징어짬뽕,너구리만 넣을수 있고,그외의값은 너구리가 들어간다.
	 * @param name 라면이름
	 */
	public void setName(String name) {
		if(!(name.equals("신라면")||name.equals("오징어짬뽕")||name.equals("너구리"))) {
			name="너구리";
		}
		this.name = name;
	}//setName
	
	/**
	 * 생성된 라면 객체의 면의 수.
	 * 면은 1개 일수밖에 없고, 그외의 값은 1로 들어간다.
	 * @param men 면의 갯수
	 */
	public void setMen(int men) {
		if(!(men==1)) {
			men=1;
		}
		this.men = men;
	}//setMen
	
	/**
	 * 생성된 라면객체의 스프 수.
	 * 1~5개까지 들어갈수 있고 그외의 값은 1가 들어간다.
	 * @param msg 스프 갯수
	 */
	public void setMsg(int msg) {
		if(!(msg>=1&&msg<=5)) {
			msg = 1;
		}
		this.msg = msg;
	}//setMsg
	
	public String getMaker() {
		return maker;
	}//getMaker
	
	public String getName() {
		return name;
	}//getName
	
	public int getMen() {
		return men;
	}//getMen
	
	public int getMsg() {
		return msg;
	}//getMsg
	
//	public String eat(String menu,int price) {
//		return name+"이(가) 식당에서 "+menu+"인 음식을 "+price+"원 내고 사먹는다.";
//	}//eat
	public String eaten() {
		return maker+"\""+name+"\"라면은 사람에게 먹힌다.";
	}//eaten
	
	
}//class
