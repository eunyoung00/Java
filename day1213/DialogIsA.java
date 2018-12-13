package day1213;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//1.Dialog ���
@SuppressWarnings("serial")
public class DialogIsA extends Dialog implements ActionListener {
	//2.�̺�Ʈ�� �����ִ� ������Ʈ ����
	private Button btn;
	
	//<���̾�α��� �����ڰ� �⺻�����ڰ� ���⶧���� �����ڰ� ��� Error
	public DialogIsA(UseDialogIsA uda) {//UseDialogIsA �� DialogIsA�� has a ���谡 ��
	//���� ���̾�α��� �θ� �� ��ü�� has a
		super(uda,"���̾�α�",true);//�����ϴ� �ʰ��� has a  ���°� ��ü�� is a (���)
		
		//������Ʈ ����
		Label lbl=new Label("������ ����� �Դϴ�.",Label.CENTER);
		
		btn=new Button("����");
		
		add("Center",lbl);
		add("South",btn);
		
		btn.addActionListener(this);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}//widnowClosing
		});
		
		//���̾�α׸� ��ﶧ ���̾�α��� ��ġ�� �θ������� �������� ����.
		System.out.println("�θ��� x "+uda.getX()+", y "+uda.getY());
		setBounds(uda.getX()+100,uda.getY()+100,300,300);
		setVisible(true);
		
		
	}//DialogIsA

	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
	}

}
