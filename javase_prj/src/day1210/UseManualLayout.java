package day1210;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 수동 배치)
 * 개발자가 컴포넌트의 배치 위치와 크기를 설정하는 배치방법.
 * @author owner
 */

//1.윈도우 컴포넌트 상속
@SuppressWarnings("serial")
public class UseManualLayout extends Frame{

	public UseManualLayout() {
		super("수동 배치");
		//1.컴포넌트 생성
		Label lbl = new Label();
		lbl.setText("라벨");
		TextField tf=new TextField();
		Button btn=new Button("클릭");
		
		
		//2.배치관리자 설정(해제) :BorderLayout
		setLayout(null);
		//<이번엔 label의 크기가 없어 안보임
		//3.배치(좌표와 크기)
		//컴포넌트의 좌표,크기 설정
		lbl.setLocation(10,35);//배치좌표
		lbl.setSize(80,20);//배치크기
//		tf.setBounds(50,100,120,25);//X,Y,w,h
		tf.setBounds(50,100,120,55);//X,Y,w,h//<높이가 높아졌다고 여러줄ㄴㄴ
		btn.setBounds(250,200,120,23);//X,Y,w,h
		add(lbl);//Frame에 배치
		add(tf);//Frame에 배치
		add(btn);//Frame에 배치
		//<가운데에 크게 하나 들어감..배치관리자를 해제하지 않았기 때문.
		
		//4.윈도우의 좌표 설정
//		setLocation(100,200);
		//5.윈도우의 크기 설정
//		setSize(500,600);
		setBounds(200,100,400,250);//<더펀하긴한다.//크기를 늘리거나 줄일수 있다 .이때쓰는 method
		setResizable(false);//<window창의 크기변경을 막는다.
		
		
		//6.사용자에게 보여주기
		setVisible(true);
		//7.종료 처리
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
		
		//<크기변경시 고정위치를 가지고 변하지 않는다.
		//<넓히면 이쁘지 않아 고정하라고 줘버린다.setResizable(false);
		//<자동배치를 섞어 만들어야한다..?
	}//UseManualLayout
	
	public static void main(String[] args) {
		new UseManualLayout();
	}//main

}//class
