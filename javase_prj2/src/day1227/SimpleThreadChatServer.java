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

@SuppressWarnings("serial")//����ȭ �ɼ� �ִ�..(������ �����鼭 ~~)
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
		super("::::::::::::ä�ü���::::::::::::");
		
		jta=new JTextArea();
		jta.setBorder(new TitledBorder("��ȭ ����"));
		//����Ұ�
		jta.setEditable(false);
		jta.setLineWrap(true);
		jta.setWrapStyleWord(true);
		//��ũ�� �߰�
		jsp=new JScrollPane(jta);
		
		jtf=new JTextField();
		jtf.setBorder(new TitledBorder("��ȭ �Է�"));
		
		add("Center",jsp);
		add("South",jtf);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
//				System.out.println("����!!!");
				dispose();//<�����츸 ���δ�. ���ҽ��Ѿ�..! ������ ����ִ�?
				//ȭ���� ����� ��-> windowClosed ȣ��
//				System.exit(0);//���� �ڹٰ���ӽŰ� ���õ� ��� �ν��Ͻ�(��ü)�� �״´�.
			}//windowClosing
			
			@Override
			public void windowClosed(WindowEvent e) {
				//Ŭ��¡���� Ŭ�ε尡 �Ҹ���.
//				System.out.println("��ȥ~~~");//��������
				try {
					close();//Ŭ���̾�Ʈ�� �����ϰ� �ִ� ��Ʈ��, ����,�������� ����
				} catch (IOException e1) {
					e1.printStackTrace();
				}//end catch
			}//windowClosed
		});
		
		
		setBounds(100, 100, 300, 400);
		setVisible(true);
		jtf.requestFocus();//Ŀ���� jtf�� ��ġ��Ų��.

//		try {
//			openServer();
//			//Thread has a : �޼����� �д� �ڵ带 Thread�� ó���ϸ� ��� �ֵ� ���۰����ϰ� �ȴ�. 
//			Thread t= new Thread(this);
//			t.start();//start()�� ���� run()ȣ��.
//		} catch (SocketException se) {
//			System.err.println("�����ڰ� ������ ���� ����Ǿ����ϴ�."+se.getMessage());
//		} catch (IOException e) {
//			JOptionPane.showMessageDialog(this/*static?this����..*/, 
//									"�������� ����!!! �޼����� �о���� �� �����ϴ�.");
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
			if(writeStream!=null) {//�����ڰ� �����Ͽ� ��Ʈ���� ������ ��쿡�� 
				//���������� �θ��� Error�� ����.
				sendMsg();//�޼����� ������.
			}else{
				JOptionPane.showMessageDialog(this, "��ȭ ��밡 �����ϴ�.");
				jtf.setText("");
			}//end if
		} catch (IOException ie) {
			JOptionPane.showMessageDialog(this, clientNick+"�Բ��� ����Ͽ����ϴ�.");
			ie.printStackTrace();
		}//end catch
	}//actionPerformed
	
	/**
	 * 1.ServerSocket�� �����ϰ�(Port����(����/2������ ����)), 
	 * 2.������ ������ ������(accept) ��ȭ�� �ְ� ���� �� �ֵ��� 
	 * 3.Stream�� ����(DIS,DOS)
	 */
	public void openServer() throws IOException,SocketException{
		////�߰�27
		serverNick=JOptionPane.showInputDialog("��ȭ�� �Է�");
		
		//1.
		server=new ServerSocket(65535);
		jta.setText("�������� ��...�����ڸ� ��ٸ��ϴ�.\n");
		//3.(�帧��)
		client=server.accept();
		jta.append(clientNick+"client ����\n");
		//4.(�������� �ǵ� �������)��Ʈ�� ����
		readStream=new DataInputStream(client.getInputStream());
		writeStream=new DataOutputStream(client.getOutputStream());
		
		//�������� �г����� �޴´�. <�а����;���
		clientNick=readStream.readUTF();
		//�� ���� �����ش�.
		writeStream.writeUTF(serverNick);
		
		
	}//openServer
	
	/**
	 * �����ڿ��� �޼����� ������ ��
	 * @throws IOException
	 */
	public void sendMsg()  throws IOException{
		//T.F�� ���� �����ͼ�
		String msg=jtf.getText().trim();
		//��Ʈ���� ����ϰ�
		writeStream.writeUTF(msg);
		//��Ʈ���� ������ �������� ����
		writeStream.flush();
		//���� �� ������ �� ȭ�鿡 ����ϰ� 
		jta.append("["+serverNick+"]: "+msg+"\n\r");//���� ���� �ϱ� ����
		//�Է��� ���ϵ��� jtf�� �ʱ�ȭ
		jtf.setText("");
		//��ũ�ѹٸ� ����
		jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
	}//sendMsg
	
	/**
	 * �����ڰ� �������� �޼����� ��� �о� �鿩���Ѵ�.
	 * @throws IOException
	 */
	@Override
	public void run(){//override�Ȱű� ������ throws������ ���ƾ� �Ѵ�.
		String msg="";
		if(readStream !=null) {
			try {
			while(true) {
				//�޼����� �о�鿩
					msg=readStream.readUTF();
				//��ȭâ�� ���
				jta.append("["+clientNick+"]: "+msg+"\n\r");
				//�޼����� T.A�� �߰��Ǹ� JScrollPane�� ��ũ�ѹ��� ���� JScrollPane�� �ְ����� ������ �ش�.
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
			//Thread�� stcs��ü�� has a ����� ����
			Thread t= new Thread(stcs);
			//�޼����� �д� �ڵ带 Thread�� ó��
			t.start();
		} catch (SocketException se) {
			System.err.println("�����ڰ� ������ ���� ����Ǿ����ϴ�."+se.getMessage());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(stcs/*static?this����..*/, 
									"�������� ����!!! �޼����� �о���� �� �����ϴ�.");
			e.printStackTrace();
		}//end catch
//		
	}//main

}//class
