package day0423;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

	public static void main(String[] args) {
		//1.Spring Container 생성
		ApplicationContext ac=new ClassPathXmlApplicationContext("day0423/applicationContext.xml");
		//2. id를 사용하여 Bean 얻기
		System.out.println("------------------생성자 의존성 주입-----------------");
		TestService ts=ac.getBean("ts", TestService.class); //내가 new 해주는게 아니라 찾아준다.
		System.out.println(ts);//해당 객체가 singleton으로 나오게 됨
		
		System.out.println("------------------method 의존성 주입-----------------");
		TestService ts1=ac.getBean("ts1", TestService.class);
		System.out.println(ts1.getTd());
		
		System.out.println("------------------생성자의 매개변수가 여러개인 경우 의존성 주입-----------------");
		TestService2 ts2=ac.getBean(TestService2.class);
		System.out.println(ts2);
		
		System.out.println("------------------생성자가 기본형 데이터형 또는 String을 의존성 주입-----------------");
		PrimitiveTypeInjection pti=ac.getBean(PrimitiveTypeInjection.class);
		System.out.println(pti);
		
		
	}//main

}//class
