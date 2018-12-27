package day1220;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * UseFileOutputStream) JVM에서 발생한 데이터가 정수, byte[]인 경우에 File로 저장하는
 * FileOutputStream에 사용.
 * @author owner
 */
public class UseFileOutputStream {

	public void useFileOutputStream() throws IOException {
		int i = 65;
		// 1.File class 생성
		File file = new File("C:/dev/temp/java_write.txt");// <아직 파일이 만들어지진 않는다.
		FileOutputStream fos = null;/* new FileOutputStream(file); */
		try {
			boolean flag = false;
			if (file.exists()) {
				boolean[] temp = {false, true, true };//switch case대신..배열로만들어 처리
				int select = JOptionPane.showConfirmDialog(null, "덮어쓰시겠습니까?");
				flag = temp[select];
			} // end if
			// 2.FileOutputStream생성 ->입력된 경로에 파일이 생성된다.
			// 파일이 없다면 생성하고, 있다면 묻지도 않고 덮어 쓴다.
			// <덮어쓰겟냐고 먼저 물어봐야 한다.
			if(!flag) {
				fos = new FileOutputStream(file);
				fos.write(i);//기록! 수에 대한 문자가 출력(65->A)//기본형은 flush안해도 나온당.
				//값을 스트림에 기록한것.=>수에 대한 문자가 그래서 출력
				fos.flush();
				System.out.println("파일기록 완료!!!");
			}//end if
		} finally {
			// fos.close(); 스트림에 저장된 (써진,기록된) 내용이있다면, 분출하고 연결을 끊는다.
			if (fos != null) {	fos.close();	} // end if
		} // end finally
	}// UseFileOutputStream

	public static void main(String[] args) {
		UseFileOutputStream ufos = new UseFileOutputStream();
		try {
			ufos.useFileOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		} // end catch

	}// main
}// class
