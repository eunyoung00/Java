package day1206;

import java.util.Random;

/**
 * Random : 다양한 난수를 얻기 위한 객체. 
 * @author owner
 */
public class UseRandom {
	
	
	public UseRandom() {
		//1.생성)
		Random r= new Random();
		//<만드는순간 내가 쓸 수가다 담아져? 있다
		//실수 난수
		double d = r.nextDouble();
		System.out.println(d);
		System.out.println(d*5);//0.xxx ~ 4.xxx
		System.out.println((int)(d*5));//0~4
		System.out.println("-------------------------------------");
		//정수 난수
		int i = r.nextInt();//음수가 발생하므로 절대값을 구해야한다.
		System.out.println(i);//음수~양수
		System.out.println(i%5);//음수~양수
		System.out.println(Math.abs(i%5));//양수
		System.out.println("-----------------가장편리--------------------");
		int j = r.nextInt(5);//음수가 발생하지 않는다.
		System.out.println(j);
		System.out.println("-------------------------------------");
		//불린 난수
		boolean b = r.nextBoolean();
		System.out.println(b);
		System.out.println("-------------------------------------");
		
		
	}//UseRandom

	public static void main(String[] args) {
		new UseRandom();
	}//main
}//class
