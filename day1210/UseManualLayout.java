package day1210;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ���� ��ġ)
 * �����ڰ� ������Ʈ�� ��ġ ��ġ�� ũ�⸦ �����ϴ� ��ġ���.
 * @author owner
 */

//1.������ ������Ʈ ���
@SuppressWarnings("serial")
public class UseManualLayout extends Frame{

	public UseManualLayout() {
		super("���� ��ġ");
		//1.������Ʈ ����
		Label lbl = new Label();
		lbl.setText("��");
		TextField tf=new TextField();
		Button btn=new Button("Ŭ��");
		
		
		//2.��ġ������ ����(����) :BorderLayout
		setLayout(null);
		//<�̹��� label�� ũ�Ⱑ ���� �Ⱥ���
		//3.��ġ(��ǥ�� ũ��)
		//������Ʈ�� ��ǥ,ũ�� ����
		lbl.setLocation(10,35);//��ġ��ǥ
		lbl.setSize(80,20);//��ġũ��
//		tf.setBounds(50,100,120,25);//X,Y,w,h
		tf.setBounds(50,100,120,55);//X,Y,w,h//<���̰� �������ٰ� �����٤���
		btn.setBounds(250,200,120,23);//X,Y,w,h
		add(lbl);//Frame�� ��ġ
		add(tf);//Frame�� ��ġ
		add(btn);//Frame�� ��ġ
		//<����� ũ�� �ϳ� ��..��ġ�����ڸ� �������� �ʾұ� ����.
		
		//4.�������� ��ǥ ����
//		setLocation(100,200);
		//5.�������� ũ�� ����
//		setSize(500,600);
		setBounds(200,100,400,250);//<�����ϱ��Ѵ�.//ũ�⸦ �ø��ų� ���ϼ� �ִ� .�̶����� method
		setResizable(false);//<windowâ�� ũ�⺯���� ���´�.
		
		
		//6.����ڿ��� �����ֱ�
		setVisible(true);
		//7.���� ó��
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
		
		//<ũ�⺯��� ������ġ�� ������ ������ �ʴ´�.
		//<������ �̻��� �ʾ� �����϶�� �������.setResizable(false);
		//<�ڵ���ġ�� ���� �������Ѵ�..?
	}//UseManualLayout
	
	public static void main(String[] args) {
		new UseManualLayout();
	}//main

}//class
