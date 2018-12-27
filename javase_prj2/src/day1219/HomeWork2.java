package day1219;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class HomeWork2 {
	private int filetotal;
	private File file;
	private List<File> listjava;
	
	public void inputPath() {
		listjava=new ArrayList<File>();
		filetotal=0;
		String path = JOptionPane.showInputDialog("경로를 입력하여 주세요");
		file=new File(path);
		if(file.isDirectory()) {//file이 디렉토리 일때,
			File[] filelist=file.listFiles();
			for(int i=1;i<filelist.length;i++) { //파일리스트만큼 돌고
				if(filelist[i].getName().contains(".java")) {//자바확장자인걸 골라
					filetotal=filetotal+1;//자바파일 카운트
					listjava.add(filelist[i]);//list에 넣고
				}//end if
			}//end for
			deleteJava();
		}else{
			JOptionPane.showMessageDialog(null, "올바른 경로를 입력하여 주세요");
			inputPath();
//			System.out.println("올바른 경로를 입력하여 주세요");
		}//end else
	}//inputPath

	public void deleteJava() {
		int num=JOptionPane.showConfirmDialog(null, "java 파일이 "+filetotal+"개 존재합니다. 삭제하시겠습니까?");
		switch (num) {
		case JOptionPane.OK_OPTION:
			for(int i=0;i<listjava.size();i++) {
				listjava.get(i).delete();//리스트의 목록을 가져와 지운다.
			}//end for
			break;
		case JOptionPane.NO_OPTION:
			break;
		case JOptionPane.CANCEL_OPTION:
			break;
		}//end switch
	}//deleteJava

	public static void main(String[] args) {
		new HomeWork2().inputPath();
	}//main

}//class
