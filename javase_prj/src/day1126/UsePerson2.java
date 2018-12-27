package day1126;

/**
 * 사람을 추상화하여 만든 Person 클래스를 사용하는 클래스
 * @author owner
 */
public class UsePerson2 {

	public static void main(String[] args) {
		//객체 생성  :heap에 생성되고 instance변수는 자동 초기화.
		//<heap에 들어가고 주소를 stack에 담는다
		Person2 teacksung = new Person2();
		//참조형 데이터형인 Person은 heap의 주소르 가지고 있다.
		System.out.println("객체를 출력하면 주소가 출력"+teacksung);
		//<day1123.Person@1db9742
//		System.out.format("생성된 사람 객체 정보 눈[%d],코[%d],입[%d],이름[%s]\n"
//				,teacksung.getEye(),teacksung.getNose(),teacksung.getMouth()
//				,teacksung.getName());
		teacksung.setName("정택성");
//		teacksung.setEye(2);
//		teacksung.setNose(1);
//		teacksung.setMouth(1);//넣어줄 필요가 없다.
		System.out.format("생성된 사람 객체 정보 눈[%d],코[%d],입[%d],이름[%s]\n"
				,teacksung.getEye(),teacksung.getNose(),teacksung.getMouth()
				,teacksung.getName());
		//생성된 객체에서 정의된 일을 사용.
		System.out.println(teacksung.eat());
		System.out.println(teacksung.eat("육회비빔밥",8000));

		System.out.format("생성된 사람 객체 정보 눈[%d],코[%d],입[%d],이름[%s]\n"
				,teacksung.getEye(),teacksung.getNose(),teacksung.getMouth()
				,teacksung.getName());		
		
		System.out.println("-------------------------------------------");
		Person2 jinban = new Person2(3,1,1);
		jinban.setName("천진반");
//		jinban.setEye(3);
//		jinban.setNose(1);
//		jinban.setMouth(1);
		
		System.out.format("생성된 사람 객체 정보 눈[%d],코[%d],입[%d],이름[%s]\n"
				,jinban.getEye(),jinban.getNose(),jinban.getMouth()
				,jinban.getName());		
		
		System.out.println(jinban.eat());
		System.out.println(jinban.eat("선두",1));
		
//<		System.out.println("객체를 출력하면 주소가 출력"+jinban);//주소가 다름을 알수있다.
	}//main
}//class
