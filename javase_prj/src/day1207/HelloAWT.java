package day1207;

import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Window Application �ۼ�
 * @author owner
 */
//1.Window Component ���
@SuppressWarnings("serial")
public class HelloAWT extends Frame{ //<���� �� ������ .is a ����
	public HelloAWT() {
		super("AWT ����");//<�θ�Ŭ������ ������("Title bar")
		//2.����� �Ϲ� ������Ʈ ����.
		Label lblTitle = new Label("���� ����Ʈ ���ڼ���");
		TextArea ta = new TextArea("���ü���\n���� 1���� �ڶ�!!! ");
		
		//3.��ġ�����ڸ� ����Ͽ� ������Ʈ�� ��ġ
		add("North",lblTitle);//<��Ŭ������ �ƴ϶� �θ��� Ŭ������ �ִ� method ���
		add("Center",ta);
		
		//4.�������� ũ�� ����
		setSize(400, 270);//<�ȼ�//<��Ŭ������ �ƴ϶� �θ��� Ŭ������ �ִ� method ���
		
		//5.����ڿ��� �����ֱ�
		setVisible(true);//<��Ŭ������ �ƴ϶� �θ��� Ŭ������ �ִ� method ���
		
		
		addWindowListener(new WindowAdapter() {//anonymous inner class�� ����.
			@Override
			public void windowClosing(WindowEvent we) {
				//���� ������ �ν��Ͻ��� ����
//				dispose();
//				System.exit(0);//���� ����� ������...
			}//windowClosing
		});//addWindowListener
		
	}//HelloAWT
	
	
	
	public static void main(String[] args) {
		new HelloAWT();
		
		
		
	}//main
}//class
