package day1119;

public class Work17 {

	public static void main(String[] args) {
/*		���� 
		1. ����� �ð��� �Է¹޾� �Ʒ��� �������� ����ϼ���.
		  ��� :  ����� �ð��� �ִ� 2�ð��� ������ ������ 60���� �Ѵ� �ٸ� "��Ÿ�"
		 	 60�� ���϶�� "�ܰŸ�"�� ����ϼ���.
*/
		int time = Integer.parseInt(args[0]);
		if(time < 120) {
			if(time>60) {
				System.out.println("��Ÿ�");
			} else if(time<=60) {
				System.out.println("�ܰŸ�");
			}
		} else
			System.out.println("2�ð� �ʰ�");
/*	

		2. �̸�, ������ܰ� ����� �Ÿ��� �Է¹޾� �Ʒ��� ���� ����ϼ���.
		   ��������� "����,����ö,�ý�,����"�� �����Ѵ�.
		   ������� 1200��, ����ö ��� 1250��, �ýÿ�� 3800�� �Դϴ�.
		   ����� 10Ű�� ������ �⺻���, 
		   �� 5Ű�� �ʰ��� ���� 100���� ���� �մϴ�.

		 ���   :  xxx�� ����� ��������� xx�̸� �Ÿ��� xx Ű�� �Դϴ�.
		            �� �̿� ��� xx���̰�, �պ��̿� ��� xx���̸�, �Ѵ� 20�ϱ���
		            ������ ��: xxxx�� �Դϴ�.  
		            +�÷ο� ��Ʈ
*/
		int len = Integer.parseInt(args[3]);
		int price = 0;
		if(args[2].equals("����")) {
			if (len<=10)
				price = 1200;
			else {
				price = 1200+ (((int)((len-10)/5))*100);
			}
			System.out.println(args[1]+"�� ����� ��������� "+args[2]+"�̸� �Ÿ��� "+ args[3]+"Ű�� �Դϴ�.");
			System.out.println("�� �̿� ��� "+price+"���̰�, �պ��̿� ��� "+(price*2)+"���̸�,"
					+ " �Ѵ� 20�ϱ���  ������ ��: "+(price*2*20)+"�� �Դϴ�.");	
		}else if(args[2].equals("����ö")) {
			if (len<=10)
				price = 1250;
			else {
				price = 1250+ (((int)((len-10)/5))*100);
			}
			System.out.println(args[1]+"�� ����� ��������� "+args[2]+"�̸� �Ÿ��� "+ args[3]+"Ű�� �Դϴ�.");
			System.out.println("�� �̿� ��� "+price+"���̰�, �պ��̿� ��� "+(price*2)+"���̸�,"
					+ " �Ѵ� 20�ϱ���  ������ ��: "+(price*2*20)+"�� �Դϴ�.");
		}else if(args[2].equals("�ý�")) {
			if (len<=10)
				price = 3800;
			else {
				price = 3800+ (((int)((len-10)/5))*100);
			}
			System.out.println(args[1]+"�� ����� ��������� "+args[2]+"�̸� �Ÿ��� "+ args[3]+"Ű�� �Դϴ�.");
			System.out.println("�� �̿� ��� "+price+"���̰�, �պ��̿� ��� "+(price*2)+"���̸�,"
					+ " �Ѵ� 20�ϱ���  ������ ��: "+(price*2*20)+"�� �Դϴ�.");
		}else if (args[2].equals("����")) {
			System.out.println(args[1]+"�� ����� ��������� "+args[2]+"�̸� �Ÿ��� "+ args[3]+"Ű�� �Դϴ�.");
			System.out.println("�� �̿� ��� "+price+"���̰�, �պ��̿� ��� "+(price*2)+"���̸�,"
					+ " �Ѵ� 20�ϱ���  ������ ��: "+(price*2*20)+"�� �Դϴ�.");
		}
		
		
		//�ѹ���
		int flag = 0;
		double flag_add = 0;
		int fee = 0;
//		int transport = Integer.parseInt(args[2]);
		int distance = Integer.parseInt(args[3]);
		if(args[2].equals("����")||args[2].equals("����ö")||args[2].equals("����")||args[2].equals("�ý�")) {

			if(args[2].equals("����")) {
				fee=0;
			}else if(args[2].equals("����ö")){
				fee=1250;
			}else if(args[2].equals("����")) {
				fee=1200;
			}else {
				fee = 3800;
			}
			
			if(distance>10) {
				flag_add = (distance-10)/5; 
				flag = (distance-10)/5; 
				if(flag_add>flag) {
					flag_add=flag_add+1;
					fee = fee + ((int)flag_add*100);
				}
			}//end if
			System.out.println(args[1]+"�� ����� ��������� "+args[2]+"�̸� �Ÿ��� "+ args[3]+"Ű�� �Դϴ�.");
			System.out.println("�� �̿� ��� "+fee+"���̰�, �պ��̿� ��� "+(fee*2)+"���̸�,"
					+ " �Ѵ� 20�ϱ���  ������ ��: "+(fee*2*20)+"�� �Դϴ�.");
			
		} else {
			System.out.println("�ùٸ� ���߱����� �Է��� �ּ���");
		}

	}

}
