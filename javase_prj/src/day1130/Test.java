package day1130;

import java.awt.Dialog;
import java.awt.Frame;

public class Test extends Dialog{
//Implicit super constructor Dialog() is undefined for default constructor.
//	public Test() {
//		super();//���̾�α׿��� �θ�����ڰ� ���? Error
	//�θ�Ŭ������ �⺻�����ڿ� �θ������?super?�� ���ٸ� API�� ���� ���� ������ �� ã�Ƴ־�?
//	}
	
	public Test() {
		super(new Frame(),"���̾�α�",true);
		//����ū â�� ������/ ������ â�� ���̾�α� / ���̾�α�â�� ������ �θ�â�� �۵��ȵǴ°� modal, �Ǵ°� ��modal
	}

	
}
