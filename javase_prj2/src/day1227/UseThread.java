package day1227;

/**
 * Thread class 를 상속받아서 Thread 사용.
 * @author owner
 */

//1.Thread 상속
public class UseThread extends Thread{

	//2.run method Override
	@Override
	public void run() {
		//3.Thread로 동작되어야 할 코드(동시에 실행되어야 할 코드)
		for(int i=0; i<1000; i++) {
			System.out.println("run i------>"+i);
		}//end for
	}//run
	
	public void test() {
		for(int i=0; i<1000; i++) {
			System.out.println("test ==========i="+i);
		}//end for
	}//test
	
	public static void main(String[] args) {
		//4.객체 생성
		UseThread ut=new UseThread();
		//5.부모 클래스인 Thread가 가지고 있는 start()method 호출.
		ut.start();//start를 호출하면 start()안에서 run()호출.
		ut.test();//호출이 끝나기전에 다른일을 더 할수 있다.
		//Thread가 동작한 느낌이 들지 않는다?하나니깐!!
		
//		ut.run();//아래에 for가 있을떄 직접불렀더니 끝난후에야 넘어간다.
//		//운전하다 전화받는격????
	}//main
}//class
