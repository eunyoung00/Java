package logAnalysis;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Login extends JFrame implements ActionListener{
	
	private JTextField jtfId;
	private JPasswordField jpfPass;
	private JButton jbtnLogin;
	private String id,pass;
	
	public Login() {
		super("로그인");
		JLabel jlblId=new JLabel("아이디");
		JLabel jlblPass=new JLabel("비밀번호");
		jtfId =new JTextField("admin");//값지우깈ㅋ
		jpfPass =new JPasswordField("1234");
		jbtnLogin=new JButton("로그인");
		
		jtfId.setToolTipText("아이디");
		jpfPass.setToolTipText("비밀번호");

		setLayout(null);
		jlblId.setBounds(50, 100, 60, 25);
		jlblPass.setBounds(50, 140, 60, 25);
		jtfId.setBounds(120, 100, 80, 25);
		jpfPass.setBounds(120, 140, 80, 25);
		jbtnLogin.setBounds(80, 180, 80, 30);
		
		add(jlblId);
		add(jlblPass);
		add(jtfId);
		add(jpfPass);
		add(jbtnLogin);
		
		jtfId.addActionListener(this);
		jpfPass.addActionListener(this);
		jbtnLogin.addActionListener(this);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}//windowClosing
		});//addWindowListener
		
		setBounds(200, 200, 250, 350);
		setVisible(true);
	}//login
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		id=jtfId.getText().trim();
		pass=new String(jpfPass.getPassword());
		
		//id에서 이벤트가 발생했을때,값이있으면 커서이동
		if(ae.getSource()==jtfId) {
			checkId();
		}//end if
		//pass 에서 이벤트가 발생했을때, 값이 있으면 둘다 비교해서 계산완료.
		if(ae.getSource()==jpfPass) {
			checkPass();
		}//end if
		
		//Button에서 이벤트 발생했을 때
		if(ae.getSource()==jbtnLogin) {
			if(id.equals("")&&pass.trim().equals("")) {
				JOptionPane.showMessageDialog(this, "아이디와 비밀번호를 입력해 주세요.");
			}else{
				checkId();
				checkPass();
			}//end if
		}//end if
	}//actionPerformed
	
	public void checkId() {
		if(id.equals("")) {
			jtfId.requestFocus();
			JOptionPane.showMessageDialog(this, "아이디를 입력해 주세요.");
			return;
		}else if(!id.equals("")){
			jpfPass.requestFocus();
		}//end else
	}//checkId

	public void checkPass() {
		if(pass.trim().equals("")) {
			JOptionPane.showMessageDialog(this, "비밀번호를 입력해 주세요.");
			return;
		}//end if
		if(id.equals("admin")&&pass.equals("1234")||id.equals("root")&&pass.equals("1111")) {
			dispose();//현재창을 닫는다.
			new SelectBtn(this);
		}else if(!id.equals("admin")||!pass.equals("1234")||!id.equals("root")||!pass.equals("1111")){
			JOptionPane.showMessageDialog(this, "로그인 실패!!\n아이디나 비밀번호를 확인해 주세요.");
		}//end else
	}//checkPass
	
}//class
