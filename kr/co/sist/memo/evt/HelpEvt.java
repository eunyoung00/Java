package kr.co.sist.memo.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import kr.co.sist.memo.view.Help;

public class HelpEvt extends WindowAdapter implements ActionListener{

	private Help hw;
	
	public HelpEvt(Help hw) {
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
	}//windowClosing

}//class
