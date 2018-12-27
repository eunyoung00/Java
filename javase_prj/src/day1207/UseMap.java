package day1207;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Map: KVP�� �Ǿ��ִ� �ڷᱸ��. Ű�� ����Ͽ� ���� ��� ���� ��.
 * @author owner
 */
public class UseMap {
	
	public UseMap() {
		//JDK�� 1.5 ������ ��� Generic�� ����� �� ����, ��ü�� ���尡���ϴ�.
		//1.����
		Map<String, String> map = new HashMap<String,String>();
		
		//2.�� �Ҵ� - key�� ���� (��ҹ��� ����), ���� �ߺ� ����, �ԷµǴ� ������� ���� �߰����� �ʴ´�.
		map.put("Oracle", "��뷮 �����ͺ��̽�");
		map.put("Java", "���α׷��� ���");
		map.put("Python", "���α׷��� ���");//���� �ߺ�����.
		map.put("Java",	"�Ϻ��� ��ü���� ���.");//<�ִٸ� ���� ����� ������ �߰��ȴ�.
		//Ű�� �����Ѵٸ� �ش�Ű�� �����. upsert
		map.put("HTML",	"Markup Language.");
		System.out.println(map.size()+" "+map);//<�ּҰ� �ƴ϶� ���� �߳��´�. Override
		
		//3.�� ��� - Ű�� ����Ͽ� ���� ��´�.
		//Ű�� �ش��ϴ� ���� ���ٸ� null(heap�� �ּҰ� ����� ���)�� ��ȯ�Ѵ�.
//		String val=map.get("Java");
//		String val=map.get("HTML");
//		String val=map.get("HTML1");//=null
		String val=map.get("html");//=null
		System.out.println(val);
		
		//4.Ű�� �����ϴ� ��?
		String key="Java";
		boolean flag = map.containsKey(key);
		System.out.println(key+"�� ���� "+flag);
		
		//5.�� ����
		map.remove("Java");
		System.out.println("������ : "+map);
		
		//6.��� Ű ���(����)
		Set<String>	allKeys=map.keySet();
		System.out.println("���� ���� ��� Ű : "+allKeys);
		
		//7.��� �� ���
		Iterator<String> ita =allKeys.iterator();
		String value="";
		while(ita.hasNext()) { //Ű�� ���� �Ѵٸ�
			value=map.get(ita.next());//�� Ű�� ������ Map�� ���� ��´�.
			System.out.println(value);
		}//end while
		
		//8.����
		map.clear();
		System.out.println("��� ���� : "+map.size()+" / "+map/*�ν��Ͻ�*/);
		
	}//UseMap
	
	/**
	 * �⺻ �����ڸ� ����ϸ� 11���� ���� �ڵ� ����.(�� �־ �˾Ƽ� �þ)
	 * MultiThread���� �������� �Ұ���.
	 * �����Ͱ� ��ü ���� ������ �� 75%ä�������� �� ���� ���� �˻��� �Ѵ�.
	 */
	public void useHashtable(String key) {
		//1.����
		Map<String,String> bloodmap = new Hashtable<String,String>();
		//�������� ũ���� capa��?
		//2.�� �Ҵ�
		bloodmap.put("A", "�����ϴ�,ģ���ϴ�.^O^b");
		bloodmap.put("B", "���� ������.-,.-");
		bloodmap.put("AB", "������ @,.@");
		bloodmap.put("O", "�����δ��ϴ� ~(^^~)(~^^)~");
		bloodmap.put("A", "�ҽ��ϴ�.��^.^��");
		
		//3.�� ���
		String value=bloodmap.get(key.toUpperCase());//.toUpperCase() �빮�ڷ�~!
		
		if(value==null) {//����� ���� ������ ��
			System.out.println(key+" �������� ����� ���� �ƴմϴ�.");
		}else {
			System.out.println(key+"���� Ư¡��  :"+value);
		}//end else
		
		//�ٸ������ �����
		if(!bloodmap.containsKey(key.toUpperCase())) {//Ű�� �����ϴ���?
			System.out.println(key+" �������� ����� ���� �ƴմϴ�.");
		}else {
			System.out.println(key+"���� Ư¡��  :"+value);
		}//end else
		
	}//useHashtable
	
	/**
	 * �⺻�����ڸ� ����ϸ� 16���� ���� �ڵ� ����(����)
	 * MultiThread���� �������� ����.
	 * �����Ͱ� ��ü ���� ������ �� 75%ä�������� �� ���� ���� �˻��� �Ѵ�.
	 */
	public void useHashMap(String key) {
		//1.����)
		Map<String,String> map = new HashMap<String,String>();
		//2.�� �Ҵ�)
		map.put("���ʺ���", "Ǯ�� ���� ������ ���´�.");
		map.put("��������", "������ ���忡�� �����Ѵ�.");
		map.put("���乫��", "�ƹ��͵� ���� ������ �� �ݷ��ϰ� �ƹ��͵� ���� �ʰڴ�.");
		map.put("���γ���", "�����ϸ� �θǽ�, �ϰ��ϸ� �ҷ�");
		map.put("�̺θ�õ", "������ ��ȥ�ϸ� ��õ���� ���ϸ� ��õ����.");
		map.put("��������", "���� ���� �����.");
		map.put("����ġ��", "�Լ��� ������ ¡�׷�����");
		map.put("���ü���", "���α��� �ڶ�");
		
		//3.�� ���)
		if(map.containsKey(key)) {//�ʿ� Ű�� �����Ѵٸ� 
			String value = map.get(key);//�� ���
			System.out.println(key+"�� ���� "+value);
		}else {
			System.out.println(key+" ���ڼ���� �غ���� �ʾҽ��ϴ�.");
		}//end else
		
		
	}//useHashMap
	

	public static void main(String[] args) {
		UseMap um= new UseMap();
		System.out.println("-------------Hashtable���-------------");
		um.useHashtable("a");
		System.out.println("-------------HashMap���-------------");
		um.useHashMap("��������");
	}//main

}//class
