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
		super("�α���");
		JLabel jlblId=new JLabel("���̵�");
		JLabel jlblPass=new JLabel("��й�ȣ");
		jtfId =new JTextField("admin");//�����샇��
		jpfPass =new JPasswordField("1234");
		jbtnLogin=new JButton("�α���");
		
		jtfId.setToolTipText("���̵�");
		jpfPass.setToolTipText("��й�ȣ");

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
		
		//id���� �̺�Ʈ�� �߻�������,���������� Ŀ���̵�
		if(ae.getSource()==jtfId) {
			checkId();
		}//end if
		//pass ���� �̺�Ʈ�� �߻�������, ���� ������ �Ѵ� ���ؼ� ���Ϸ�.
		if(ae.getSource()==jpfPass) {
			checkPass();
		}//end if
		
		//Button���� �̺�Ʈ �߻����� ��
		if(ae.getSource()==jbtnLogin) {
			if(id.equals("")&&pass.trim().equals("")) {
				JOptionPane.showMessageDialog(this, "���̵�� ��й�ȣ�� �Է��� �ּ���.");
			}else{
				checkId();
				checkPass();
			}//end if
		}//end if
	}//actionPerformed
	
	public void checkId() {
		if(id.equals("")) {
			jtfId.requestFocus();
			JOptionPane.showMessageDialog(this, "���̵� �Է��� �ּ���.");
			return;
		}else if(!id.equals("")){
			jpfPass.requestFocus();
		}//end else
	}//checkId

	public void checkPass() {
		if(pass.trim().equals("")) {
			JOptionPane.showMessageDialog(this, "��й�ȣ�� �Է��� �ּ���.");
			return;
		}//end if
		if(id.equals("admin")&&pass.equals("1234")||id.equals("root")&&pass.equals("1111")) {
			dispose();//����â�� �ݴ´�.
			new SelectBtn(this);
		}else if(!id.equals("admin")||!pass.equals("1234")||!id.equals("root")||!pass.equals("1111")){
			JOptionPane.showMessageDialog(this, "�α��� ����!!\n���̵� ��й�ȣ�� Ȯ���� �ּ���.");
		}//end else
	}//checkPass
	
}//class
