package day0111;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JButtonTestView extends JFrame{
	
	private JButton jbt1,jbt2,jbt3,jbt4,jbt5,jbt6,jbt7,jbt8,jbt9,jbt10;//=>�迭�� �̿��ϸ� �ѹ���?
	
	public JButtonTestView() {
		jbt1=new JButton("������");
		jbt2=new JButton("�ڿ���");
		jbt3=new JButton("������");
		jbt4=new JButton("����ö");
		jbt5=new JButton("������");
		jbt6=new JButton("������");
		jbt7=new JButton("������");
		jbt8=new JButton("������");
		jbt9=new JButton("�����");
		jbt10=new JButton("������");
		
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(5, 2));
		panel.add(jbt1);
		panel.add(jbt2);
		panel.add(jbt3);
		panel.add(jbt4);
		panel.add(jbt5);
		panel.add(jbt6);
		panel.add(jbt7);
		panel.add(jbt8);
		panel.add(jbt9);
		panel.add(jbt10);
		
		add("Center",panel);
		
		JButtonTestViewEvt jtve=new JButtonTestViewEvt(this);
		jbt1.addActionListener(jtve);
		jbt2.addActionListener(jtve);
		jbt3.addActionListener(jtve);
		jbt4.addActionListener(jtve);
		jbt5.addActionListener(jtve);
		jbt6.addActionListener(jtve);
		jbt7.addActionListener(jtve);
		jbt8.addActionListener(jtve);
		jbt9.addActionListener(jtve);
		jbt10.addActionListener(jtve);
		
		addWindowListener(jtve);
		
		setBounds(100, 100, 300, 300);
		setVisible(true);
		
	}//JButtonTestView

	public static void main(String[] args) {
		new JButtonTestView();
	}//main

}//class
