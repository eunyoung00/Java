package logAnalysis;


import java.awt.Dialog;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class ReportDialogView extends Dialog {
	private JLabel jlNum1, jlNum2, jlNum3, jlNum4,jlNum5, jlNum6;
	private JTextArea report1, report2, report3, report4, report5, report6;
	private SelectBtn mce;
	
	public ReportDialogView(SelectBtn mce) {
		super(mce, "VIEW", true);
		this.mce=mce;
		jlNum1 = new JLabel("1.	�ִٻ�� Ű�� �̸��� Ƚ��");
		jlNum2 = new JLabel("2.	�������� ����Ƚ��, ����");
		jlNum3 = new JLabel("3. ���񽺸� ���������� ������ Ƚ���� ����(404) Ƚ��");
		jlNum4 = new JLabel("4. ��û�� ���� ���� �ð�");
		jlNum5 = new JLabel("5. ���������� ��û(403)�� �߻��� Ƚ��, ���� ���ϱ�");
		jlNum6 = new JLabel("6. �Էµ� ���ο� �ش��ϴ� �������\r\n" + " �ִٻ�� Ű�� �̸��� Ƚ�� ");
		report1 = new JTextArea("");
		report2 = new JTextArea("");
		report3 = new JTextArea("");
		report4 = new JTextArea("");
		report5 = new JTextArea("");
		report6 = new JTextArea("");
		JPanel dialogView = new JPanel();
		
		dialogView.setLayout(null);
		
		jlNum1.setBounds(20,40,300,30);
		jlNum2.setBounds(20,120,300,30);
		jlNum3.setBounds(20,200,300,30);
		jlNum4.setBounds(20,280,300,30);
		jlNum5.setBounds(20,360,300,30);
		jlNum6.setBounds(20,440,300,30);
		report1.setBounds(20,80,300,30);
		report2.setBounds(20,160,300,30);
		report3.setBounds(20,240,300,30);
		report4.setBounds(20,320,300,30);
		report5.setBounds(20,400,300,30);
		report6.setBounds(20,480,300,30);
		
		
		dialogView.add(jlNum1);
		dialogView.add(jlNum2);
		dialogView.add(jlNum3);
		dialogView.add(jlNum4);
		dialogView.add(jlNum5);
		dialogView.add(jlNum6);
		dialogView.add(report1);
		dialogView.add(report2);
		dialogView.add(report3);
		dialogView.add(report4);
		dialogView.add(report5);
		dialogView.add(report6);
		add("Center",dialogView);
		
	
		//�̺�Ʈ ���
//		MainControlEvt mce = new MainControlEvt(this);

//		addWindowListener(mce);
		
		setBounds( mce.getX()+150, mce.getY()+80, 400, 700);
		setResizable(false);
		report1.setEditable(false);
		report2.setEditable(false);
		report3.setEditable(false);
		report4.setEditable(false);
		report5.setEditable(false);
		report6.setEditable(false);
		
		setVisible(true);
	}//LogAnalysisView
	
}//LogAnalysisView
