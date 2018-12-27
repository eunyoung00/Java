package day1210;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * �Ϲ�������Ʈ�� LayoutManager�� ���.
 * @author owner
 */

//1.Window Component ���(����ڿ��� �������� ��)
@SuppressWarnings("serial")
public class UseBorderLayout extends Frame{

	public UseBorderLayout() {
		//<default Construct
//		super();//<�θ��� �⺻�����ڸ� �ҷ��ش�.
		super("BorderLayout ����");//<�θ��� �Ű����� �ִ� �����ڸ� �θ���.
		//<�θ�����ڿ� ���� �־��ִ°����� title bar�� ���ϴ� ������ �� �� �ִ�.
		
		//2.����� �Ϲ� ������Ʈ�� ����.
		TextField tfNorth = new TextField("North");
		//<�����ڰ� �ֱ� ������ ���鶧�� �̷��� ������ش�. �����Է�textâ�� �����.
		Label lblEast = new Label("East");
		TextArea taCenter = new TextArea("Center");
		Label lblWest = new Label("West");
		Choice choSouth = new Choice();
		choSouth.add("South");
		
		//3.��ġ������ ���� : Window Component�� Frame, Dialog�� BorderLayout��
		//�⺻ ���� �ȴ�.
		setLayout(new BorderLayout());//<������ ����.�⺻�̶� �н� ����
		
		//4.������Ʈ�� ��ġ�����ڸ� ����Ͽ� ��ġ
		//add("��ġ�Ǵ� ��ġ", ������Ʈ); add(���, ������Ʈ); add(������Ʈ, ���);
		//(( =>�����ε�~!~! �����̸��� method �Ű������� �ٸ� �������ΰ�
		add("North",tfNorth);//<���ڿ� ��� ���ڿ� ���ͳ��� ���ڿ�����ҿ� ����Ǵµ�
		//���ڿ� ����� ����Ͽ� ��ġ.
		add("Center",taCenter);
		//Center�� ��ġ�ϸ� �׵θ��� North,West,South,East�� �ڸ��� �������. 
		//Constant(Field)�� ����Ͽ� ��ġ
		add(BorderLayout.WEST,lblWest);
		add(BorderLayout.EAST,lblEast);
		add(BorderLayout.SOUTH,choSouth);
		
		//5.Window�� ũ�� ����.
		setSize(400, 400);
		//<�ƹ��� �����ص� ����ڿ��� ������ �ʴ´�.
		
		//6.����ڿ��� �����ֱ�(����ȭ)
		setVisible(true);
		//����(���ѹ���)
		addWindowListener(new WindowAdapter() {
			//anonymous inner class�� ����.�̸��� ���� Ŭ����.
			//Annotation
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		}/*anonymous inner class����*/);
		
	}//UseBorderLayout
	public static void main(String[] args) {
		new UseBorderLayout();
	}//main
	
}//class
