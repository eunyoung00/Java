package c.server.helper;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 * 서버에서 생성하며 접속자소켓에 스트림을 얻어와서 관리하는 클래스<br>
 * 접속자가 존재하면 접속자 소켓에서 얻어낸 스트림에서 메세지를 무한루프로 읽어들이고 모든접속자에게 메세지 출력
 * @author owner
 */
public class ChatServerHelper extends Thread{
	private Socket someClient;
	private DataInputStream readStream;
	private DataOutputStream writeStream;
	private DefaultListModel<String> dlm;
	private int cnt;
	private List<ChatServerHelper> connectList;//리스트에 저장하는 하나가 클라이언트 하나하나 인것.
	
	private JFrame jf;
	private JScrollPane jsp;
	private String nick, client;
	
	
	/**
	 * 접속자 소켓을 받아서 스트림을 얻어 메세지를 읽거나 보낼 수 있는 상태로 만든다.
	 * @param socket 접속자 소켓
	 * @param dlm 접속자 관리창을 사용하기 위한 Model객체
	 * @param cnt 접속 순서
	 */
	public ChatServerHelper(Socket socket, DefaultListModel<String> dlm, int cnt,JFrame jf,List<ChatServerHelper> list, JScrollPane jsp) {
		someClient=socket;
		this.dlm=dlm;
		this.cnt=cnt;
		this.jf=jf;
		connectList=list;
		this.jsp=jsp;
		
		//스트림 얻기//<보내고 읽을 수 있는 상태가 된것
		try {
			readStream=new DataInputStream(someClient.getInputStream());
			writeStream=new DataOutputStream(someClient.getOutputStream());
			
			//접속자가 보내오는 nick을 받는다.
			nick=readStream.readUTF();
			//서버창에 접속메세지를 출력
			dlm.addElement("["+someClient.getInetAddress()+"/"+nick+"] 님이 접속하셨습니다.");//<접속 시간까지도 가능해짐.
			
			//서버에 접속한 모든 접속자에게 메세지를 출력(<누가들어왔어~!)
			broadcast("["+cnt+"] 번째 접속자가 ["+nick+"]으로 채팅방에 접속하였습니다.");
			jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
			//setclient();
		} catch (IOException ie) {
			JOptionPane.showMessageDialog(jf, "접속자 연결 중 문제 발생...");
			ie.printStackTrace();
		}//end catch
		
	}//MultiChatServerHelper
	
	public void run() {
		if(readStream!=null) {
			try {//<얘가 나가게 try를 while밖으로.
				
				String revMsg="";
				while(true) {
					//서버에서 보내오는 모든 메세지를 읽어서, 모든 접속자에게 뿌린다.
					revMsg=readStream.readUTF();
					broadcast(revMsg);
				}//end while
			} catch (IOException ie) {
				//접속자가 퇴실하면 해당 접속자를 리스트에서 삭제 한다. 후엔 서버창에 남겨주도 삭제된애 빼고 모든접속자에게 보내준다.
				connectList.remove(this);//<cnt가 안되는 이유는 list에 여러명이 들어오는데, 앞에사람이 나가면 인덱스가 변경됨으로 안됨.(나를 지우라고 하면 됨)
				setclient();
				
				//메세지를 읽어들이지 못하는 상태라면 접속자가 연결을 종료한 상태.라 관리자 창에 뿌려준다.
				dlm.addElement(cnt+"번째/"+nick+" 접속자 퇴실");
				broadcast("["+nick+"]님이 퇴실하였습니다.");
				jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum()+1 );
				ie.printStackTrace();
//			} catch (EOFException ee) {//파일이 끝났는데?더 읽어들이려 할때?
//				ee.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}//end catch
		}//end if
	}//run
	
	/**
	 * 모든 접속자에게 메세지를 뿌려주는 일.
	 * synchronized : MultiThread에서 동시 호출을 막는다.(동기화처리)
	 * @param msg
	 */
	public synchronized void broadcast(String msg) {
		ChatServerHelper csh=null;
		
		try {
			for(int i=0; i<connectList.size(); i++) {//<모든접속자가 나올것.
				
				csh = connectList.get(i);//list에서 Helper객체를 얻고
				csh.writeStream.writeUTF(msg);//출력 스트림에 출력
				csh.writeStream.flush();//목적지로 분출
			}//end for
		} catch (IOException ie) {//<보낼수없는상태에요 라는건 연결이 끊긴것
			JOptionPane.showMessageDialog(jf, "["+cnt+"] 번째 접속자에게 메세지를 보낼 수 없습니다.");
			ie.printStackTrace();
		}//end catch
	}//broadcast
	
	public synchronized void setclient() {
		ChatServerHelper csh=null;
		client="    ,";
		for(int i=0; i<connectList.size();i++){
			csh=connectList.get(i);
			client=client+csh.nick+",";
		}//end for
		broadcast(client);
	}//setclient
	
	
}//class
