package day1210;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 일반컴포넌트와 LayoutManager의 사용.
 * @author owner
 */

//1.Window Component 상속(사용자에게 보여지는 일)
@SuppressWarnings("serial")
public class UseBorderLayout extends Frame{

	public UseBorderLayout() {
		//<default Construct
//		super();//<부모의 기본생성자를 불러준다.
		super("BorderLayout 연습");//<부모의 매개변수 있는 생성자를 부른다.
		//<부모생성자에 값을 넣어주는것으로 title bar에 원하는 제목을 줄 수 있다.
		
		//2.사용할 일반 컴포넌트를 생성.
		TextField tfNorth = new TextField("North");
		//<생성자가 있기 떄문에 만들때에 이렇게 만들어준다. 한줄입력text창이 생길것.
		Label lblEast = new Label("East");
		TextArea taCenter = new TextArea("Center");
		Label lblWest = new Label("West");
		Choice choSouth = new Choice();
		choSouth.add("South");
		
		//3.배치관리자 설정 : Window Component인 Frame, Dialog는 BorderLayout이
		//기본 설정 된다.
		setLayout(new BorderLayout());//<있으나 마나.기본이라 패스 가능
		
		//4.컴포넌트의 배치관리자를 사용하여 배치
		//add("배치되는 위치", 컴포넌트); add(상수, 컴포넌트); add(컴포넌트, 상수);
		//(( =>오버로딩~!~! 같은이름의 method 매개변수만 다른 여러개인것
		add("North",tfNorth);//<문자열 상수 문자열 리터널은 문자열저장소에 저장되는데
		//문자열 상수를 사용하여 배치.
		add("Center",taCenter);
		//Center만 배치하면 테두리인 North,West,South,East는 자리가 사라진다. 
		//Constant(Field)를 사용하여 배치
		add(BorderLayout.WEST,lblWest);
		add(BorderLayout.EAST,lblEast);
		add(BorderLayout.SOUTH,choSouth);
		
		//5.Window의 크기 설정.
		setSize(400, 400);
		//<아무리 실행해도 사용자에게 보이지 않는다.
		
		//6.사용자에게 보여주기(가시화)
		setVisible(true);
		//종료(딱한번만)
		addWindowListener(new WindowAdapter() {
			//anonymous inner class로 종료.이름이 없는 클래스.
			//Annotation
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		}/*anonymous inner class종료*/);
		
	}//UseBorderLayout
	public static void main(String[] args) {
		new UseBorderLayout();
	}//main
	
}//class
