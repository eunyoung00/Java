package kr.co.sist.memo.evt;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import kr.co.sist.memo.view.Help;
import kr.co.sist.memo.view.JavaMemo;
import kr.co.sist.memo.view.MemoFormat;

public class JavaMemoEvt extends WindowAdapter implements ActionListener{

	private JavaMemo jm;
	
	public JavaMemoEvt(JavaMemo jm) {
		this.jm=jm;
	}//JavaMemoEvt
	
	@Override
	public void windowClosing(WindowEvent we) {
		jm.dispose();
	}//windowClosing
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		//miNew, miOpen, miSave, miNewSave, miEnd, miFormat, miHelp
		//이벤트를 비교해야될 객체들
		
		//새글 메뉴아이템에서 이벤트가 발생 했을 때 
		if(ae.getSource()==jm.getMiNew()) {
			//라벨을 가지고 비교 할거면 getter method가 필요가 없다 .
			//주소를 얻어 오기 위해서 getter method가 필요한 것이고, 사용하는 방법이 라벨비교 보다 좋다.
			newMemo();
		}//end if
		
		//열기 메뉴 아이템에서 이벤트가 발생했을 때 
		if(ae.getSource()==jm.getMiOpen()) {
			openMemo();
		}//end if
		
		//저장 메뉴 아이템에서 이벤트가 발생했을 때 
		if(ae.getSource()==jm.getMiSave()) {
			saveMemo();
		}//end if
		
		//다른이름으로 저장 메뉴 아이템에서 이벤트가 발생했을 때 
		if(ae.getSource()==jm.getMiNewSave()) {
			newSaveMemo();
		}//end if
		
		//종료 메뉴 아이템에서 이벤트가 발생했을 때 
		if(ae.getSource()==jm.getMiEnd()) {
			jm.dispose();//<원래는 그냥종료하면 안된다.
		}//end if
		
		//서식 메뉴 아이템에서 이벤트가 발생했을 때 
		if(ae.getSource()==jm.getMiFormat()) {
			formatDialog();
		}//end if
		
		//도움말 메뉴 아이템에서 이벤트가 발생했을 때 
		if(ae.getSource()==jm.getMiHelp()) {
			helpDialog();
		}//end if
		
		
		
	}//actionPerformed
	
	/**
	 * 새글   에 대한 처리
	 * :TextArea를 초기화 한다.
	 */
	public void newMemo() {
		jm.getTaNote().getText();//버그때문에 값을 한번 갖고 와야함.
		jm.getTaNote().setText("");
		
		jm.setTitle("메모장-새글");
	}//newMemo
	
	/**
	 * txt파일을 열기
	 */
	public void openMemo() {
		FileDialog fdOpen = new FileDialog(jm, "문서 열기", FileDialog.LOAD	);
		fdOpen.setVisible(true);
		
		String filePath=fdOpen.getDirectory();//경로
		String fileName=fdOpen.getFile();//파일명
		
		if(filePath!=null) {//선택한 파일이 존재
			//파일의 경로와 이름을 Frame의 TitleBar에 설정
			jm.setTitle("메모장-열기 "+filePath+fileName);
		}//end if
		
	}//openMemo
	
	/**
	 * 작성한 메모 저장 - 기존의 파일명을 그대로 저장하는 파일명에 반영
	 */
	public void saveMemo() {
		newSaveMemo();
	}//saveMemo
	
	/**
	 * 파일명을 입력받아 새 이름으로 저장
	 */
	public void newSaveMemo() {
		FileDialog fdSave = new FileDialog(jm, "문서 저장", FileDialog.SAVE);
		fdSave.setVisible(true);
		
		String filePath=fdSave.getDirectory();//경로
		String fileName=fdSave.getFile();//파일명
		
		if(filePath!=null) {//선택한 파일이 존재
			//파일의 경로와 이름을 Frame의 TitleBar에 설정
			jm.setTitle("메모장-저장 "+filePath+fileName);
		}//end if
	}//newSaveMemo
	
	/**
	 * 글꼴을 설정하는 다이얼로그를 실행하는 일
	 */
	public void formatDialog() {
		new MemoFormat(jm);//this는 이벤트니까 메인을 넣기 위해 jm
	}//formatDialog
	
	/**
	 * 메모장 정보를 제공하는 다이얼로그를 실행
	 */
	public void helpDialog() {
		new Help(jm);
	}//helpDialog
	
	
}//class
