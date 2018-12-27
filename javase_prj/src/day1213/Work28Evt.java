package day1213;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Work28Evt extends WindowAdapter implements ActionListener{

	private Work28 hw;
	
	public Work28Evt(Work28 hw) {
		this.hw=hw;
	}//Work28Evt
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==hw.getBtnOk()) {
			hw.dispose();
		}//end if
	}//actionPerformed
	
	@Override
	public void windowClosing(WindowEvent e) {
		hw.dispose();
	}

}//class
