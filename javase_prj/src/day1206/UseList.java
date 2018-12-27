package day1206;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import javax.swing.plaf.synth.SynthSeparatorUI;

/**
 * List : <br>
 * �ߺ����� ����ϸ� �˻��� ������ְ�, ������� ���� �Է��ϴ� ����������.
 * 
 * @author owner
 */
public class UseList {
	
	public UseList() {
/*		//JDK 1.4������ Generic�� �������� �ʰ� ��ü�� ����ȴ�.
		List list = new ArrayList();
		//���߰� : JDK 1.5���� ������ ��ü�θ� ���� ���� �� �ִ�.
//		list.add(10);//<1.4������ ��ü�� �޾Ƽ� Error
		list.add(new Integer(10));
		list.add(new Short((short)10));
		list.add("������");
		
		System.out.println(list.size());//=>3
		//�����
//		System.out.println(list.get(0)+10);//��ü�� ������� �ʴ´�...����������.
		System.out.println(((Integer)list.get(0)).intValue()+10);
*/
		//JDK 1.5+(�̻�) ������ ��� : Generic, autoboxing, unboxing
		List list = new ArrayList();
		list.add(10);//autoboxing�� �Ǿ��� ������~!~Error�ȳ�
		//=>list.add(new Integer(10)); compiler�� ����..
		list.add(20);
		list.add("�����");
		
		System.out.println("ũ��"+list.size());
		System.out.println((Integer)list.get(0)+10);//����2�����̵Ǹ� Error �׷��� Generic����.
		
		System.out.println("----------Generic---------------");
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(10);
		list1.add(20);
		list1.add(new Integer(30));
//		list1.add("�����");//<Error, ���������� ��ġ��Ű�°�.
		//Generic���� ������ ���� �ƴ� ���������� �߰��� �� ����.
		System.out.println("ũ��"+list1.size());
		System.out.println(list1.get(0)+10); //�����°͵� Integer�̱� ������ casting�� �ʿ����.
		
		for(int i=0;i<list.size(); i++) {
			System.out.println(list1.get(i));
		}//end for

	}//UseList
	
	/**
	 * ArrayList�� ��� : Multi Thread ȯ�濡�� ���� ���� ����.(����ȭ�� �Ǿ����� �ʴ�.) 
	 */
	public void useArrayList() {
		//1.����
		ArrayList<String> al = new ArrayList<String>();//capa x =��0��
		List<String> al1 = new ArrayList<>(100);//��������. �����ִ°� ����.
		//��100��.
		
		System.out.println(al+" / "+al1);//�ּҰ� ������ ���� ������???
		//toString �� Overriding �ؼ�.(((�ּҰ� �ȳ����°� �� override�Ѱ�)))
		
		//���߰� : ������� �߰��ȴ�.
		al.add("������");
		al.add("���ü�");
		al.add("������");
		al.add("�����");
		al.add("������");	//�ߺ��� ���尡��.
		al.add("������");
		al.add("������");	//�ߺ��� ���尡��.
		al.add("������");
		System.out.println(al+" / "+al1);
		//size() : �������� ũ�� (����ũ�Ⱑ �ƴ϶� ���� ����ִ°��� ũ��)
		System.out.println("al�� ũ�� "+al.size()+"/ al1��ũ�� : "+al1.size());
		
		//�迭�� ����
		String[] names = new String[al.size()];
		al.toArray(names);
		
		//���� ���� ����
		//�ε����� ���� : Ư���ε��� ���� ���� ����.
		al.remove(4);
		System.out.println(al.size()+" / "+al);
		
		//���� �������� ����.
		al.remove("������");//<���� ù���� ����. vs ���峡���� ���� �����ȴ�.vs ��λ��� �ȴ�.=>1��~!~!
		//L->R���� �����ϸ鼭 ��ġ�ϴ� ù���� ���� ����.
		System.out.println(al.size()+" / "+al);
		
		//������ for loop
		for( String name : al) {
			System.out.println(name);
		}//end for
		
		//��� ���� �� ����:  
		al.clear();
		System.out.println("��ü ���� �� : "+al.size()+"/"+al);
		
		//�迭�� ��
		for(int i=0;i<names.length;i++) {
			System.out.printf("%s\n",names[i]);
		}//end for
		
		
	}//useArrayList
	
