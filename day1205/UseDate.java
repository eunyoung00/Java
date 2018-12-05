package day1205;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * ������ �ִ� ��¥ ������ ���� ��.
 * ���� -java.text.SimpleDateFormat
 * ��¥���� -java.util.Date
 * ������ �ִ� ��¥������ ������ �� �ΰ��� ���� ��� ����� �ִ�. ȥ�ڴ� ������ �ʴ´�.
 * @author owner
 */
public class UseDate {

	public UseDate() {
		Date date = new Date();
		System.out.println(date);
		//��ü�� ����ߴµ� �ּҰ��ƴ϶� ��µ� ���� : Object�� toString�� Override.
		//�� ��¥ ������ ���ϴ°� �ƴ϶�.
//		System.out.println(1900+date.getYear());//����õ method�� ����.
		//������ �����µ� 1900�� �����־�� �Ѵ�.����õ�� ����..!
		//��ġ�°� �ƴ϶� ����õ�� ��.

		SimpleDateFormat sdf = new SimpleDateFormat
//				("yyyy��M��d�� a HH(hh,kk):mm:ss EEEE");
		("yyyy��M��d�� a EEEE HH(hh,kk):mm:ss",Locale.JAPAN);
		String formatDate = sdf.format(date);//date�� has a ����
		System.out.println(formatDate);
		
		//Locale: �ٸ������� ��¥�������� �����Ͽ� ������ ��.
		//util package
		
	
	
	}//UseDate
	
	public static void main(String[] args) {
		new UseDate();
	}//main
}//class
