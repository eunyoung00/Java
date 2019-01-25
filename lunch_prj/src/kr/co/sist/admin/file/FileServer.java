package kr.co.sist.admin.file;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

import kr.co.sist.lunch.admin.run.LunchAdminMain;

public class FileServer extends Thread {

	@Override
	public void run() {
//		System.out.println("thread?0000000000000000000");
		ServerSocket server=null;
		try {
			try {
				server=new ServerSocket(25000);//�ŷڼ� ���TCP/IP
				Socket client=null;
				DataInputStream dis=null;
				int cnt=0;
				String[] fileNames=null;
				String[] serverFileNames=null;
				
				List<String> tempFileList=new ArrayList<String>();
				
				DataOutputStream dos=null;
				
				while(true) {
					System.out.println("��������");
					client=server.accept();
					System.out.println("������ ����");
					
					dis=new DataInputStream(client.getInputStream());
					
					cnt=dis.readInt();//Ŭ���̾�Ʈ�� �������� ���ϸ��� ��
//					System.out.println(cnt);
					fileNames=new String[cnt];//�迭�� �濡�� null,,,
					
					for(int i=0; i<cnt; i++) {
						fileNames[i]=dis.readUTF();
						System.out.println(i+"��° ���� "+fileNames[i] );
					}//end for
					
					//������ �����ϴ� ���ϸ��� �迭�� ����
					serverFileNames=new String[LunchAdminMain.lunchImageList.size()];
					LunchAdminMain.lunchImageList.toArray(serverFileNames);
					System.out.println("����"+Arrays.toString(serverFileNames));
					System.out.println("Ŭ���̾�Ʈ"+Arrays.toString(fileNames));
					//Ŭ���̾�Ʈ�� ������ ���ϸ�� ������ ���ϸ��� ���Ͽ� Ŭ���̾�Ʈ�� ���� ���ϸ��� ���
//					List<String> list=new ArrayList<String>();
//					for(int i=0; i<serverFileNames.length; i++) {
//						list.add(serverFileNames[i]);
//						for(int j=0; j<fileNames.length; j++) {
//							if(serverFileNames[i].equals(fileNames[j])) {
//								list.remove(serverFileNames[i]);
//							}//end if
//						}
//					}//end for
//					System.out.println(list);
					
					for(String tName:LunchAdminMain.lunchImageList) {
						tempFileList.add(tName);
						tempFileList.add("s_"+tName);
					}//end for
					
					System.out.println(tempFileList);
					
					for(String rmName : fileNames) {
						tempFileList.remove(rmName);
						tempFileList.remove("s_"+rmName);
					}//end for
					System.out.println("���� ���� : "+tempFileList);
					
					dos=new DataOutputStream(client.getOutputStream());
					dos.writeInt(tempFileList.size());//������ ������ ������ ������.
					
					for(String fName : tempFileList) {
						fileSend(fName,dos);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}//end catch
					}//end for
					
				}//end while
				
			}finally {
				if(server !=null) {server.close();}//end if
			}//end finally
		}catch (IOException ie) {
			JOptionPane.showMessageDialog(null, "���� ������ ����");
			ie.printStackTrace();
		}//end catch
	}//run
	
	private void fileSend(String fName, DataOutputStream dos/*Socket client*/) throws IOException{
		FileInputStream fis=null;
	
		try {
			int fileData=0;
			
			fis=new FileInputStream("C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/"+fName);
			byte[] readData=new byte[512];
			int fileLen=0;
			
			while((fileLen=fis.read(readData))!=-1) {
				fileData++;//��� ��������
			}//end while
			fis.close();
			
			dos.writeInt(fileData);
			dos.flush();
			
			dos.writeUTF(fName);//writeUTF
			//<�丷�� ������ ������(���ϼ��� �丷�� ��) �׼���ŭ ����(������ ���빰)�� �ݺ��� �޴´�
			fis=new FileInputStream("C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/"+fName);
			while( (fileLen=fis.read(readData))!=-1) {
				dos.write(readData,0,fileLen);
//				fileData--;
			}//end while
			
			dos.flush();
			
		}finally {
//			if(dos!=null) {dos.close();}//end if//�ȵʿ��⼭������
			if(fis!=null) {fis.close();}//end if
		}//end finally
	}//fileSend
	
//	public static void main(String[] args) {
//		new FileServer().start();
//	}//main
	
}//class
