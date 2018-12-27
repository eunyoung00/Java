package day1213;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Frame class에서 Dialog class를  has a 사용 
 * @author owner
 */
@SuppressWarnings("serial")
public class UseDialogHasA extends Frame implements ActionListener {

	private Button btn1/*Frame에 배치*/,btn2/*Dialog에 배치*/;
	private Dialog d;
	public UseDialogHasA() {
		super("다이얼로그의 사용");
		
		btn1=new Button("다이얼로그 사용");
		Panel panel=new Panel();
		panel.add(btn1);
		
		add("Center",panel);
		
		btn1.addActionListener(this);
		setBounds(100, 100, 300, 400);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}//windowClosing
		});
		
	}//UseDialogHasA
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==btn1) {
			createDialog();
		}//end if
		
		if(ae.getSource()==btn2) {
//			d.dispose()//d를 사용할 수 없어 instance변수로 올려준다.
			d.dispose();//사용가능 해졌다
		}//end if
		
	}//actionPerformed
	
	public void createDialog() {
		//1.생성
//		Dialog d = new Dialog(this,"다이얼로그",true);
		d = new Dialog(this,"다이얼로그",false);  //has a : Frame이 Dialog...쓰는..
		//true는 모달 vs false는 비모달.
		//2.Dialog에 배치될 Component 생성
		Label lbl = new Label("오늘은 눈오는 목요일 입니다.(^.~)",Label.CENTER);
		btn2=new Button("닫기");
		
		d.add("Center", lbl);
		d.add("South", btn2);
		btn2.addActionListener(this);
		
		//크기 설정
		d.setBounds(200, 200, 300, 300);
		//dialog닫기 :반드시 visible 전에 이벤트 발생을 해야한다.
		d.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
//				dispose();//는 윈도우의 dispose라서 부모창 죽음, 다이얼로그를 죽이려면 d.붙여야 한다.
				d.dispose();
			}
		});
		//가시화
		d.setVisible(true);
		
	}//createDialog

	public static void main(String[] args) {
		new UseDialogHasA();
	}//main

}//class
