package day0423;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestService3 {
	
	//������ ���� ���� ��ü ���� annotation ����
	@Autowired
	private TestDao3 td; //private TestDao2 td2;�� �߰����� �Ǹ� 1.������ 2.�Ʒ��� 3.�Ѵ�x-1�� ���� �ϳ��� �ȴ�!�������־����
	
	public TestDao3 getTestDao3() {
		return td;
	}
	
}//class
