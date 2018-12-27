package day1214;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * JScrollPane)
 * JScrollPane의 사용.
 * @author owner
 */
@SuppressWarnings("serial")
public class UseJScrollPane extends JFrame {
	
	public UseJScrollPane() {
		super("스크롤 바가 없는 객체");
		
		JTextArea jta = new JTextArea();//<정해진 크기를 넘어가도 스크롤바가 생기지 않는다.
		//JTextArea내 작성한 글이 jta화면의 끝에 도달하면 줄 변경.
		jta.setLineWrap(true);//<줄바꿈 메소드=>단어 보존이 안되고 한글자씩 떨어지는데, 한글자만 떨어지려면~!
		//줄이 변경되면 단어를 보호하면서 줄을 변경.(한글은 지원되지 않는다. 영어만)
		jta.setWrapStyleWord(true);
		
		//JTextArea에 ScrollBar 설정~!
		//1.JScrollPane 생성
		JScrollPane jsp =new JScrollPane(jta);
		//2.배치
//		add("")
		
		add("Center",jsp);//JScrollPane을 넣어준다.
//		add("Center",jta);
		
		setBounds(100, 100, 300, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//UseJscrollPane
	
	public static void main(String[] args) {
		new UseJScrollPane();
	}//main

}//class
