package day1129;

import java.util.Arrays;

/**
 * 
 * @author owner
 */
public class UseSecureArray {

	public static void main(String[] args) {
		SecureArray sa= new SecureArray();
		int[] tempArr=sa.getArr();
		//�迭 ���� ���� �ս��� ��� �ҷ��� ArrayŬ����
		//<Arrays.toString�� for���� �ս��� ��� ����
		System.out.println(Arrays.toString(tempArr));
		tempArr[0]=190;
		System.out.println(Arrays.toString(tempArr));
		
		//<�������� ���� �; ������ �ٽ� �޾Ҵµ�,
		int[] tempArr1=sa.getArr();
		System.out.println(Arrays.toString(tempArr1));
		//<�ٸ��ٰ� ���������� �ּҴ� �ϳ��� ����ǰ�, ����� ���� ����(������ ���ϵɶ�)
		
		//<SecureArray()Ŭ������ �����Ŀ��� ������ ��������ʰ� ������ ���� �˼� �ִ�.
		//�θ������� temp�� �����Ͽ� (����) �ֱ� ������ ���纻�� ������� ����� �����Ǵ°�.
		
		
		
	}//main
}//class
