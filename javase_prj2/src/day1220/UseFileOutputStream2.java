package day1220;

import java.io.BufferedWriter;
import java.io.File;
//import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;

/**
 * 8bit Stream과 16bit Stream을 사용하여 문자열 데이터를 File에 기록.
 * @author owner
 */
public class UseFileOutputStream2 {

	public UseFileOutputStream2() throws IOException {
		String data="오늘은 20일 목요일 입니다.내일은 금요일오예";
	//1.File 객체 생성 :파일이 존재한다면 덮어쓸것인지를 판단
		File file = new File("c:/dev/temp/java_write2.txt");
		
		boolean flag=false;//파일이 없을 때 
		if(file.exists()) {//파일이 존재할 때.
			boolean[] temp= {false,true,true};//예,아니오,취소
			flag=temp[JOptionPane.showConfirmDialog(null, "덮어쓰시겠습니까???")];
		}//end if
		//<이부분 잘 못하면 if 도배가 된다...
	//2.Stream 생성
		if(!flag) { //true
			BufferedWriter bw=null;
			try {
				//8bit Stream과 16bit Stream의 연결 사용.))))
//				//2.파일과 연결하여 파일을 생성하는 스트림. : FileNotFoundException발생->폴더가 없을때.(폴더는 못만든다)
//				FileOutputStream fos = new FileOutputStream(file);
//				//3.문자열을 쓰기위한 스트림을 연결 (다좋은데 속도가 느린게 단점)
//				OutputStreamWriter osw =new OutputStreamWriter(fos);
//				//4.느린 속도를 개선하기 위한 스트림 연결.
//				BufferedWriter bw=new BufferedWriter(osw);
//				
//				bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));

				////////////////////16bit 만 사용////////////////////////////////
				bw=new BufferedWriter(new FileWriter(file));
				//문자열만 쓸땐 16bit가 더 간단..!
				/////////////////16bit////////////////////////////////
				
				bw.write(data);//스트림에 데이터를 기록
				bw.flush();//목적지 파일로 분출   //안해도 close되면 잘써진다.
				System.out.println("파일에 기록 완료!!!");
			} finally {
				//스트림 객체가 생성되어 있다면 연결 끊기
				if(bw!=null) {bw.close();}//end if   //close안되도 flush되면 나온다.
			}//end finally
		}//end if
	}//UseFileOutputStream2
	
	public static void main(String[] args) {
		try {
			new UseFileOutputStream2();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
	}//main
}//class
