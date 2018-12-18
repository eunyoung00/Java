package day1218;

/**
 * clone)
 * 객체 복제  :복제되는 객체는 Cloneable interface를 구현해야만 한다.
 * @author owner
 */
public class ObjectClone implements Cloneable{//구현하니 복제가 잘된다...아무method도 가지지않아서 override도 없음?맞나?
	private int i;
//	private Stack<ObjectClone> stack=new Stack<>();//복제해 저장하려했는데 메소드가 달라야..해서 이따..
	
	public static void main(String[] args) {
		
		ObjectClone oc=new ObjectClone();
		oc.i=100;
		
		try {
			ObjectClone oc1=(ObjectClone)oc.clone();
			System.out.println("복제 성공"+oc1);
			oc.i=200;//현재객체의 상태가 변경
			System.out.println("원본 : "+oc.i+"/ 복제본 : "+oc1.i);
			
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}//end catch
	}//main

}//class
