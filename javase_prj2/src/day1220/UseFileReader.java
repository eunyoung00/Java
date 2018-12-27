package day1220;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 16bit Stream 만 사용하여 파일읽기
 * @author owner
 */
public class UseFileReader {
	
	public void useFileReader() throws IOException{
		//<특정상황에 throw new exception이 숨겨져 있을것.발생1 넘김2 처리3
		BufferedReader br=null;
		
		try {
			File file=new File("c:/dev/temp/java_read.txt");//<getCanonicalPath
			//1.근원지 파일에 스트림 연결
//			FileReader fr= new FileReader(file);//<파일과 스트림 연결
//			//2.줄단위 읽어들이는 기능을 가진 스트림 연결
//			br=new BufferedReader(fr);

			br=new BufferedReader(new FileReader(file));
			
			String temp="";
			//한줄씩 읽어들여 읽어들인 내용이 존재한다면 
			while((temp=br.readLine())!=null) {
				System.out.println(temp);//출력한다.
			}//end while
			
		}finally {
			//<연결되어있든 그렇지 않든 끊어봐~!연결만이 아님~!!
			//다썼다면 연결된 스트림을 끊는다.
			if(br!=null) {br.close();}//end if
		}//end finally
	}//useFileReader

	public static void main(String[] args) {
		UseFileReader ufr=new UseFileReader();
		try {
			ufr.useFileReader();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
	}//main
}//class
