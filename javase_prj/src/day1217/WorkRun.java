package day1217;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class WorkRun {
	
	private List<stuVO> listStu;
	private String inputnum,stu;
	private String[] tempData;
	private JTextArea jta;
	
	public WorkRun() {
//		System.out.println(listStu);//null
		listStu=new ArrayList<stuVO>();
//		System.out.println(listStu);//""
	
	}//WorkRun
	
	public void selectNum() {
		inputnum=JOptionPane.showInputDialog("�޴�����\n1.�Է� 2.��� 3.����");
		
		switch (inputnum) {
		case "1"://�Է�
			inputData();
			break;
		case "2":
			printData();
			break;
		case "3":
			break;
		default:
			JOptionPane.showMessageDialog(null, "�޴��� ��ȣ�� �Է��� �ּ���");
			selectNum();
		}

	}//selectNum
	
	public void inputData() {//�Է�->����->�Է�â ����
		stu=JOptionPane.showInputDialog("������ �Է�\n��) �̸�, �ڹ�����, ����Ŭ����");
		stuVO svo=new stuVO();
		tempData=stu.split(",");

		if(tempData.length !=3 ) {//�ĸ� 2���� �����Ͱ� ���������� ������,�ٽ� ùȭ�� ȣ��
			JOptionPane.showMessageDialog(null, "�Է� �������� ���´� \n�̸�, �ڹ�����, ����Ŭ���� �̾�� �մϴ�.","�Է� ����", JOptionPane.ERROR_MESSAGE);
		}//end if
		svo.setName(tempData[0]);
		svo.setJavaScore(Integer.parseInt(tempData[1]));
		svo.setOracleScore(Integer.parseInt(tempData[2]));//����
		System.out.println(listStu);//���⿡ ���� �ʾҴ�..[]
		selectNum();//�ٽ� �Է�â ����
	}//inputData
	
	public void printData() {//���
		//1.JTextArea ����( ���, �÷���)
		if(listStu.size()==0) {//�ƿ����� �����ϱ� ���� ũ�Ⱑ 0�ΰɷ�
			JOptionPane.showMessageDialog(null, "�����Ͱ� �����ϴ�.");
			selectNum();//�ٽ� �Է�â ����
		}else{//������ T.Aâ�� ������Ƽ�.
			jta = new JTextArea(10,40);
			jta.setEditable(false);
			jta.append(String.valueOf(listStu));
		//2.
		JScrollPane jsp=new JScrollPane(jta);
		//3.MessageDialog�� �ι��� �Ű������� ������Ʈ�� �Ҵ�
		JOptionPane.showMessageDialog(null, jsp);
		}
	}//printData

	public static void main(String[] args) {
		WorkRun wr = new WorkRun();
		wr.selectNum();
	}//main

}//class
