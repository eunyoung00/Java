package day0109;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class HomeworkView extends JFrame{
	
	private JTextField jtftabName,jtfcolsize,jtfcolName,jtfConstraintName;
	private JComboBox<String> jcbDataType,jcbConstraint;
	private JButton jbtAddtab,jbtAddConst,jbtCreate,jbtReset;
	private JTextArea jtaQueryView;
	
	public HomeworkView() {
		super("테이블 만들기");
		
		jtftabName=new JTextField(8);
		jtfcolName=new JTextField(8);
		jtfcolsize=new JTextField(8);
		jtfConstraintName=new JTextField(8);
		
		jcbDataType=new JComboBox<String>();
		jcbConstraint=new JComboBox<String>();
		
		jbtAddtab=new JButton("추가");
		jbtAddConst=new JButton("추가");
		jbtCreate=new JButton("테이블 생성");
		jbtReset=new JButton("초기화");
		
		jtaQueryView=new JTextArea();
		
		String[] dataType= {"varchar2","char","number","date"};
		jcbDataType.setModel(new DefaultComboBoxModel<String>(dataType));

		String[] constraints= {"null","primary key","unique","not null"};
		jcbConstraint.setModel(new DefaultComboBoxModel<String>(constraints));
		
		JPanel panel1=new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel1.add(new JLabel("테이블명"));
		panel1.add(jtftabName);
		panel1.add(jbtAddtab);
		
		JPanel panel2=new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel2.add(new JLabel("컬럼명   "));
		panel2.add(jtfcolName);
		panel2.add(new JLabel("데이터형"));
		panel2.add(jcbDataType);
		panel2.add(new JLabel("크기"));
		panel2.add(jtfcolsize);
		
		JPanel panel3=new JPanel();
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel3.add(new JLabel("제약사항"));
		panel3.add(jcbConstraint);
		panel3.add(new JLabel("제약사항명"));
		panel3.add(jtfConstraintName);
		panel3.add(jbtAddConst);
		
		JPanel panelNorth=new JPanel();
		panelNorth.setLayout(new GridLayout(3, 1));
		panelNorth.add("North",panel1);
		panelNorth.add("Center",panel2);
		panelNorth.add("South",panel3);
		
		jtaQueryView.setEditable(false);//입력방지
		JScrollPane jsp=new JScrollPane(jtaQueryView);
		jsp.setBorder(new TitledBorder("Query View"));
		
		JPanel panelSouth=new JPanel();
		panelSouth.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelSouth.add(jbtCreate);
		panelSouth.add(jbtReset);
		
		add("North",panelNorth);
		add("Center",jsp);
		add("South", panelSouth);
		
		HomeworkViewEvt hve=new HomeworkViewEvt(this);
		jbtAddConst.addActionListener(hve);
		jbtAddtab.addActionListener(hve);
		jbtCreate.addActionListener(hve);
		jbtReset.addActionListener(hve);
		
		addWindowListener(hve);
		
		setBounds(100, 100, 500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//HomeworkView
	
	public JTextField getJtftabName() {
		return jtftabName;
	}
	public JTextField getJtfcolsize() {
		return jtfcolsize;
	}
	public JTextField getJtfcolName() {
		return jtfcolName;
	}
	public JTextField getJtfConstraintName() {
		return jtfConstraintName;
	}
	public JComboBox<String> getJcbDataType() {
		return jcbDataType;
	}
	public JComboBox<String> getJcbConstraint() {
		return jcbConstraint;
	}
	public JButton getJbtAddtab() {
		return jbtAddtab;
	}
	public JButton getJbtAddConst() {
		return jbtAddConst;
	}
	public JButton getJbtCreate() {
		return jbtCreate;
	}
	public JButton getJbtReset() {
		return jbtReset;
	}
	public JTextArea getJtaQueryView() {
		return jtaQueryView;
	}

	public static void main(String[] args) {
		new HomeworkView();
	}//main
}//class
