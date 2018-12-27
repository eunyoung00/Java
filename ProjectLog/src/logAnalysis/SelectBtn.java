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
	private int viewcnt;//로그분석실행횟수
	private FileDialog fdSelect;
	private String filePath,fileName;

	public SelectBtn(Login in) {
		super(in,"작업 선택 창",true);
		this.in=in;
		viewcnt=0;
		
		btnView=new Button("로그 분석");
		btnReport=new Button("리포트 파일 생성");
		
		setLayout(null);
		
		btnView.setBounds(70,120,100,50);
		btnReport.setBounds(220,120,100,50);
		add(btnView);
		add(btnReport);
		
		//이벤트 등록
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
//				JOptionPane.showMessageDialog(in, "쨔란 파일을 고르고 분석~!");
				try {
					fileDialog();
				}catch (NullPointerException npe) {
					JOptionPane.showMessageDialog(this, "분석창이 열리지 않는다?");
				}//end catch
			}else if(viewcnt>=1) {
				int selectValue= JOptionPane.showConfirmDialog(this, "선택한 파일이 있습니다.\n덮어쓰시겠습니까?");
				switch (selectValue) {
				case JOptionPane.OK_OPTION:
					fileDialog();
					viewcnt++;//파일을 열었을떄 카운트
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
				JOptionPane.showMessageDialog(this, "파일을 생성합니다.");
			}//end if
		}else {
			if(ae.getSource()==btnReport) {
				JOptionPane.showMessageDialog(this, "로그 분석을 먼저 실행해 주세요.");
			}//end if
		}//end if
	}//actionPerformed
	
	public void fileDialog() throws NullPointerException{
		fdSelect = new FileDialog(in, "파일 열기", FileDialog.LOAD);
		fdSelect.setVisible(true);
		
		filePath=fdSelect.getDirectory();//경로
		fileName=fdSelect.getFile();//파일명
//		System.out.println(filePath+fileName);
//		System.out.println(fdSelect);

		File file =new File(filePath);//경로를 파일화
		File[] fileList=file.listFiles();//그 경로의 파일들
//		for(int i=0;i<fileList.length;i++) {//그 경로의 파일들을 돌릴때,
//			System.out.println(fileList[i].getName());
//			System.out.println(fileName+"    /      "+fileList[i].getName());
//		}//end for
		
		boolean flag=false;
		if(filePath!=null) {//선택한 파일명이 null 이아니고,
			
			for(int i=0;i<fileList.length;i++) {//그 경로의 파일들을 돌릴때,
				if(fileName.equals(fileList[i].getName())) {
					flag=true;
					new LogData();
//					new Analysis(this);//존재한다면 분석창
//					new LogData();
				}//end if
			}//end for
			if(!flag) {//만약플래그가 false라면 
				JOptionPane.showMessageDialog(this, "파일명이 존재하지 않습니다.");
				fileDialog();//하고 다시 파일고르기
			}//end if
			flag=false;//다시 초기화
		}else{//존재하지 않으면?null이면? 파일을 다시고르세요 하고 파일열기?
			JOptionPane.showMessageDialog(this, "파일을 다시 고르세요.");
		}//end if
	}//fileDialog

	public FileDialog getFdSelect() {
		return fdSelect;
//		return "java.awt.FileDialog[filedlg0,0,0,0x0,hidden,APPLICATION_MODAL,title=파일 열기,dir= C:\\Users\\user\\Dropbox\\01.group_prj1\\,file= sist_input_1.log,load]";
	}//getFdSelect
	
}//class
