package kr.co.sist.memo.evt;

import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import kr.co.sist.memo.view.MemoFormat;

public class MemoFormatEvt extends WindowAdapter implements ItemListener, ActionListener {

	private MemoFormat mf;
	
	public MemoFormatEvt(MemoFormat mf) {
		this.mf = mf;
	}//MemoFormatEvt
	
	@Override
	public void windowClosing(WindowEvent e) {
		mf.dispose();
	}//windowClosing
	
	@Override
	public void itemStateChanged(ItemEvent ie) {
//		System.out.println(ie.getSource());//����Ʈ ������ ������..
		List listEvt =(List)ie.getSource();
		String selectedValue =((List)ie.getSource()).getSelectedItem();
//		System.out.println(selectedValue);//���� ����Ʈ���� ��� ���õ� �������� �� ������ �´�.
		Font temp=mf.getLblPreview().getFont();//�ѹ��� �� ���� �ٲ��. ��Ŭ���� �ϳ��̹Ƿ� �������ش�.
		String font=temp.getFamily();
		int style=temp.getStyle();
		int size=temp.getSize();
		
		//������ �������� T.F�� ������ �����Ѵ�.
		//�̸����� ���� ����
		if(ie.getSource()==mf.getListFont()) {
			mf.getTfFontText().setText(selectedValue);
			font=selectedValue;
//			mf.getLblPreview().setFont();
		}//end if
		if(ie.getSource()==mf.getListStyle()) {
			mf.getTfStyleText().setText(selectedValue);
			//0,1,2,3 �� �����Ƿ�
			style=((List)ie.getSource()).getSelectedIndex();
		}//end if
		if(ie.getSource()==mf.getListSize()) {
			mf.getTfSizeText().setText(selectedValue);
			size=/*static import=>parsInt������ ����� ��*/Integer.parseInt(selectedValue);
		}//end if
		//������ ���� �� ����� ������ ������ Preview�� �۲� ������ �����Ѵ�.
		mf.getLblPreview().setFont(new Font(font,style,size));
	}//itemStateChanged

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==mf.getBtnYes()) { //������ �۲� ������ ����.
			setTaNoteFont();
		}//end if
		if(ae.getSource()==mf.getBtnNo()) {	//����
			mf.dispose();
		}//end if
	}//actionPerformed
	
	/**
	 * MemoFormatŬ������ �̸����� Label��  Font������ 
	 * JavaMemoŬ������ TextArea�� ����.
	 */
	public void setTaNoteFont() {
//		System.out.println(mf.getJm().getTaNote());//��ü�� ���� ta�� ������ ��.
		mf.getJm().getTaNote().setFont(mf.getLblPreview().getFont());
		mf.dispose();
	}//setTaNoteFont
	
}
