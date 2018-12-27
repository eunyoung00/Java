package day1218;

import static java.lang.Integer.parseInt;//parseInt�� ���� �ǰԲ� ����� �ش�.

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ScoreProcess {
	private List<ScoreVO> listStu;
	private int totalScore;
	
	public static final int INPUT_DATA=1;
	public static final int VIEW_DATA=2;
	public static final int EXIT=3;
	
	public ScoreProcess() {
		listStu=new ArrayList<ScoreVO>();//�ν��Ͻ�ȭ
	}//ScoreProcess
	

	/**
	 * ���ø޴��� �����ϴ� ��
	 */
	public void inputMenu() {
		String selectMenu="",inputResult="";
		
		boolean exitFlag=false;//�Ҹ��� �ϳ� ���� 3�϶��� ������
		do {//��� ���;� ���ƾ� �ϴ����� ������ ���õ� 1�� �Ǿ�� �ϰ�
			selectMenu=JOptionPane.showInputDialog("�޴� ����\n1.�Է� 2.��� 3.����");
//			if(selectMenu.equals("3")) {
//				exitFlag=true;      //flag������ ���� 3�̸� ture�� ture�϶� ������ ���� �ȴ�.
////				break;//���� �ݺ����� ������ ������
//			}
//			exitFlag=selectMenu.equals("3");//���ٷε� ������ ����~!~!
			
			try {
				switch (parseInt(selectMenu/*String�ϱ� integer��*/)) {
				case INPUT_DATA:
//					inputData();	break;
					inputResult="�������� ������ ���� �ʰų�, ������ ���������̾�� �մϴ�.";
					if(inputData()) {
						inputResult="�߰�����";
					}//end if
					JOptionPane.showMessageDialog(null, inputResult);
					break;
				case VIEW_DATA:
					printData();	break;
				case EXIT:
					exitFlag=true; break;
				default:
					JOptionPane.showMessageDialog(null, "�޴��� 1,2,3�� �ϳ� �̾�߸� �մϴ�.");
				}//end switch
			}catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "�޴��� ���� �̾�� �մϴ�.");
			}//end catch
		}while(/*true*/!exitFlag);
		
	}//inputMenu
	
	/**
	 * ����ó���� �����͸� �Է¹޴� ��
	 * @return 
	 */
	public boolean inputData() {
		boolean flag=false;
		
		String inputData=JOptionPane.showInputDialog("������ �Է�\n��) �̸�, �ڹ�����, ����Ŭ����");
		try {//��Ҵ����� nullpoint��...
		String[] data=inputData.replaceAll(" ", "").split(",");//<��������ְ� �ĸ����� �߶���
		if(data.length==3) { //�Է����Ŀ� ���� ��
			try {
				ScoreVO sv=new ScoreVO(data[0], parseInt(data[1]), parseInt(data[2]));
				listStu.add(sv);//������ �����͸� list�� �߰�
				flag=true;//���� ����� ����.
			//�ڹ������� ����Ŭ������ ���� �̾�� �Ѵ�.
			}catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "�ڹ������� ����Ŭ������ ���� �̾�� �մϴ�.");
				flag=false;
			}//end catch
			
		}//end if
		}catch (NullPointerException npe) {
		
		}//end catch
		
		return flag;
	}//inputData
	
	/**
	 * �Է������� ����ϴ� �� 
	 */
	public void printData() {
		if(listStu.size()==0) {
			JOptionPane.showMessageDialog(null, "����� �����Ͱ� �����ϴ�.");
			return;//�Ʒ��� �귯���� �ʰ�
		}//end if
		
		StringBuilder viewData=new StringBuilder();
		viewData
			.append("-----------------------------------------\n")
			.append("��ȣ\t�̸�\t�ڹ�\t����Ŭ\t����\t���\n")
			.append("-----------------------------------------\n");
		int tempTotal=0;
		ScoreVO sv=null;
		for(int i=0;i<listStu.size();i++) {
			sv=listStu.get(i);
			tempTotal=sv.getJavaScore()+sv.getOracleScore();
			viewData.append(i+1).append("\t").append(sv.getName())
			.append("\t").append(sv.getJavaScore())
			.append("\t").append(sv.getOracleScore()).append("\t").append(tempTotal)
			.append("\t").append(tempTotal/2.0).append("\n");
			
			totalScore+=tempTotal;//�� �л��� �ڹ������� ����Ŭ ������ ���� ���� ������.
			tempTotal=0;//�� �л��� ���� ������ �ʱ�ȭ
		}//end for
//		DecimalFormat df = new DecimalFormat("00.00");
		viewData.append("-----------------------------------------\n")
		.append("\t\t\t\t����").append(totalScore).append("\t���")
		.append(String.format("%5.2f",totalScore/((double)listStu.size()*2)));
		//value Arguments �Ǽ�)	"%��ü�ڸ���.�Ǽ��ڸ���f" 

		JTextArea jta=new JTextArea(7,50);
		jta.append(/*String.valueOf(viewData)*/viewData.toString());//ȭ���� ������ �����͸� JTA�� �ٿ��ش�.
		JScrollPane jsp=new JScrollPane(jta);
		JOptionPane.showMessageDialog(null, jsp);
		
	}//printData
	
	public static void main(String[] args) {
		ScoreProcess sp =new ScoreProcess();
		sp.inputMenu();
	}//main

}//class
