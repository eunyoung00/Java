package day0111;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class TestSite extends JFrame {

	private JTable jtab;
	private DefaultTableModel dtmtab;
	
	public TestSite() {
		super("������Ʈ ���̺�");
		String[] columnNames= {"�ΰ�","URL","Ư¡"};
		
		//����Ժκ�
		Object[][] rowData=new Object[3][3];
		rowData[0][0]=new ImageIcon("C:/dev/workspace/javase_prj2/src/day0111/images/daum.png");
		rowData[0][1]="https://www.daum.net/";
		rowData[0][2]="īī��";
		rowData[1][0]=new ImageIcon("C:/dev/workspace/javase_prj2/src/day0111/images/naver.png");
		rowData[1][1]="https://www.naver.com/";
		rowData[1][2]="����";
		rowData[2][0]=new ImageIcon("C:/dev/workspace/javase_prj2/src/day0111/images/google.png");
		rowData[2][1]="https://www.google.com/";
		rowData[2][2]="�˻�";
		
		dtmtab=new DefaultTableModel(rowData, columnNames);
//		jtab=new JTable(dtmtab);//�Էµ� ��ü�� toString() ȣ���ϴ� ����� �����µ� �״�� ������ ���ľ���.
		//<�� Ŭ������ ���ڿ��� �ƴ϶� �� Ŭ���� �״�� ���;� �Ѵ�.
		//<�Էµ� ��ü�� �״�� ��� =>ovrride �Ͽ� �θ��� ����� ����
		
		//�Էµ� Ŭ������ �״�� Cell(columns)�� ǥ���ǵ��� method Override
		//getColumnclass(int column)
		jtab=new JTable(dtmtab) {//ananymous class
			@Override
			public Class getColumnClass(int column) {//column : ������ ��� �÷�
				//getValueAt:������ ��
				//row-JTable�� �Էµ� ������ �迭�� �࿡ ���Ѵٸ� ����̴����� 
				//��� �÷��� ���� �Էµ� ������ ��ȯ�Ѵ�.
				return getValueAt(0, column).getClass();
//				return getValueAt(3, column).getClass();//�ִ����̾�߸� �ٲپ��ְ� ��� Error
				//�ڿ� �÷��� �������� ��쿡�� �� �ٸ� �ٲ�� ���´�...
				//<�Էµ� ��ü�� ���� �� return
				//<0���� ������? : jtable�� �Էµ� ��� �࿡ ���� �޾Ƶ���???������ Ư����?
			}//getColumnClass
		};
		JScrollPane jsp = new JScrollPane(jtab);
		
		jtab.getTableHeader().setResizingAllowed(false);//�÷��� ũ�� ���� ����
		jtab.getTableHeader().setReorderingAllowed(false);//�÷��� �̵� ����
		
		jtab.getTableHeader().getColumnModel().getColumn(0).setPreferredWidth(160);
		jtab.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(200);
		jtab.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(50);
		///����Բ�
		
		//��
//		dtmtab=new DefaultTableModel(0,0);
//		jtab=new JTable(dtmtab);
//		String[] rogo={"C:/dev/workspace/javase_prj2/src/day0111/images/daum.png",
//						"C:/dev/workspace/javase_prj2/src/day0111/images/naver.png",
//						"C:/dev/workspace/javase_prj2/src/day0111/images/google.png"};
////		ImageIcon rogo0= new ImageIcon("C:/dev/workspace/javase_prj2/src/day0111/images/daum.png");
////		ImageIcon rogo1= new ImageIcon("C:/dev/workspace/javase_prj2/src/day0111/images/naver.png");
////		ImageIcon rogo2= new ImageIcon("C:/dev/workspace/javase_prj2/src/day0111/images/google.png");
//		String[] url= {"https://www.google.com","https://www.naver.com/","https://www.daum.net/"};
//		String[] feature= {"īī��","����","�˻�"};
//		
//		dtmtab.addColumn(columnNames[0],rogo);
//		dtmtab.addColumn(columnNames[1], url);
//		dtmtab.addColumn(columnNames[2], feature);
//		jtab.getTableHeader().setReorderingAllowed(false);//�÷� �̵� ����
		
		jtab.setRowHeight(50);//���ڵ� ����	
		
		add(jsp);
		setBounds(100, 100, 500, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//TestSite

	public static void main(String[] args) {
		new TestSite();
	}//main
}//class
