package day1214;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Icon class를 사용한 이미지 사용
 * @author owner
 */
@SuppressWarnings("serial")
public class UseImageIcon extends JFrame{

	public UseImageIcon() {
		super("Image Icon 사용");
		
		ImageIcon ii1 = new ImageIcon("C:/dev/workspace/javase_prj/src/day1214/Images/img4.gif");
		ImageIcon ii2 = new ImageIcon("C:/dev/workspace/javase_prj/src/day1214/Images/img5.gif");
		ImageIcon ii3 = new ImageIcon("C:/dev/workspace/javase_prj/src/day1214/Images/img6.png");
		//gif도 된다~!
		
		JButton btn1=new JButton("버튼1",ii1);
		JButton btn2=new JButton("버튼2",ii2);
		JButton btn3=new JButton("버튼3",ii3);
		
		//Tooltip Text 설정   =>마우스를 올렸을때 설명한줄이 따라 붙는것
		btn1.setToolTipText("버튼1");
		btn2.setToolTipText("버튼을 클릭하세요.");
		btn3.setToolTipText("오늘은 금요일 입니다.");
		
		//RollOver icon  =>마우스를 올렸을때 바뀌는것
		btn2.setRolloverIcon(ii3);
		
		//    =>글자의 위치도 지정할수 있는데 9등분해서 각각의 자리지정 가능
		//Left Center Right  =>Horizontal 
		//버튼의 라벨 위치 변경
		//가로위치 변경 : LEFT, CENTER, RIGHT
		btn1.setHorizontalTextPosition(JButton.CENTER);
		btn2.setHorizontalTextPosition(JButton.CENTER);
		btn3.setHorizontalTextPosition(JButton.CENTER);
		//세로위치를 변경 : TOP,CENTER,BOTTOM
		btn2.setVerticalTextPosition(JButton.CENTER);
		btn3.setVerticalTextPosition(JButton.BOTTOM);
		
		setLayout(new GridLayout(1, 3));
		add(btn1);
		add(btn2);
		add(btn3);
		
		setBounds(200, 200, 900, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//addWindowListener하지 않아도 종료
		//그냥닫아도 닫히지만 여전히 실행중
	}//UseImageIcon
	
	public static void main(String[] args) {
		new UseImageIcon();//객체 생성?
	}//main

}//class
