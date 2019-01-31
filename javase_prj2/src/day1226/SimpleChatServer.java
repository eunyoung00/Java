package day1226;

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
public class SimpleChatServer extends JFrame implements ActionListener {
	
	private JTextArea jta;
	private JTextField jtf;
	
	private ServerSocket server;
	private Socket client;
	private DataInputStream readStream;
	private DataOutputStream writeStream;
	
	
	public SimpleChatServer() {
		super("::::::::::::ä�ü���::::::::::::");
		
		jta=new JTextArea();
		jta.setBorder(new TitledBorder("��ȭ ����"));
		//����Ұ�
		jta.setEditable(false);
		jta.setLineWrap(true);
		jta.setWrapStyleWord(true);
		//��ũ�� �߰�
		JScrollPane jsp=new JScrollPane(jta);
		
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
		jtf.addActionListener(this);//�޼����� �������� ��ġ! �ڵ� ������ȭ�Ǽ� �о����°�?

		try {
			openServer();
			revMsg();
		} catch (SocketException se) {
			System.err.println("�����ڰ� ������ ���� ����Ǿ����ϴ�."+se.getMessage());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this/*static?this����..*/, 
									"�������� ����!!! �޼����� �о���� �� �����ϴ�.");
			e.printStackTrace();
		}//end catch
//		jtf.addActionListener(this);//���������� �޼����� �������� �ʴ´�.
		
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
			ie.printStackTrace();
		}//end catch
	}//actionPerformed
	
	/**
	 * 1.ServerSocket�� �����ϰ�(Port����(����/2������ ����)), 
	 * 2.������ ������ ������(accept) ��ȭ�� �ְ� ���� �� �ֵ��� 
	 * 3.Stream�� ����(DIS,DOS)
	 */
	public void openServer() throws IOException,SocketException{
		//1.
		server=new ServerSocket(65535);
		jta.setText("�������� ��...�����ڸ� ��ٸ��ϴ�.\n");
		//3.(�帧��)
		client=server.accept();
		jta.append("client ����\n");
		//4.(�������� �ǵ� �������)��Ʈ�� ����
		readStream=new DataInputStream(client.getInputStream());
		writeStream=new DataOutputStream(client.getOutputStream());
		
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
		jta.append("[server �޼���]: "+msg+"\n\r");//���� ���� �ϱ� ����
		//�Է��� ���ϵ��� jtf�� �ʱ�ȭ
		jtf.setText("");
	}//sendMsg
	
	/**
	 * �����ڰ� �������� �޼����� ��� �о� �鿩���Ѵ�.
	 * @throws IOException
	 */
	public void revMsg()  throws IOException{
		String msg="";
		while(true) {
			//�޼����� �о�鿩
			msg=readStream.readUTF();
			//��ȭâ�� ���
			jta.append("[client �޼���]: "+msg+"\n\r");
		}//end while
		
	}//revMsg
	

	public static void main(String[] args) {
		new SimpleChatServer();
//		SimpleChatServer scs=new SimpleChatServer();
//		try {
//			scs.openServer();
//			scs.revMsg();
//		} catch (SocketException se) {
//			System.err.println("�����ڰ� ������ ���� ����Ǿ����ϴ�."+se.getMessage());
//		} catch (IOException e) {
//			JOptionPane.showMessageDialog(scs/*static?this����..*/, 
//									"�������� ����!!! �޼����� �о���� �� �����ϴ�.");
//			e.printStackTrace();
//		}//end catch
//		
	}//main

}//class
