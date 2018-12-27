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
		super(jm,"����",true);
		this.jm=jm;
		
		TextArea taInfo=new TextArea("�޸��� ����\n�� �޸����� Java�� ���������\n������ �ڵ� ���� �� ������ �� �� �ֽ��ϴ�."
				+ "\n��, �� �ڵ带 ����Ͽ� �������� ������\n�ҽ������� ��Ģ���� �Ѵ�.\n�ۼ��� : ������\nversion :1.0");
		btnOk =new Button("Ȯ��");
		taInfo.setEditable(false);
		
		add("Center", taInfo);
		add("South",btnOk);
		
		//�̺�Ʈ ���
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
