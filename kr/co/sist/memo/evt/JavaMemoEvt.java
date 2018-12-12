package kr.co.sist.memo.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import kr.co.sist.memo.view.JavaMemo;

public class JavaMemoEvt extends WindowAdapter implements ActionListener{

	private JavaMemo jm;
	
	public JavaMemoEvt(JavaMemo jm) {
		this.jm=jm;
	}//JavaMemoEvt
	
	@Override
	public void windowClosing(WindowEvent e) {
		jm.dispose();
	}//windowClosing
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}//actionPerformed
	
	/**
	 * 새글   에 대한 처리
	 */
	public void newMemo() {
		
	}//newMemo
	
	/**
	 * txt파일을 열기
	 */
	public void openMemo() {
		
	}//openMemo
	
	/**
	 * 작성한 메모 저장 - 기존의 파일명을 그대로 저장하는 파일명에 반영
	 */
	public void saveMemo() {
		
	}//saveMemo
	
	/**
	 * 파일명을 입력받아 새 이름으로 저장
	 */
	public void newSaveMemo() {
		
	}//newSaveMemo
	
	/**
	 * 글꼴을 설정하는 다이얼로그를 실행하는 일
	 */
	public void formatDialog() {
		
	}//formatDialog
	
	/**
	 * 메모장 정보를 제공하는 다이얼로그를 실행
	 */
	public void helpDialog() {
		
	}//helpDialog
	
	
}//class
