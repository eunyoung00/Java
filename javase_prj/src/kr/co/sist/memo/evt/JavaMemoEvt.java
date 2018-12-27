package kr.co.sist.memo.evt;

import java.awt.FileDialog;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import kr.co.sist.memo.view.Help;
import kr.co.sist.memo.view.JavaMemo;
import kr.co.sist.memo.view.MemoFormat;

public class JavaMemoEvt extends WindowAdapter implements ActionListener {

	private JavaMemo jm;
	private String taNoteDate/* =null�� ������ 2���� ���ؾ��ؼ� */;// TextArea�� ������ ������ ����
	private String openPath;// ������ ���ϸ��� ����.
	private TextArea tempTa;

	public JavaMemoEvt(JavaMemo jm) {// ��ü�� �����ɶ� ���� �־���� �ʱ�ȭ���� �־���.
		this.jm = jm;
		taNoteDate = "";// 2������ ���ϱ����� ����.
		openPath = "";
		tempTa= jm.getTaNote();
	}// JavaMemoEvt

	@Override
	public void windowClosing(WindowEvent we) {
		if(!taNoteDate.equals(tempTa.getText())) {
			saveMemo();
		}//end if
		jm.dispose();
	}// windowClosing

	@Override
	public void actionPerformed(ActionEvent ae) {
		// miNew, miOpen, miSave, miNewSave, miEnd, miFormat, miHelp
		// �̺�Ʈ�� ���ؾߵ� ��ü��

		// ���� �޴������ۿ��� �̺�Ʈ�� �߻� ���� ��
		if (ae.getSource() == jm.getMiNew()) {
			// ���� ������ �� �ҰŸ� getter method�� �ʿ䰡 ���� .
			// �ּҸ� ��� ���� ���ؼ� getter method�� �ʿ��� ���̰�, ����ϴ� ����� �󺧺� ���� ����.
			newMemo();
		} // end if

		// ���� �޴� �����ۿ��� �̺�Ʈ�� �߻����� ��
		if (ae.getSource() == jm.getMiOpen()) {
			try {
				openMemo();
			} catch (FileNotFoundException e) {// JOptionPane�������� static import�� �Ҽ���
				JOptionPane.showMessageDialog(jm, "������ ������ ���� �� �����ϴ�.", "���Ͽ��� ����", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(jm, "������ ������ �о���̴��� ������ �߻��Ͽ����ϴ�.", "���Ͽ��� ����", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		} // end if

		// ���� �޴� �����ۿ��� �̺�Ʈ�� �߻����� ��
		if (ae.getSource() == jm.getMiSave()) {
			saveMemo();
		} // end if

		// �ٸ��̸����� ���� �޴� �����ۿ��� �̺�Ʈ�� �߻����� ��
		if (ae.getSource() == jm.getMiNewSave()) {
			newSaveMemo();
		} // end if

		// ���� �޴� �����ۿ��� �̺�Ʈ�� �߻����� ��
		if (ae.getSource() == jm.getMiEnd()) {
			//������� ���� ������ �ִٸ� �����ϰ� ����
//			System.out.println(taNoteDate+"/"+tempTa.getText());
			if(!taNoteDate.equals(tempTa.getText())) {
				saveMemo();
			}//end if
			jm.dispose();// <������ �׳������ϸ� �ȵȴ�.savememo�� �ذ�..�ȉ��..+����!
		} // end if

		// ���� �޴� �����ۿ��� �̺�Ʈ�� �߻����� ��
		if (ae.getSource() == jm.getMiFormat()) {
			formatDialog();
		} // end if

		// ���� �޴� �����ۿ��� �̺�Ʈ�� �߻����� ��
		if (ae.getSource() == jm.getMiHelp()) {
			helpDialog();
		} // end if

	}// actionPerformed

	/**
	 * ���� �� ���� ó�� :TextArea�� �ʱ�ȭ �Ѵ�.
	 */
	public void newMemo() {
		TextArea tempTa = jm.getTaNote();
		boolean flagNew = false;
		// ������ ������ �Ǵ�
//		taNoteDate.equals(tempTa.getText());//������ �ʿ䰡 ����?
		if (!taNoteDate.equals(tempTa.getText())) {
//			JOptionPane.showConfirmDialog(jm, "\"�������.txt\"�� ���� �Ͻðڽ��ϱ�?");
			int flag = JOptionPane.showConfirmDialog(jm, "�ٸ� �̸����� ���� �Ͻðڽ��ϱ�?");

			switch (flag) {
			case JOptionPane.OK_OPTION:
				newSaveMemo();
				break;
			case JOptionPane.NO_OPTION:
				flagNew = false;
				break;
			default:
				flagNew = true;
			}// end switch
		} // end if

		if (!flagNew) {
			tempTa.getText();// ���׶����� ���� �ѹ� ���� �;���.
			tempTa.setText("");
			// ������ �� ���Ŀ��� �б��� ������ �ʱ�ȭ
			taNoteDate = tempTa.getText();// <""�� �־��ذ͵� ����. �ٷ� ������ �ʱ�ȭ�߱� ����
			openPath = "";// <���� ���������ϱ� �ʱ�ȭ
			// �о���� ������ ��θ� �ʱ�ȭ �׷��� �������� ���� ������ �߻����� �ʴ´�.

			jm.setTitle("�޸���-����");
		} // end if
	}// newMemo

	/**
	 * txt������ ����
	 */
	public void openMemo() throws FileNotFoundException, IOException {
		//////////////// 12-20-2018 �ڵ� �߰� ����///////////////////
		// TextArea�� ����� �о�鿴�� ������ �ٸ��ٸ� ���忩�θ� ����, �۾��� �����Ѵ�.
		TextArea tempTa = jm.getTaNote();
		boolean flagOpen = false;
		if (!taNoteDate.equals(tempTa.getText())) {
			int flag = JOptionPane.showConfirmDialog(jm, openPath + "\n�� �����Ͻðڽ��ϱ�?");
//			if (!openPath.equals("")) {// �����ѹ��̶� ������~! ���ƴϸ�
//				int flag=JOptionPane.showConfirmDialog(jm, openPath+"\n�� �����Ͻðڽ��ϱ�?");

			switch (flag) {
			case JOptionPane.OK_OPTION:
				if (!openPath.equals("")) {
					// �ƴϸ� ������ �̸��� ������ ������
					saveMemo();
				} else {
					// �ٸ� �̸����� ������ ������
					newSaveMemo();
				} // end else

			case JOptionPane.NO_OPTION:
				flagOpen = false;
				break;
			default:
				flagOpen = true;
			}// end switch
		} // end if
			//////////////// 12-20-2018 �ڵ� �߰� ��///////////////////
		if (!flagOpen) {

			FileDialog fdOpen = new FileDialog(jm, "���� ����", FileDialog.LOAD);
			fdOpen.setVisible(true);

			String filePath = fdOpen.getDirectory();// ���
			String fileName = fdOpen.getFile();// ���ϸ�

			if (filePath != null) {// ������ ������ ����
				//////////////// 12-20-2018 �ڵ� �߰� ����///////////////////
				/////// ���� : ��Ʈ������ ������ ������ �д� �ڵ� �߰�, �ۼ��� : ��
				// ������ ���Ϸ� ���ϰ�ü�� ����.
				File file = new File(filePath + fileName);
				// 16bit Stream���θ� ����(��������) ���
				BufferedReader br = null;

				try {
					br = new BufferedReader(new FileReader(file));
					String temp = "";
					// T.A�� �ʱ�ȭ �� ��
					// <�ʱ�ȭ ���� �ʾҴ��� �Ʒ��� ���� ���̰� ���δ�.
					tempTa.setText("");// getText���ߴµ��� �ǳ�..?
					while ((temp = br.readLine()) != null) {
						// ���Ͽ��� �о���� ������ �����Ѵ�.
						tempTa.append(temp + 
								/* ��������\r�־��ֳ� ������ ����. ������� �ƴ�!�Ѵ� �ʿ�~!~!
								 * �ƴԿ��°� ��������� �������ٷ� ����ȴ� */"\r\n");
					} // end while

					// ������¸� �����Ҷ��� �ν��Ͻ� ������ ����ϰ� �ȴ�.
					// ������ �о���� ������ ����
					taNoteDate = tempTa.getText();// ""��Ȳ�� null��Ȳ�� ������.

					// ������ ���ϸ��� ����
					openPath = file.getAbsolutePath();
				} finally {
					if (br != null) {
						br.close();
					} // end if
						// nullpointer exception�������°� �̿��� �����Ҽ� �ִ�.
				} // end finally

				//////////////// 12-20-2018 �ڵ� �߰� ��/////////////////////
				// ������ ��ο� �̸��� Frame�� TitleBar�� ����
				jm.setTitle("�޸���-���� " + filePath + fileName);
			} // end if
		} // end if

	}// openMemo

	/**
	 * �ۼ��� �޸� ���� - ������ ���ϸ��� �״�� �����ϴ� ���ϸ� �ݿ�
	 */
	public void saveMemo() {
		//������ ������ �̸��� ���Ͽ� ����� ��
		try {
			if(!openPath.equals("")) {
				createFile(openPath);
			}else{
				newSaveMemo();
			}//end else
			
			///////////////���� �����ؼ� �����ϸ� �������ٷ� ����ȴ�.///////////////
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
//		newSaveMemo();
	}// saveMemo

	private void createFile(String pathName) throws IOException{
		//saveMemo���Ҹ��� ���ϸ� �н�, newSaveMemo���Ҹ��� ���ϸ� â
		BufferedWriter bw=null;
		
		try {
			//����ڰ� ���丮���� ������� ������ �� ���� ������ File Ŭ������ ����� �ʿ䰡 ����.
			bw=new BufferedWriter(new FileWriter(pathName));//<�ִ���ġ�� �ִ°��̱� ������ File�� �ʿ䰡��
			//<���� ����� �ʾƵ� �ȴ�.
			bw.write(jm.getTaNote().getText());//textArea�� ������ ��Ʈ���� ���
			bw.flush();//��Ʈ���� ��ϵ� ������ �������� ����
			
			openPath=pathName;
			taNoteDate=jm.getTaNote().getText();
		}finally {
			if(bw!=null) {bw.close();}//end if
		}//end finally
	}//createFile
	
	/**
	 * ���ϸ��� �Է¹޾� �� �̸����� ����
	 */
	public void newSaveMemo() {
		FileDialog fdSave = new FileDialog(jm, "���� ����", FileDialog.SAVE);
		fdSave.setVisible(true);

		String filePath = fdSave.getDirectory();// ���
		String fileName = fdSave.getFile();// ���ϸ�

		if (filePath != null) {//�����ư�� �������� ����.
			try {
				createFile(filePath+fileName);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(jm, "������ ���� �߻�", "�����߻�", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}//end catch
			// ������ ��ο� �̸��� Frame�� TitleBar�� ����
			jm.setTitle("�޸���-���� " + filePath + fileName);
		} // end if
	}// newSaveMemo

	/**
	 * �۲��� �����ϴ� ���̾�α׸� �����ϴ� ��
	 */
	public void formatDialog() {
		new MemoFormat(jm);// this�� �̺�Ʈ�ϱ� ������ �ֱ� ���� jm
	}// formatDialog

	/**
	 * �޸��� ������ �����ϴ� ���̾�α׸� ����
	 */
	public void helpDialog() {
		new Help(jm);
	}// helpDialog

}// class
