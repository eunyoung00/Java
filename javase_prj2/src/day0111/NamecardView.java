package day0111;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class NamecardView extends JFrame {
	
	private JButton jbtImg,jbtAdd;
	private DefaultTableModel dtmNamecard;
	private JLabel jlPreview;
	private JTextField jtfName,jtfAddr;
	
	public NamecardView() {
		super("명함 관리");
		//리멤버 명함정리앱
		JLabel jlName=new JLabel("성명");
		JLabel jlAddr=new JLabel("주소");
		JLabel jlImg=new JLabel("이미지");
		
		jbtImg=new JButton("이미지선택");
		jbtAdd=new JButton("명함추가");
		
		String[] columnNames= {"번호","이미지","성명","주소"};
		Object[][] data =new Object[1][4];
		data[0][0]="";
		data[0][1]="";
		data[0][2]="";
		data[0][3]="";
		dtmNamecard=new DefaultTableModel(data, columnNames) {
			//테이블의 모든 행과열 편집막기
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}//isCellEditable
		};
		
		jlPreview=new JLabel(new ImageIcon("C:/dev/workspace/javase_prj2/src/day0111/upload/no_image.png"));
		jtfName=new JTextField();
		jtfAddr=new JTextField();
		
		JTable jtaNamecardList=new JTable(dtmNamecard) {
			@Override
			public Class<?> getColumnClass(int column) {
				return getValueAt(0, column).getClass();//들어가 있는 행이 없어 Error=>object[][]넣어줌
			}//getColumnClass
		};
		JScrollPane jsp=new JScrollPane(jtaNamecardList);
		jsp.setBorder(new TitledBorder("명함 리스트"));
		
		jtaNamecardList.getColumnModel().getColumn(0).setPreferredWidth(40);
		jtaNamecardList.getColumnModel().getColumn(1).setPreferredWidth(170);
		jtaNamecardList.getColumnModel().getColumn(2).setPreferredWidth(120);
		jtaNamecardList.getColumnModel().getColumn(3).setPreferredWidth(260);
		
		jtaNamecardList.setRowHeight(200);
		jtaNamecardList.getTableHeader().setReorderingAllowed(false);//컬럼간에 안바뀌게
		
		setLayout(null);//수동배치
		
		jlName.setBounds(10, 20, 80, 25);
		jtfName.setBounds(80, 20, 120, 25);
		jlAddr.setBounds(10, 50, 80, 25);
		jtfAddr.setBounds(80, 50, 120, 25);
		jlImg.setBounds(10, 80, 80, 25);
		jlPreview.setBounds(80, 80, 167, 199);
		
		jbtImg.setBounds(115, 285, 100, 25);
		jbtAdd.setBounds(115, 320, 100, 25);
		jsp.setBounds(260, 20, 600, 300);
		
		add(jlName);
		add(jtfName);
		add(jlAddr);
		add(jtfAddr);
		add(jlImg);
		add(jlPreview);
		add(jbtImg);
		add(jbtAdd);
		add(jsp);
		
		//이벤트 등록 :
		NamecardViewController nvc=new NamecardViewController(this);
		addWindowListener(nvc);
		jbtAdd.addActionListener(nvc);
		jbtImg.addActionListener(nvc);
		
		setBounds(100,100,900,400);
		setVisible(true);
		setResizable(false);//크기 고정
	}//NamecardView

	public JButton getJbtImg() {
		return jbtImg;
	}
	public JButton getJbtAdd() {
		return jbtAdd;
	}
	public DefaultTableModel getDtmNamecard() {
		return dtmNamecard;
	}
	public JLabel getJlPreview() {
		return jlPreview;
	}
	public JTextField getJtfName() {
		return jtfName;
	}
	public JTextField getJtfAddr() {
		return jtfAddr;
	}

	public static void main(String[] args) {
		new NamecardView();
	}//main
}//class
