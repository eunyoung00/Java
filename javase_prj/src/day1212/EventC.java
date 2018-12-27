package day1212;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author owner
 */
@SuppressWarnings("serial")
public class EventC extends Frame implements ActionListener{

	private Button btn1;
	private Button btn2;
	
	public EventC() {
		super("이벤트 비교");
		btn1=new Button("ㅋㅋㅋ");
		btn2=new Button("^o^");
		
		setLayout(null);
		
		btn1.setBounds(40,50,100,25);
		btn2.setBounds(160,50,100,25);
		add(btn1);
		add(btn2);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		//6.윈도우의 크기 설정
		setBounds(200, 200, 400, 150);
		//7.사용자에게 보여주기(가시화)
		setVisible(true);
		//8.Window 종료 처리
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}//windowClosing
		});//addWindowListener
		
	}//EvnetC
	
	@Override
	public void actionPerformed(ActionEvent ae) {
//		if(btn1.getActionCommand()=="ㅋㅋㅋ") {
//			System.out.println("ㅋㅋㅋ");
//		}else if(btn2.getLabel()=="^o^"){
//			System.out.println("^o^");
//			//둘다 안됌..
//		}
		
	}//actionPerformed

	public static void main(String[] args) {
		new EventC();
	}//main
}//class
