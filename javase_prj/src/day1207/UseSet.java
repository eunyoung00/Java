package day1207;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * Set :�˻��� ����� ������(get X), �ߺ����� �������� �ʴ�(����) ����� ����.  
 * 
 * @author owner
 */
public class UseSet {
	public UseSet() {
		//JDK 1.5 ���Ͽ����� Generic�� �������� �ʰ�, ��ü�� ����ȴ�.
		//<List,Set,Map��. 
		//1.����
		Set<String> set = new HashSet<String>();//is a ������ �ν��Ͻ�ȭ
		//<ctrl+shift+o import����.
		//2.�� �Ҵ� : ������� �Էµ��� �ʴ´�.
		set.add("���ü�");
		set.add("������");
		set.add("������");
		set.add("������");
		set.add("������");
		set.add("������");//<���������� ���� �ʴ´�.
		set.add("�̺���");//<index�� ������ �� ����.
		set.add("������");
		set.add("������");
		set.add("������");//�ߺ����� �������� �ʴ´�.<<(���� �����ϰ� ����)
		System.out.println(set.size()+" / "+set);//toString�� override�ؼ�.
		set.remove("������");//����������.
		System.out.println(set.size()+" / "+set);//toString�� override�ؼ�.
		
		//�迭�� ����
		String[] names = new String[set.size()];
		set.toArray(names);
		
		//set�� ��� ��(Element,���=e)�� �� ���
//		System.out.println(set.get("������"));//set��ü���� �˻��� ����� ����.
		//<���� for �� ���δ� iterator �ʿ������.
		for(String temp : names) {
			System.out.print(temp+" ");
		}//������ Iterator�� �ӵ��� ������....List�� Iterator�� ��������!
		System.out.println("=============Iterator===============");
		
		//iterator�� ����Ͽ� ���� ���
		Iterator<String> ita = set.iterator();//set�� ������� �Ѿ��.
		
		
		String name="";//""=mt
		while(ita.hasNext()) {//Iterator�� �����ϴ� Set�� ��Ұ� �����Ѵٸ�
			name=ita.next();//�ش� ����� ���� ��� ���� �����ͷ� �̵�.
			System.out.println(name);
		}//end while
		
		//��� ���� �� ����
		set.clear();
		System.out.println("clear�� size:"+set.size()+" , ��:"+set);
		System.out.println("=============�迭�� ������ ��===============");
		for(int i=0; i<names.length; i++) {
			System.out.println(names[i]);
		}
		
	}//UseSet
	
	public int[] lotto() {
		int[] tempLotto=new int[6];
		//������ �Ҷ����� 2�����迭��??
		
		Random random = new Random();
		for(int i=0; i<tempLotto.length; i++) {
			tempLotto[i]=random.nextInt(45)+1;//�������� �߻��� �� �ִ�.
			for(int j=0; j<i; j++) {//<����ó���� ���� �ʰ���
				if(tempLotto[i]==tempLotto[j]) {//���� ���� ����.
					i--;//�ߺ��߻��� ��ȣ�� �ε�����°�� �ٽ� �߻���Ű�� ����
					//�ε�����ȣ�� �ϳ� ���δ�.
					break;//�ݺ����� ����������.
				}//end if
			}//end for
		}//end for
				
		return tempLotto;
	}//lotto
	
	public Integer[] lotto1() {
//		int[] tempLotto=new int[6];
		Integer[] tempLotto=new Integer[6];
		
		Set<Integer> set = new HashSet<Integer>();
		Random random = new Random();
//		for(; ;) {
		while(true) {
			set.add(random.nextInt(45)+1);//�������� �߰����� �ʴ´�.
			if(set.size()==6) {
				break;
			}//end if;
		}//end for
		set.toArray(tempLotto);
		return tempLotto;
	}//lotto
	
	public static void main(String[] args) {
		UseSet us=new UseSet();
		int[] temp = us.lotto();
		
		for(int i=0;i<temp.length; i++) {
			System.out.print(temp[i]+" ");
		}//end for
		
		System.out.println("\n--------------------------------");
		Integer[] temp1 = us.lotto1();
		for(int i=0;i<temp1.length; i++) {
			System.out.print(temp1[i]+" ");
		}//end for
		
	}//main
}//class
