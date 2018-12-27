package day1218;

import java.util.Stack;

public class DataClone {

	private Stack<Data> historyStack;
	
	public DataClone() {
		historyStack=new Stack<Data>();
	}//DataClone
	
	public void useData() throws CloneNotSupportedException {
		Data d=new Data("�ֿ� ��ġ��");
		
		if(d instanceof Cloneable) {//�ڹٿ��� ������ ���ڿ�(�ε�?) ������..! ������¥ �Ⱦ�...
			
		d.setSchool("�ֿ��ʵ��б�");
		Data d1=d.getData();//����
		historyStack.push(d1);
		
		d.setSchool("�ֿ����б�");
		Data d2=d.getData();
		historyStack.push(d2);
		
		d.setSchool("�ֿ����б�");
		Data d3=d.getData();
		historyStack.push(d3);
		
		d.setSchool("�ֿ���б�");
		historyStack.push(d.getData());//�̻ڰ� ������ d.getData()�� ���� ���ذ�.
		
		getHistoryData();
		}else {
			System.out.println("Cloneable�� ó���մϴ�.");
		}//end else
	}//useData
	
	public void getHistoryData() {

		Data temp=null;
		while(!historyStack.empty()) {
			temp=historyStack.pop();
			System.out.println(temp);//�� �ٸ� �ּҸ� ������.
			System.out.println(temp.getSchool());
		}//end while
	}//getHistoryData
	
	public static void main(String[] args) {
		try {//getData���� ����ó���� �����...
			new DataClone().useData();
		} catch (CloneNotSupportedException e) {
			System.out.println("�������� �ʽ��ϴ�.");
			e.printStackTrace();
		}//end catch
	}//main

}//class
