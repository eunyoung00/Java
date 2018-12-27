package day1127;

/**
 * ���ڿ� ������� �ּҸ� �����ϰ�, ���ڿ��� �ٷ�� ����� �����ϴ� String class�� ���<br>
 * java���� �����ϴ� Ŭ������ �̸��� �������� Ŭ������ �̸��� ���ٸ� �������� Ŭ������ ���� ����ϰ� �ȴ�.<br>
 * java���� �����ϴ� Ŭ������ ����� ������, "full path:��Ű�� ���� ��� ����Ͽ� Ŭ������ ����ϴ°�"
 * �� ����ؾ� �Ѵ�.
 * ��Ű����.Ŭ������
 * =))���ŷο� ������ �����̸��� Ŭ������ �ȸ���� �ȴ�. Ư�� lang���ִ°� ����
 * @author owner
 */
public class UseString {

	
	public static void main(String[] args) { 
		//<�̸��� ������ ������ ������� ������
		//<�ڹ�.��.��Ʈ����  ����ϴµ� �������� ��Ʈ���� ����ϰԵ�.
//		System.out.println("�ȳ�?");//Error ��Ŭ����������.
		
		//�⺻�� ���� ���. String s ="���ڿ�";
//		java.lang.String s="ABCD"; //Ǯ�н� ����� �� �̷��� ����ϰ� ��.
		String str="AbcdEfg";
		
		//������ ���� ���. String s=new String("���ڿ�");
		String mail=new String("beebee1170@naver.com");
		//rurouni5181@daum.net
		
		System.out.println(str);
		System.out.println(mail); //���� �ι��ڰ� ���� ��������. 
		
		System.out.println(str+"�� ���� "+str.length());
		System.out.println(mail+"�� ���� "+mail.length());
		
		System.out.println(str+"�� ��� �빮�� "+str.toUpperCase());
		System.out.println(str+"�� ��� �ҹ��� "+str.toLowerCase());
		//"AbcdEfg"
		// 0123456 7
		//indexOf�� ��->�� �� �����ϸ� ����ó�� ã������ ���ڿ��� �ε����� ��´�.(L->R)
		System.out.println(str+"���� 'd'�� �ε��� : "+str.indexOf("d"));//�������ִ°�
		System.out.println(str+"���� 'd'�� �ε��� : "+str.indexOf("dEf"));
		System.out.println(str+"���� 'z'�� �ε��� : "+str.indexOf("z"));//������ -1
		
		System.out.println(mail+"���� \"@\"�� �ε��� : "+mail.indexOf("@"));
		str="AbcdEfAg";
		//lastIndexOf�� ��->�� �������� �����ϸ鼭 ����ó�� ã������ ���ڿ��� �ε����� ��´�.(R->L)
		System.out.println(str+"���ڿ����� �ڷκ���'A'�� �ε��� : "+
							str.lastIndexOf("A"));
		
		//Ư�� �ε����� ���� ���
		char temp =str.charAt(2);
		System.out.println(str+"���� 2��° �ε����� �ش��ϴ� ���� "+temp);
//		char temp2 =str.charAt(200);//�����ڸ� ������ Error
//		System.out.println(str+"���� 200��° �ε����� �ش��ϴ� ���� "+temp2);
		
		//�ڽĹ��ڿ� �ڸ���
		//str="AbcdEfAg";
		System.out.println(str+"���� �ε����� 2~5��° �ش��ϴ� ���ڿ� "+
							str.substring(2,5));//f�ڸ��� null�� ���.
		System.out.println(str+"���� �ε����� 2~5��° �ش��ϴ� ���ڿ� "+
				str.substring(2,6));//f���� �������� +1
		
		//"beebee1170 @n a v e r . c o m"
		// 012345678910111213141516171819 <- String index
		System.out.println(mail+"���� ���� �ּҸ� ��� "+mail.substring(0, 10));//������� �ٸ����� @ã�°� ����.
		System.out.println(mail+"���� ���� �ּҸ� ��� "+mail.substring(0, mail.indexOf("@")));
		System.out.println(mail+"���� ������ �ּҸ� ��� "+mail.substring(11,20));
		System.out.println(mail+"���� ������ �ּҸ� ��� "+mail.substring(mail.indexOf("@")+1,mail.length()));
		//substring�� �����ε����� ������ ������ �߶󳽴�.
		System.out.println(mail+"���� ������ �ּҸ� ��� "+mail.substring(mail.indexOf("@")+1));
		
		//�յ� ���� �ڸ���, <���̰����� �ڸ��� ����.
		str="   A BC    ";
		System.out.println("["+str+"]���� �յ� ���� ����["+str.trim()+"]");
		
		//���ڿ� ���̱�, <concat�� +�� ��� ����.
		str="Abcd";
		String str1=str.concat("Efg");
		String str2=str+"Efg";
		System.out.println(str1);
		System.out.println(str2);
		
		//���ڿ��� �Ϻ��ϰ� ������ ��
//		str="������";
		str="������";
		System.out.println(str+"��(��) "+(str.equals("������")?"����":"���"));
		
		//���ڿ��� �� ���ڿ��� �����ϴ���
//		str="�Ǿ���";
		str="�������";
		if(str.startsWith("����")) {
			System.out.println("���� ����ϽǼ� �����ϴ�.");
		}else {
			System.out.println(str);
		}//end else
		
		str="����� ������";
		str1="������ �ȴޱ�";
		System.out.println(str+"��(��) "+
					(str.startsWith("����")?"����� �Դϴ�.":"������ �ƴմϴ�."));
		
		//Ư�����ڿ��� ��������
		str="����� ������ ���ﵿ";
		str1="��⵵ ������ ������";
		System.out.println(str+"��(��) "+
							(str.endsWith("��")?"����":"�ð�"));
		System.out.println(str1+"��(��) "+
							(str1.endsWith("��")?"����":"�ð�"));
		
		//ġȯ : ���ڿ� ���� ��� ���ڿ� ã�Ƽ� "ġȯ"
		//replaceAll or replace
		//replaceAll(String regex(���Խ��� ����), String replacement)  
		str="�� ���� �Ǿ����ε� �� ���� �������!";
		str="�� ���� �Ǿ����ε� �� ���� �� �����!";
		str="�� ���� �Ǿ����ε� �� ���� �� �� �����!";
		
//		System.out.println(str.replace("����", "**"));
		System.out.println(str.replaceAll("����", "**"));
		//method�� �����ؼ� ȣ���ϴ� ���� method chain ��
		System.out.println(str.replace("��", "*").replaceAll("��", "*"));
		
		str="  A BC  ";
		System.out.println(str.replace(" ", ""));//ABC����.
		
		int i=27;
//		str=i;//<���� �޶� ����� �ʴ´�.//int�� String���� �Ҵ� �� �� ����.
		//�⺻�� ���������� ���ڿ��� ��ȯ
		str=String.valueOf(i);//���������ʰ�?�׷��� static method
		System.out.println(str);
		double d= 11.27;
//		str=d;//<���� �޶� ����� �ʴ´�.
		str=d+""; //���ڿ��� ������ ���ڿ��� �ȴ�.c���� �ַξ��� �ڹٿ��� ���夤��
		System.out.println(str);
		
//		str="11";
		str="";
		System.out.println(str.isEmpty());
		
		//��ü������ ���� �ʾ��� �� �� Ŭ������ �����ϴ� method�� ����Ҽ� ����. Error 
		//<Ŭ������ ��ü�� ���� �ʰ� ���赵�� ����ü�� �ٸ��Ŵ�.
//		str=null;//heap�� �ּҸ� �������� �ʾҽ��ϴ�.=>�������� ����.
//		System.out.println(str.isEmpty());//Error
		
		///////////////////////11-28-2018 split ��� �ڵ� �߰�/////////////
		String data="������,������,���ü�~������~�����.������,������,������.������";
		//split�� �ѹ��� �ϳ��� ���ڷ� �����Ͽ� �ڸ���.
		String[] arr=data.split("[.]");//�ѱ۵� ���е����� .�� �׳� ���鱸�е��� �ʴ´�.
		//[]�� ��� ����=>[.]�� ����
		System.out.println("���е� �迭 ���� ���� : "+arr.length);
		for(String name : arr) {
			System.out.println(name);
		}//end for
		//<�������� �Ѳ����� �ڸ�������. �ѹ��� �ϳ� ƿ���ƿ��, �ĸ��� �ĸ�
		
		
		
	}//main
}//class
