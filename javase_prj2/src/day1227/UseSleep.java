package day1227;

import java.util.Random;

/**
 * running ���¿��� block ���·� ���� ����(���� �ֱ�)<br>
 * ������ ������ ����ϰ� �ȴ�. ����� �ѹ��� �ϳ��� ���������� ������ ��� �����ؼ�!!!
 * @author owner
 */
public class UseSleep implements Runnable{

	@Override
	public void run() {
		/*for(int i=0; i<10; i++) {
			System.out.println("2*"+i+"="+(2*i));
			try {//<��run()�� �ʿ�� ���� ��𼭳� ����.main�� �յ� �߰���~!
				Thread.sleep(500);//0.5��<�Ƚ��� �־ ����ó���� �ִ°�.
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
				Thread.sleep(1000*r.nextInt(10)+1);//0����+1
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}//end for
		System.out.println("finish");
	}//run

	public static void main(String[] args) {
		//Ŭ���� ��üȭ
		UseSleep us=new UseSleep();
		//Thread �� has a
		Thread t= new Thread(us);
		//start()
		t.start();
	}//main
}//class
