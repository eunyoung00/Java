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
//		System.out.println(ie.getSource());//리스트 정보와 아이템..
		List listEvt =(List)ie.getSource();
		String selectedValue =((List)ie.getSource()).getSelectedItem();
//		System.out.println(selectedValue);//여러 리스트에서 모든 선택된 아이템을 다 가지고 온다.
		Font temp=mf.getLblPreview().getFont();//한번에 다 들어와 바뀐다. 한클릭에 하나이므로 나누어준다.
		String font=temp.getFamily();
		int style=temp.getStyle();
		int size=temp.getSize();
		
		//선택한 아이템을 T.F에 값으로 설정한다.
		//미리보기 라벨을 변경
		if(ie.getSource()==mf.getListFont()) {
			mf.getTfFontText().setText(selectedValue);
			font=selectedValue;
//			mf.getLblPreview().setFont();
		}//end if
		if(ie.getSource()==mf.getListStyle()) {
			mf.getTfStyleText().setText(selectedValue);
			//0,1,2,3 이 나오므로
			style=((List)ie.getSource()).getSelectedIndex();
		}//end if
		if(ie.getSource()==mf.getListSize()) {
			mf.getTfSizeText().setText(selectedValue);
			size=/*static import=>parsInt여러번 사용할 때*/Integer.parseInt(selectedValue);
		}//end if
		//설정된 정보 중 변경된 정보만 가지고 Preview의 글꼴 정보를 변경한다.
		mf.getLblPreview().setFont(new Font(font,style,size));
	}//itemStateChanged

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==mf.getBtnYes()) { //설정한 글꼴 정보를 적용.
			setTaNoteFont();
		}//end if
		if(ae.getSource()==mf.getBtnNo()) {	//닫힘
			mf.dispose();
		}//end if
	}//actionPerformed
	
	/**
	 * MemoFormat클래스의 미리보기 Label의  Font정보를 
	 * JavaMemo클래스의 TextArea에 설정.
	 */
	public void setTaNoteFont() {
//		System.out.println(mf.getJm().getTaNote());//본체의 정보 ta의 정보가 옴.
		mf.getJm().getTaNote().setFont(mf.getLblPreview().getFont());
		mf.dispose();
	}//setTaNoteFont
	
}
