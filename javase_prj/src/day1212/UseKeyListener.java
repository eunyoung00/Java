package day1212;

import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/** 
 * Keyboard Event ó��
 * @author owner
 */

//1.Window Component ���, �̺�Ʈ ó�� ������ ����
@SuppressWarnings("serial")
public class UseKeyListener extends Frame implements KeyListener{

	public static final int ENTER=10;
	//2.�̺�Ʈ�� �����ִ�(����) ������Ʈ ����
	private TextField tf;
	private Label lbl;
	
	public UseKeyListener() {
		super("KeyListener-Ű���� �̺�Ʈ ����");
		//3.������Ʈ ����
		tf=new TextField();
		lbl=new Label("���â",Label.CENTER);//<,Alignment����
		
		//4.��ġ
		//<borderLayout�� �⺻�̶� ���� ��ġ�����ڸ� �ٲپ��� �ʿ䰡 ����
		add("North",tf);
		add("Center",lbl);
		
		//5.������Ʈ�� �̺�Ʈ�� ���
		tf.addKeyListener(this);
		
		//6.�������� ũ�� ����
		setBounds(200, 200, 400, 150);
		//7.����ڿ��� �����ֱ�(����ȭ)
		setVisible(true);
		//8.Window ���� ó��
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}//windowClosing
		});//addWindowListener
	}//UseKeyListener

	@Override
	public void keyTyped(KeyEvent ke) {
		//2.Ű�� ���� ������ ���޵Ǵ� ����. ����Ű�� ������ ���ڸ� �� �� �� �ִ�.
//		System.out.println("keyTyped");
		
	}//keyTyped

	@Override
	public void keyPressed(KeyEvent ke) {
		//1.Ű������ Ű�� ������ �����̾ Ű�������� �� �� ����.
//		System.out.println("keyPressed");
	}//keyPressed

	@Override
	public void keyReleased(KeyEvent ke) {
		//3.����Ű�� ������ �����ϰ� �ٽ� �ö���� ����. ����Ű�� ������ �� �� �ִ�.
//		System.out.println("keyReleased");
		
		//����Ű�� ���ڿ� �ڵ尪�� ���
		char inputKey=ke.getKeyChar();
		int inputCode=ke.getKeyCode();//<keycode�� ��! �����ڵ尡 �ƴ�
		//keycode�� Ű���� Ű�� ������ : unicode�� �ٸ���, �������� ���´�.
		//<(�빮��=�ҹ���)
		
		//��¿� Label�� �Ѹ���.
//		System.out.println(inputKey+" "+inputCode);
		StringBuilder output=new StringBuilder();
		output.append("����Ű�� ����: ").append(inputKey)
				.append(", ����Ű�� Ű�ڵ�: ").append(inputCode);
		
		lbl.setText(output.toString());
		
		switch (inputCode) {
		case ENTER/*KeyEvent.VK_ENTER*/:
			//JDK 1.7���� �߻��� ���� :TextField,TextArea�� 
			//setText("")�� �ٷ� ����ϸ� �ʱ�ȭ ���� �ʴ´�.
			//<�ذ��Ϸ��� �� ���� �ʱ�ȭ.
			tf.getText();//���� �ѹ� �� �� �ʱ�ȭ�� �ϸ� �ʱ�ȭ�� �� �ȴ�.
			tf.setText("");//<mt�� �ȵǴµ�, setText�� ����..
//			tf.setText("");
//			tf.setText("");//<������ setText�ص� get������ �ҿ����.

			break;
		case 27 /*KeyEvent.VK_ESCAPE*/: 
			dispose();
		}//end switch
		
//		if(ke.getKeyCode()==10) {
//			tf.setText("");
//		}
	}//keyReleased
	
	//<������ ���� �޼ҵ� �ٸ���°� �����̹Ƿ� inner,is a,has a������ ...

	public static void main(String[] args) {
		new UseKeyListener();
	}//main
}//class
