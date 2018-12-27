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
		super("수동 배치-숙제2");
		
		//컴포넌트 생성
		Label lblFont=new Label("글꼴");
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
		
		Label lblStyle=new Label("글꼴스타일");
		TextField tfStyle=new TextField();
		List listStyle = new List();
		listStyle.add("일반");
		listStyle.add("굵게");
		listStyle.add("기울임꼴");
		listStyle.add("굵게기울임꼴");
//		TextArea taStyle=new TextArea("일반\n"
//								+ "굵게\n"
//								+ "기울임꼴\n"
//								+ "굵게기울임꼴");
		
		
		Label lblSize=new Label("크기");
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
		
		Label lblSample=new Label("보기");
		TextField tfSample=new TextField("AaBbYyZz");
		tfSample.setFont(new Font("Dialog",Font.BOLD,15));
		
		Button btnCheck=new Button("확인");
		Button btnCancel=new Button("취소");
		
		
		//배치관리자 해지
		setLayout(null);
		
		lblFont.setLocation(20,45);//배치좌표
		lblFont.setSize(80,20);//배치크기
		add(lblFont);//Frame에 배치
		tfFont.setLocation(20,70);//배치좌표
		tfFont.setSize(100,25);//배치크기
		add(tfFont);//Frame에 배치
		listFont.setLocation(20,100);//배치좌표
		listFont.setSize(100,100);//배치크기
		add(listFont);//Frame에 배치
		
		lblStyle.setLocation(140,45);//배치좌표
		lblStyle.setSize(80,20);//배치크기
		add(lblStyle);//Frame에 배치
		tfStyle.setLocation(140,70);//배치좌표
		tfStyle.setSize(100,25);//배치크기
		add(tfStyle);//Frame에 배치
		listStyle.setLocation(140,100);//배치좌표
		listStyle.setSize(100,100);//배치크기
		add(listStyle);//Frame에 배치

		lblSize.setLocation(260,45);//배치좌표
		lblSize.setSize(80,20);//배치크기
		add(lblSize);//Frame에 배치
		tfSize.setLocation(260,70);//배치좌표
		tfSize.setSize(100,25);//배치크기
		add(tfSize);//Frame에 배치
		listSize.setLocation(260,100);//배치좌표
		listSize.setSize(100,100);//배치크기
		add(listSize);//Frame에 배치
		
		lblSample.setLocation(140,220);//배치좌표
		lblSample.setSize(100,25);//배치크기
		add(lblSample);//Frame에 배치
		tfSample.setLocation(140,250);//배치좌표
		tfSample.setSize(100,50);//배치크기
		add(tfSample);//Frame에 배치
		
		btnCheck.setLocation(200,350);//배치좌표
		btnCheck.setSize(70,25);//배치크기
		add(btnCheck);//Frame에 배치
		btnCancel.setLocation(290,350);//배치좌표
		btnCancel.setSize(70,25);//배치크기
		add(btnCancel);//Frame에 배치
		
		
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
