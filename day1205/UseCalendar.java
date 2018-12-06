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
		
		//<YEAR =>Constant : ������ ���(filed)
		//Constant�� ����ϸ� ������ ���
		int i = cal.get(1);//������ �����µ� ������ ����...���� ����.
		int year = cal.get(Calendar.YEAR);
		//�ڹٿ����� ���� ������ 0��. �̶� 12��������11��.����+1
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DATE);
		int day2 = cal.get(Calendar.DAY_OF_MONTH);
		
		int day_of_year = cal.get(Calendar.DAY_OF_YEAR);
		//���� : ��-1, ��-2, ȭ-3, ��-4, ��-5, ��-6, ��-7 
		int day_of_week = cal.get(Calendar.DAY_OF_WEEK);
		System.out.printf("%d-%d-%d ������ ���ؿ� %d��° ��\n", year,month,
							day2,day_of_year);
		System.out.printf("%d����", day_of_week);
		
/*		String week="";
		switch(day_of_week) {
//		case 1 :System.out.println("�Ͽ���");	break;
		case Calendar.SUNDAY : 
			//�̷��� ���°� �������� �̾����� ����.
//			System.out.println("�Ͽ���");	break;
				week="�Ͽ���"; break;
				//�̷��Ծ��°� ��º��� ���� �־��� ����.
//		case 2 :System.out.println("������");	break;
		case Calendar.MONDAY :
			System.out.println("������");	break;
		case 3 :System.out.println("ȭ����");	break;
		case 4 :System.out.println("������");	break;
		case 5 :System.out.println("�����");	
				week="�����"; break;
		case 6 :System.out.println("�ݿ���");
				week="�ݿ���"; break;
		case 7 :System.out.println("�����");	
		}//end switch
		
		System.out.printf("%s", week);		
*/
		
		String[] weekTitle = {"��","��","ȭ","��","��","��","��"};
		System.out.printf(" %s\n",weekTitle[day_of_week-1]);//�迭�̶� -1
		int am_pm=cal.get(Calendar.AM_PM);//1����, 0����
//		switch (am_pm) {
//		case Calendar.AM/*���*/:
//			System.out.println("����");
//			break;
//		case Calendar.PM:
//			System.out.println("����");
//			break;
//		}
		System.out.printf("%d, %s\n",am_pm,am_pm==Calendar.AM?"����":"����");//���Կ����ڷ� ���̸� ����,f�� ����
		//3�׿����ڷ� �� ���ϰ� ���� �ִ�. ���� 2������ �����ϱ�.
		
		//�ð�
		int hour=cal.get(Calendar.HOUR);
		int hour24=cal.get(Calendar.HOUR_OF_DAY);
		int minute=cal.get(Calendar.MINUTE);
		int second=cal.get(Calendar.SECOND);
		System.out.printf("%d(%d):%d:%d\n", hour, hour24,minute,second);
		//�ϳ��ϳ��� calendar, �������ִ� ��¥ =>SimpleDateFormat,Date

		
		System.out.println("------------------------------------------------");
		System.out.printf("������ %d-%d-%d %s����\n",
				cal1.get(Calendar.YEAR),cal1.get(Calendar.MONTH)+1,
				cal1.get(Calendar.DAY_OF_MONTH),
				"��,��,ȭ,��,��,��,��".split(",")[cal1.get(Calendar.DAY_OF_WEEK)-1]);
		//��
		cal1.set(Calendar.YEAR, 2019);//2019-12-06
		//�� : ����� �����ϴ� ������ 1�۰� ����
		cal1.set(Calendar.MONTH, 5-1);//2019-05-06
		//�� : �ش� �Ͽ� �������� �ʴ� ���� ���ڰ� �����Ǹ� �ڵ����� ������ 1�Ϸ� ����
		cal1.set(Calendar.DAY_OF_MONTH, 15);//2019-05-15
		
		System.out.printf("������ %d-%d-%d %s����",
				cal1.get(Calendar.YEAR),cal1.get(Calendar.MONTH)+1,
				cal1.get(Calendar.DAY_OF_MONTH),
				"��,��,ȭ,��,��,��,��".split(",")[cal1.get(Calendar.DAY_OF_WEEK)-1]);
		
		System.out.println("\n�̹����� �������� : "+cal1.getActualMaximum(Calendar.DATE));
		
		
		
	}//UseCalendar
	
	public static void main(String[] args) {
		new UseCalendar();
	}//main

}//class
