package day1213;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.TextArea;

import kr.co.sist.memo.view.JavaMemo;

@SuppressWarnings("serial")
public class Work28 extends Dialog{

	private JavaMemo jm;
	private Button btnOk;
	
	public Work28(JavaMemo jm) {
		super(jm,"도움말",true);
		this.jm=jm;
		
		TextArea taInfo=new TextArea("메모장 정보\n이 메모장은 Java로 만들었으며\n누구나 코드 수정 및 배포를 할 수 있습니다."
				+ "\n단, 이 코드를 사용하여 개선했을 때에는\n소스공개를 원칙으로 한다.\n작성자 : 박은영\nversion :1.0");
		btnOk =new Button("확인");
		taInfo.setEditable(false);
		
		add("Center", taInfo);
		add("South",btnOk);
		
		//이벤트 등록
		Work28Evt hwe =new Work28Evt(this);
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
