package day0111;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class TestChangeJTableView extends JFrame{
	
	private JTextField jtfName,jtfAdrr,jtfImage;
	private JButton jbtImage,jbtAdd;
	private JTable jt;
	private DefaultTableModel dtm;
	
	public TestChangeJTableView() {
		super("���̺� �̹��� �ֱ�");
		
		jtfName=new JTextField();
		jtfAdrr=new JTextField();
		jtfImage=new JTextField();
		
		jbtImage=new JButton("����");
		jbtAdd=new JButton("�Է�");
		
//		String[] = {"�̹���","",""}
//		dtm
		
		
	
	}

	public static void main(String[] args) {

	}//main

}//class
