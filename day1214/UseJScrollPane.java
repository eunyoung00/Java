package day1214;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * JScrollPane)
 * JScrollPane�� ���.
 * @author owner
 */
@SuppressWarnings("serial")
public class UseJScrollPane extends JFrame {
	
	public UseJScrollPane() {
		super("��ũ�� �ٰ� ���� ��ü");
		
		JTextArea jta = new JTextArea();//<������ ũ�⸦ �Ѿ�� ��ũ�ѹٰ� ������ �ʴ´�.
		//JTextArea�� �ۼ��� ���� jtaȭ���� ���� �����ϸ� �� ����.
		jta.setLineWrap(true);//<�ٹٲ� �޼ҵ�=>�ܾ� ������ �ȵǰ� �ѱ��ھ� �������µ�, �ѱ��ڸ� ����������~!
		//���� ����Ǹ� �ܾ ��ȣ�ϸ鼭 ���� ����.(�ѱ��� �������� �ʴ´�. ���)
		jta.setWrapStyleWord(true);
		
		//JTextArea�� ScrollBar ����~!
		//1.JScrollPane ����
		JScrollPane jsp =new JScrollPane(jta);
		//2.��ġ
//		add("")
		
		add("Center",jsp);//JScrollPane�� �־��ش�.
//		add("Center",jta);
		
		setBounds(100, 100, 300, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//UseJscrollPane
	
	public static void main(String[] args) {
		new UseJScrollPane();
	}//main

}//class
