package day1212;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author owner
 */
@SuppressWarnings("serial")
public class EventC extends Frame implements ActionListener{

	private Button btn1;
	private Button btn2;
	
	public EventC() {
		super("戚坤闘 搾嘘");
		btn1=new Button("せせせ");
		btn2=new Button("^o^");
		
		setLayout(null);
		
		btn1.setBounds(40,50,100,25);
		btn2.setBounds(160,50,100,25);
		add(btn1);
		add(btn2);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		//6.制亀酔税 滴奄 竺舛
		setBounds(200, 200, 400, 150);
		//7.紫遂切拭惟 左食爽奄(亜獣鉢)
		setVisible(true);
		//8.Window 曽戟 坦軒
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}//windowClosing
		});//addWindowListener
		
	}//EvnetC
	
	@Override
	public void actionPerformed(ActionEvent ae) {
//		if(btn1.getActionCommand()=="せせせ") {
//			System.out.println("せせせ");
//		}else if(btn2.getLabel()=="^o^"){
//			System.out.println("^o^");
//			//却陥 照��..
//		}
		
	}//actionPerformed

	public static void main(String[] args) {
		new EventC();
	}//main
}//class
