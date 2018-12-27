package kr.co.sist.memo.view;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;

import kr.co.sist.memo.evt.JavaMemoEvt;

/**
 * 사용자가 간단한 메모를 작성, 파일로 저장, 파일에서 읽어들이는 기능이 구현된 메모장. 
 * @author owner
 */
@SuppressWarnings("serial")
public class JavaMemo extends Frame {
	private Menu menuFile, menuEdit, menuHelp;
	private MenuItem miNew, miOpen, miSave, miNewSave, miEnd, miFormat, miHelp;
	private TextArea taNote;
	
	public JavaMemo(Font font) {
		super("메모장-제목없음");
		
		//메뉴 생성 : menu가 add전에만 만들어 주면 된다.
		menuFile=new Menu("파일");
		menuEdit=new Menu("서식");
		menuHelp=new Menu("도움말");
		//메뉴 아이템 생성
		miNew=new MenuItem("새 글");
		miOpen=new MenuItem("열기");
		miSave=new MenuItem("저장");
		miNewSave=new MenuItem("다른 이름으로 저장");
		miEnd=new MenuItem("종료");
		miFormat=new MenuItem("글꼴");
		miHelp=new MenuItem("도움말");
		//TextArea 생성
		taNote=new TextArea();
		
		//////////12-20-2018///////////////////
		//매개변수로 들어오는 font를 적용하여 TextArea에 Font를 설정한다.
		if(font!=null) {
			taNote.setFont(font);
		}//end if
		//////////12-20-2018///////////////////
		
		//배치
		//메뉴아이템->메뉴 에 배치
		menuFile.add(miNew);
		menuFile.addSeparator();
		menuFile.add(miOpen);
		menuFile.add(miSave);
		menuFile.add(miNewSave);
		menuFile.addSeparator();
		menuFile.add(miEnd);
		
		menuEdit.add(miFormat);
		
		menuHelp.add(miHelp);
		
		//메뉴->메뉴바에 배치
		MenuBar mb = new MenuBar();
		mb.add(menuFile);
		mb.add(menuEdit);
		mb.add(menuHelp);
		
		//메뉴바->Frame 에 배치
		setMenuBar(mb);
		//T.A를 BorderLayout의 Center에 배치
		add("Center",taNote);
		
		JavaMemoEvt jme= new JavaMemoEvt(this);
		//윈도우 종료 이벤트 등록 : Frame은 보여주기 전에 종료?이벤트를 넣어도 상관 없지만 Dialog는 아님.
		addWindowListener(jme);
		//메뉴 아이템 이벤트 등록
		miNew.addActionListener(jme);
		miOpen.addActionListener(jme);
		miSave.addActionListener(jme);
		miNewSave.addActionListener(jme);
		miEnd.addActionListener(jme);
		miFormat.addActionListener(jme);
		miHelp.addActionListener(jme);
		
		//윈도우의  크기 설정
		setBounds(10, 10, 900, 600);
		setVisible(true);
		
		
	}//JavaMemo

	//메뉴아이템이랑 T.A만 밖에서 사용하게 됨.
	public MenuItem getMiNew() {
		return miNew;
	}

	public MenuItem getMiOpen() {
		return miOpen;
	}

	public MenuItem getMiSave() {
		return miSave;
	}

	public MenuItem getMiNewSave() {
		return miNewSave;
	}

	public MenuItem getMiEnd() {
		return miEnd;
	}

	public MenuItem getMiFormat() {
		return miFormat;
	}

	public MenuItem getMiHelp() {
		return miHelp;
	}

	public TextArea getTaNote() {
		return taNote;
	}
	
	
}//class
