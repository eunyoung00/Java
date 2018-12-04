package day1129;

public class UsePersonalData {


//	 ����� ������ x��
//	 ���� �� x��
//	 �ְ���� "���ü�(����)"
//	 
//	1. ���ǰ��� �迭�� �Է��ϴ� method�� �ۼ��Ұ�.     v
//	2. �迭�� �Էµ� ���� ����ϴ� method �� �ۼ��Ұ�.   
//	   2�� method ���� ����ÿ� ��� �ִ� �ο����� ��� �Ұ�.
//	   2�� method ���� ������ ���� ��� �Ұ�.
//	   2�� method ���� ���� ���̰� ���� ����� �̸��� ��� �� ��.
	public PersonalData[] inputData() {
		PersonalData[] dataArr = null;
		dataArr = new PersonalData[7];
		
		dataArr[0]=new PersonalData(1, "������", "����� ������ ���ﵿ", 28,"����");
		dataArr[1]=new PersonalData(2, "������", "����� ���빮�� ��ʸ���", 27,"����");
		dataArr[2]=new PersonalData(3, "������", "������ ���뱸 ���뵿", 26,"����");
		dataArr[3]=new PersonalData(4, "���ü�", "����� ���α� ���ε�",27,"����");
		dataArr[4]=new PersonalData(5, "���ü�", "����� ���۱� �󵵵�",29,"����");
		dataArr[5]=new PersonalData(6, "�����", "��⵵ ��õ�� ��õ��",26,"����");
		dataArr[6]=new PersonalData(7, "�����", "����� ������ �����絿",27,"����");
		
		for(PersonalData tempData : dataArr ) {
		System.out.println(tempData.getNum()+" / "+tempData.getName()
		+" / "+tempData.getAddr()
		+" / "+tempData.getAge()+" / "+
				tempData.getGender());
		}
		return dataArr;
	}
	
	public void print1(PersonalData[] dataArr) {
		int cnt=0;
//		   2��-1 method ���� ����ÿ� ��� �ִ� �ο����� ��� �Ұ�.
		PersonalData tempData=null;
		for(int i=0; i<dataArr.length; i++) {
			tempData=dataArr[i];
			if(tempData.getAddr().startsWith("�����")) {
				cnt++;
			}
		}
		System.out.println("����� ������"+cnt+"��");
	}
	
	public void print2(PersonalData[] dataArr) {
//		   2��-2 method ���� ������ ���� ��� �Ұ�.
		int agesum=0;
		PersonalData tempData=null;
		for(int i=0; i<dataArr.length; i++) {
			tempData=dataArr[i];
			agesum = tempData.getAge()+agesum;
		}
		System.out.println("���� �� "+agesum+"��");
	}
	
	public void print3(PersonalData[] dataArr) {
//		   2��-3 method ���� ���� ���̰� ���� ����� �̸��� ��� �� ��.	

		int maxAge=0;
		String name = null;
		String gen = null;
		PersonalData tempData=null;
		for(int i=0; i<dataArr.length; i++) {
			tempData=dataArr[i];
			if(maxAge<tempData.getAge()) {
				//���� ��ȯ����  ���� ������ �ְ������� ������ �ش�.
				maxAge=tempData.getAge();
				name = tempData.getName();
				gen = tempData.getGender();
				
			}//�ڹ��� �ְ� ����
		}
		System.out.println("�ְ����\""+name+"("+gen+")"+"\"");
	
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UsePersonalData upd = new UsePersonalData();
		PersonalData[] dataArr = upd.inputData();
//		upd.inputData();
		upd.print1(dataArr);
		upd.print2(dataArr);
		upd.print3(dataArr);

	}

}
