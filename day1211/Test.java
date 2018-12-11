package day1211;

import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Test extends Frame implements ItemListener{

	List listName;
	Label lblNameAge;
	
	public Test() {
		super("Test");
		
		//컴포넌트 생성
		listName = new List();
		listName.add("이재찬/27");
		listName.add("정택성/26");
		listName.add("공선의/27");
		
		lblNameAge=new Label("이름 :             나이 :       ");

		add("Center",listName);//패널로 넣는게 없어서 패널로 넣지않아도 가득찬다.
		add("South",lblNameAge);
		
		listName.addItemListener(this);
		
		//5.윈도우 크기 설정
		setBounds(200,150,400,250);
		setVisible(true);
		//윈도위 종료 이벤트 처리
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			}//windowClosing
		});//addWindowListener
		
	}//Test
	
	public static void main(String[] args) {
		new Test();
	}//main

	@Override
	public void itemStateChanged(ItemEvent e) {
		String name=listName.getSelectedItem();
//		System.out.println(name);
		if(name!=null) {
//			name.substring(3);
			
		}//end if
	}//itemStateChanged
}//class
