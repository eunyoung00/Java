package day1121;

/**
 * do~while : ���۰� ���� �𸦶� ����ϴ� �ݺ���<br>
 *            �ּ� 1�� ����~�ִ� ���Ǳ��� ����<br>
 * ����) do{  <br>
 *         �ݺ� ���� �����;<br>
 *      }while(���ǽ�);<br>
 *      
 * @author owner
 */
public class TestDoWhile {

	public static void main(String[] args) {
		//���ݾ��°� for����
		int i=1000;//�ʱⰪ
		do {
			System.out.println("i="+i);//�ݺ����๮��
			i++;//������      <������� ������ 1��~!~!
		}while(i<10);//���ǽ�
		
		
		//�ԷµǴ� ������ ������ ���
		i = Integer.parseInt(args[0]);
		//i=9;//test
		
//		float f = Float.parseFloat(args[0]);   //����Ŭ����!!! �� �ֱ�� �ִ�.
//		double d = Double.parseDouble(args[0]);
		
		if(i>1 && i<10) {//2�ܿ��� 9�� ����
			//System.out.println(i);//test
			System.out.println(i+"��");
			int j = 1;
			do {
				System.out.println(i+"*"+j +" = "+i*j);
				j++;
			}while(j<10);
			
		}else{
			System.out.println("���� 2�ܿ��� 9�ܱ��� �Է��� �ּ���.");
		}//end if
		
	}//main
}//class
