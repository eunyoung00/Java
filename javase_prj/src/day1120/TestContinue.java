package day1120;

/**
 * continue : �ݺ������� �ݺ� ���� �ڵ��� ������ �ǳ� �ٴ� ��.<br>
 *    
 * @author owner
 */
public class TestContinue {

	public static void main(String[] args) {
		
		 //0~100���� Ȧ���� ����ϰ� ������
		 for(int i=0; i<100; i++) {
			 //System.out.println("i ="+i); <�ݺ������ڵ� ���̿� ������ �ִ�.����..
			 if(i%2==0){
				 continue;
			 }//end if
				 
			 //continue;//<�̰͸� ������ �Ʒ��ڵ带 ������ �ǳ� �پ  Error
			 System.out.println("i ="+i);
			 //continue;//�Ʒ��ʿ� �ڵ尡 ��� �ǳʶ۰� ���� ����� �Ȱ��� ���´�.
		 }//end for
		
	}//main
}//class
