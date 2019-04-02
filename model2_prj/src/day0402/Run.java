package day0402;

import java.util.HashMap;
import java.util.Map;

public class Run {

	/**
	 * is a ���踦 ������� ��
	 **is a -�ڽ��� �θ��̴�.(�ڽ�Ŭ������ �θ� ��� ����ϴ°�) 
	 */
	public void useIsA() {
		Map<String, Person> map=new HashMap<String,Person>();
		//�� �Ҵ�
		map.put("gong", new SeonUi());
		map.put("lee", new JeaHyun());
		map.put("Jung", new TeackSung());
		
		//Ű
		String key="Jung";
		//Is a -��ü �������� ����Ͽ� �θ� �� �ڽ��� �����Ѵ�.
		if(map.containsKey(key)) {//nullPoint ����
			Person person=map.get(key);
			System.out.println(person.execute());
		}//end if
	}//useIsA
	
	/**
	 * is a ���踦 ������� �ʰ� ��ü�� ����� ��
	 **is a �Ⱦ��� ->�ڵ尡 �� �پ��
	 */
	public void notUseIsA() {
		Map<String, Object> map=new HashMap<String,Object>();
		//�� �Ҵ�
		map.put("gong", new SeonUi());
		map.put("lee", new JeaHyun());
		map.put("Jung", new TeackSung());
		
		//�� ���
		//is a �� ���� ������ �� ����ϴ� �ڵ尡 �������.
		String key="gong"; //�Է��ϴ� �� = Ŀ���=commend  
		//gong�� �ƴϸ� SeonUi�� Error ���� if�� Ȯ�����־�� �Ѵ�.
		if("gong".equals(key)) { //���ڿ��� ������Ʈ ������ �տ��ΰ� ���Ѵ�.
			SeonUi su=(SeonUi)map.get(key);
			System.out.println(su.execute());
		}//end if
		if("lee".equals(key)) {
			JeaHyun jh=(JeaHyun)map.get(key);
			System.out.println(jh.execute());
		}//end if
		if("Jung".equals(key)) { 
			TeackSung ts=(TeackSung)map.get(key);
			System.out.println(ts.execute());
		}//end if
	}//notUseIsA
	
	
	public static void main(String[] args) {
		Run run=new Run();
		run.useIsA();
		System.out.println("=======================================");
		run.notUseIsA();
	}//main
}//class
