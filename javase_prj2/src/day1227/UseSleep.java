package day1227;

import java.util.Random;

/**
 * running 상태에서 block 상태로 상태 이전(생명 주기)<br>
 * 구현을 더많이 사용하게 된다. 상속은 한번에 하나만 가능함으로 구현은 몇개든 가능해서!!!
 * @author owner
 */
public class UseSleep implements Runnable{

	@Override
	public void run() {
		/*for(int i=0; i<10; i++) {
			System.out.println("2*"+i+"="+(2*i));
			try {//<꼭run()일 필요는 없다 어디서나 가능.main의 앞도 중간도~!
				Thread.sleep(500);//0.5초<안쉴수 있어서 예외처리가 있는것.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}//end catch
		}//end for
		*/
		System.out.print("loading");
		Random r=new Random();
		for(int i=0; i<15; i++) {
			System.out.print(" . ");
			try {
				Thread.sleep(1000*r.nextInt(10)+1);//0방지+1
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}//end for
		System.out.println("finish");
	}//run

	public static void main(String[] args) {
		//클래스 객체화
		UseSleep us=new UseSleep();
		//Thread 와 has a
		Thread t= new Thread(us);
		//start()
		t.start();
	}//main
}//class
