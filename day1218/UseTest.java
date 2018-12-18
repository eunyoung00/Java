package day1218;

public class UseTest {
	public void useTest(Test test) {
		if(test instanceof TestImpl) {//TestImpl자리에 객체를 쓰면 Error
			String date=test.getDate();
			System.out.println(date);//상속의 장점
		}else{
			System.out.println("TestImpl만 처리합니다.");
		}//end if
	}//useTest

	public static void main(String[] args) {
		TestImpl ti=new TestImpl();
		TestImpl2 ti2=new TestImpl2();
		
		UseTest ut=new UseTest();
		ut.useTest(ti);
		ut.useTest(ti2);
		
	}//main

}//class
