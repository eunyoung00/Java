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
		//target method�� �Ű����� ó��(JoinPoint)
		Object[] params=jp.getArgs();
		//target method�� method ���� (�Ű�����, method ��)
		Signature sig=jp.getSignature();
		System.out.println("target method�� : "+sig.getName());
		System.out.println("target method ���������� : "+
				Modifier.toString(sig.getModifiers())+"/"+
				(Modifier.isPublic(sig.getModifiers())?"public":"")); //1025=public, �߻�޼ҵ带 overide�ؼ� public abstract������.
		
		if(params != null) {
			System.out.println("�Ű����� ����: "+params.length);
			for(Object param: params) {
				System.out.println("�Ű������� �� : "+param);
			}//end for
		}//end if
	}//before

	/*@After("execution(* searchItem(String))")
	public void before() {
		System.out.println("After advice");
	}//before
*/
//	@Before("execution(* get*())") //��� Spring Bean(Spring container�� �������ִ� ��ü, Ư¡�� class�� s�ٿ��ִ°� Spring bean���� ..)�� getter�� ȣ�����ִ� Pointcut
//	@Before("execution(* kr.co.sist.service.ItemServiceImpl.get*())")//itemServiceImpl�� getter�� ȣ��
	@Before("execution(String kr.co.sist.service.ItemServiceImpl.get*())")//itemServiceImpl�� ��ȯ���� String�� getter�� ȣ��
	public void getter() {
		System.out.println("getter before advice");
	}//getter
	
	@Around("execution(* searchData(..))") ///..=������� �Ű������� searchData�̸��� ������ ȣ��Ƕ�� �ϴ°�
	public ItemDomain around(ProceedingJoinPoint pjp) throws Throwable {
		//ProceedingJoinPoint is only supported for around advice
//		pjp.getArgs(); //target�� �Ķ���� ó��
//		pjp.getSignature(); //target�� method ���� ó��
		
		//target�� �������� �޾ƿ� ������ �����.
		ItemDomain id=(ItemDomain)pjp.proceed(); //target method�� ������ ��
		if(id !=null) {
			id.setItem(id.getItem()+" s('-^)v");
		}//end if
		return id;
	}//around
/*	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		//ProceedingJoinPoint is only supported for around advice
		
		//target�� �������� �޾ƿ� ������ �����.
		Object o=pjp.proceed(); //target method�� ������ �϶�
		
		return o;
	}//around
*/	
}//class
