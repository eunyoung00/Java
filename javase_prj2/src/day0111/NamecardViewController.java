package day0111;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class NamecardViewController extends WindowAdapter implements ActionListener {

	private NamecardView nv;
	private NamecardDAO n_dao;
	private String imgPath;
	
	public NamecardViewController(NamecardView nv) {
		this.nv=nv;
		n_dao=NamecardDAO.getInstance();//<객체가 딱한번 만들어짐..중간에 죽어버리면 DB작업불가..
		setAllNamecard();//테이블에 데이터를 추가.
		imgPath="";//안해주면 null
	}//NamecardViewController
	
	@Override
	public void windowClosing(WindowEvent we) {
		nv.dispose();
	}//windowClosing
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==nv.getJbtAdd()) {
			addNamecard();
		}//end if
		
		if(ae.getSource()==nv.getJbtImg()) {
			selectFile();
		}//end if
		
	}//actionPerformed
	
	private void selectFile() {
		FileDialog fdOpen=new FileDialog(nv, "이미지 선택", FileDialog.LOAD);
		fdOpen.setVisible(true);
		
		String path=fdOpen.getDirectory();
		String name=fdOpen.getFile();
		if(path !=null) {
			imgPath=path+"/"+name;
			JLabel jl=nv.getJlPreview();
			jl.setIcon(new ImageIcon(imgPath));
		}//end if
	}//selectFile

	private void addNamecard() {
		JTextField jtfName=nv.getJtfName();
		JTextField jtfAddr=nv.getJtfAddr();
		
		String name=jtfName.getText().trim();
		if(name.equals("")) {
			JOptionPane.showMessageDialog(nv, "이름은 필수 입력입니다.");
			jtfName.requestFocus();
			return;
		}//end if
		
		String addr=jtfAddr.getText().trim();
		if(addr.equals("")) {
			JOptionPane.showMessageDialog(nv, "주소는 필수 입력입니다.");
			jtfAddr.requestFocus();
			return;
		}//end if
		
		boolean insertflag=false;
		if(imgPath.equals("")) {//이미지를 선택하지 않았을 때
			insertflag=JOptionPane.showConfirmDialog(nv, "기본 이미지를 사용하시겠습니까?")
					==JOptionPane.OK_OPTION;
			if(insertflag) {
				imgPath="no_image.png";
			}//end if
		}else {//이미지를 선택했을 떄
			insertflag=true;
		}//end else
		
		if(insertflag) {
		//DB에 추가
			//변경된 파일명으로 지정한 위치에 업로드를 수행한 후
			//
			StringBuilder filePath=new StringBuilder();
			filePath.append(System.currentTimeMillis())
			.append(imgPath.substring(imgPath.lastIndexOf(".")));
			
			try {
				if(!imgPath.equals("no_image.png")) {//기본이미지가 아니라면 업로드 수행
					uploadImg(filePath.toString());
				}//end if
			//DB에 추가한다.
				NamecardVO nvo=new NamecardVO(name, addr, !imgPath.equals("no_image.png")?filePath.toString():"no_image.png");
				n_dao.insertNamecard(nvo);
				JOptionPane.showMessageDialog(nv, "명함이 추가되었습니다.");
				jtfName.setText("");
				jtfAddr.setText("");
				nv.getJlPreview().setIcon(new ImageIcon("C:/dev/workspace/javase_prj2/src/day0111/upload/no_image.png"));
				jtfName.requestFocus();
				
				setAllNamecard();//추가된 명함을 갱신해 준다.
				
			}catch (SQLException se) {
				JOptionPane.showMessageDialog(nv, "명함 추가 중 문제 발생");
				se.printStackTrace();
			}catch (IOException ie) {
				JOptionPane.showMessageDialog(nv, "이미지 업로드 중 문제 발생");
				ie.printStackTrace();
			}//catch
			System.out.println("-----------추가되었습니다-------------");
			imgPath="";
		}//end if
	}//addNamecard
	
	/**
	 * 조회된 명함정보를 JTable에 추가  
	 */
	private void setAllNamecard() {
		try {
			List<NamecardVO> list=n_dao.selectAllNamecard();
			
			DefaultTableModel dtm=nv.getDtmNamecard();
//			dtm.removeRow(0);//다지운다..데이터를 출력하기전에 초기화
			dtm.setRowCount(0);//로 고치면 하나씩 안쭐고 중복출력안된다?//이걸로 초기화~!~!
			
			Object[] rowData=null;
			
			NamecardVO nvo=null;
			for(int i=0; i<list.size(); i++) {//조회된 레코드의 수만큼 반복
				nvo=list.get(i);
				rowData=new Object[4];
				rowData[0]=new Integer(i+1);
				rowData[1]=new ImageIcon("C:/dev/workspace/javase_prj2/src/day0111/upload/"+nvo.getImg());//경로중복을 피하기위해 파일명만 넣음
				rowData[2]=nvo.getName();
				rowData[3]=nvo.getAddr();
				
				dtm.addRow(rowData);
			}//end for
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(nv, "데이터를 가져오는 중 문제가 발생하였습니다.");
			e.printStackTrace();
		}//end catch
	}//setAllNamecard

	private boolean uploadImg(String filePath) throws IOException{
		boolean flag=false;
		
		//원본파일을 복사하여 지정한 위치에 생성한다.
		FileInputStream fis=new FileInputStream(imgPath);
		FileOutputStream fos=new FileOutputStream("C:/dev/workspace/javase_prj2/src/day0111/upload/"+filePath);
		
		try {
			//파일 읽어들이기
			byte[] readData=new byte[512];//<512byte나 1024씩 읽어들이는데 하나씩 읽어들여 시간이 오래걸린다.따라서  배열..?
			int byteSize=0;
			
			while((byteSize=fis.read(readData)) !=-1) {//<0이아니면 읽어들인 데이터가 있는것? read()?안쓰면 한바이트씩 읽어들여 느림 
				fos.write(readData,0,byteSize);
				fos.flush();
			}//end while
			
		}finally {
			if(fos !=null) {fos.close();}//end if
			if(fis !=null) {fis.close();}//end if
		}//end finally
		
		return flag;		
	}//uploadImg
}//class
