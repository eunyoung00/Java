package kr.co.sist.memo.evt;

import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

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
		
		try {
			fontStatusSave();//설정한 글꼴 상태정보(폰트)정보를 저장.
		}catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
		mf.dispose();
	}//setTaNoteFont
	
	/**
	 * 설정한 폰트의 상태를 파일로 저장->다음에 프로그램이 실행되면 현재 저장된 폰트값을 적용하여 TA를 설정하면 
	 * 변경상태가 유지된다.
	 */
	private void fontStatusSave() throws IOException{
		//다 영어라 8bit로도 충분
		BufferedWriter bw=null;
		//////////////////////////////2018-12-21 ObjectOutputStream////////////////////////////
		//객체가 써졌을때의 장점! 알아보기 힘들어 손댈수 없다.
		ObjectOutputStream oos =null;
		
		try {
			//미리보기 라벨에 설정된 폰트 정보를 얻는다.
			Font fontTemp=mf.getLblPreview().getFont();//폰트가 객체라 builder필요 없음..
			//직렬화가능..API확인
			oos=new ObjectOutputStream(
							new FileOutputStream("c:/dev/temp/memo.dat"));
			oos.writeObject(fontTemp);
			oos.flush();
			
//			StringBuilder fontData=new StringBuilder();
//			fontData.append(fontTemp.getFamily())
//			.append(",").append(fontTemp.getStyle())
//			.append(",").append(fontTemp.getSize());
//			//물어볼 필요없이 덮어쓰면된다. 
			
//			bw=new BufferedWriter(new FileWriter("c:/dev/temp/memo.dat"));
//			bw.write(fontData.toString());
//			bw.flush();//문자열로 써지면 밖에서 편집이 가능해진다..
			
		}finally {
//			if(bw!=null) {bw.close();}//end if
			if(oos!=null) {oos.close();}//end if
		}//end finally
		
	}//fontStatusSave
	
}//class
