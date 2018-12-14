package day1214;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

/**
 * JList)
 * MVC Pattern�� ��������� Component�� ���.
 * @author owner
 */
@SuppressWarnings("serial")
public class UseJList extends JFrame implements ActionListener,MouseListener/*ListSelectionListener*/{

	private JList<String> jl;  //View
	private DefaultListModel<String> dlm;  //Model
	private JLabel jlOutput;
	private JButton jb;
	
	public UseJList() {
		super("JList�� ���");
		
		dlm=new DefaultListModel<String>();
		dlm.addElement("Java SE");
		dlm.addElement("Oracle");
		dlm.addElement("JDBC");
		dlm.addElement("HTML");
		dlm.addElement("JavaScript");
		dlm.addElement("CSS");
		
		jl=new JList<String>(dlm);
		
		//ScrollBar�� ���� JList���� ScrollBar ����
		JScrollPane jsp=new JScrollPane(jl);
		
		jlOutput=new JLabel("���");
		jlOutput.setBorder(new TitledBorder("���� ������"));
		
		jb=new JButton("�Է�");
		
		add("North",jb);
//		add("Center",jl);
		add("Center",jsp);//������Ʈ�� ���� ��Ʈ�ѹ� ��ü�� ��ġ
		add("South",jlOutput);
		
		//�̺�Ʈ
		jb.addActionListener(this);
//		jl.addListSelectionListener(this);
		jl.addMouseListener(this);
		
		setBounds(100, 100, 300, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//UseJList
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String lang= JOptionPane.showInputDialog("��ǻ�� ���߰��� �� �Է�");
//		System.out.println(lang);
		//�Էµ������̹Ƿ� Model��ü�� ����Ѵ�.
		//Ȯ���� mt"", ��Ҵ� null
//		if(lang!=null && !lang.equals("")) {
//			dlm.addElement(lang);
//		}//end if//��������������
		
//		if(!lang.equals("") && lang!=null) {
//�� ������ �տ��ͽ����ϰ� �ڿ��� �����ϰԵ�. ������ ����ϸ� null�̵��µ�,lang�� �ȸ�������� �ν��Ͻ� ������ �������� �ʾƼ� 
//��ü�� ����������ʾұ� ������ Error, null�̸� �޼ҵ带 �ҷ� ���� �� �Ҽ� �ִ�...�ٵ� �տ� ���� null�϶� �޼ҵ带 �θ��� ���� Error
		//mt�϶� ==���δ� ���Ҽ� ����!
		
		if(lang!=null && !lang.equals("")) {
			dlm.addElement(lang);
		}
		
	}//actionPerformed
	
//	int i=0;//���������� �ؼ� �ϳ��϶� ���...21��� ������ �׵ڷδ� ó���� ���Ѵ�.(Error)�Ѱ谡 ����.
//	private	boolean flag;//���ҹ��ϰ� �پ��� �ִ�..
//	@Override
//	public void valueChanged(ListSelectionEvent lse) {
//		//���õ� ������(JList)�� ��(DefaultListModel)�� ���ͼ�
//		////////
////		int i=0;//���������� ��� �ʱ�ȭ�� �Ǳ⶧����
////		i++;
////		if(i%2==0) {
//		if(flag) {
//		////////
//			int idx=jl.getSelectedIndex();
//		String value=dlm.get(idx);
//		//JLabel�� �߰�
//		jlOutput.setText(value);//�� ������ �ϳ� ���� �ϳ� =>�Ҹ��� �ڹ��� ������ �����ڰ� ������ ����. 
//		//���� �ι� ����ǵ� �ѹ� ��µǵ��� ������ �ϴ°�...
////		System.out.println(value);//�� ������ �ϳ� ���� �ϳ� 2���� ��µȴ�...
//		//������ ����..?�� �˸� �Ҽ� �ִ�..���
//
//		//���õ� ���� ����
//		dlm.removeElementAt(idx);//jl.getSelectedIndex();�� ���ϸ� �� ã�� �־�� �ϱ� ������ ����Ʈ�� ������2������ 1������ ���ϼ� �ִ�.
//		//���ٴ��ϸ� ȿ��������//but 2�� ����Ǹ鼭 �ε����� ����ȴ�...Error.....
//
//		}//end if
//		flag=!flag;//���� �ȳ��� �ڵ�! boolean�� �� ����.
//	}//valueChanged


	@Override
	public void mouseClicked(MouseEvent e) {
		int idx=jl.getSelectedIndex();
		String value=dlm.get(idx);
		//JLabel�� �߰�
		jlOutput.setText(value);
		//���õ� ���� ����
		dlm.removeElementAt(idx);
	}//mouseClicked
	
	@Override
	public void mousePressed(MouseEvent e) {
	}//������
	@Override
	public void mouseReleased(MouseEvent e) {
	}//����?
	@Override
	public void mouseEntered(MouseEvent e) {
	}//Ư�������� ������
	@Override
	public void mouseExited(MouseEvent e) {
	}//���콺Ŀ���� ������������
	
	public static void main(String[] args) {
		new UseJList();
	}//main

}//class
