package day1217;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Work29 extends JFrame {
	private List<stdVO> liststu;
	private String inputnum,stu;
	
	public Work29() {
			
	}//Work29
	
	public void selectNum() {
		inputnum=JOptionPane.showInputDialog("메뉴선택\n1.입력 2.출력 3.종료");
		
		if(inputnum.equals("1")) {//입력
			stu=JOptionPane.showInputDialog("데이터 입력\n예) 이름, 자바점수, 오라클점수");
			String[] tempData=stu.split(",");

			if(tempData.length !=3 ) {//컴마 2개로 데이터가 나누어있지 않으면,다시!
				JOptionPane.showMessageDialog(this, "입력 데이터의 형태는 \n이름, 자바점수, 오라클점수 이어야 합니다.",
						"입력 오류", JOptionPane.ERROR_MESSAGE);
				selectNum();
			}
//			liststu.set(0, tempData[0]);//리스트에 저장하는~~!아...리스트가 아니라, vo class에 담아두었다가 꺼내면된다.
//			liststu.add(tempData[0]+"\t"+tempData[1]+"\t"+tempData[2]);
//			showInput();
		}else if(inputnum.equals("2")) {//출력
			//1.JTextArea 생성( 행수, 컬럼수)
			JTextArea jta = new JTextArea(10,40);
			jta.setEditable(false);
			if(liststu.equals(0)) {
				JOptionPane.showMessageDialog(this, "데이터가 없습니다.");
			}else{
				jta.append(String.valueOf(liststu));
			}
			//2.
			JScrollPane jsp=new JScrollPane(jta);
			//3.MessageDialog의 두번쨰 매개변수에 컴포넌트를 할당
			JOptionPane.showMessageDialog(null, jsp);
		}else if(inputnum.equals("3")) {

		}else{
			JOptionPane.showMessageDialog(this, "해당하지 않는 숫자입니다.","입력 오류", JOptionPane.ERROR_MESSAGE);
		}//end else
		
	}//selectNum
	
	public static void main(String[] args) {
		Work29 hw=new Work29();
		hw.selectNum();
	}//main

}//class
