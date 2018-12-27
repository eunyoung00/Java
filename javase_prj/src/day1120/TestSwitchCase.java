package day1120;

/**
 * switch~case를 사용한 학점 구하기
 * @author owner
 */
public class TestSwitchCase {

	public static void main(String[] args) {
		
		int score = 100;
//		char grade = ' ';	//char는 문자를 저장한다. ''는 문자가 없다 라는것으로 
				           //' '공백문자(white space)- unicode \u0000(~\uFFFF)
		                   //코드셋에 존재하지 않아 들어가지 않는다.Error
		                   //(int)Character.MIN_VALUE = \u0000  MAX_VALUE = \uFFFF
		//System.out.println((int)Character.MIN_VALUE+"/"+Character.MIN_VALUE)
		char grade=64;
		
		//case의 상수는 가독성이 떨어지기 때문에 Constant를 사용하려 한다..
		switch(score/10) {
/*		case 10 :
		case 9 : grade = 'A'; break;
		case 8 : grade = 'B'; break;
		case 7 : grade = 'C'; break;
		case 6 : grade = 'D'; break;
    	default : grade = 'F';	*/
    	//break; default는 아랫줄에 실행될 코드가 없으므로 분기문을 사용하지않는다. 줄일수있닷
		
		case 6: grade++;	//64->65
		case 7: grade++;	//65->67
		case 8: grade++;
		case 9: 
		case 10: grade++;break;
		default : grade+=6;
		//a=65,b=66 ~ F=70
		//break 있는게 이경우에서는 더 좋다. 한줄하고 나가니깐, 여러줄수행 안해서
		//case i 는 변수라 안돼고 상수를 쓰면 가독성이 떨어진다. constant를 넣어주는게 좋다.
		//6이 무언지 7이 무언지 알수 없어서?=>나쁜코드
		}//end switch
		
		System.out.println(score +" 점의 학점은 "+grade);
		
	}//main

}//class
