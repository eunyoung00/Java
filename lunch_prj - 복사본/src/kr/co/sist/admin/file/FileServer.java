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
				server=new ServerSocket(25000);//신뢰성 통신TCP/IP
				Socket client=null;
				DataInputStream dis=null;
				int cnt=0;
				String[] fileNames=null;
				String[] serverFileNames=null;
				
				List<String> tempFileList=new ArrayList<String>();
				
				DataOutputStream dos=null;
				
				while(true) {
					System.out.println("서버가동");
					client=server.accept();
					System.out.println("접속자 있음");
					
					dis=new DataInputStream(client.getInputStream());
					
					cnt=dis.readInt();//클라이언트가 보내오는 파일명의 수
//					System.out.println(cnt);
					fileNames=new String[cnt];//배열의 방에는 null,,,
					
					for(int i=0; i<cnt; i++) {
						fileNames[i]=dis.readUTF();
						System.out.println(i+"번째 파일 "+fileNames[i] );
					}//end for
					
					//서버에 존재하는 파일명을 배열로 복사
					serverFileNames=new String[LunchAdminMain.lunchImageList.size()];
					LunchAdminMain.lunchImageList.toArray(serverFileNames);
					System.out.println("서버"+Arrays.toString(serverFileNames));
					System.out.println("클라이언트"+Arrays.toString(fileNames));
					//클라이언트가 보내온 파일명과 서버의 파일명을 비교하여 클라이언트가 없는 파일명을 출력
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
					System.out.println("없는 파일 : "+tempFileList);
					
					dos=new DataOutputStream(client.getOutputStream());
					dos.writeInt(tempFileList.size());//전송할 파일의 갯수를 보낸다.
					
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
			JOptionPane.showMessageDialog(null, "파일 보내기 실패");
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
				fileData++;//몇개를 보낼건지
			}//end while
			fis.close();
			
			dos.writeInt(fileData);
			dos.flush();
			
			dos.writeUTF(fName);//writeUTF
			//<토막낸 갯수를 보내고(파일수와 토막난 수) 그수만큼 파일(실질적 내용물)을 반복해 받는다
			fis=new FileInputStream("C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/"+fName);
			while( (fileLen=fis.read(readData))!=-1) {
				dos.write(readData,0,fileLen);
//				fileData--;
			}//end while
			
			dos.flush();
			
		}finally {
//			if(dos!=null) {dos.close();}//end if//안됨여기서끊으면
			if(fis!=null) {fis.close();}//end if
		}//end finally
	}//fileSend
	
//	public static void main(String[] args) {
//		new FileServer().start();
//	}//main
	
}//class
