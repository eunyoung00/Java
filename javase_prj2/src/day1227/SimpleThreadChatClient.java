package day1227;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Thread를 사용하여 무한루프로 메세지를 읽어들이는 코드를 
 * 화면디자인과,메세지를 보내는 코드와 동시에 실행시킨다.
 * @author owner
 */
@SuppressWarnings("serial")//직렬화 될수 있다..(나갔다 들어오면서 ~~)
public class SimpleThreadChatClient extends JFrame implements Runnable,ActionListener {
	
	private JTextArea jta;
	private JTextField jtf;
	private JScrollPane jsp;
	
	private Socket client;//서버와 연결하기 위해
	private DataInputStream readStream;//서버의 데이터를 읽기위한 스트림
	private DataOutputStream writeStream;//서버로 데이터를 보내기 위한 스트림.
	
	private String clientNick,serverNick;//나의(클라이언트) 대화명,서버의 대화명.
	
	public SimpleThreadChatClient() {
		super("::::::채팅클라이언트:::::");
		
		jta=new JTextArea();
		jta.setBorder(new TitledBorder("대화 내용"));
		//변경불가
		jta.setEditable(false);
		jta.setLineWrap(true);
		jta.setWrapStyleWord(true);
		//스크롤 추가
		jsp=new JScrollPane(jta);
		
		jtf=new JTextField();
		jtf.setBorder(new TitledBorder("대화 입력"));
		
		add("Center",jsp);
		add("South",jtf);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				
			}//windowClosing
			
			@Override
			public void windowClosed(WindowEvent e) {
				try {
					close();
					System.exit(0);//인스턴스를 바로 끊어버림.바로죽는다..
				} catch (IOException ie) {
					ie.printStackTrace();
				}//end catch
			}//windowClosed
		});
		
		setBounds(100, 100, 300, 400);
		setVisible(true);
		jtf.requestFocus();//커서를 jtf에 위치시킨다.
		
//		try {
//			connectToServer();
//			//Thread와 현재 클래스를 has a 관계로 설정
//			Thread t=new Thread(this);
//			//Thread 시작.
//			t.start();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}//end catch
		
		jtf.addActionListener(this);
	}//SimpleChatServer
	

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			sendMsg();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//end catch
	}//actionPerformed
	
	public void close() throws IOException{//중요~!~!
		try {
			if(readStream!=null) {readStream.close();}//end if
			if(writeStream!=null) {writeStream.close();}//end if
		}finally {
			if(client!=null) {client.close();}//end if
		}//end finally
	}//close
	
	/**
	 * 2.소켓을 생성하여 서버에 연결하고 대화를 읽거나 보내기 위해 
	 * 4.스트림을 연결한다.
	 * @throws IOException
	 */
	public void connectToServer() throws IOException{
		/////추가27
		clientNick=JOptionPane.showInputDialog("대화명 입력");
		//2.
//		client=new Socket("211.63.89.148", 65535);
		client=new Socket("211.63.89.144", 35000);
		
		//4.스트림 연결.
		readStream=new DataInputStream(client.getInputStream());
		writeStream=new DataOutputStream(client.getOutputStream());
		
		/////추가27
		//서버로 대화명 전달.
		writeStream.writeUTF(clientNick);
		jta.setText("대화방에 \""+clientNick+"\"으로 입장하셨습니다.\n");
		//서버의 대화명을 저장
		serverNick=readStream.readUTF();
		
	}//connectToServer
	
	/**
	 * 서버에서 보내오는 메세지를 무한루프로 읽어 들인다.
	 */
	@Override
	public void run(){
		String revMsg="";
		if(readStream !=null) {
			try {
				while(true) {
					revMsg=readStream.readUTF();
					//대화창에 읽어 들인 메세지를 출력
					jta.append("["+serverNick+"] :"+revMsg+"\n");
					//스크롤바 따라가게
					jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
				}//end while
			}catch (IOException ie) {
				JOptionPane.showMessageDialog(this, serverNick+"님께서 퇴실하였습니다.");
				ie.printStackTrace();
			}//end catch
		}//end if
	}//readMsg
	/**
	 * 작성된 메세지를 서버로 보내는 일.
	 */
	public void sendMsg() throws IOException{
		///작성된 메세지를 가져와서
		String sendMsg=jtf.getText().trim();
		//스트림에 기록하고
		writeStream.writeUTF(sendMsg);
		//스트림의 내용을 목적지로 분출
		writeStream.flush();
		//작성된 메세지를 채팅창에 출력한다.
		jta.append("["+clientNick+"] :"+sendMsg+"\n");
		//T.F의 내용을 삭제한다.
		jtf.setText("");
		//스크롤바 따라가게
		jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
	}//sendMsg
	

	public static void main(String[] args) {
//		new SimpleThreadChatClient();
		SimpleThreadChatClient stcc=new SimpleThreadChatClient();
		try {
			stcc.connectToServer();
			//메세지를 동시에 읽어야 하기 때문에 Thread로 처리
			Thread t= new Thread(stcc);
			t.start();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
//		try부분 생성자 쪽으로 붙여주고 이벤트를 내려주고 나니
//		이벤트를 등록하는 코드가 무한루프 아래에 있어서 서로의 메세지가 보내지지 않는다.
	}//main

}//class
