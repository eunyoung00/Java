package day1129;

/**
 * 사람의 공통 특징을 부모(Person)로 부터 사용하고 자신만의 특징만(싸움을 잘함)정의.
 * @author owner
 */
public class HongGilDong extends Person2{
	private int level;//홀길동의 싸움 레벨
	
	/**
	 * 홍길동은 싸움을 평민보다 잘하므로 7로 시작
	 */
	public HongGilDong() {
		super();
		level=7;
		
	}//HongGilDong
	
	/**
	 * 싸움하는 일 : 입력된 레벨보다 낮다면 패배, 입력된 레벨보다 높다면 승리, 입력됩 레벨과 같다면 비김<br>
	 * 승리하면 레벨이 1증가, 패배하면 레벨이 1감소, 비기면 레벨변화 없음.
	 * 레벨은 최대 10, 최소 0을 가진다.
	 * @param inputLevel 싸움 상대자의 레벨
	 * @return 싸움의 결과
	 */
	public String fight(int inputLevel) {
		String result="";
		
		if(level>inputLevel) {//승리
			result="이겼다. s('.^)V";
			level++;
			if(level>10) {
				level=10;
			}//end if
		}else if(level<inputLevel) {//패배
			result = "졌다.Orz  ~(_-_)~";
			level--;
			if(level <1) {
				level=1;
			}//end if
		}else {//비김
			result="비김 --+;;";
		}//end else
		
		
		return result;
	}//fight
	
	@Override	//컴파일러한테 명령. annotation.
	public String toString() {
		//잘못하면 만들때는 모르고 실행해야 알게 된다.
		//이때에 method위에 annotation주는것
		//잘못했을때 Error로 잡아 줌.
		return "홍길동 객체의 값 눈 : "+getEye()+", 코: "+getNose()+", 입: "+getMouth();
	}//toString
	
	/* (non-Javadoc)
	 * @see day1129.Person2#eat(java.lang.String, int)
	 */
	/**
	 * 부모클래스가 제공하는 method의 기능이 자식에서 맞지않아<br>
	 * 장소인 식당 -&gt; 주막 으로 변경.<br>
	 * 화폐단위인  원-&gt; 냥 으로 변경.
	 *  (non-Javadoc)
	 * @see day1129.Person2#eat(java.lang.String, int)
	 */
	@Override
	public String eat(String menu, int price) {	//하나라도 틀리면 잡아준다.
		return getName()+"이 주막에서 "+menu+"인 음식을 "+price+"냥 내고 사먹는다.";
	}
	
	
		
		
}//class
