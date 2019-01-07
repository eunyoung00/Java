package day0107;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HomeWorkEvt extends WindowAdapter implements ActionListener {

	private HomeWorkView hwv;
	
	public HomeWorkEvt(HomeWorkView hwv) {
		this.hwv=hwv;
		
	}//HomeWorkEvt
	
	@Override
	public void windowClosing(WindowEvent we) {
		hwv.dispose();
	}//windowClosing
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==hwv.getJbtOk()) {
			
		}//end if
		
	}//actionPerformed

}
