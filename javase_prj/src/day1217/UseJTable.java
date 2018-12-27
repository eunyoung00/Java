package day1217;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 * (JTable)
 * MVC Pattern�� ����� class 
 * @author owner
 */
@SuppressWarnings("serial")
public class UseJTable extends JFrame implements ActionListener{

	private JButton btnAdd;
	private DefaultTableModel dtm;
	private JTable jt;//<���̺����� �������� ���� ��� ���� �÷���.
	private UseJTable ujt;//<null����.(�ڵ� �ʱ�ȭ)
	
	public UseJTable() {
		super("JTable ����");
		ujt=this;//<����? �ּҸ� �ۿ��� ��������� ��üȭ(�ν��Ͻ� ������ ����� �ش�.)
		//1.�����͸� �����ϴ� Model Ŭ������ ����
		String[] columnNames = {"��ȣ","�̸�","�ּ�","�̸���"};
		String[][] rowData= {
					{"1","������","��õ�� �ҷ���","chan@test.com"},
					{"2","���ü�","����� ���ε�","teack@test.com"},
					{"3","������","��⵵ �Ⱦ��","hyun@test.com"}
		};
//		dtm = new DefaultTableModel(rowData, columnNames);
		dtm = new DefaultTableModel(rowData, columnNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};//<�޼ҵ带 �������̵��� ���! �⺻���� true�� ������! �޼ҵ� �ϳ������� ����� ���ŷο�ϱ� anonymous inner class�� ���. 
				//<��� �������� �߰� ���� ����.
				//<�Ű������� ���ʹ� ���� ������ ���� �ʴ¤��٤���������������������arrayList�� ���ٰ���..
		//<Ŭ���ؼ� Ư������ �������� ���̺��� ���� �ö󰡾��Ѵ�=>�����°� JTable�� �����̹Ƿ� �׶� �ν��Ͻ� ������ ���� ������ִ°� ����.
		//<�ٵ� ������ ���� �־��ִϱ�?????
		//<��ư�� �߰������� ���� �����ϴ°�ü�� ��ư���� ���οö󰡾� ��ư�� ���� �־�����
		
		
		//2.�����͸� �����ִ� View Ŭ���� ����.
		jt=new JTable(dtm);//<�����ʹ� ���� �����ϴ� view�� �ȴ�.
		
		//���̺� �÷��� ũ�� ���� :�÷��� �ϳ��� ���̸� �����ϸ� ���� ��� �÷��� ������ ũ�⸦ ����޴´�. 
		//<�ϳ��� �ٲٸ� �׾Ʒ� �ش��÷��� �� �Ȱ��� ����ȴ�.���̺��� 0��° ���� ������ ����
		//<�÷���ü�� ��� ����..!  getColumnModel()  =>javax.swing.JTable�� ����.
		//< getColumn(Object identifier)  
		//�÷�ũ�� ���� 1)�÷��� ��´�.
		TableColumn tc =jt.getColumnModel().getColumn(0);
		//�÷�ũ�� ���� 2)�÷��� ũ�� ����.
		tc.setPreferredWidth(30);
		
		//���̺� ���� ���� ����
		jt.setRowHeight(25);//< setRowHeight(int rowHeight)  
		
		//����Ŭ������ �÷����� ������ �����ѵ�, �������ؼ�~!~!�� �̵�~!=>���̺����� ���콺 �̺�Ʈ�� �����.inner class�� �̵�.
		
		jt.getColumnModel().getColumn(1).setPreferredWidth(100);
		jt.getColumnModel().getColumn(2).setPreferredWidth(200);
		jt.getColumnModel().getColumn(3).setPreferredWidth(170);//<�� �ջ��� ���̴� window�� ����~!=500
		
		btnAdd = new JButton("������ �߰�");
		
		//Column�� �̸��� ScrollBar�� ����� �� �ֵ��� JScrollPane�� ��ġ
		JScrollPane jsp=new JScrollPane(jt);
		JPanel jp = new JPanel();
		jp.add(btnAdd);
		
		//��ġ
		add("Center",jsp);
		add("South",jp);
		
		//�̺�Ʈ ���
		btnAdd.addActionListener(this);//<��ǲ���̾�α׷� �����͸� �߰��Ұ�.
		UseJTable.TableEvt te=this.new TableEvt();//inner class�� ��üȭ~!~!
		jt.addMouseListener(te);//inner class�� ��üȭ..?
//		jt.addMouseListener(new this.innerclass��?);
		//jtable�� ���� ��� method��? ������ ���� �˶�~! jt.getSelectedRow();
		
		setBounds(100,100,500,300);
		setVisible(true);//<window component�� �ʼ�~!~!����ȭ������ ������ �������� �ʴ´�.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}//UseJTable
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String inputData=JOptionPane.showInputDialog("������ �Է�\n��)��ȣ, �̸�, �ּ�, �̸���");
		
		String[] tempData=inputData.split(",");
				//<String Toknizer�� Split�� ����.�̴�� ���� ������ �߸����°����� ����
		//����
		if(tempData.length !=4 ) {
			JOptionPane.showMessageDialog(this, "�Է� �������� ���´� \n��ȣ,�̸�,�ּ�,�̸��� �̾�� �մϴ�.",
					"�Է� ����", JOptionPane.ERROR_MESSAGE);
			return;//<void�϶� ������ ȣ��Ȱ����� �׳� ������������ ���ư� ����~!~!
		}//end if
		
		//�Էµ� �����͸� ȭ�鿡 �����ֱ� ���� DefaultTableModel�� �߰�=>(���߰�)
		//<record,row,tuple,�߰�~!~!
		//< addRow(Vector rowData)  
		dtm.addRow(tempData);
		//<String[]�� ������ �������? Object��??�־ tempdata! object�� String�� �θ��̹Ƿ� ���°�~!~!�ڽ��̴ϱ� ����~!
		//<Default table model�� �ִ°�~!~!

		//<�÷��� ���̸� �ٲٰ� ������ view�� Jtable�� �������� jt�ʿ��� �ؾ��Ѵ�.(��������)
		//<setPreferredWidth(int preferredWidth) //Ư�� �÷��� ��ü�� �޾ƿ;��Ѵ�.
		//<�÷��� ��ü�� �����ϴ°�javax.swing.table.TableColumn �ε�, �ε����� ����
		
	}//actionPerformed
	////////////////////////////////inner class ����////////////////////////////////////////////////
	public class TableEvt extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent me) {//�̺�Ʈ�� ���ϴ°� �ƴ����� me
//			System.out.println("�༱�� : "+jt.getSelectedRow()+",������ : "+jt.getSelectedColumn());
			//<������ �÷����� ��� ���� �˼� �ִ�.
//			System.out.println(jt.getValueAt(jt.getSelectedRow(), jt.getSelectedColumn()));
			//<�����~!
//			String selectedValue=jt.getValueAt(jt.getSelectedRow(), jt.getSelectedColumn());//�����Ŷ��ٸ��� �����ϱ�
			//<getValueAt �� ��ȯ���� object�� ���� String�� ������. �θ�� �ڽ��� ������ �˼� �����ϱ�~! ������.
			String selectValue=(String)jt.getValueAt(jt.getSelectedRow(), jt.getSelectedColumn());//��?��ȯ
			//<�ϳ��� �����µ� ��簪�� ���ʹ�...!
//			String selectValue0=(String)jt.getValueAt(jt.getSelectedRow(), 0);
//			String selectValue1=(String)jt.getValueAt(jt.getSelectedRow(), 1);
//			String selectValue2=(String)jt.getValueAt(jt.getSelectedRow(), 2);
//			String selectValue3=(String)jt.getValueAt(jt.getSelectedRow(), 3);//�̷��� �ص� ����� ����!
			//<� �ȵǴµ� ���� for�� �� �ʿ������ ����.
			//<�ߺ��ڵ尡 ���� for������=>
			StringBuilder viewData=new StringBuilder();
			int selectedRow=jt.getSelectedRow();
			int columnCount=jt.getColumnCount();
			
			//������ �� ����
			int flag=JOptionPane.showConfirmDialog(ujt, "\"��\"�� ������ ��ȸ, \"�ƴϿ�\"�� ������ ������ �����մϴ�.");
			switch (flag) {
			case JOptionPane.OK_OPTION:
				for(int i=0; i<columnCount; i++) {
					viewData.append(jt.getValueAt(selectedRow, i)).append("\n");
				}//end for
				JOptionPane.showMessageDialog(ujt, viewData);
				break;
			case JOptionPane.NO_OPTION:
				switch (JOptionPane.showConfirmDialog(ujt, "���� �����ϼ��ڽ��ϱ�?")) {//����� ������ �ݵ�� ����� �ؾ��Ѵ�.
				case JOptionPane.OK_OPTION: 
					dtm.removeRow(selectedRow);
				}//end switch
			}//end switch
			
//			for(int i=0; i<columnCount; i++) {
//				viewData.append(jt.getValueAt(selectedRow, i)).append("\n");
//			}//end for
////////���� �Űܼ� �ּ�
//			JOptionPane.showMessageDialog(/*�θ� ���۳�Ʈ ��ü=>���⼭ this�� mouseAdapter�� �Ǿ�x,
//			view�� �ƴ϶� window�� �θ�ϱ� jt�� ������ �ùٸ� ����� �ƴϴ�.
//			������ ��üȭ�� �ؼ� �־��ָ� �ȴ�...null�ص� �Ǳ�ȴ�...���߿� �ѹ��� ������ ������..*/ujt, viewData);
			
			//<Ŭ���ϸ� �ߴϱ� ��� ���Ƶΰ�...����Ŭ���������
			//<isCellEditable(int row,int column) ������ ������� ���������ϴٰ� true�� ���´�.
			//�� ture�� �����µ� ������ false�� ���������Ѵ�.=>�������� DefaultTableModel
			
			//javax.swing.table.DefaultTableModel�� �ִ� method: removeRow(int row)  ������ �� ����
			
			
		}//mouseClicked
		
	}//class
	////////////////////////////////inner class ��//////////////////////////////////////////////////
	public static void main(String[] args) {
		new UseJTable();
		//<�ν��Ͻ�ȭ�� ��ü�� �����ϱ� ���ؼ� �Ѱ� �����ڶ�°� ȣ��ǰ� ��ü�� �׷� �ڱⰡ ������ �ִ� �ν��Ͻ� ������ Heap�� �ø��� ����ù�ּҸ� ��ȯ.
	}//main

}//class
