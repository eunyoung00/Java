package day1213;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//1.Dialog 상속
@SuppressWarnings("serial")
public class DialogIsA extends Dialog implements ActionListener {
	//2.이벤트와 관련있는 컴포넌트 선언
	private Button btn;
	
	//<다이어로그의 생성자가 기본생성자가 없기때문에 생성자가 없어서 Error
	public DialogIsA(UseDialogIsA uda) {//UseDialogIsA 와 DialogIsA는 has a 관계가 됨
	//현재 다이얼로그의 부모가 될 객체와 has a
		super(uda,"다이얼로그",true);//생성하는 쪽과는 has a  쓰는것 자체는 is a (상속)
		
		//컴포넌트 생성
		Label lbl=new Label("오늘은 목요일 입니다.",Label.CENTER);
		
		btn=new Button("종료");
		
		add("Center",lbl);
		add("South",btn);
		
		btn.addActionListener(this);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}//widnowClosing
		});
		
		//다이얼로그를 띄울때 다이얼로그의 위치를 부모프레임 안족에서 띄우기.
		System.out.println("부모의 x "+uda.getX()+", y "+uda.getY());
		setBounds(uda.getX()+100,uda.getY()+100,300,300);
		setVisible(true);
		
		
	}//DialogIsA

	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
	}

}
