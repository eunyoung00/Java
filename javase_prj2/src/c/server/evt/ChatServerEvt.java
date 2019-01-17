package c.server.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
//import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import c.server.helper.ChatServerHelper;
import c.server.view.ChatServerView;

public class ChatServerEvt extends WindowAdapter implements ActionListener{

	private ChatServerView csv;
	private Thread threadServer1,threadServer2,threadServer3,threadServer4;//�����ڿ� ���� ó���� �ϱ� ���� Thread
	private ServerSocket server1,server2,server3,server4;//PORT ����
	private List<ChatServerHelper> listClient1,listClient2,listClient3,listClient4;
	//��� �����ڸ� ������ List
	private int port1,port2,port3,port4;
	
	
	public ChatServerEvt(ChatServerView chatServerView) {
		this.csv=chatServerView;//<View �� Evt class�� ����� has a �����ΰ�.
		listClient1 = new ArrayList<ChatServerHelper>();
		listClient2 = new ArrayList<ChatServerHelper>();
		listClient3 = new ArrayList<ChatServerHelper>();
		listClient4 = new ArrayList<ChatServerHelper>();
		
		port1=36001;
		port2=36002;
		port3=36003;
		port4=36004;
	}//MultiChatServerEvt
	
	@Override
	public void windowClosing(WindowEvent we) {
		csv.dispose();	//<Closed�� �θ���.
	}//windowClosing
	
	@Override
	public void windowClosed(WindowEvent we) {
		//<serversocket�� ���� �κ� ����
		try {
			if(server1!=null){server1.close();}//end if
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
	}//windowClosed

	@Override
	public void actionPerformed(ActionEvent ae) {
		for(int i=0;i<listClient1.size();i++) {
			System.out.println(listClient1);
		}
		if(ae.getSource()==csv.getJbtOpenServer()) {
			if(threadServer1==null) {
				threadServer1= new Thread(new Runnable(){
					JScrollPane jsp=csv.getJspList1();
					public void run(){
						try {	
							server1=new ServerSocket(port1);
							DefaultListModel<String> dlmTemp1=csv.getDlmChatList1();
							dlmTemp1.addElement("������ "+port1+"PORT�� ���� ������...");
							Socket someClient1=null;
							ChatServerHelper csh1=null;
							jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum() );
							
							for(int cnt=0; ;cnt++) {//������ ������ ���ѷ���
								someClient1=server1.accept();
								csh1=new ChatServerHelper(someClient1, dlmTemp1, cnt, csv, listClient1, csv.getJspList1());//<�ν��Ͻ�ȭ
								listClient1.add(csh1);
								csh1.setclient();
								csh1.start();//<����� ���� : �ڵ��� ���뼺
								jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum() );
							}//end while
						} catch (IOException e) {
							e.printStackTrace();
						}//end catch
						jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum() );
					}//run
				}
			);
				threadServer1.start();
				
				threadServer2=new Thread(new Runnable(){
					JScrollPane jsp=csv.getJspList2();
					public void run(){
						try {	
							server2=new ServerSocket(port2);
							DefaultListModel<String> dlmTemp2=csv.getDlmChatList2();
							dlmTemp2.addElement("������ "+port2+"PORT�� ���� ������...");
							Socket someClient2=null;
							ChatServerHelper csh2=null;
							jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum() );
							for(int cnt=0; ;cnt++) {//������ ������ ���ѷ���
								someClient2=server2.accept();
								csh2=new ChatServerHelper(someClient2, dlmTemp2, cnt, csv, listClient2, csv.getJspList2());//<�ν��Ͻ�ȭ
								listClient2.add(csh2);
								csh2.setclient();
								csh2.start();//<����� ���� : �ڵ��� ���뼺
								jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum() );
							}//end while
						} catch (IOException e) {
							e.printStackTrace();
						}//end catch
						jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum() );
					}//run
				}
			);
				threadServer2.start();
				threadServer3=new Thread(new Runnable(){
					JScrollPane jsp=csv.getJspList3();
					public void run(){
						try {	
							server3=new ServerSocket(port3);
							DefaultListModel<String> dlmTemp3=csv.getDlmChatList3();
							dlmTemp3.addElement("������ "+port3+"PORT�� ���� ������...");
							Socket someClient3=null;
							ChatServerHelper csh3=null;
							jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum() );
							for(int cnt=0; ;cnt++) {//������ ������ ���ѷ���
								someClient3=server3.accept();
								csh3=new ChatServerHelper(someClient3, dlmTemp3, cnt, csv, listClient3, csv.getJspList3());//<�ν��Ͻ�ȭ
								listClient3.add(csh3);
								csh3.setclient();
								
								csh3.start();//<����� ���� : �ڵ��� ���뼺
								jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum() );
							}//end while
						} catch (IOException e) {
							e.printStackTrace();
						}//end catch
						jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum() );
					}//run
					
				}
			);
				threadServer3.start();
				threadServer4=new Thread(new Runnable(){
					JScrollPane jsp=csv.getJspList4();
					public void run(){
						try {	
							server4=new ServerSocket(port4);
							DefaultListModel<String> dlmTemp4=csv.getDlmChatList4();
							dlmTemp4.addElement("������ "+port4+"PORT�� ���� ������...");
							Socket someClient4=null;
							ChatServerHelper csh4=null;
							
							for(int cnt=0; ;cnt++) {//������ ������ ���ѷ���
								someClient4=server4.accept();
								csh4=new ChatServerHelper(someClient4, dlmTemp4, cnt, csv, listClient4, csv.getJspList4());//<�ν��Ͻ�ȭ
								listClient4.add(csh4);
								csh4.setclient();
								
								csh4.start();//<����� ���� : �ڵ��� ���뼺
								jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum() );
							}//end while
						} catch (IOException e) {
							e.printStackTrace();
						}//end catch
						jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum() );
					}//run
				}
			);
				threadServer4.start();
			}else {
				JOptionPane.showMessageDialog(csv, "ä�� ������ �̹� ������ �Դϴ�.");
			}//end else
		}//end if
		
		if(ae.getSource()==csv.getJbtCloseServer()) {
			switch (JOptionPane.showConfirmDialog(csv,
							"ä�� ������ ���� �Ͻðڽ��ϱ�?\n�����Ͻø� ��� �������� ������ �������ϴ�.")) {
			case JOptionPane.OK_OPTION:csv.dispose();
			}//end switch
		}//end if
	}//actionPerformed
	
	
		
}//class
