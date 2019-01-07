package client.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import client.evt.ChatClientEvt;

@SuppressWarnings("serial")
public class ChatClientView extends JFrame{
	private JTextArea jtaTalkDisplay;
	private JTextField jtfNick,jtfTalk;
	private JButton jbtConnect,jbtCapture,jbtClose,jbtNickList;
	private JScrollPane jspTalkDisplay;
	private int port;

	public ChatClientView(int port) {
		super("채팅 클라이언트");
		this.port=port;
	
		jtaTalkDisplay=new JTextArea();
		jtfNick=new JTextField(10);
		
		jbtConnect=new JButton("접속");
		jbtCapture=new JButton("저장");
		jbtClose=new JButton("종료");
		jbtNickList=new JButton("접속자");
		
		jspTalkDisplay=new JScrollPane(jtaTalkDisplay);
		jspTalkDisplay.setBorder(new TitledBorder("대화 내용"));
		
		jtfTalk=new JTextField();
		jtfTalk.setBorder(new TitledBorder("대화"));
		
		jtaTalkDisplay.setEditable(false);
		
		JPanel jpNorth=new JPanel();
		jpNorth.add(new JLabel("닉네임",JLabel.CENTER));
		jpNorth.add(jtfNick);
		jpNorth.add(jbtConnect);
		jpNorth.add(jbtCapture);
		jpNorth.add(jbtClose);
		jpNorth.add(jbtNickList);
		
		add("North",jpNorth);
		add("Center",jspTalkDisplay);
		add("South",jtfTalk);
		
		ChatClientEvt cse=new ChatClientEvt(this);
		addWindowListener(cse);
		
		jbtConnect.addActionListener(cse);
		jbtClose.addActionListener(cse);
		jbtCapture.addActionListener(cse);
		jbtNickList.addActionListener(cse);
		jtfTalk.addActionListener(cse);
		
		setBounds(100, 100, 600, 350);
		setVisible(true);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//ChatClientView

	public JTextArea getJtaTalkDisplay() {
		return jtaTalkDisplay;
	}

	public JTextField getJtfNick() {
		return jtfNick;
	}

	public JTextField getJtfTalk() {
		return jtfTalk;
	}

	public JButton getJbtConnect() {
		return jbtConnect;
	}

	public JButton getJbtCapture() {
		return jbtCapture;
	}

	public JButton getJbtClose() {
		return jbtClose;
	}

	public JButton getJbtNickList() {
		return jbtNickList;
	}

	public JScrollPane getJspTalkDisplay() {
		return jspTalkDisplay;
	}

	public int getPort() {
		return port;
	}
	
}//class
