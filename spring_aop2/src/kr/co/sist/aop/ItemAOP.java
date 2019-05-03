package kr.co.sist.aop;

import org.apache.ibatis.javassist.Modifier;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import kr.co.sist.domain.ItemDomain;

@Aspect
@Component
public class ItemAOP {
	
	@Before("execution(* searchItem(String))")
	public void beforeItem(JoinPoint jp) {
		System.out.println("Before advice");
		//target method의 매개변수 처리(JoinPoint)
		Object[] params=jp.getArgs();
		//target method의 method 정보 (매개변수, method 명)
		Signature sig=jp.getSignature();
		System.out.println("target method명 : "+sig.getName());
		System.out.println("target method 접근지정자 : "+
				Modifier.toString(sig.getModifiers())+"/"+
				(Modifier.isPublic(sig.getModifiers())?"public":"")); //1025=public, 추상메소드를 overide해서 public abstract나왔음.
		
		if(params != null) {
			System.out.println("매개변수 갯수: "+params.length);
			for(Object param: params) {
				System.out.println("매개변수의 값 : "+param);
			}//end for
		}//end if
	}//before

	/*@After("execution(* searchItem(String))")
	public void before() {
		System.out.println("After advice");
	}//before
*/
//	@Before("execution(* get*())") //모든 Spring Bean(Spring container가 생성해주는 객체, 특징이 class에 s붙여주는게 Spring bean으로 ..)의 getter를 호출해주는 Pointcut
//	@Before("execution(* kr.co.sist.service.ItemServiceImpl.get*())")//itemServiceImpl의 getter만 호출
	@Before("execution(String kr.co.sist.service.ItemServiceImpl.get*())")//itemServiceImpl의 반환형이 String인 getter만 호출
	public void getter() {
		System.out.println("getter before advice");
	}//getter
	
	@Around("execution(* searchData(..))") ///..=어떤형식의 매개변수든 searchData이름을 가지면 호출되라고 하는것
	public ItemDomain around(ProceedingJoinPoint pjp) throws Throwable {
		//ProceedingJoinPoint is only supported for around advice
//		pjp.getArgs(); //target의 파라메터 처리
//		pjp.getSignature(); //target의 method 정보 처리
		
		//target의 리턴형을 받아와 리턴을 만든다.
		ItemDomain id=(ItemDomain)pjp.proceed(); //target method가 유일할 때
		if(id !=null) {
			id.setItem(id.getItem()+" s('-^)v");
		}//end if
		return id;
	}//around
/*	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		//ProceedingJoinPoint is only supported for around advice
		
		//target의 리턴형을 받아와 리턴을 만든다.
		Object o=pjp.proceed(); //target method가 여러개 일때
		
		return o;
	}//around
*/	
}//class
