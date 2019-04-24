package day0423;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestService3 {
	
	//의존성 주입 받을 객체 위에 annotation 선언
	@Autowired
	private TestDao3 td; //private TestDao2 td2;가 추가선언 되면 1.위에만 2.아래만 3.둘다x-1번 위에 하나만 된다!각각해주어야함
	
	public TestDao3 getTestDao3() {
		return td;
	}
	
}//class
