package day1121;

/**
 * while : ���۰� ���� �𸦶� ����ϴ� �ݺ���<br>
 *         �ּ� 0�� ����~�ִ� ���Ǳ��� ����<br>
 * ����) while(���ǽ�){<br>
 *         �ݺ����๮��;<br>
 *      }<br>
 * @author owner
 */
public class TestWhile {

	public static void main(String[] args) {
		int i=0; //�ʱⰪ    while�̶�� ���� ����. for �ΰ�
		
		while(i<10) {
			System.out.println("i="+i);//�ݺ����๮��
			//���� �������� ���ٸ� ���ѷ���
			i++;//������
		}//end while
		
		System.out.println("-------------------------------------");
		//�������� ���� �Է¹޾� 2~9�� ���̶�� �������� ��� while�� 
		int dan = Integer.parseInt(args[0]);
		if(dan>1 && dan<10) {
			int j = 1;
			while(j<10) {
				System.out.println(dan+"*"+j+" = "+ (dan*j));
				j++;
			}
		}
		
		//����loop
//		while(true) {
//			System.out.println("���� loop");
//		}//end while
//		//���� �����Ʒ��ڵ�� ���� �ȵż� ������ Error
		while(true) {
			System.out.println("���� loop");
			break;//���� ���� ���� �����ƴϰԵ� �׳� ���������ϱ�
		}//end while
		
		i=0;
		while(true) {
			System.out.println("���� loop");
			if(i==5) {
				break;//���ǰ� �Բ�
			}//end if
			i++;
		}//end while

	}//main
}//class
