package day1212;

import java.awt.Button;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 같은종류의 이벤트가 여러개 발생하면, 그이벤트를 비교하여 처리하는 방법<br>
 * 이벤트를 발생시킨 주소를 비교하는 방법 : getSource()-모든이벤트에서 사용가능 <br>
 * 이벤트를 발생시킨 객체의 Label을 비교하는 방법 : getActionCommand()-
 * ActionEvent에서만 사용가능
 * @author owner
 */

//1.윈도우 컴포넌트 상속, Event 처리 Listener를 구현.
@SuppressWarnings("serial")
public class EventCompare extends Frame implements ActionListener{
//<클래스가 가질수있는 Full 형태
	
	//2.이벤트와 관련있는 Component를 선언. <다른 method에서 비교?하려고 올린것
	private Button btnOpen;
	private Button btnSave;
	private Label lblOutput;
	
	public EventCompare() {
		super("파일다이얼로그 사용");
		
		//3.생성
		btnOpen =new Button("열기모드");
		btnSave =new Button("저장모드");
		lblOutput =new Label("출력창 :");
		
		//4.배치
		Panel panel =new Panel();//Container Component라고 한다.
		panel.add(btnOpen);
		panel.add(btnSave);
		
		add("Center",panel);
		add("South",lblOutput);
		
		//5.이벤트 등록
		btnOpen.addActionListener(this);
		btnSave.addActionListener(this);
		
		//6.윈도우 크기 설정
		setBounds(100, 100, 500, 100);
		//7.가시화
		setVisible(true);
		
		//종료 처리
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}//windowClosing
		});
	}//EventCompare

	@Override
	public void actionPerformed(ActionEvent ae) {
//		System.out.println("이벤트 발생"+ae);
		//////////////////////주소로 비교/////////////////////////
//		if(ae.getSource()==btnOpen) {
//			System.out.println("열기");
//		}//end if
//		
//		if(ae.getSource()==btnSave) {
//			System.out.println("저장");
//		}//end if
		
		
//		System.out.println("이벤트 발생 객체의 Label "+ae.getActionCommand());
		/////////////////////Label 비교//////////////////////////
		String label=ae.getActionCommand();
		if(label.equals("열기모드")) {
//			System.out.println("열기!!!");
			//window component로 생성과 동시에 사용자에게 보여지지 않는다.
			FileDialog fdOpen=new FileDialog(this, "파일열기", FileDialog.LOAD);
			//<Window component라서 생성했다고 뜨지 않는다.
			//가시화
			fdOpen.setVisible(true);//<파일을 여는기능도 ...내가구현...
			
			String path=fdOpen.getDirectory();
			String name=fdOpen.getFile();
			
//			if(path!=null) {
			if(name!=null) {//선택한 파일이 있을 때 비교
				lblOutput.setText("열기 파일 : "+path+name);
				//타이틀바의 내용 변경
				setTitle("파일다이얼로그 사용-열기 : "+name);
			}else {
				lblOutput.setText("출력창 : ");
				//타이틀바의 내용 변경
				setTitle("파일다이얼로그 사용");
			}
		}//end if
		
		if(label.equals("저장모드")) {
//			System.out.println("저장!!!");
			FileDialog fdSave=new FileDialog(this, "파일저장", FileDialog.SAVE);
			//가시화
			fdSave.setVisible(true);//<파일을 저장기능도 ...내가구현...
			
			String path=fdSave.getDirectory();
			String name=fdSave.getFile();
			
			if(name!=null) {
				lblOutput.setText("저장 파일 : "+path+name);
				//타이틀바의 내용 변경
				setTitle("파일다이얼로그 사용-저장 : "+name);
			}//end if
		}//end if
		
	}//actionPerformed
	
	public static void main(String[] args) {
		new EventCompare();
	}//main

}//class
