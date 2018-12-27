package day1219;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * File 클래스
 * -파일의 정보얻기
 * -디렉토리 생성
 * -파일 삭제
 * @author owner
 */
public class UseFile {

	public UseFile() {
		String path="c:/dev/temp/java_read.txt";
		//1.생성
		File file=new File(path);
		System.out.println(file);//overriding되서 경로가 잘 나온다.
		if(file.exists()) {	//파일이 존재 할 때
//			System.out.println(file.exists());
			System.out.println("절대 경로 : "+file.getAbsolutePath());
			try {
				System.out.println("규범 경로  : "+file.getCanonicalPath());//유일하게 식별가능한 path고 대문자
			} catch (IOException ie) {
				ie.printStackTrace();
			}//end catch
			System.out.println("경로 : "+file.getPath());
			System.out.println("폴더명(부모경로) : "+file.getParent()); //c:/dev/temp
			System.out.println("파일명 : "+file.getName()); //java_read.txt
			
			System.out.println(file.isFile()?"True,파일입니다.":"디렉토리");  //c:/dev/temp/면 디렉토리가 나온다.
			System.out.println(file.isDirectory()?"True,디렉토리입니다.":"파일");
			
			System.out.println("파일의 길이 : "+file.length()+"byte");//NTFS 무조건 1KB의 공간을 만들고 해당파일크기만큼 저장.
			System.out.println("실행"+(file.canExecute()?"가능":"불가능"));
			System.out.println("읽기"+(file.canRead()?"가능":"불가능"));
			System.out.println("쓰기"+(file.canWrite()?"가능":"불가능"));//(읽기전용)덮어쓰는것을 이야기 함.써지기는 한다ㅏ.파일에 저장되지 못하게 막혀있음..
			System.out.println(file.isHidden()?"숨김파일":"일반파일");//숨김을 설정해 놓은것
			Date d = new Date(file.lastModified());
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss");
			System.out.println("마지막 수정일 : "+sdf.format(d)/*file.lastModified()*/);//=>long으로 나오는데,Date(long date) 로
			//Wed Dec 19 14:29:12 KST 2018(d)=>2018-12-19 오후 14:29:12(sdf.format(d))
			
		}else {
			System.out.println("경로를 확인해 주세요.");
		}//end else
		
	}//UseFile
	
	public static void main(String[] args) {
		new UseFile();
	}//main

}//class
