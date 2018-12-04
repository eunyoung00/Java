package day1123;

/**
 * 마카펜을 구현한 클래스를 사용하는 클래스.<br>
 * 4.객체 생성<br>
 * 5.생성된 객체 사용
 * @author owner
 */
public class UseMarker {

	public static void main(String[] args) {
		//검은색 마카펜 1개 생성
		Marker black = new Marker();
//		System.out.printf("생성된 마카펜 색[%s], 뚜껑[%d], 몸체[%d]",
//				black.getColor(),black.getCap(),black.getBody());
		//<   =>자동초기화가 된 상태

		black.setColor("검은색");
		black.setCap(1);
		black.setBody(1);
		
		System.out.printf("생성된 마카펜 색[%s], 뚜껑[%d], 몸체[%d]\n",
				black.getColor(),black.getCap(),black.getBody());
		
		//생성된 객체의 사용
		System.out.println(black.write("안녕하세요?"));
		
		//빨간색 마카펜 객체를 5개 생성해 보고 사용
		Marker red = new Marker();
//		red.color = "빨간색";//<이러면 상관없으나
//		red.color = "흰색";//<아무거나 막들어간다.
		//접근지정자가 public이라면 외부엥서 값을 직접설정할수 있으므로 잘못된값이 입력될 수 있다.
//		red.setColor("빨간색");
		red.setColor("흰색");//<설정한 값을 벗어나 검은색이 나오게 된다.
		//<엉뚱한 값 검증~!~!
		//=>color를 캡슐화하여 밖에서 안보이는??? private를 하게 된것
		//<접근지정자로 캡슐화
		red.setBody(5);
		red.setCap(5);
		System.out.printf("생성된 마카펜 색[%s], 뚜껑[%d], 몸체[%d]\n",
				red.getColor(),red.getCap(),red.getBody());
		System.out.println(red.write("빨간맛"));
		
	}//main
}//class
