package day1204;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class TestAnonymous extends Frame {
	
	public TestAnonymous() {
		super("Anonymous innerclass연습");
		Button btn = new Button("클릭");
		add(btn);
		setSize(300, 300);
//		addWindowListener(l);
		//anonymous innerclass로 윈도우 종료 이벤트를 처리.
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			}//windowClosing
		});
	}//TestAnonymous

	public static void main(String[] args) {
		new TestAnonymous();
	}//main

}//class
