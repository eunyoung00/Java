package day1219;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class HomeWork {
	private BufferedReader br;
	private StringBuilder viewData;
	
	public HomeWork() {
		br= new BufferedReader(new InputStreamReader(System.in));
		viewData=new StringBuilder();
	}//HomeWork
	
	public void directoryInfo() {
		System.out.println("���丮���� �Է� : ");
		
		viewData
			.append("-----------------------------------------")
			.append("-----------------------------------------\n")
			.append("�̸�\t\t����\tũ��\t���������� ������ ��¥\n")
			.append("-----------------------------------------")
			.append("-----------------------------------------\n");
		
		try {
			String str=br.readLine(); //str=���� ���丮��.
			File file=new File(str);
			boolean flag=file.isDirectory();
			
			if(flag) {//���丮�̸�
				
				File[] filelist=file.listFiles();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd a HH:mm");
				for(int i=1;i<filelist.length;i++) {
					Date d = new Date(filelist[i].lastModified());
					if(filelist[i].isDirectory()) {
						viewData.append(filelist[i].getName()).append("\t")
						.append("\t").append("����").append("\t")
						.append("").append("\t")
						.append(sdf.format(d)).append("\n");
					}else {
						viewData.append(filelist[i].getName()).append("\t")
						.append("\t").append("����").append("\t")
						.append(filelist[i].length()+"byte").append("\t")
						.append(sdf.format(d)).append("\n");
					}//end else
				}//end for
				br.close();
				
				JTextArea jta=new JTextArea(20,50);
				jta.append(viewData.toString());//ȭ���� ������ �����͸� JTA�� �ٿ��ش�.
				JScrollPane jsp=new JScrollPane(jta);
				JOptionPane.showMessageDialog(null, jsp);
			}else {
				System.out.println("������ ������� �ʽ��ϴ�.");
			}//end else
					
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
	}//directoryInfo

	public static void main(String[] args) {
		new HomeWork().directoryInfo();
	}//main

}//class
