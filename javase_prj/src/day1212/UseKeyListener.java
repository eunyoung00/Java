package day1212;

import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/** 
 * Keyboard Event 처리
 * @author owner
 */

//1.Window Component 상속, 이벤트 처리 리스너 구현
@SuppressWarnings("serial")
public class UseKeyListener extends Frame implements KeyListener{

	public static final int ENTER=10;
	//2.이벤트와 관련있는(사용될) 컴포넌트 선언
	private TextField tf;
	private Label lbl;
	
	public UseKeyListener() {
		super("KeyListener-키보드 이벤트 연습");
		//3.컴포넌트 생성
		tf=new TextField();
		lbl=new Label("출력창",Label.CENTER);//<,Alignment정렬
		
		//4.배치
		//<borderLayout이 기본이라 굳이 배치관리자를 바꾸어줄 필요가 없다
		add("North",tf);
		add("Center",lbl);
		
		//5.컴포넌트를 이벤트에 등록
		tf.addKeyListener(this);
		
		//6.윈도우의 크기 설정
		setBounds(200, 200, 400, 150);
		//7.사용자에게 보여주기(가시화)
		setVisible(true);
		//8.Window 종료 처리
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}//windowClosing
		});//addWindowListener
	}//UseKeyListener

	@Override
	public void keyTyped(KeyEvent ke) {
		//2.키가 눌려 정보가 전달되는 순간. 눌린키의 정보중 문자만 를 알 수 있다.
//		System.out.println("keyTyped");
		
	}//keyTyped

	@Override
	public void keyPressed(KeyEvent ke) {
		//1.키보드의 키가 눌리는 순간이어서 키의정보를 알 수 없다.
//		System.out.println("keyPressed");
	}//keyPressed

	@Override
	public void keyReleased(KeyEvent ke) {
		//3.눌린키가 정보를 전달하고 다시 올라오는 순간. 눌린키의 정보를 알 수 있다.
//		System.out.println("keyReleased");
		
		//눌린키의 문자와 코드값을 얻어
		char inputKey=ke.getKeyChar();
		int inputCode=ke.getKeyCode();//<keycode의 값! 유니코드가 아님
		//keycode는 키보드 키의 고유값 : unicode와 다르게, 같은값이 나온다.
		//<(대문자=소문자)
		
		//출력용 Label에 뿌린다.
//		System.out.println(inputKey+" "+inputCode);
		StringBuilder output=new StringBuilder();
		output.append("눌린키의 문자: ").append(inputKey)
				.append(", 눌린키의 키코드: ").append(inputCode);
		
		lbl.setText(output.toString());
		
		switch (inputCode) {
		case ENTER/*KeyEvent.VK_ENTER*/:
			//JDK 1.7에서 발생한 버그 :TextField,TextArea는 
			//setText("")를 바로 사용하면 초기화 되지 않는다.
			//<해결하려면 꼭 얻어내고 초기화.
			tf.getText();//값을 한번 얻어낸 후 초기화를 하면 초기화가 잘 된다.
			tf.setText("");//<mt면 안되는데, setText의 버그..
//			tf.setText("");
//			tf.setText("");//<여러번 setText해도 get없으면 소용없다.

			break;
		case 27 /*KeyEvent.VK_ESCAPE*/: 
			dispose();
		}//end switch
		
//		if(ke.getKeyCode()==10) {
//			tf.setText("");
//		}
	}//keyReleased
	
	//<쓰지도 않을 메소드 다만드는건 낭비이므로 inner,is a,has a등으로 ...

	public static void main(String[] args) {
		new UseKeyListener();
	}//main
}//class
