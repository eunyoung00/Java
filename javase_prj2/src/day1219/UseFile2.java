package day1219;

import java.io.File;

/**
 * 폴더 생성, 파일 삭제
 * @author owner
 */
public class UseFile2 {
	
	public void createDirectory() {
		File file = new File("c:/eunyoung/park");
		if(file.mkdirs()) {//s붙은것과 안붙은게 차이가 없는데, 없으니까 연달아 안만들어지는데?
			System.out.println("폴더 생성 성공");
		}else {
			System.out.println("같은 이름의 폴더 존재");
		}//end else
	}//createDirectory
	
	public void removeFile() {
		File file=new File("c:/dev/temp/a.txt");
		boolean flag=file.delete();//묻지도 않고 지운당..곤란
		if(flag) {
			System.out.println("파일 삭제 성공");
		}else {
			System.out.println("파일 삭제 실패");
		}//end else
	}//removeFile
	
	public static void main(String[] args) {
		UseFile2 uf2= new UseFile2();
		uf2.createDirectory();
		System.out.println("-----------------------------");
		uf2.removeFile();
	}//main
}//class
