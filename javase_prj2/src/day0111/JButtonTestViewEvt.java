package day0111;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

public class JButtonTestViewEvt extends WindowAdapter implements ActionListener{

	private JButtonTestView jtv;
	
	public JButtonTestViewEvt(JButtonTestView jtv) {
		this.jtv=jtv;
	}//JButtonTestViewEvt
	
	@Override
	public void actionPerformed(ActionEvent ae) {
//		if(ae.getSource()==)
	}//actionPerformed

}//class
