package day1227;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")//직렬화 될수 있다..(나갔다 들어오면서 ~~)
public class SimpleThreadChatServer extends JFrame implements Runnable,ActionListener {
	
	private JTextArea jta;
	private JTextField jtf;
	private JScrollPane jsp;
	
	private ServerSocket server;
	private Socket client;
	private DataInputStream readStream;
	private DataOutputStream writeStream;
	
	private String serverNick;
	private String clientNick;
	
	
	public SimpleThreadChatServer() {
		super("::::::::::::채팅서버::::::::::::");
		
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
//				System.out.println("종료!!!");
				dispose();//<윈도우만 죽인다. 성불시켜야..! 소켓이 살아있다?
				//화면이 종료된 후-> windowClosed 호출
//				System.exit(0);//현재 자바가상머신과 관련된 모든 인스턴스(객체)가 죽는다.
			}//windowClosing
			
			@Override
			public void windowClosed(WindowEvent e) {
				//클로징에서 클로드가 불린다.
//				System.out.println("영혼~~~");//없어져야
				try {
					close();//클라이언트와 연결하고 있는 스트림, 소켓,서버소켓 종료
				} catch (IOException e1) {
					e1.printStackTrace();
				}//end catch
			}//windowClosed
		});
		
		
		setBounds(100, 100, 300, 400);
		setVisible(true);
		jtf.requestFocus();//커서를 jtf에 위치시킨다.

//		try {
//			openServer();
//			//Thread has a : 메세지를 읽는 코드를 Thread로 처리하면 어디에 있든 동작가능하게 된다. 
//			Thread t= new Thread(this);
//			t.start();//start()에 의해 run()호출.
//		} catch (SocketException se) {
//			System.err.println("접속자가 들어오기 전에 종료되었습니다."+se.getMessage());
//		} catch (IOException e) {
//			JOptionPane.showMessageDialog(this/*static?this못써..*/, 
//									"서버가동 실패!!! 메세지를 읽어들일 수 없습니다.");
//			e.printStackTrace();
//		}//end catch
		
		jtf.addActionListener(this);
	}//SimpleChatServer
	
	 public void close() throws IOException{
		 try {
			 if(readStream!=null) {readStream.close();}//end if
			 if(writeStream!=null) {writeStream.close();}//end if
			 if(client!=null) {client.close();}//end if
		 }finally {
			 if(server!=null) {server.close();}//end if
		}//end finally
	}//close

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(writeStream!=null) {//접속자가 존재하여 스트림이 생성된 경우에만 
				//막무가내로 부르면 Error가 난다.
				sendMsg();//메세지를 보낸다.
			}else{
				JOptionPane.showMessageDialog(this, "대화 상대가 없습니다.");
				jtf.setText("");
			}//end if
		} catch (IOException ie) {
			JOptionPane.showMessageDialog(this, clientNick+"님께서 퇴실하였습니다.");
			ie.printStackTrace();
		}//end catch
	}//actionPerformed
	
	/**
	 * 1.ServerSocket을 생성하고(Port열림(선점/2번열수 없다)), 
	 * 2.접속자 소켓이 들어오면(accept) 대화를 주고 받을 수 있도록 
	 * 3.Stream을 연결(DIS,DOS)
	 */
	public void openServer() throws IOException,SocketException{
		////추가27
		serverNick=JOptionPane.showInputDialog("대화명 입력");
		
		//1.
		server=new ServerSocket(65535);
		jta.setText("서버가동 중...접속자를 기다립니다.\n");
		//3.(흐름상)
		client=server.accept();
		jta.append(clientNick+"client 접속\n");
		//4.(누가먼저 되든 상관없다)스트림 연결
		readStream=new DataInputStream(client.getInputStream());
		writeStream=new DataOutputStream(client.getOutputStream());
		
		//접속자의 닉네임을 받는다. <닉갖구와야함
		clientNick=readStream.readUTF();
		//내 닉을 보내준다.
		writeStream.writeUTF(serverNick);
		
		
	}//openServer
	
	/**
	 * 접속자에게 메세지를 보내는 일
	 * @throws IOException
	 */
	public void sendMsg()  throws IOException{
		//T.F의 값을 가져와서
		String msg=jtf.getText().trim();
		//스트림에 기록하고
		writeStream.writeUTF(msg);
		//스트림의 내용을 목적지로 분출
		writeStream.flush();
		//내가 쓴 내용을 내 화면에 출력하고 
		jta.append("["+serverNick+"]: "+msg+"\n\r");//나도 봐야 하기 때문
		//입력이 편하도록 jtf를 초기화
		jtf.setText("");
		//스크롤바를 갱신
		jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
	}//sendMsg
	
	/**
	 * 접속자가 보내오는 메세지를 계속 읽어 들여야한다.
	 * @throws IOException
	 */
	@Override
	public void run(){//override된거기 때문에 throws까지도 같아야 한다.
		String msg="";
		if(readStream !=null) {
			try {
			while(true) {
				//메세지를 읽어들여
					msg=readStream.readUTF();
				//대화창에 출력
				jta.append("["+clientNick+"]: "+msg+"\n\r");
				//메세지가 T.A에 추가되면 JScrollPane의 스크롤바의 값을 JScrollPane의 최고값으로 변경해 준다.
				jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
			}//end while
			} catch (IOException e) {
				e.printStackTrace();
			}//end catch
		}//end if
	}//revMsg
	

	public static void main(String[] args) {
//		new SimpleThreadChatServer();
		SimpleThreadChatServer stcs=new SimpleThreadChatServer();
		try {
			stcs.openServer();
			//Thread와 stcs객체를 has a 관계로 설정
			Thread t= new Thread(stcs);
			//메세지를 읽는 코드를 Thread로 처리
			t.start();
		} catch (SocketException se) {
			System.err.println("접속자가 들어오기 전에 종료되었습니다."+se.getMessage());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(stcs/*static?this못써..*/, 
									"서버가동 실패!!! 메세지를 읽어들일 수 없습니다.");
			e.printStackTrace();
		}//end catch
//		
	}//main

}//class
