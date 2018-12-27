package kr.co.sist.memo.view;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.TextArea;

import kr.co.sist.memo.evt.HelpEvt;

@SuppressWarnings("serial")
public class Help extends Dialog{

	private JavaMemo jm;
	private Button btnOk;
	
	public Help(JavaMemo jm) {
		super(jm,"도움말",true);
		this.jm=jm;
		
		TextArea taInfo=new TextArea("메모장 정보\n이 메모장은 Java로 만들었으며\n"
				+ "누구나 코드 수정 및 배포를 할 수 있습니다.\n단, 이 코드를 사용하여 개선했을 때에는\n"
				+ "소스공개를 원칙으로 한다.\n작성자 : 박은영\nversion :1.0");
		btnOk =new Button("확인");
		taInfo.setEditable(false);
		
		setLayout(null);
		
		taInfo.setBounds(20, 40, 360, 250);
		btnOk.setBounds(175,305,50,25);
		add(taInfo);
		add(btnOk);
		
		//이벤트 등록
		HelpEvt hwe =new HelpEvt(this);
		btnOk.addActionListener(hwe);
		addWindowListener(hwe);
		
		setBounds(jm.getX()+150,jm.getY()+80,400,350);
		setVisible(true);
	
	}//Work28

	public JavaMemo getJm() {
		return jm;
	}

	public Button getBtnOk() {
		return btnOk;
	}
	
}//class
