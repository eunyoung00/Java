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
	//��ư �̺�Ʈ
	public void actionPerformed(ActionEvent ae) {
		//�߰��� ������ �̸� ���� �ּҸ� list�� �߰��ϰ� �ʱ�ȭ
		//null�� �ƴҶ� �߰�~!~!~!~
		String label=ae.getActionCommand();
		if(label.equals("�߰�")) {
			if(!hw.getTfName().getText().equals("") && !hw.getTfAge().getText().equals("")
						&& !hw.getTfAdress().getText().equals("")) {
				hw.getList().add(hw.getTfName().getText()+"/"+
						hw.getTfAge().getText()+"/"+
						hw.getTfAdress().getText());
				//�ʱ�ȭ
				hw.getTfName().setText("");
				hw.getTfAge().setText("");
				hw.getTfAdress().setText("");
			}//end if
		}//end if
		
		//������ ������ �������� ���õǾ����� Ȯ���� TF�� ������ ����
		if(label.equals("����")) {
			List templ = hw.getList();
//			String[] strlist=templ.getSelectedItem().split("/");
			int selectedIndex=templ.getSelectedIndex();
			//���� ���õǾ�����
			if(!templ.getSelectedItem().equals("")) {
				//tf�� ������ ����
//				System.out.println(strlist[0]);//��
//				System.out.println(hw.getTfName().getText());//��
				if(!hw.getTfName().getText().equals("") && !hw.getTfAge().getText().equals("")
						&& !hw.getTfAdress().getText().equals("")) {
					templ.remove(selectedIndex);
					
					//�ش� ������ ����.
					hw.getList().add(hw.getTfName().getText()+"/"+
							hw.getTfAge().getText()+"/"+
							hw.getTfAdress().getText(),selectedIndex);
				}//end if
			}//end if

			//�ʱ�ȭ
			hw.getTfName().setText("");
			hw.getTfAge().setText("");
			hw.getTfAdress().setText("");
		}//end if
		
		//������ ������ ���õǾ����� Ȯ���� ���� ��ġ�ϴ� �������� ����
		if(label.equals("����")) {
			List templ = hw.getList();
			String[] strlist=templ.getSelectedItem().split("/");
			int selectedIndex=templ.getSelectedIndex();
			//���� ���õǾ�����
			if(!templ.getSelectedItem().equals("")) {
				//���� ��ġ�ϴ��� ���� �Ŀ�
				if(strlist[0].equals(hw.getTfName().getText())&&
						strlist[1].equals(hw.getTfAge().getText())&&
						strlist[2].equals(hw.getTfAdress().getText())) {
					//�ش� ������ �����
					templ.remove(selectedIndex);
				}//end if
			}//end if
			//�ʱ�ȭ
			hw.getTfName().setText("");
			hw.getTfAge().setText("");
			hw.getTfAdress().setText("");
		}//end if
		
		//�ݱⰡ ������ ���α׷��� �����Ѵ�.
		if(label.equals("�ݱ�")) {
			hw.dispose();
		}//end if
	}//actionPerformed

	@Override
	//����Ʈ �̺�Ʈ
	public void itemStateChanged(ItemEvent ie) {
		if(ie.getSource()==hw.getList()) {
			//����Ʈ�� �������� Ŭ���ϸ� ������ ���� TF�� �Էµ�
			List templ = hw.getList();
//			System.out.println(hw.getList().getSelectedItem());
			String[] strlist=templ.getSelectedItem().split("/");
			
			hw.getTfName().setText(strlist[0]);
			hw.getTfAge().setText(strlist[1]);
			hw.getTfAdress().setText(strlist[2]);
		}//end if
	}//itemStateChanged

}
