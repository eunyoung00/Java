package day1214;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * showInputDialog,showMessageDialog,showConfirmDialog
 * @author owner
 */
@SuppressWarnings("serial")
public class UseJOptionPane extends JFrame implements ActionListener {

	private JButton btn1,btn2,btn3;
	private JLabel jlOutput;
	
	public UseJOptionPane() {
		super("JOptionPane 사용");
		
		btn1=new JButton("Input Dialog");
		btn2=new JButton("Message Dialog");
		btn3=new JButton("Confirm Dialog");
		
		jlOutput=new JLabel("출력");
		jlOutput.setBorder(new TitledBorder("출력창"));
		
		JPanel panel=new JPanel();
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		
		add("Center",panel);
		add("South",jlOutput);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		
		setBounds(100, 100, 400, 180);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//UseJOptionPane
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==btn1) {
			String name=JOptionPane.showInputDialog("이름을 입력해주세요","홍길동");//("메세지","초기값")
			jlOutput.setText(name+"님 안녕하세요?");
		}//end if
		if(ae.getSource()==btn2) {
			JOptionPane.showMessageDialog(this, "오늘은 금요일입니다.","요일안내",/*아이콘 바꾸기-!,?,X,,*/
					JOptionPane.QUESTION_MESSAGE);//값을 반환하는 method가 아니다.
		}//end if
		if(ae.getSource()==btn3) {
			int flag=JOptionPane.showConfirmDialog(this, "점심 맛있게 드셨어요?");
//			System.out.println(flag);//0,1,2순으로 나온다.
			switch (flag) {
//			case 0 ,1 ,2 로도 줄수 있지만 무엇인지 명확하지 않기때문에 상수표현을 쓴다.
			case JOptionPane.OK_OPTION : 
				JOptionPane.showMessageDialog(this, "행복한 오후 되세요!"); 
				break;
			case JOptionPane.NO_OPTION: String menu = JOptionPane.showInputDialog("어떤 점심 메뉴였어요?"); 
				JOptionPane.showMessageDialog(this,menu+"가 다 그렇죠 뭐!");
				break;
			case JOptionPane.CANCEL_OPTION:	JOptionPane.showMessageDialog(this, "하기 싫으냐??");
			}//end switch
		}//end if
		
	}//actionPerformed

	public static void main(String[] args) {
		new UseJOptionPane();
	}//main

}//class
