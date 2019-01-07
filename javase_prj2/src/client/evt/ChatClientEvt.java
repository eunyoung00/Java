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
				
				while(true) {//�������� �������� �޼����� �о�鿩
						revMsg=readStream.readUTF();
						//ä�ù濡 �Ѹ���.
						if(revMsg.contains("    @")) {
							createList(revMsg);
							revMsg=null;
						}
						ccv.getJtaTalkDisplay().append(revMsg.trim()+"\n");
						//��ũ�ѹٸ� ���� �Ʒ��� �̵�
						jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum() );
				}//end while
			} catch (IOException e) {
				JOptionPane.showMessageDialog(ccv, "������ ����Ǿ����ϴ�.");
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
			
			if(nick.equals("")) {//<nick�� ������~~
				JOptionPane.showMessageDialog(ccv, "��ȭ���� �Է��� �ּ���.");
				ccv.getJtfNick().requestFocus();
				return;
			}//end if

			client=new Socket("211.63.89.156", ccv.getPort());//�Է��� ip address�� ��ǻ�Ϳ� ����
			//��Ʈ��
			readStream=new DataInputStream(client.getInputStream());
			writeStream=new DataOutputStream(client.getOutputStream());
			
			//��ȭ���� ������ ������.
			writeStream.writeUTF(nick);
			writeStream.flush();//<��ȭ���� ������ ���´�
			
			ccv.getJtaTalkDisplay().setText("������ �����Ͽ����ϴ�.\n��ſ� ä�õǼ���\n");
			
			//�޼��� �б�
			threadMsg=new Thread(this);
			threadMsg.start();
			
		}else {//<�̹� ������ �ִ� ���¿��� ���ӹ�ư�� ������
			JOptionPane.showMessageDialog(ccv, 
							client.getInetAddress().getHostAddress()+"������ �̹� ������ �Դϴ�.");
		}//end else
	}//connectToServer
	private void sendMsg() throws IOException {
		if(writeStream!=null) {
			//<������� �������¿����� ���ܸ� �߻��ǹǷ�
			JTextField jtf=ccv.getJtfTalk();
			//JTF�� �Է��� �޼����� �о� ���δ�.
			String msg=jtf.getText().trim();
			
			if(!msg.equals("")/*!msg.isEmpty()*/) {
				//��Ʈ���� ���� ���ܴ� ��������
				writeStream.writeUTF("["+nick+/*"] ["+client.getInetAddress().getHostAddress()+"]"*/"]"+msg);
				//�������� ����
				writeStream.flush();
				//<�������� �Է��� ���ϰ� �ϱ�����
				jtf.setText("");
			}//end if
		}//end if
	}//sendMsg
	private void capture() throws IOException {
		switch (JOptionPane.showConfirmDialog(ccv, "��ȭ������ �����Ͻðڽ��ϱ�?")) {
		case JOptionPane.OK_OPTION:
			//��Ʈ���� ����Ͽ� ����
			File saveDir=new File("C:/dev/chat");
			saveDir.mkdirs();
			File saveFile=new File(saveDir.getAbsolutePath()+"/java_chat["+System.currentTimeMillis()+"].dat");
			
			BufferedWriter bw=null;
			try {
				bw=new BufferedWriter(new FileWriter(saveFile));
				bw.write(ccv.getJtaTalkDisplay().getText());//��Ʈ���� ��ȭ������ ���
				bw.flush();//��Ʈ���� ��ϵ� ������ ����
				JOptionPane.showMessageDialog(ccv, saveDir+"�� ��ȭ ������ ��� �Ǿ����ϴ�.");
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
				JOptionPane.showMessageDialog(ccv, "������ �� �� �����ϴ�.");
				uhe.printStackTrace();
			} catch (IOException ie) {
				JOptionPane.showMessageDialog(ccv, "���� ����.");
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
					JOptionPane.showMessageDialog(ccv, "������ ��ȭ ������ �����ϴ�.");
				}//end else
			} catch (IOException e) {
				JOptionPane.showMessageDialog(ccv, "���Ϸ� �����ϴ� �� ������ �߻��Ͽ����ϴ�.");
				e.printStackTrace();
			}//end catch
		}//end if
		
		if(ae.getSource()==ccv.getJtfTalk()) {
			try {
				sendMsg();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(ccv, "������ ����Ǿ� �޼����� ������ �� �����ϴ�.");
				e.printStackTrace();
			}//end catch
		}//end if
		
		if(ae.getSource()==ccv.getJbtNickList()) {
			printData();
		}
	}//actionPerformed
	
	/**
	 * ������ ����Ʈ�� ����ϴ� �� 
	 */
	public void printData() {
//		if(nick==null) {
//			JOptionPane.showMessageDialog(null, "���� �����Ͽ��ּ���.");
//			return;//�Ʒ��� �귯���� �ʰ�
//		}
		if(clientList.size()==0) {
			JOptionPane.showMessageDialog(null, "�����ڰ� �����ϴ�.");
			return;//�Ʒ��� �귯���� �ʰ�
		}//end if
		
		StringBuilder viewData=new StringBuilder();
		viewData
			.append("----------------\n")
			.append("������\n")
			.append("----------------\n");
		String csh=null;
		for(int i=0;i<clientList.size();i++) {
			csh=clientList.get(i).toString();
			viewData.append(csh).append("\n");
		}//end for
//		viewData.append("-----------------------------------------\n");

		JTextArea jta=new JTextArea(10,1);
		jta.setEditable(false);
		jta.append(/*String.valueOf(viewData)*/viewData.toString());//ȭ���� ������ �����͸� JTA�� �ٿ��ش�.
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
