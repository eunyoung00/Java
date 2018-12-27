package day1212;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class DesignFriend extends Frame{

	private Button btnright;
	private Button btnletf;
	
	public DesignFriend() {
		super("친구목록 - has a");
		
		Label lblfriend=new Label("친구목록");
		List listfriend=new List();
		listfriend.add("이재찬");
		listfriend.add("정택성");
		
		btnright=new Button(">>");
		btnletf=new Button("<<");
		
		Label lblblock=new Label("차단된 친구");
		List listblock=new List();
		
		setLayout(null);
		
		lblfriend.setBounds(40,50,100,25);
		listfriend.setBounds(40,100,100,200);
		
		lblblock.setBounds(220,50,100,25);
		listblock.setBounds(220,100,100,200);
		btnright.setBounds(160,120,40,40);
		btnletf.setBounds(160,200,40,40);
		
		add(lblfriend);
		add(lblblock);
		add(listfriend);
		add(listblock);
		add(btnright);
		add(btnletf);
		
		Event et=new Event(this);
		
		
		//6.윈도우 크기 설정
		setBounds(100, 100, 400, 400);
		//7.가시화
		setVisible(true);
		//종료 처리
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}//windowClosing
		});
		
	}//Design
	
	public Button getBtnRight() {
		return btnright;
	}//getBtnRight
	public Button getBtnLeft() {
		return btnright;
	}//getBtnLeft
	
	public static void main(String[] args) {
		new DesignFriend();
	}//main
}//class
