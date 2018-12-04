package day1120;

/**
 * 
 * @author owner
 */
public class Work18 {

	public static void main(String[] args) {
//		숙제 1.
//		구구단 출력 (flowchart 그리고 )
//		2x1=2    3x1=3  4x1=4  ...            9x1=9
//		.
//		.
//		.
//		2x9=18                                     9x9=81
		for(int i=2; i<3; i++) {
			for(int j=1; j<10; j++) {
				System.out.println(i+"x"+j+" = "+(i*j)+"    "+
						(i+1)+"x"+j+" = "+((i+1)*j)+"    "+
						(i+2)+"x"+j+" = "+((i+2)*j)+"    "+
						(i+3)+"x"+j+" = "+((i+3)*j)+"    "+
						(i+4)+"x"+j+" = "+((i+4)*j)+"    "+
						(i+5)+"x"+j+" = "+((i+5)*j)+"    "+
						(i+6)+"x"+j+" = "+((i+6)*j)+"    "+
						(i+7)+"x"+j+" = "+((i+7)*j)+"    "	);
			}
		}
		System.out.println("=====================2번=============================");
//		숙제2.
//		0 0
//		 1 0 1 1
//		   2 0 2 1 2 2
//		     3 0 3 1 3 2 3 3 
		for(int i=0; i<4; i++) {
			for(int j=0;j<=i;j++) {
				System.out.print(i+" "+j+" ");
			}
			System.out.println();
			for(int j=0;j<=i;j++) {
				System.out.print("  ");
			}
		}
		
		 
	}//main
}//class
