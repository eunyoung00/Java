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
		inputnum=JOptionPane.showInputDialog("�޴�����\n1.�Է� 2.��� 3.����");
		
		if(inputnum.equals("1")) {//�Է�
			stu=JOptionPane.showInputDialog("������ �Է�\n��) �̸�, �ڹ�����, ����Ŭ����");
			String[] tempData=stu.split(",");

			if(tempData.length !=3 ) {//�ĸ� 2���� �����Ͱ� ���������� ������,�ٽ�!
				JOptionPane.showMessageDialog(this, "�Է� �������� ���´� \n�̸�, �ڹ�����, ����Ŭ���� �̾�� �մϴ�.",
						"�Է� ����", JOptionPane.ERROR_MESSAGE);
				selectNum();
			}
//			liststu.set(0, tempData[0]);//����Ʈ�� �����ϴ�~~!��...����Ʈ�� �ƴ϶�, vo class�� ��Ƶξ��ٰ� ������ȴ�.
//			liststu.add(tempData[0]+"\t"+tempData[1]+"\t"+tempData[2]);
//			showInput();
		}else if(inputnum.equals("2")) {//���
			//1.JTextArea ����( ���, �÷���)
			JTextArea jta = new JTextArea(10,40);
			jta.setEditable(false);
			if(liststu.equals(0)) {
				JOptionPane.showMessageDialog(this, "�����Ͱ� �����ϴ�.");
			}else{
				jta.append(String.valueOf(liststu));
			}
			//2.
			JScrollPane jsp=new JScrollPane(jta);
			//3.MessageDialog�� �ι��� �Ű������� ������Ʈ�� �Ҵ�
			JOptionPane.showMessageDialog(null, jsp);
		}else if(inputnum.equals("3")) {

		}else{
			JOptionPane.showMessageDialog(this, "�ش����� �ʴ� �����Դϴ�.","�Է� ����", JOptionPane.ERROR_MESSAGE);
		}//end else
		
	}//selectNum
	
	public static void main(String[] args) {
		Work29 hw=new Work29();
		hw.selectNum();
	}//main

}//class
