package day1205;

import java.util.StringTokenizer;

public class work22 {
//	숙제
//	1. 1~45 까지의 사이의 수중에서 무작위로 하나를 뽑아 6개의 세트를 
//	   만들어 배열로 반환하는 method를 만들고 호출하여 출력할 것.
//	   단, 중복된 수는 배열에 입력되지 않아야한다.
	public int[] createRandom() {
		int[] intset = new int[6];

		int flag=0;
		for(int i=0; i<intset.length; i++) {//0~5까지 
//			intset[i]=(char)((int)(Math.random()*45));
			//0~45가 아니라 0~44 해서 45개인것
			//그래서 0~44 +1값을 더해서 1~45
//			System.out.print(intset[i]+" ");//정상출력..
			
			flag=(char)((int)(Math.random()*45)+1);
			
			//앞자리랑 비교해서 같으면 다시돌려
			if(i==0) {
				intset[i]=flag;
//				System.out.print(intset[i]+" ");//정상출력..
			}else if(i>0){
				for(int j=0;j<i; j++) {
					if(flag==intset[j]) {
						i--;//break만나면 나가면서 1더해주니까, 
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
	
//	2.아래제시된 문자열을 구분 문자로 잘라내어 문자열 배열에 저장하고 반환하는 일을 하는 method를
//	작성하세요.
//	"이재찬,이재현,공선의,정택성~이재현!최지우.김희철,이재찬,이채찬,정택성.공선의"
//	
//	출력: 이재찬 이재현 공선의 정택성 이재현 최지우 김희철 이재찬 이재찬 정택성 공선의
	public String[] Token(String names) {
		StringTokenizer stk = new StringTokenizer(names, ",.~!");
//		System.out.println(stk.countTokens()+"개");
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
		new work22().Token("이재찬,이재현,공선의,정택성~이재현!최지우.김희철,이재찬,이채찬,정택성.공선의");
		
		
		
	}//main
}//class
