package day1217;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import day1217.UseJTable.TableEvt;

@SuppressWarnings("serial")
public class UseJTab extends JFrame {
	
	private JPanel tab4;
	private ImageIcon ii2;
	private JTabbedPane jtp;
	private JLabel jl4;
	
	public UseJTab() {
		super("Tab");
		
		//1.���� �߰��� �� �ִ� ��ü ����.
		jtp=new JTabbedPane();
		
		//2.�� �ǿ� �� ������Ʈ ����.
		//ó�� �ǿ� �� ������Ʈ
		ImageIcon ii=new ImageIcon("C:/dev/workspace/javase_prj/src/day1214/Images/img1.png");
		JLabel jl=new JLabel(ii);
		
		//�ι�° �ܿ� �� ������Ʈ
		JPanel jp=new JPanel();
		jp.add(new JLabel("�̸�"));//�̺�Ʈ�� �߻���Ű�� �����Ŷ� �׳� �־��־���..
		jp.add(new JTextField(30));
		jp.add(new JButton("�Է�")); 
		
		JPanel tab2=new JPanel();
		tab2.setLayout(new BorderLayout());
		
		jp.setBorder(new TitledBorder("�Է� ������"));
		
		JTextArea jta = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta);
		jsp.setBorder(new TitledBorder("���â"));
		
		tab2.add("North",jp);
		tab2.add("Center",jsp);
		
		ii2=new ImageIcon("C:/dev/workspace/javase_prj/src/day1214/Images/img6.png");
		tab4=new JPanel();
		jl4=new JLabel();
//		add()

		
		
		jtp.addTab("ó�� ��", jl);
		jtp.addTab("�ι�° ��", tab2);
		jtp.addTab("����° ��", new JButton("Ŭ��")/*new UseJTable()=>�г��̸� �����ѵ� �������̶� �ȉ��..*/);
//		jtp.add("�׹�° ��", new JOptionPane().showInputDialog("��й�ȣ�� �Է��ϼ���."));
		//�׹�° ���� ������ ��й�ȣ�� ������� showinputdialog�� �߰�, 123���� Ȯ���Ͽ� ������ �ƴϸ� ù��° ������
//		jtp.addTab("�׹�° ��", jl4);
		jtp.addTab("�׹�° ��", tab4);
		
		//��ġ
		add("Center",jtp);
		
		//�̺�Ʈ ���
		TabEvt te=this.new TabEvt();//inner class�� ��üȭ~!~!
		jtp.addMouseListener(te);
		
		setBounds(100, 100, 600, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}//UseJTab
	
////////////////////////////////inner class ����////////////////////////////////////////////////
	public class TabEvt extends MouseAdapter{
		
		@Override
		public void mouseClicked(MouseEvent me) {//�̺�Ʈ�� ���ϴ°� �ƴ����� me
			int index = jtp.getSelectedIndex();
			if(index==3) {
				String inputpass=JOptionPane.showInputDialog("��й�ȣ�� �Է��ϼ���.");
				
				if(inputpass.equals("123")) {
					tab4.add("Center", new JLabel(ii2));
//					jl4.setIcon(ii2);
				}else{
					jtp.setSelectedIndex(0);
				}//end else
			}//end if
		}//mouseClicked
	
	}//TabEvt

	public static void main(String[] args) {
		new UseJTab();
	}//main

}//class
