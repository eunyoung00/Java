package day1210;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Work25_2 extends Frame{

	public Work25_2() {
		super("���� ��ġ-����2");
		
		//������Ʈ ����
		Label lblFont=new Label("�۲�");
		TextField tfFont=new TextField();
		List listFont = new List();
		listFont.add("Dialog");
		listFont.add("Serif");
		listFont.add("SansSerif");
		listFont.add("Monospaced");
		listFont.add("DialogInput");
//		TextArea taFont=new TextArea("Dialog\n"
//								+ "Serif\n"
//								+ "SansSerif\n"
//								+ "Monospaced\n"
//								+ "DialogInput");
		
		Label lblStyle=new Label("�۲ý�Ÿ��");
		TextField tfStyle=new TextField();
		List listStyle = new List();
		listStyle.add("�Ϲ�");
		listStyle.add("����");
		listStyle.add("����Ӳ�");
		listStyle.add("���Ա���Ӳ�");
//		TextArea taStyle=new TextArea("�Ϲ�\n"
//								+ "����\n"
//								+ "����Ӳ�\n"
//								+ "���Ա���Ӳ�");
		
		
		Label lblSize=new Label("ũ��");
		TextField tfSize=new TextField();
		List listSize=new List();
		
		String num = null;
		for(int i=2; i<81; i++) {
			if(i<=10) {
				if(i%2==0) {
					num=String.valueOf(i);
					listSize.add(num);
				}
			}else {
				num=String.valueOf(i);
				listSize.add(num);
			}//end else
		}//end for
		
		Label lblSample=new Label("����");
		TextField tfSample=new TextField("AaBbYyZz");
		tfSample.setFont(new Font("Dialog",Font.BOLD,15));
		
		Button btnCheck=new Button("Ȯ��");
		Button btnCancel=new Button("���");
		
		
		//��ġ������ ����
		setLayout(null);
		
		lblFont.setLocation(20,45);//��ġ��ǥ
		lblFont.setSize(80,20);//��ġũ��
		add(lblFont);//Frame�� ��ġ
		tfFont.setLocation(20,70);//��ġ��ǥ
		tfFont.setSize(100,25);//��ġũ��
		add(tfFont);//Frame�� ��ġ
		listFont.setLocation(20,100);//��ġ��ǥ
		listFont.setSize(100,100);//��ġũ��
		add(listFont);//Frame�� ��ġ
		
		lblStyle.setLocation(140,45);//��ġ��ǥ
		lblStyle.setSize(80,20);//��ġũ��
		add(lblStyle);//Frame�� ��ġ
		tfStyle.setLocation(140,70);//��ġ��ǥ
		tfStyle.setSize(100,25);//��ġũ��
		add(tfStyle);//Frame�� ��ġ
		listStyle.setLocation(140,100);//��ġ��ǥ
		listStyle.setSize(100,100);//��ġũ��
		add(listStyle);//Frame�� ��ġ

		lblSize.setLocation(260,45);//��ġ��ǥ
		lblSize.setSize(80,20);//��ġũ��
		add(lblSize);//Frame�� ��ġ
		tfSize.setLocation(260,70);//��ġ��ǥ
		tfSize.setSize(100,25);//��ġũ��
		add(tfSize);//Frame�� ��ġ
		listSize.setLocation(260,100);//��ġ��ǥ
		listSize.setSize(100,100);//��ġũ��
		add(listSize);//Frame�� ��ġ
		
		lblSample.setLocation(140,220);//��ġ��ǥ
		lblSample.setSize(100,25);//��ġũ��
		add(lblSample);//Frame�� ��ġ
		tfSample.setLocation(140,250);//��ġ��ǥ
		tfSample.setSize(100,50);//��ġũ��
		add(tfSample);//Frame�� ��ġ
		
		btnCheck.setLocation(200,350);//��ġ��ǥ
		btnCheck.setSize(70,25);//��ġũ��
		add(btnCheck);//Frame�� ��ġ
		btnCancel.setLocation(290,350);//��ġ��ǥ
		btnCancel.setSize(70,25);//��ġũ��
		add(btnCancel);//Frame�� ��ġ
		
		
		setSize(400, 400);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
	}//Work25_2
	
	public static void main(String[] args) {
		new Work25_2();
	}//main

}//class
