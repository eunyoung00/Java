package day1219;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class HomeWork2 {
	private int filetotal;
	private File file;
	private List<File> listjava;
	
	public void inputPath() {
		listjava=new ArrayList<File>();
		filetotal=0;
		String path = JOptionPane.showInputDialog("��θ� �Է��Ͽ� �ּ���");
		file=new File(path);
		if(file.isDirectory()) {//file�� ���丮 �϶�,
			File[] filelist=file.listFiles();
			for(int i=1;i<filelist.length;i++) { //���ϸ���Ʈ��ŭ ����
				if(filelist[i].getName().contains(".java")) {//�ڹ�Ȯ�����ΰ� ���
					filetotal=filetotal+1;//�ڹ����� ī��Ʈ
					listjava.add(filelist[i]);//list�� �ְ�
				}//end if
			}//end for
			deleteJava();
		}else{
			JOptionPane.showMessageDialog(null, "�ùٸ� ��θ� �Է��Ͽ� �ּ���");
			inputPath();
//			System.out.println("�ùٸ� ��θ� �Է��Ͽ� �ּ���");
		}//end else
	}//inputPath

	public void deleteJava() {
		int num=JOptionPane.showConfirmDialog(null, "java ������ "+filetotal+"�� �����մϴ�. �����Ͻðڽ��ϱ�?");
		switch (num) {
		case JOptionPane.OK_OPTION:
			for(int i=0;i<listjava.size();i++) {
				listjava.get(i).delete();//����Ʈ�� ����� ������ �����.
			}//end for
			break;
		case JOptionPane.NO_OPTION:
			break;
		case JOptionPane.CANCEL_OPTION:
			break;
		}//end switch
	}//deleteJava

	public static void main(String[] args) {
		new HomeWork2().inputPath();
	}//main

}//class
