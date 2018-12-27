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
		
		//������Ʈ ����
		listName = new List();
		listName.add("������/27");
		listName.add("���ü�/26");
		listName.add("������/27");
		
		lblNameAge=new Label("�̸� :             ���� :       ");

		add("Center",listName);//�гη� �ִ°� ��� �гη� �����ʾƵ� ��������.
		add("South",lblNameAge);
		
		listName.addItemListener(this);
		
		//5.������ ũ�� ����
		setBounds(200,150,400,250);
		setVisible(true);
		//������ ���� �̺�Ʈ ó��
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
