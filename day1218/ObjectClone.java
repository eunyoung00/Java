package day1218;

/**
 * clone)
 * ��ü ����  :�����Ǵ� ��ü�� Cloneable interface�� �����ؾ߸� �Ѵ�.
 * @author owner
 */
public class ObjectClone implements Cloneable{//�����ϴ� ������ �ߵȴ�...�ƹ�method�� �������ʾƼ� override�� ����?�³�?
	private int i;
//	private Stack<ObjectClone> stack=new Stack<>();//������ �����Ϸ��ߴµ� �޼ҵ尡 �޶��..�ؼ� �̵�..
	
	public static void main(String[] args) {
		
		ObjectClone oc=new ObjectClone();
		oc.i=100;
		
		try {
			ObjectClone oc1=(ObjectClone)oc.clone();
			System.out.println("���� ����"+oc1);
			oc.i=200;//���簴ü�� ���°� ����
			System.out.println("���� : "+oc.i+"/ ������ : "+oc1.i);
			
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}//end catch
	}//main

}//class
