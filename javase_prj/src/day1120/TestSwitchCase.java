package day1120;

/**
 * switch~case�� ����� ���� ���ϱ�
 * @author owner
 */
public class TestSwitchCase {

	public static void main(String[] args) {
		
		int score = 100;
//		char grade = ' ';	//char�� ���ڸ� �����Ѵ�. ''�� ���ڰ� ���� ��°����� 
				           //' '���鹮��(white space)- unicode \u0000(~\uFFFF)
		                   //�ڵ�¿� �������� �ʾ� ���� �ʴ´�.Error
		                   //(int)Character.MIN_VALUE = \u0000  MAX_VALUE = \uFFFF
		//System.out.println((int)Character.MIN_VALUE+"/"+Character.MIN_VALUE)
		char grade=64;
		
		//case�� ����� �������� �������� ������ Constant�� ����Ϸ� �Ѵ�..
		switch(score/10) {
/*		case 10 :
		case 9 : grade = 'A'; break;
		case 8 : grade = 'B'; break;
		case 7 : grade = 'C'; break;
		case 6 : grade = 'D'; break;
    	default : grade = 'F';	*/
    	//break; default�� �Ʒ��ٿ� ����� �ڵ尡 �����Ƿ� �б⹮�� ��������ʴ´�. ���ϼ��ִ�
		
		case 6: grade++;	//64->65
		case 7: grade++;	//65->67
		case 8: grade++;
		case 9: 
		case 10: grade++;break;
		default : grade+=6;
		//a=65,b=66 ~ F=70
		//break �ִ°� �̰�쿡���� �� ����. �����ϰ� �����ϱ�, �����ټ��� ���ؼ�
		//case i �� ������ �ȵŰ� ����� ���� �������� ��������. constant�� �־��ִ°� ����.
		//6�� ������ 7�� ������ �˼� ���?=>�����ڵ�
		}//end switch
		
		System.out.println(score +" ���� ������ "+grade);
		
	}//main

}//class
