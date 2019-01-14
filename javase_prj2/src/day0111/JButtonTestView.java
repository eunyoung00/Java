package day0111;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JButtonTestView extends JFrame{
	
	private JButton jbt1,jbt2,jbt3,jbt4,jbt5,jbt6,jbt7,jbt8,jbt9,jbt10;//=>배열을 이용하면 한번에?
	
	public JButtonTestView() {
		jbt1=new JButton("김정윤");
		jbt2=new JButton("박영민");
		jbt3=new JButton("노진경");
		jbt4=new JButton("김희철");
		jbt5=new JButton("김정운");
		jbt6=new JButton("이재찬");
		jbt7=new JButton("이재현");
		jbt8=new JButton("공선의");
		jbt9=new JButton("김건하");
		jbt10=new JButton("오영근");
		
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
