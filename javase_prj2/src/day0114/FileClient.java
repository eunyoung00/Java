package day0114;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

/**
 * ������ ������ ������ �����ϴ� ���� Ŭ���̾�Ʈ
 * @author owner
 */
@SuppressWarnings("serial")
public class FileClient extends JFrame implements ActionListener{
	
	private JButton btnSelectFile;
	private DefaultListModel<String> dlmFileList;
	
	public FileClient() {
		super("���� ����");
		btnSelectFile=new JButton("���� ����");
		
		dlmFileList=new DefaultListModel<String>();
		JList<String> listFile=new JList<String>(dlmFileList);
		JScrollPane jspFileList=new JScrollPane(listFile);
		jspFileList.setBorder(new TitledBorder("������ ����"));
		
		JPanel panel=new JPanel();
		panel.add(btnSelectFile);
		
		add("Center",jspFileList);
		add("South",panel);
		
		btnSelectFile.addActionListener(this);
		
		setBounds(100, 100, 400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//FileClient

	private void selectFile() {
		FileDialog fdOpen=new FileDialog(this, "���� ����", FileDialog.LOAD);
		fdOpen.setVisible(true);
		//�̹��� ���ϸ� ����
		String fPath=fdOpen.getDirectory();
		String fName=fdOpen.getFile();
		
/*		String[] dot= {"jpg","jpeg","gif","png","bmp"};
		for(int i=0; i<dot.length; i++) {
			String[] namearr=name.split(".");
			if(namearr[1]!=dot[i]) {
				JOptionPane.showMessageDialog(this, "������ ������ Ȯ���ڰ� �̹��������� �ƴմϴ�.");
			}
		}*/
		
		//�̹��� ����(jpg,jpeg,gif,png,bmp)�� ����
		//������ ������ ���� ������ �ƴ� ��� ���â ���
		if(fName!=null) {
			String ext=fName.substring(fName.lastIndexOf(".")+1).toLowerCase();//Ȯ���� �κ�->�ҹ���
			String[] arrCompare= {"jpg","jpeg","gif","png","bmp"};
			
			boolean extFlag=false;
			
			for(String tempExt: arrCompare) {
				if(tempExt.equals(ext)) {
					extFlag=true;
				}//end if
			}//end for
			
			if(!extFlag) {
				JOptionPane.showMessageDialog(this, fName+"�� ���۰����� ������ �ƴմϴ�.\n�̹����� ���۰����մϴ�.");
				return;
			}//end if
			
			//���� ����!!!!!
			try {
				sendFile(new File(fPath+"/"+fName) );
				dlmFileList.addElement(fName);
				JOptionPane.showMessageDialog(this, fName+"������ �����Ͽ����ϴ�.");
			} catch (IOException e) {
				e.printStackTrace();
			}//end catch
			
		}//end if
	}//selectFile
	
	private void sendFile(File file) throws IOException,UnknownHostException{
		//��������!!���Ϻ��Ϳ���~������ ����
		Socket socketClient=null;
		DataOutputStream dos=null;
		FileInputStream fis=null;
		
		try {
			String ip=JOptionPane.showInputDialog("���� ip ");
		socketClient=new Socket("211.63.89."+ip,10000);
//		System.out.println("����");
		
		String fName=file.getName();
		//1.���ϸ��� ����
		dos=new DataOutputStream(socketClient.getOutputStream());
		dos.writeUTF(fName);
		dos.flush();
		
		//3.������ ������ byte[] ���� ���� ����
		int dataCnt=0;
		byte[] tempData=new byte[512];
		int dataLen=0;
		
		fis=new FileInputStream(file);
		while((dataLen=fis.read(tempData))!=-1) {
			dataCnt++;//<<�긦 list�� ������ ���� fis�� 2�� ������ �ʿ䰡 ����. 
		}//end while
		
		System.out.println("������ �迭�� ����"+dataCnt);
		fis.close();//<�ѹ������� ������ ������(�о�����) ����ó������ ���ƿü� ���� �ٽ� ������ �־�� �Ѵ�.
		
		dos.writeInt(dataCnt);//������ �о���� �迭�� Ƚ��(����)�� �����Ѵ�.
		dos.flush();
		
		//5.���Ͽ��� �о���� ������ �����Ѵ�.
		dataLen=0;
		fis=new FileInputStream(file);//������ ũ�⸦ ���� �� ������ ������ ������ �翬���Ѵ�.
		while((dataLen=fis.read(tempData))!=-1) {//�����Ͱ� ������
			dos.write(tempData,0,dataLen);//<�о���ΰͱ����� ������������
			dos.flush();
			dataCnt--;
		}//end while
		System.out.println("���� Ƚ�� " +dataCnt);//<0�� ������ �ٺ�����
		
		}finally {
			if(fis!=null) {fis.close();}//end if
			if(dos!=null) {dos.close();}//end if
			if(socketClient!=null) {socketClient.close();}//end if
		}//end finally
	}//sendFile
	
	@Override
	public void actionPerformed(ActionEvent e) {
		selectFile();
	}//actionPerformed
	
	public static void main(String[] args) {
		new FileClient();
	}//main
}//class

