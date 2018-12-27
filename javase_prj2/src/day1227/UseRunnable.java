package day1227;

/**
 * Runnable interface를 구현하여 Thread를 사용.
 * @author owner
 */

//1.Runnable 구현
public class UseRunnable implements Runnable {

	//2.run() method의 Override
	@Override
	public void run() {
		//3.동시에 Thread로 동작해야 하는 코드
		for(int i=0; i<1000; i++) {
			System.out.println("run i======"+i);
		}//end for
	}//run
	
	public void test() {
		for(int i=0; i<1000; i++) {
			System.out.println("===================test i="+i);
		}
	}//test

	public static void main(String[] args) {
		long st=System.currentTimeMillis();
		//4.Runnable을 구현한 클래스를 객체화
		UseRunnable ur=new UseRunnable();
		//5.Thread 객체와 Runnable을 구현한 객체를 has a관계로 설정
//		Thread t=new Thread();//<지금은 아무런 관게도 아님.
		//6.Thread class에 있는 start() 호출.
		Thread t=new Thread(ur);
		t.start();//<아무런관계가 없을때에는 Thread의 run이 나와 아무일도 하지 않는다.
		//has a관계가 설정되지 않으면 Thread의 run()이 호출된다.
//		t.run();
		ur.test();
		
		long et=System.currentTimeMillis();
		System.out.println((et-st)+"ms");
	}//main
}//class