	public void useVector() {
		//1.����
		Vector<String> vec = new Vector<String>();
		List<String> vec1 = new Vector<>(100);

		
		System.out.println(vec+" / "+vec1);//�ּҰ� ������ ���� ������???
		//toString �� Overriding �ؼ�.(((�ּҰ� �ȳ����°� �� override�Ѱ�)))
		
		//���߰� : ������� �߰��ȴ�.
		vec.add("������");
		vec.add("���ü�");
		vec.add("������");
		vec.add("�����");
		vec.add("������");	//�ߺ��� ���尡��.
		vec.add("������");
		vec.add("������");	//�ߺ��� ���尡��.
		vec.add("������");
		System.out.println(vec+" / "+vec1);
		//size() : �������� ũ�� (����ũ�Ⱑ �ƴ϶� ���� ����ִ°��� ũ��)
		System.out.println("vec�� ũ�� "+vec.size()+"/ vec1��ũ�� : "+vec1.size());
		
		//�迭�� ����
		String[] names = new String[vec.size()];
		vec.toArray(names);
		
		//���� ���� ����
		//�ε����� ���� : Ư���ε��� ���� ���� ����.
		vec.remove(4);
		System.out.println(vec.size()+" / "+vec);
		
		//���� �������� ����.
		vec.remove("������");//<���� ù���� ����. vs ���峡���� ���� �����ȴ�.vs ��λ��� �ȴ�.=>1��~!~!
		//L->R���� �����ϸ鼭 ��ġ�ϴ� ù���� ���� ����.
		System.out.println(vec.size()+" / "+vec);
		
		//������ for loop
		for( String name : vec) {
			System.out.println(name);
		}//end for
		
		//��� ���� �� ����:  
		vec.clear();
		System.out.println("��ü ���� �� : "+vec.size()+"/"+vec);
		
		//�迭�� ��
		for(int i=0;i<names.length;i++) {
			System.out.printf("%s\n",names[i]);
		}//end for
		
	}//useVector
	
	public void useLinkedList() {
		//1.����
		LinkedList<String> ll = new LinkedList<String>();
		List<String> ll1 = new LinkedList<>();
		
		System.out.println(ll+" / "+ll1);//�ּҰ� ������ ���� ������???
		//toString �� Overriding �ؼ�.(((�ּҰ� �ȳ����°� �� override�Ѱ�)))
		
		//���߰� : ������� �߰��ȴ�.
		ll.add("������");
		ll.add("���ü�");
		ll.add("������");
		ll.add("�����");
		ll.add("������");	//�ߺ��� ���尡��.
		ll.add("������");
		ll.add("������");	//�ߺ��� ���尡��.
		ll.add("������");
		System.out.println(ll+" / "+ll1);
		//size() : �������� ũ�� (����ũ�Ⱑ �ƴ϶� ���� ����ִ°��� ũ��)
		System.out.println("ll�� ũ�� "+ll.size()+"/ ll1��ũ�� : "+ll1.size());
		
		//�迭�� ����
		String[] names = new String[ll.size()];
		ll.toArray(names);
		
		//���� ���� ����
		//�ε����� ���� : Ư���ε��� ���� ���� ����.
		ll.remove(4);
		System.out.println(ll.size()+" / "+ll);
		
		//���� �������� ����.
		ll.remove("������");//<���� ù���� ����. vs ���峡���� ���� �����ȴ�.vs ��λ��� �ȴ�.=>1��~!~!
		//L->R���� �����ϸ鼭 ��ġ�ϴ� ù���� ���� ����.
		System.out.println(ll.size()+" / "+ll);
		
		//������ for loop
		for( String name : ll) {
			System.out.println(name);
		}//end for
		
		//��� ���� �� ����:  
		ll.clear();
		System.out.println("��ü ���� �� : "+ll.size()+"/"+ll);
		
		//�迭�� ��
		for(int i=0;i<names.length;i++) {
			System.out.printf("%s\n",names[i]);
		}//end for
	}//useLinkedList
	
	public static void main(String[] args) {
		//method�� �������� ��ü�� ������ �ʿ䰡 �ִ�.
		UseList ui = new UseList();
		System.out.println("------------------ArrayList--------------------");
		ui.useArrayList();
		System.out.println("--------------------Vector--------------------");
		ui.useVector();
		System.out.println("-------------------LinkedList--------------------");
		ui.useLinkedList();
		
	}//main
}//class
