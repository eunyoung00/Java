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
		super(jm,"����",true);
		this.jm=jm;
		
		TextArea taInfo=new TextArea("�޸��� ����\n�� �޸����� Java�� ���������\n"
				+ "������ �ڵ� ���� �� ������ �� �� �ֽ��ϴ�.\n��, �� �ڵ带 ����Ͽ� �������� ������\n"
				+ "�ҽ������� ��Ģ���� �Ѵ�.\n�ۼ��� : ������\nversion :1.0");
		btnOk =new Button("Ȯ��");
		taInfo.setEditable(false);
		
		setLayout(null);
		
		taInfo.setBounds(20, 40, 360, 250);
		btnOk.setBounds(175,305,50,25);
		add(taInfo);
		add(btnOk);
		
		//�̺�Ʈ ���
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
