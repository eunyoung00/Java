package kr.co.sist.memo.run;

import java.awt.Font;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import kr.co.sist.memo.view.JavaMemo;

/**
 * 메모장 클래스를 실행하는 일.
 * @author owner
 */
public class RunJavaMemo {
	
	public Font readFontInfo() throws IOException,ClassNotFoundException{
//		BufferedReader br=null;
		/////////////////////////2018-12-21 ObjectInputStream/////////////////////////
		ObjectInputStream ois=null;
		Font font=null;
		
		try {
//			br=new BufferedReader(new FileReader("C:/dev/temp/memo.dat"));
//			String readFont=br.readLine();
//			String[] temp=readFont.split(",");//nullpointerException발생할 수 있다.
//			font = new Font(temp[0], Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));
			
			ois=new ObjectInputStream(new FileInputStream("C:/dev/temp/memo.dat"));
			font=(Font)ois.readObject();
		}finally {
//			if(br!=null) {br.close();}//end if
			if(ois!=null) {ois.close();}//end if
		}//end finally
		return font;
		
	}//readFontInfo

	/**
	 * 자바클래스를 실행하는 일 : Java Application
	 * @param args
	 */
	public static void main(String[] args) {
		RunJavaMemo rjm=new RunJavaMemo();
		Font font =null;
		try {
			font=rjm.readFontInfo();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}//end catch
		
		new JavaMemo(font);//패키지가 달라 import
	}//main

}//class
