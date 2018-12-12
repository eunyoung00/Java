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
	 * ����   �� ���� ó��
	 */
	public void newMemo() {
		
	}//newMemo
	
	/**
	 * txt������ ����
	 */
	public void openMemo() {
		
	}//openMemo
	
	/**
	 * �ۼ��� �޸� ���� - ������ ���ϸ��� �״�� �����ϴ� ���ϸ��� �ݿ�
	 */
	public void saveMemo() {
		
	}//saveMemo
	
	/**
	 * ���ϸ��� �Է¹޾� �� �̸����� ����
	 */
	public void newSaveMemo() {
		
	}//newSaveMemo
	
	/**
	 * �۲��� �����ϴ� ���̾�α׸� �����ϴ� ��
	 */
	public void formatDialog() {
		
	}//formatDialog
	
	/**
	 * �޸��� ������ �����ϴ� ���̾�α׸� ����
	 */
	public void helpDialog() {
		
	}//helpDialog
	
	
}//class