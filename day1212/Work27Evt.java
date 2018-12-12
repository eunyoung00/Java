package day1212;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Work27Evt extends WindowAdapter implements ActionListener,ItemListener{

	private Work27 hw;
	
	public Work27Evt(Work27 hw) {
		this.hw=hw;
	}//Work27Evt
	
	@Override
	public void windowClosing(WindowEvent e) {
		hw.dispose();
	}//windowClosing
	
	
	@Override
	//버튼 이벤트
	public void actionPerformed(ActionEvent ae) {
		//추가가 눌리면 이름 나이 주소를 list에 추가하고 초기화
		//null이 아닐때 추가~!~!~!~
		String label=ae.getActionCommand();
		if(label.equals("추가")) {
			if(!hw.getTfName().getText().equals("") && !hw.getTfAge().getText().equals("")
						&& !hw.getTfAdress().getText().equals("")) {
				hw.getList().add(hw.getTfName().getText()+"/"+
						hw.getTfAge().getText()+"/"+
						hw.getTfAdress().getText());
				//초기화
				hw.getTfName().setText("");
				hw.getTfAge().setText("");
				hw.getTfAdress().setText("");
			}//end if
		}//end if
		
		//변경이 눌리면 아이템이 선택되었는지 확인후 TF의 값으로 수정
		if(label.equals("변경")) {
			List templ = hw.getList();
//			String[] strlist=templ.getSelectedItem().split("/");
			int selectedIndex=templ.getSelectedIndex();
			//값이 선택되었을때
			if(!templ.getSelectedItem().equals("")) {
				//tf의 값으로 변경
//				System.out.println(strlist[0]);//전
//				System.out.println(hw.getTfName().getText());//후
				if(!hw.getTfName().getText().equals("") && !hw.getTfAge().getText().equals("")
						&& !hw.getTfAdress().getText().equals("")) {
					templ.remove(selectedIndex);
					
					//해당 아이템 변경.
					hw.getList().add(hw.getTfName().getText()+"/"+
							hw.getTfAge().getText()+"/"+
							hw.getTfAdress().getText(),selectedIndex);
				}//end if
			}//end if

			//초기화
			hw.getTfName().setText("");
			hw.getTfAge().setText("");
			hw.getTfAdress().setText("");
		}//end if
		
		//삭제가 눌리면 선택되었는지 확인후 값과 일치하는 아이템을 삭제
		if(label.equals("삭제")) {
			List templ = hw.getList();
			String[] strlist=templ.getSelectedItem().split("/");
			int selectedIndex=templ.getSelectedIndex();
			//값이 선택되었을때
			if(!templ.getSelectedItem().equals("")) {
				//값과 일치하는지 비교한 후에
				if(strlist[0].equals(hw.getTfName().getText())&&
						strlist[1].equals(hw.getTfAge().getText())&&
						strlist[2].equals(hw.getTfAdress().getText())) {
					//해당 아이템 지우기
					templ.remove(selectedIndex);
				}//end if
			}//end if
			//초기화
			hw.getTfName().setText("");
			hw.getTfAge().setText("");
			hw.getTfAdress().setText("");
		}//end if
		
		//닫기가 눌리면 프로그램을 종료한다.
		if(label.equals("닫기")) {
			hw.dispose();
		}//end if
	}//actionPerformed

	@Override
	//리스트 이벤트
	public void itemStateChanged(ItemEvent ie) {
		if(ie.getSource()==hw.getList()) {
			//리스트의 아이템을 클릭하면 선택한 값이 TF에 입력됨
			List templ = hw.getList();
//			System.out.println(hw.getList().getSelectedItem());
			String[] strlist=templ.getSelectedItem().split("/");
			
			hw.getTfName().setText(strlist[0]);
			hw.getTfAge().setText(strlist[1]);
			hw.getTfAdress().setText(strlist[2]);
		}//end if
	}//itemStateChanged

}
