package day1205;

import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 * Calendar : ���� ��¥ ������ ���� ��.
 * 
 * @author owner
 */
public class UseCalendar {

	public UseCalendar() {
		//Calendar Ŭ������ �ν��Ͻ� ��� 
		//1.getInstance ���
//		Calendar cal = new Calendar;//�߻�Ŭ������ �ν��Ͻ��� �ɼ� ����.
		Calendar cal =Calendar.getInstance();
		//GregorianCalendar���Ἥ ��üȭ������ �˼� ����. //����ּҸ� ����.
		//2.is a ���� ��üȭ
		Calendar cal1 = new GregorianCalendar();
		//3.�ڽĸ����� ��üȭ
		GregorianCalendar gc = new GregorianCalendar();
		System.out.println(cal);
		System.out.println(cal1);
		System.out.println(gc);
		
		//YEAR =>Constant : ������ ���
		int i = cal.get(1);//������ �����µ� ������ ����...���� ����.
		int year = cal.get(Calendar.YEAR);
		System.out.println(year+" "+i);
		
		
	}//UseCalendar
	
	public static void main(String[] args) {
		new UseCalendar();
	}//main

}//class
