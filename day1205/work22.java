package day1205;

import java.util.StringTokenizer;

public class work22 {
//	����
//	1. 1~45 ������ ������ ���߿��� �������� �ϳ��� �̾� 6���� ��Ʈ�� 
//	   ����� �迭�� ��ȯ�ϴ� method�� ����� ȣ���Ͽ� ����� ��.
//	   ��, �ߺ��� ���� �迭�� �Էµ��� �ʾƾ��Ѵ�.
	public int[] createRandom() {
		int[] intset = new int[6];

		int flag=0;
		for(int i=0; i<intset.length; i++) {//0~5���� 
//			intset[i]=(char)((int)(Math.random()*45));
			//0~45�� �ƴ϶� 0~44 �ؼ� 45���ΰ�
			//�׷��� 0~44 +1���� ���ؼ� 1~45
//			System.out.print(intset[i]+" ");//�������..
			
			flag=(char)((int)(Math.random()*45)+1);
			
			//���ڸ��� ���ؼ� ������ �ٽõ���
			if(i==0) {
				intset[i]=flag;
//				System.out.print(intset[i]+" ");//�������..
			}else if(i>0){
				for(int j=0;j<i; j++) {
					if(flag==intset[j]) {
						i--;//break������ �����鼭 1�����ִϱ�, 
						break;
					} else {
						intset[i]=flag;
					}//end else
				}//end for
			}//end else
		}//end for
//		System.out.print((int)(Math.random()*45));
		for(int i=0; i<intset.length; i++) {
			System.out.print(intset[i]+" ");
		}
		return intset;
	}//createRandom
	
//	2.�Ʒ����õ� ���ڿ��� ���� ���ڷ� �߶󳻾� ���ڿ� �迭�� �����ϰ� ��ȯ�ϴ� ���� �ϴ� method��
//	�ۼ��ϼ���.
//	"������,������,������,���ü�~������!������.����ö,������,��ä��,���ü�.������"
//	
//	���: ������ ������ ������ ���ü� ������ ������ ����ö ������ ������ ���ü� ������
	public String[] Token(String names) {
		StringTokenizer stk = new StringTokenizer(names, ",.~!");
//		System.out.println(stk.countTokens()+"��");
		String[] tok = new String[stk.countTokens()];
//		String[] tok = new String[11];
		int i=0;
		while(stk.hasMoreTokens()) {
			tok[i]=stk.nextToken();
			System.out.print(tok[i]+" ");
			i++;
		}
		
		
		return tok;
	}//Token

	public static void main(String[] args) {
		new work22().createRandom();
		System.out.println();
		new work22().Token("������,������,������,���ü�~������!������.����ö,������,��ä��,���ü�.������");
		
		
		
	}//main
}//class
