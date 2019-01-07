package client.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class ChatClientChoice extends JFrame implements ActionListener{
	private JButton jbtChoice;
	private JRadioButton team1,team2,team3,team4;
	private int port;
	
	public ChatClientChoice() {
		super("채팅방 선택");
		
		team1=new JRadioButton("1조");
		team2=new JRadioButton("2조");
		team3=new JRadioButton("3조");
		team4=new JRadioButton("4조");
		jbtChoice=new JButton("접속");
		
		//라디오버튼을 그룹으로 묶기위한 객체
		ButtonGroup radioGroup=new ButtonGroup();
	
		setLayout(new GridLayout(5, 1));
		
		radioGroup.add(team1);
		radioGroup.add(team2);
		radioGroup.add(team3);
		radioGroup.add(team4);
		add(team1);
		add(team2);
		add(team3);
		add(team4);
		add(jbtChoice);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		team1.addActionListener(this);
		team2.addActionListener(this);
		team3.addActionListener(this);
		team4.addActionListener(this);
		jbtChoice.addActionListener(this);
	
		setBounds(100, 100, 300, 350);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//ChatClientChoice

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==team1) {
			port=36001;
		}//end if
		if(ae.getSource()==team2) {
			port=36002;
		}//end if
		if(ae.getSource()==team3) {
			port=36003;
		}//end if
		if(ae.getSource()==team4) {
			port=36004;
		}//end if

//		try {
//			Socket client=new Socket("211.63.89.156",port);
//		} catch (UnknownHostException uhe) {
//			JOptionPane.showMessageDialog(this, "서버를 알 수 없습니다.");
//			uhe.printStackTrace();
//		} catch (IOException ie) {
//			JOptionPane.showMessageDialog(this, "연결 실패");
//			ie.printStackTrace();
//		}//end catch
		if(ae.getSource()==jbtChoice&&port!=0) {
			new ChatClientView(port);
//			System.out.println(port);
			dispose();
		}//end if
	}//actionPerformed
	
}//class
