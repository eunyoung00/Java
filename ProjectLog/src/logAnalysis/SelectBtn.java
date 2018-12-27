package logAnalysis;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JOptionPane;;

@SuppressWarnings("serial")
public class SelectBtn extends Dialog implements ActionListener{
	
	private Login in;
	private Button btnView,btnReport;
	private int viewcnt;//�α׺м�����Ƚ��
	private FileDialog fdSelect;
	private String filePath,fileName;

	public SelectBtn(Login in) {
		super(in,"�۾� ���� â",true);
		this.in=in;
		viewcnt=0;
		
		btnView=new Button("�α� �м�");
		btnReport=new Button("����Ʈ ���� ����");
		
		setLayout(null);
		
		btnView.setBounds(70,120,100,50);
		btnReport.setBounds(220,120,100,50);
		add(btnView);
		add(btnReport);
		
		//�̺�Ʈ ���
		btnView.addActionListener(this);
		btnReport.addActionListener(this);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}//windowClosing
		});
		
		setBounds(in.getX()+100,in.getY()+80,400,280);
		setVisible(true);
	}//SelectBtn

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==btnView) {
			if(viewcnt==0) {
//				JOptionPane.showMessageDialog(in, "¹�� ������ ���� �м�~!");
				try {
					fileDialog();
				}catch (NullPointerException npe) {
					JOptionPane.showMessageDialog(this, "�м�â�� ������ �ʴ´�?");
				}//end catch
			}else if(viewcnt>=1) {
				int selectValue= JOptionPane.showConfirmDialog(this, "������ ������ �ֽ��ϴ�.\n����ðڽ��ϱ�?");
				switch (selectValue) {
				case JOptionPane.OK_OPTION:
					fileDialog();
					viewcnt++;//������ �������� ī��Ʈ
					break;
				case JOptionPane.NO_OPTION:
					break;
				default:
					break;
				}//end switch
			}//end if
		}//end if
		if(viewcnt>1) {
			if(ae.getSource()==btnReport) {
				JOptionPane.showMessageDialog(this, "������ �����մϴ�.");
			}//end if
		}else {
			if(ae.getSource()==btnReport) {
				JOptionPane.showMessageDialog(this, "�α� �м��� ���� ������ �ּ���.");
			}//end if
		}//end if
	}//actionPerformed
	
	public void fileDialog() throws NullPointerException{
		fdSelect = new FileDialog(in, "���� ����", FileDialog.LOAD);
		fdSelect.setVisible(true);
		
		filePath=fdSelect.getDirectory();//���
		fileName=fdSelect.getFile();//���ϸ�
//		System.out.println(filePath+fileName);
//		System.out.println(fdSelect);

		File file =new File(filePath);//��θ� ����ȭ
		File[] fileList=file.listFiles();//�� ����� ���ϵ�
//		for(int i=0;i<fileList.length;i++) {//�� ����� ���ϵ��� ������,
//			System.out.println(fileList[i].getName());
//			System.out.println(fileName+"    /      "+fileList[i].getName());
//		}//end for
		
		boolean flag=false;
		if(filePath!=null) {//������ ���ϸ��� null �̾ƴϰ�,
			
			for(int i=0;i<fileList.length;i++) {//�� ����� ���ϵ��� ������,
				if(fileName.equals(fileList[i].getName())) {
					flag=true;
					new LogData();
//					new Analysis(this);//�����Ѵٸ� �м�â
//					new LogData();
				}//end if
			}//end for
			if(!flag) {//�����÷��װ� false��� 
				JOptionPane.showMessageDialog(this, "���ϸ��� �������� �ʽ��ϴ�.");
				fileDialog();//�ϰ� �ٽ� ���ϰ���
			}//end if
			flag=false;//�ٽ� �ʱ�ȭ
		}else{//�������� ������?null�̸�? ������ �ٽð����� �ϰ� ���Ͽ���?
			JOptionPane.showMessageDialog(this, "������ �ٽ� ������.");
		}//end if
	}//fileDialog

	public FileDialog getFdSelect() {
		return fdSelect;
//		return "java.awt.FileDialog[filedlg0,0,0,0x0,hidden,APPLICATION_MODAL,title=���� ����,dir= C:\\Users\\user\\Dropbox\\01.group_prj1\\,file= sist_input_1.log,load]";
	}//getFdSelect
	
}//class
