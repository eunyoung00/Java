package day1214;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Icon class�� ����� �̹��� ���
 * @author owner
 */
@SuppressWarnings("serial")
public class UseImageIcon extends JFrame{

	public UseImageIcon() {
		super("Image Icon ���");
		
		ImageIcon ii1 = new ImageIcon("C:/dev/workspace/javase_prj/src/day1214/Images/img4.gif");
		ImageIcon ii2 = new ImageIcon("C:/dev/workspace/javase_prj/src/day1214/Images/img5.gif");
		ImageIcon ii3 = new ImageIcon("C:/dev/workspace/javase_prj/src/day1214/Images/img6.png");
		//gif�� �ȴ�~!
		
		JButton btn1=new JButton("��ư1",ii1);
		JButton btn2=new JButton("��ư2",ii2);
		JButton btn3=new JButton("��ư3",ii3);
		
		//Tooltip Text ����   =>���콺�� �÷����� ���������� ���� �ٴ°�
		btn1.setToolTipText("��ư1");
		btn2.setToolTipText("��ư�� Ŭ���ϼ���.");
		btn3.setToolTipText("������ �ݿ��� �Դϴ�.");
		
		//RollOver icon  =>���콺�� �÷����� �ٲ�°�
		btn2.setRolloverIcon(ii3);
		
		//    =>������ ��ġ�� �����Ҽ� �ִµ� 9����ؼ� ������ �ڸ����� ����
		//Left Center Right  =>Horizontal 
		//��ư�� �� ��ġ ����
		//������ġ ���� : LEFT, CENTER, RIGHT
		btn1.setHorizontalTextPosition(JButton.CENTER);
		btn2.setHorizontalTextPosition(JButton.CENTER);
		btn3.setHorizontalTextPosition(JButton.CENTER);
		//������ġ�� ���� : TOP,CENTER,BOTTOM
		btn2.setVerticalTextPosition(JButton.CENTER);
		btn3.setVerticalTextPosition(JButton.BOTTOM);
		
		setLayout(new GridLayout(1, 3));
		add(btn1);
		add(btn2);
		add(btn3);
		
		setBounds(200, 200, 900, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//addWindowListener���� �ʾƵ� ����
		//�׳ɴݾƵ� �������� ������ ������
	}//UseImageIcon
	
	public static void main(String[] args) {
		new UseImageIcon();//��ü ����?
	}//main

}//class
