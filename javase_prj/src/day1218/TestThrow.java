package day1218;

import java.util.Random;

/**
 * Throw : 예외를 강제로 발생
 * @author owner
 */
public class TestThrow {

	/**
	 * 길을 가다가 담배를 피우는 학생을 보면 정의사회를 구현한다.
	 */
	public void teacksung() throws Exception {
		String[] grade= {"초등학생","중학생","고등학생"};
		String randomGd=grade[new Random().nextInt(grade.length)];
		
		if(randomGd.equals("초등학생")) {
//			try {//try~로하면 혼자만 알고있어 혼자속으로 이야기 한것과 다르지 않기 때문에 throws로 날려준다.
				throw new Exception(randomGd+"행님들 금연해야하는 부분 인지용?");
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
		}else {
			System.out.println(randomGd+ "이 담배를 피우면 모른척 지나간다.(\" )( \")");
			
		}//end else
	}//teacksung
	
	public void teacksung2() /*throws TobaccoException =>Runtime예외는 throws하지 않아도 문제가 없다.하지만 Compile예외는 꼬옥~!처리해 주어야한다.*/{
		String[] grade= {"초등학생","중학생","고등학생"};
		String randomGd=grade[new Random().nextInt(grade.length)];
		
		if(randomGd.equals("초등학생")) {
//			try {//try~로하면 혼자만 알고있어 혼자속으로 이야기 한것과 다르지 않기 때문에 throws로 날려준다.
//				throw new TobaccoException(randomGd+"행님들 금연해야하는 부분 인지용?");
				throw new TobaccoException();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
		}else {
			System.out.println(randomGd+ "이 담배를 피우면 모른척 지나간다.(\" )( \")");
			
		}//end else
	}//teacksung2
	
	public static void main(String[] args) {
		TestThrow tt= new TestThrow();
		try {
			tt.teacksung();
		} catch (Exception e) {//뭐때문에 정확하게 예외가 발생한것인지 알수 없다..단지 화가났음만을 알수 있음.
			e.printStackTrace();
		}//end catch
		
		System.out.println("-------------------------------------------");
//		try {
			tt.teacksung2();
//		} catch (TobaccoException te) {
//			te.printStackTrace();
//		}//end catch
			
			/*이렇게 순서를 흩트러 뜨릴수 있다. println은 바로 바로 출력이라서~!
			java.lang.Exception: 초등학생행님들 금연해야하는 부분 인지용?
					-------------------------------------------
					중학생이 담배를 피우면 모른척 지나간다.(" )( ")
						at day1218.TestThrow.teacksung(TestThrow.java:20)
						at day1218.TestThrow.main(TestThrow.java:50)*/
	}//main

}//class
