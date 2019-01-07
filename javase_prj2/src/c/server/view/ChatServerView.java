package c.server.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import c.server.evt.ChatServerEvt;

/**
 * 채팅방 관리자 화면
 * @author owner
 */
@SuppressWarnings("serial")
public class ChatServerView extends JFrame{
	private JList<String> jlChatList1,jlChatList2,jlChatList3,jlChatList4;
	private JScrollPane jspList1,jspList2,jspList3,jspList4;
	private DefaultListModel<String> dlmChatList1,dlmChatList2,dlmChatList3,dlmChatList4;
	private JButton jbtOpenServer,jbtCloseServer;
	
	public ChatServerView() {
		super("::::::::채팅방 관리자::::::::");
		dlmChatList1=new DefaultListModel<String>();//인스턴스화
		jlChatList1 = new JList<String>(dlmChatList1);
		jspList1=new JScrollPane(jlChatList1);
		dlmChatList2=new DefaultListModel<String>();//인스턴스화
		jlChatList2 = new JList<String>(dlmChatList2);
		jspList2=new JScrollPane(jlChatList2);
		dlmChatList3=new DefaultListModel<String>();//인스턴스화
		jlChatList3 = new JList<String>(dlmChatList3);
		jspList3=new JScrollPane(jlChatList3);
		dlmChatList4=new DefaultListModel<String>();//인스턴스화
		jlChatList4 = new JList<String>(dlmChatList4);
		jspList4=new JScrollPane(jlChatList4);
		
		jbtOpenServer=new JButton("서버 시작");
		jbtCloseServer=new JButton("서버 중지");
		
		JPanel btnPanel =new JPanel();
		btnPanel.add(jbtOpenServer);
		btnPanel.add(jbtCloseServer);
		
		JPanel team1=new JPanel();
		team1.setLayout(new BorderLayout());
		team1.add("North",new JLabel("1조"));
		team1.add("Center",jspList1);
		JPanel team2=new JPanel();
		team2.setLayout(new BorderLayout());
		team2.add("North",new JLabel("2조"));
		team2.add("Center",jspList2);
		JPanel team3=new JPanel();
		team3.setLayout(new BorderLayout());
		team3.add("North",new JLabel("3조"));
		team3.add("Center",jspList3);
		JPanel team4=new JPanel();
		team4.setLayout(new BorderLayout());
		team4.add("North",new JLabel("4조"));
		team4.add("Center",jspList4);
		
		JPanel gridPanel=new JPanel();
		gridPanel.setLayout(new GridLayout(2,2));
		gridPanel.add(team1);
		gridPanel.add(team2);
		gridPanel.add(team3);
		gridPanel.add(team4);
		
		add("Center",gridPanel);
		add("South",btnPanel);
		
		//이벤트 등록
		ChatServerEvt cse=new ChatServerEvt(this);
		jbtOpenServer.addActionListener(cse);
		jbtCloseServer.addActionListener(cse);
		
		addWindowListener(cse);
		
		setBounds(100, 100, 500, 450);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//MultiChatServerView

	public JButton getJbtOpenServer() {
		return jbtOpenServer;
	}

	public JButton getJbtCloseServer() {
		return jbtCloseServer;
	}

	public JList<String> getJlChatList1() {
		return jlChatList1;
	}

	public JList<String> getJlChatList2() {
		return jlChatList2;
	}

	public JList<String> getJlChatList3() {
		return jlChatList3;
	}

	public JList<String> getJlChatList4() {
		return jlChatList4;
	}

	public JScrollPane getJspList1() {
		return jspList1;
	}

	public JScrollPane getJspList2() {
		return jspList2;
	}

	public JScrollPane getJspList3() {
		return jspList3;
	}

	public JScrollPane getJspList4() {
		return jspList4;
	}

	public DefaultListModel<String> getDlmChatList1() {
		return dlmChatList1;
	}

	public DefaultListModel<String> getDlmChatList2() {
		return dlmChatList2;
	}

	public DefaultListModel<String> getDlmChatList3() {
		return dlmChatList3;
	}

	public DefaultListModel<String> getDlmChatList4() {
		return dlmChatList4;
	}
	
}//class
