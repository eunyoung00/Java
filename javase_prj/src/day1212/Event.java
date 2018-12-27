package day1212;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class Event implements ActionListener,ItemListener{

	private DesignFriend designf;
	
	public Event(DesignFriend design) {
		this.designf=design;
	}//Event
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}//actionPerformed



	@Override
	public void itemStateChanged(ItemEvent e) {
	
	}//itemStateChanged

	
}//class
