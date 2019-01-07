package client.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import client.view.ChatClientView;

public class ChatClientEvt extends WindowAdapter implements ActionListener,Runnable {

	private ChatClientView ccv;
	private Socket client;
	private DataInputStream readStream;
	private DataOutputStream writeStream;
	private Thread threadMsg;
	private String nick;
	private String clients;
	private List<String> clientList;
	
	public ChatClientEvt(ChatClientView ccv) {
		this.ccv=ccv;
		clientList=new ArrayList<String>();
		
	}//ChatClientEvt
	
	@Override
	public void run() {
		if(readStream!=null) {
			try {
				String revMsg="";
				JScrollPane jsp=ccv.getJspTalkDisplay();
				
				while(true) {//서버에서 보내오는 메세지를 읽어들여
						revMsg=readStream.readUTF();
						//채팅방에 뿌린다.
						if(revMsg.contains("    @")) {
							createList(revMsg);
							revMsg=null;
						}
						ccv.getJtaTalkDisplay().append(revMsg.trim()+"\n");
						//스크롤바를 가장 아래로 이동
						jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum() );
				}//end while
			} catch (IOException e) {
				JOptionPane.showMessageDialog(ccv, "서버가 종료되었습니다.");
				e.printStackTrace();
			}//end catch
		}//end if
	}//run
	
	@Override
	public void windowClosing(WindowEvent e) {
		ccv.dispose();
	}//windowClosing

	@Override
	public void windowClosed(WindowEvent e) {
		try {
			if(readStream!=null) {readStream.close();}
			if(writeStream!=null) {writeStream.close();}
			if(client!=null) {client.close();}
		} catch (IOException ie) {
			ie.printStackTrace();
		} finally {
			System.exit(0);
		}//end finally
	}//windowClosed
	
	private void connectToServer() throws UnknownHostException, IOException {
		if(client==null) {
			nick=ccv.getJtfNick().getText().trim();
			
			if(nick.equals("")) {//<nick이 없으면~~
				JOptionPane.showMessageDialog(ccv, "대화명을 입력해 주세요.");
				ccv.getJtfNick().requestFocus();
				return;
			}//end if

			client=new Socket("211.63.89.156", ccv.getPort());//입력한 ip address의 컴퓨터에 연결
			//스트림
			readStream=new DataInputStream(client.getInputStream());
			writeStream=new DataOutputStream(client.getOutputStream());
			
			//대화명을 서버로 보낸다.
			writeStream.writeUTF(nick);
			writeStream.flush();//<대화명을 서버로 보냈다
			
			ccv.getJtaTalkDisplay().setText("서버에 접속하였습니다.\n즐거운 채팅되세요\n");
			
			//메세지 읽기
			threadMsg=new Thread(this);
			threadMsg.start();
			
		}else {//<이미 접속해 있는 상태에서 접속버튼을 누른것
			JOptionPane.showMessageDialog(ccv, 
							client.getInetAddress().getHostAddress()+"서버에 이미 접속중 입니다.");
		}//end else
	}//connectToServer
	private void sendMsg() throws IOException {
		if(writeStream!=null) {
			//<연결되지 않은상태에서는 예외만 발생되므로
			JTextField jtf=ccv.getJtfTalk();
			//JTF에 입력한 메세지를 읽어 들인다.
			String msg=jtf.getText().trim();
			
			if(!msg.equals("")/*!msg.isEmpty()*/) {
				//스트림에 쓰고 예외는 날리도록
				writeStream.writeUTF("["+nick+/*"] ["+client.getInetAddress().getHostAddress()+"]"*/"]"+msg);
				//목적지로 분출
				writeStream.flush();
				//<다음번에 입력을 편하게 하기위해
				jtf.setText("");
			}//end if
		}//end if
	}//sendMsg
	private void capture() throws IOException {
		switch (JOptionPane.showConfirmDialog(ccv, "대화내용을 저장하시겠습니까?")) {
		case JOptionPane.OK_OPTION:
			//스트림을 사용하여 저장
			File saveDir=new File("C:/dev/chat");
			saveDir.mkdirs();
			File saveFile=new File(saveDir.getAbsolutePath()+"/java_chat["+System.currentTimeMillis()+"].dat");
			
			BufferedWriter bw=null;
			try {
				bw=new BufferedWriter(new FileWriter(saveFile));
				bw.write(ccv.getJtaTalkDisplay().getText());//스트림의 대화내용을 기록
				bw.flush();//스트림에 기록된 내용을 분출
				JOptionPane.showMessageDialog(ccv, saveDir+"에 대화 내용이 기록 되었습니다.");
			}finally {
				if(bw!=null) {bw.close();}//end if
			}//end finally
		}//end switch
	}//capture
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==ccv.getJbtConnect()) {
			try {
				connectToServer();
			} catch (UnknownHostException uhe) {
				JOptionPane.showMessageDialog(ccv, "서버를 알 수 없습니다.");
				uhe.printStackTrace();
			} catch (IOException ie) {
				JOptionPane.showMessageDialog(ccv, "연결 실패.");
				ie.printStackTrace();
			}//end catch
		}//end if
		if(ae.getSource()==ccv.getJbtClose()) {
			ccv.dispose();
		}//end if
		if(ae.getSource()==ccv.getJbtCapture()) {
			try {
				if(!ccv.getJtaTalkDisplay().getText().equals("")) {
					capture();
				}else {
					JOptionPane.showMessageDialog(ccv, "저장할 대화 내용이 없습니다.");
				}//end else
			} catch (IOException e) {
				JOptionPane.showMessageDialog(ccv, "파일로 저장하는 중 문제가 발생하였습니다.");
				e.printStackTrace();
			}//end catch
		}//end if
		
		if(ae.getSource()==ccv.getJtfTalk()) {
			try {
				sendMsg();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(ccv, "서버가 종료되어 메세지를 전송할 수 없습니다.");
				e.printStackTrace();
			}//end catch
		}//end if
		
		if(ae.getSource()==ccv.getJbtNickList()) {
			printData();
		}
	}//actionPerformed
	
	/**
	 * 접속자 리스트를 출력하는 일 
	 */
	public void printData() {
//		if(nick==null) {
//			JOptionPane.showMessageDialog(null, "먼저 접속하여주세요.");
//			return;//아래로 흘러가지 않게
//		}
		if(clientList.size()==0) {
			JOptionPane.showMessageDialog(null, "접속자가 없습니다.");
			return;//아래로 흘러가지 않게
		}//end if
		
		StringBuilder viewData=new StringBuilder();
		viewData
			.append("----------------\n")
			.append("접속자\n")
			.append("----------------\n");
		String csh=null;
		for(int i=0;i<clientList.size();i++) {
			csh=clientList.get(i).toString();
			viewData.append(csh).append("\n");
		}//end for
//		viewData.append("-----------------------------------------\n");

		JTextArea jta=new JTextArea(10,1);
		jta.setEditable(false);
		jta.append(/*String.valueOf(viewData)*/viewData.toString());//화면을 구성한 데이터를 JTA에 붙여준다.
		JScrollPane jsp=new JScrollPane(jta);
		JOptionPane.showMessageDialog(null, jsp);
		
	}//printData
	
	public void createList(String revMsg) {
		clients=revMsg.replace("@", " ").trim();
		String[] arr=clients.split(",");
		for(int i=0;i<arr.length;i++) {
			clientList.add(arr[i]);
		}//end for
	}//createList

}//class
