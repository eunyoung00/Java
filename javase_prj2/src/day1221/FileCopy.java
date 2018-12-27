package day1221;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

@SuppressWarnings("serial")
public class FileCopy extends JFrame implements ActionListener,Runnable {

	private JButton jb;
	private JProgressBar jpb;//진척도를 보여주는 바 (0~100까지 쌓이는?)
	private long fileLen;
	private int cnt;
	
	public FileCopy() {
		super("파일복사");
		jb=new JButton("파일 선택");
		jpb=new JProgressBar(0,100);
		jpb.setString("진척도");
		jpb.setValue(50);
		
		JPanel jp=new JPanel();
		jp.add(jb);
		
		add("Center",jp);
		add("South",jpb);
		
		jb.addActionListener(this);
		setBounds(100, 100, 500, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//FileCopy
	
	@Override
	public void actionPerformed(ActionEvent e) {
		FileDialog fd=new FileDialog(this, "파일선택", FileDialog.LOAD);
		fd.setVisible(true);
		
		String path=fd.getDirectory();
		String name=fd.getFile();
		if(path!=null) { //파일을 선택했다면
			File file=new File(path+name);
			try {
				copy(file);
				JOptionPane.showMessageDialog(this, file+" 복사 성공");
			} catch (FileNotFoundException fnfe) {
				JOptionPane.showMessageDialog(this, "파일이 존재하지 않습니다.");
				fnfe.printStackTrace();
			} catch (IOException ie) {
				JOptionPane.showMessageDialog(this, "입출력 작업에 문제 발생.");
				ie.printStackTrace();
			}//end catch
		}//end if
	}//actionPerformed
	
	public void copy(File file) throws FileNotFoundException,IOException{
		
		int selectValue=JOptionPane.showConfirmDialog(this, "파일을 복사하시겠습니까?");
		switch (selectValue) {
		case JOptionPane.OK_OPTION:
			StringBuilder copyFileName=new StringBuilder(file.getAbsolutePath());
			copyFileName.insert(copyFileName.lastIndexOf("."), "_bak");
//			System.out.println(copyFileName);
			
			FileInputStream fis =null;
			FileOutputStream fos=null;
			
			try {
				//원본파일에 스트림 연결
				fis=new FileInputStream(file);
				fos=new FileOutputStream(copyFileName.toString());//_bak가 들어간 이름.
				
				//파일과 연결된 스트림에서 값을 얻는다.
				//HDD가 읽어들이는 크기를 무시하고 1byte씩 읽어들여 사용하는 code
//				int temp=0;
//				int i=0;
//				while((temp=fis.read())!=-1) {
//					//읽어들인 내용을 _bak가 붙은 파일을 생성하여 출력(복사의 개념)
//					System.out.print((char)temp);
//					//이미지는 읽어서 콘솔창에 뿌려봐야 알아볼 수 없다
//					i++;//fat와 바이트의 크기는 다를수 있다.
//					fos.write(temp);
//					fos.flush();
//				}//end while
				
				//HDD가 한번에 읽어들이는 크기를 그대로 사용
				//HDD몰라도 개발할 수 있지만 알면 더 빠르게 실행되게 할 수 있다.
				//어느경우에는 한번에 읽어들이는 경우도 있을텐데 =>빨라짐
//				byte[] temp=new byte[512];
//				int len=0;
//				while((len=fis.read(temp)/*방의갯수*/)!= -1) {//읽어들인 데이터가 있어
//					fos.write(temp,0,len);
//					fos.flush();
//				}//end while
				
				int temp=0;
				fileLen=file.length();
				System.out.println(fileLen);
				cnt=0;
				int i=0;
				File tempFile=null;
				Thread t =new Thread(this);
				t.start();
				while((temp=fis.read())!=-1) {
					//읽어들인 내용을 _bak가 붙은 파일을 생성하여 출력(복사의 개념)
					fos.write(temp);
					fos.flush();
					jpb.setValue((int)((i/(double)fileLen)*100));
					if(jpb.getValue()==100) {
						break;
					}//end if
					i++;
				}//end while
			}finally {
				if(fis!=null) {fis.close();}//end if
				if(fos!=null) {fos.close();}//end if
			}//end finally
		}//end switch
	}//copy
	
	@Override
	public void run() {
		for(int i=cnt;i<=fileLen; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}//end catch
			jpb.setValue((int)((cnt/(double)fileLen)*100));
		}//end for
	}//run

	public static void main(String[] args) {
		new FileCopy();
	}//main

}//class
